package org.xpande.conty.report;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MAccount;
import org.compiere.model.MBPartner;
import org.compiere.model.MInvoice;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.xpande.conty.model.MZContyAsientoCpra;
import org.xpande.conty.model.MZContyConfig;
import org.xpande.conty.model.X_Z_ContyAsientoCpra;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * Reporte de Asientos de Compra para interface contable con Conty.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 2/19/18.
 */
public class AsientoCompras extends SvrProcess {

    private int adOrgID = 0;
    private int cBPartnerID = 0;
    private Timestamp startDate = null;
    private Timestamp endDate = null;

    private MZContyConfig contyConfig = null;

    @Override
    protected void prepare() {

        ProcessInfoParameter[] para = getParameter();

        for (int i = 0; i < para.length; i++){

            String name = para[i].getParameterName();

            if (name != null){
                if (para[i].getParameter() != null){
                    if (name.trim().equalsIgnoreCase("AD_Org_ID")){
                        this.adOrgID = ((BigDecimal)para[i].getParameter()).intValueExact();
                    }
                    else if (name.trim().equalsIgnoreCase("C_BPartner_ID")){
                        this.cBPartnerID = ((BigDecimal)para[i].getParameter()).intValueExact();
                    }
                    else if (name.trim().equalsIgnoreCase("DateTrx")){
                        this.startDate = (Timestamp)para[i].getParameter();
                        this.endDate = (Timestamp)para[i].getParameter_To();
                    }
                }
            }
        }

        this.contyConfig = MZContyConfig.getDefault(getCtx(), null);

    }

    @Override
    protected String doIt() throws Exception {

        this.deleteData();

        this.getData();

        return "OK";
    }


    /***
     * Elimina información anterior para este usuario en tablas de reporte
     * Xpande. Created by Gabriel Vila on 9/11/17.
     */
    private void deleteData() {

        try{
            String action = " delete from " + X_Z_ContyAsientoCpra.Table_Name + " where ad_user_id =" + this.getAD_User_ID();
            DB.executeUpdateEx(action, null);
        }
        catch (Exception e){
            throw new AdempiereException(e);
        }
    }


    /***
     * Obtiene información inicial necesaria para el reporte e inserta la misma en tablas del reporte
     * Xpande. Created by Gabriel Vila on 9/11/17.
     */
    private void getData() {

        String sql = "", action = "";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{

            // Armo condicion where dinámica del reporte
            String whereClause = "";

            if (this.cBPartnerID > 0){
                whereClause += " and inv.c_bpartner_id =" + this.cBPartnerID;
            }

            sql = " select inv.c_invoice_id, inv.c_bpartner_id, inv.dateinvoiced, inv.documentserie, inv.documentno, " +
                    " date_part('day',inv.dateinvoiced) as dianro, coalesce(amtrounding,0) as amtrounding, doc.docbasetype " +
                    " from c_invoice inv " +
                    " inner join c_doctype doc on inv.c_doctypetarget_id = doc.c_doctype_id " +
                    " where inv.ad_client_id = " + this.getAD_Client_ID() +
                    " and inv.ad_org_id = " + this.adOrgID +
                    " and inv.docstatus='CO' " +
                    " and inv.issotrx='N' " + whereClause +
                    " and inv.dateinvoiced >='" + this.startDate + "' " +
                    " and inv.dateinvoiced <='" + this.endDate + "' " +
                    " order by inv.dateinvoiced";

            pstmt = DB.prepareStatement(sql, null);
            rs = pstmt.executeQuery();

            while(rs.next()){

                String docBaseType = rs.getString("docbasetype");
                int cInvoiceID = rs.getInt("c_invoice_id");
                int cBPartnerId = rs.getInt("c_bpartner_id");
                BigDecimal amtRounding = rs.getBigDecimal("amtrounding");
                int diaNro = rs.getInt("dianro");

                MInvoice invoice = new MInvoice(getCtx(), cInvoiceID, null);
                MBPartner partner = (MBPartner) invoice.getC_BPartner();

                this.setBPartnerAcct(invoice, partner, docBaseType, diaNro);
                this.setProductsAcct(invoice, partner, docBaseType, diaNro);
                this.setTaxesAcct(invoice, partner, docBaseType, diaNro);
                this.setRoundingAcct(invoice, partner, docBaseType, diaNro, amtRounding);
            }

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }
        finally {
            DB.close(rs, pstmt);
            rs = null; pstmt = null;
        }


    }

    private void setBPartnerAcct(MInvoice invoice, MBPartner partner, String docBaseType, int diaNro) {

        try{
            MZContyAsientoCpra asientoCpra = new MZContyAsientoCpra(getCtx(), 0, null);
            asientoCpra.setAD_User_ID(this.getAD_User_ID());
            asientoCpra.setC_Invoice_ID(invoice.get_ID());
            asientoCpra.setC_BPartner_ID(invoice.getC_BPartner_ID());
            asientoCpra.setAmtTotal(invoice.getGrandTotal());
            asientoCpra.setConty_CodImpu("2");
            asientoCpra.setConty_CodIva("0");
            asientoCpra.setConty_Impu("3");
            asientoCpra.setConty_IVA("1");
            asientoCpra.setConty_Libro("C");
            asientoCpra.setCurrencyRate(Env.ZERO);
            asientoCpra.setTaxID(partner.getTaxID());
            asientoCpra.setDateTrx(invoice.getDateInvoiced());

            int acctID = DB.getSQLValueEx(null, " select v_liability_acct from c_bp_vendor_acct where c_bpartner_id =" + partner.get_ID());
            if (acctID <= 0){
                throw new AdempiereException("No esta parametrizada la cuenta contable para compras, del socio de negocio: " + partner.getName());
            }

            MAccount acct = MAccount.get(getCtx(), acctID);

            if (docBaseType.equalsIgnoreCase("API")){
                asientoCpra.setAcctValueCr(acct.getAccount().getValue());
                asientoCpra.setDocumentType("FAC");
            }
            else{
                asientoCpra.setAcctValueDr(acct.getAccount().getValue());
                asientoCpra.setDocumentType("NDC");
            }
            if (invoice.getC_Currency_ID() == 142){
                asientoCpra.setCurSymbol("0");
            }
            else{
                asientoCpra.setCurSymbol("1");
            }
            asientoCpra.setDiaNro(diaNro);
            asientoCpra.setDocumentNoRef(invoice.getDocumentNo());
            asientoCpra.setDocumentSerie(invoice.get_ValueAsString("DocumentSerie"));
            asientoCpra.saveEx();

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }
    }
    

    private void setRoundingAcct(MInvoice invoice, MBPartner partner, String docBaseType, int diaNro, BigDecimal amtRounding) {

        try{
            MZContyAsientoCpra asientoCpra = new MZContyAsientoCpra(getCtx(), 0, null);
            asientoCpra.setAD_User_ID(this.getAD_User_ID());
            asientoCpra.setC_Invoice_ID(invoice.get_ID());
            asientoCpra.setC_BPartner_ID(invoice.getC_BPartner_ID());
            asientoCpra.setAmtTotal(amtRounding);
            asientoCpra.setConty_CodImpu("2");
            asientoCpra.setConty_CodIva("0");
            asientoCpra.setConty_Impu("3");
            asientoCpra.setConty_IVA("1");
            asientoCpra.setConty_Libro("C");
            asientoCpra.setCurrencyRate(Env.ZERO);
            asientoCpra.setTaxID(partner.getTaxID());
            asientoCpra.setDateTrx(invoice.getDateInvoiced());

            MAccount acct = MAccount.get(getCtx(), this.contyConfig.getZ_Redondeo_Acct());

            if (docBaseType.equalsIgnoreCase("API")){
                asientoCpra.setAcctValueDr(acct.getAccount().getValue());
                asientoCpra.setDocumentType("FAC");
            }
            else{
                asientoCpra.setAcctValueCr(acct.getAccount().getValue());
                asientoCpra.setDocumentType("NDC");
            }
            if (invoice.getC_Currency_ID() == 142){
                asientoCpra.setCurSymbol("0");
            }
            else{
                asientoCpra.setCurSymbol("1");
            }
            asientoCpra.setDiaNro(diaNro);
            asientoCpra.setDocumentNoRef(invoice.getDocumentNo());
            asientoCpra.setDocumentSerie(invoice.get_ValueAsString("DocumentSerie"));
            asientoCpra.saveEx();

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }
    }

    private void setProductsAcct(MInvoice invoice, MBPartner partner, String docBaseType, int diaNro) {

        String sql = "";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            sql = " select cct.v_liability_acct, sum(it.taxbaseamt) as total " +
                    "from c_invoicetax it " +
                    "inner join z_contyconfigtax cct on it.c_tax_id = cct.c_tax_id " +
                    "where cct.z_contyconfig_id =" + this.contyConfig.get_ID() +
                    "and it.c_invoice_id =" + invoice.get_ID() +
                    "group by cct.v_liability_acct ";

            pstmt = DB.prepareStatement(sql, null);
            rs = pstmt.executeQuery();

            while(rs.next()){

                MZContyAsientoCpra asientoCpra = new MZContyAsientoCpra(getCtx(), 0, null);
                asientoCpra.setAD_User_ID(this.getAD_User_ID());
                asientoCpra.setC_Invoice_ID(invoice.get_ID());
                asientoCpra.setC_BPartner_ID(invoice.getC_BPartner_ID());
                asientoCpra.setAmtTotal(rs.getBigDecimal("total"));
                asientoCpra.setConty_CodImpu("2");
                asientoCpra.setConty_CodIva("0");
                asientoCpra.setConty_Impu("3");
                asientoCpra.setConty_IVA("1");
                asientoCpra.setConty_Libro("C");
                asientoCpra.setCurrencyRate(Env.ZERO);
                asientoCpra.setTaxID(partner.getTaxID());
                asientoCpra.setDateTrx(invoice.getDateInvoiced());

                MAccount acct = MAccount.get(getCtx(), rs.getInt("v_liability_acct"));

                if (docBaseType.equalsIgnoreCase("API")){
                    asientoCpra.setAcctValueDr(acct.getAccount().getValue());
                    asientoCpra.setDocumentType("FAC");
                }
                else{
                    asientoCpra.setAcctValueCr(acct.getAccount().getValue());
                    asientoCpra.setDocumentType("NDC");
                }
                if (invoice.getC_Currency_ID() == 142){
                    asientoCpra.setCurSymbol("0");
                }
                else{
                    asientoCpra.setCurSymbol("1");
                }
                asientoCpra.setDiaNro(diaNro);
                asientoCpra.setDocumentNoRef(invoice.getDocumentNo());
                asientoCpra.setDocumentSerie(invoice.get_ValueAsString("DocumentSerie"));
                asientoCpra.saveEx();
            }

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }
        finally {
            DB.close(rs, pstmt);
            rs = null; pstmt = null;
        }

    }


    private void setTaxesAcct(MInvoice invoice, MBPartner partner, String docBaseType, int diaNro) {

        String sql = "";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            sql = " select it.c_tax_id, ita.t_credit_acct, it.taxamt " +
                    " from c_invoicetax it " +
                    " inner join c_tax_acct ita on it.c_tax_id = ita.c_tax_id " +
                    " where c_invoice_id =" + invoice.get_ID();

        	pstmt = DB.prepareStatement(sql, null);
        	rs = pstmt.executeQuery();

        	while(rs.next()){

                MZContyAsientoCpra asientoCpra = new MZContyAsientoCpra(getCtx(), 0, null);
                asientoCpra.setAD_User_ID(this.getAD_User_ID());
                asientoCpra.setC_Invoice_ID(invoice.get_ID());
                asientoCpra.setC_BPartner_ID(invoice.getC_BPartner_ID());
                asientoCpra.setAmtTotal(rs.getBigDecimal("taxamt"));
                asientoCpra.setConty_CodImpu("2");
                asientoCpra.setConty_CodIva("0");
                asientoCpra.setConty_Impu("3");
                asientoCpra.setConty_IVA("1");
                asientoCpra.setConty_Libro("C");
                asientoCpra.setCurrencyRate(Env.ZERO);
                asientoCpra.setTaxID(partner.getTaxID());
                asientoCpra.setDateTrx(invoice.getDateInvoiced());

                MAccount acct = MAccount.get(getCtx(), rs.getInt("t_credit_acct"));

                if (docBaseType.equalsIgnoreCase("API")){
                    asientoCpra.setAcctValueDr(acct.getAccount().getValue());
                    asientoCpra.setDocumentType("FAC");
                }
                else{
                    asientoCpra.setAcctValueCr(acct.getAccount().getValue());
                    asientoCpra.setDocumentType("NDC");
                }
                if (invoice.getC_Currency_ID() == 142){
                    asientoCpra.setCurSymbol("0");
                }
                else{
                    asientoCpra.setCurSymbol("1");
                }
                asientoCpra.setDiaNro(diaNro);
                asientoCpra.setDocumentNoRef(invoice.getDocumentNo());
                asientoCpra.setDocumentSerie(invoice.get_ValueAsString("DocumentSerie"));
                asientoCpra.saveEx();
        	}

        }
        catch (Exception e){
            throw new AdempiereException(e);
        }
        finally {
            DB.close(rs, pstmt);
        	rs = null; pstmt = null;
        }
    }


}
