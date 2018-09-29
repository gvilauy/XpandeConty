/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.										*
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net or http://www.adempiere.net/license.html         *
 *****************************************************************************/
package org.xpande.conty.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for Z_ContyAsientoCpra
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0
 */
public interface I_Z_ContyAsientoCpra 
{

    /** TableName=Z_ContyAsientoCpra */
    public static final String Table_Name = "Z_ContyAsientoCpra";

    /** AD_Table_ID=1000198 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AcctValueCr */
    public static final String COLUMNNAME_AcctValueCr = "AcctValueCr";

	/** Set AcctValueCr.
	  * Codigo de cuenta contable al Credito
	  */
	public void setAcctValueCr(String AcctValueCr);

	/** Get AcctValueCr.
	  * Codigo de cuenta contable al Credito
	  */
	public String getAcctValueCr();

    /** Column name AcctValueDr */
    public static final String COLUMNNAME_AcctValueDr = "AcctValueDr";

	/** Set AcctValueDr.
	  * Codigo de cuenta contable al Débito
	  */
	public void setAcctValueDr(String AcctValueDr);

	/** Get AcctValueDr.
	  * Codigo de cuenta contable al Débito
	  */
	public String getAcctValueDr();

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID(int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AD_User_ID */
    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";

	/** Set User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID(int AD_User_ID);

	/** Get User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID();

	public I_AD_User getAD_User() throws RuntimeException;

    /** Column name AmtTotal */
    public static final String COLUMNNAME_AmtTotal = "AmtTotal";

	/** Set AmtTotal.
	  * Monto total
	  */
	public void setAmtTotal(BigDecimal AmtTotal);

	/** Get AmtTotal.
	  * Monto total
	  */
	public BigDecimal getAmtTotal();

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID(int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_Invoice_ID */
    public static final String COLUMNNAME_C_Invoice_ID = "C_Invoice_ID";

	/** Set Invoice.
	  * Invoice Identifier
	  */
	public void setC_Invoice_ID(int C_Invoice_ID);

	/** Get Invoice.
	  * Invoice Identifier
	  */
	public int getC_Invoice_ID();

	public I_C_Invoice getC_Invoice() throws RuntimeException;

    /** Column name Conty_CodImpu */
    public static final String COLUMNNAME_Conty_CodImpu = "Conty_CodImpu";

	/** Set Conty_CodImpu.
	  * Codigo de impuesto para interface con Conty
	  */
	public void setConty_CodImpu(String Conty_CodImpu);

	/** Get Conty_CodImpu.
	  * Codigo de impuesto para interface con Conty
	  */
	public String getConty_CodImpu();

    /** Column name Conty_CodIva */
    public static final String COLUMNNAME_Conty_CodIva = "Conty_CodIva";

	/** Set Conty_CodIva.
	  * Codigo de IVA para interface con Conty
	  */
	public void setConty_CodIva(String Conty_CodIva);

	/** Get Conty_CodIva.
	  * Codigo de IVA para interface con Conty
	  */
	public String getConty_CodIva();

    /** Column name Conty_Impu */
    public static final String COLUMNNAME_Conty_Impu = "Conty_Impu";

	/** Set Conty_Impu.
	  * Atributo de Impuesto para interface con Conty
	  */
	public void setConty_Impu(String Conty_Impu);

	/** Get Conty_Impu.
	  * Atributo de Impuesto para interface con Conty
	  */
	public String getConty_Impu();

    /** Column name Conty_IVA */
    public static final String COLUMNNAME_Conty_IVA = "Conty_IVA";

	/** Set Conty_IVA.
	  * Atributo de IVA para interface con Conty
	  */
	public void setConty_IVA(String Conty_IVA);

	/** Get Conty_IVA.
	  * Atributo de IVA para interface con Conty
	  */
	public String getConty_IVA();

    /** Column name Conty_Libro */
    public static final String COLUMNNAME_Conty_Libro = "Conty_Libro";

	/** Set Conty_Libro.
	  * Atributo de Libro para interface con Conty
	  */
	public void setConty_Libro(String Conty_Libro);

	/** Get Conty_Libro.
	  * Atributo de Libro para interface con Conty
	  */
	public String getConty_Libro();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name CurrencyRate */
    public static final String COLUMNNAME_CurrencyRate = "CurrencyRate";

	/** Set Rate.
	  * Currency Conversion Rate
	  */
	public void setCurrencyRate(BigDecimal CurrencyRate);

	/** Get Rate.
	  * Currency Conversion Rate
	  */
	public BigDecimal getCurrencyRate();

    /** Column name CurSymbol */
    public static final String COLUMNNAME_CurSymbol = "CurSymbol";

	/** Set Symbol.
	  * Symbol of the currency (opt used for printing only)
	  */
	public void setCurSymbol(String CurSymbol);

	/** Get Symbol.
	  * Symbol of the currency (opt used for printing only)
	  */
	public String getCurSymbol();

    /** Column name DateTrx */
    public static final String COLUMNNAME_DateTrx = "DateTrx";

	/** Set Transaction Date.
	  * Transaction Date
	  */
	public void setDateTrx(Timestamp DateTrx);

	/** Get Transaction Date.
	  * Transaction Date
	  */
	public Timestamp getDateTrx();

    /** Column name DiaNro */
    public static final String COLUMNNAME_DiaNro = "DiaNro";

	/** Set DiaNro.
	  * Número de día del mes
	  */
	public void setDiaNro(int DiaNro);

	/** Get DiaNro.
	  * Número de día del mes
	  */
	public int getDiaNro();

    /** Column name DocumentNoRef */
    public static final String COLUMNNAME_DocumentNoRef = "DocumentNoRef";

	/** Set DocumentNoRef.
	  * Numero de documento referenciado
	  */
	public void setDocumentNoRef(String DocumentNoRef);

	/** Get DocumentNoRef.
	  * Numero de documento referenciado
	  */
	public String getDocumentNoRef();

    /** Column name DocumentSerie */
    public static final String COLUMNNAME_DocumentSerie = "DocumentSerie";

	/** Set DocumentSerie.
	  * Serie de un Documento
	  */
	public void setDocumentSerie(String DocumentSerie);

	/** Get DocumentSerie.
	  * Serie de un Documento
	  */
	public String getDocumentSerie();

    /** Column name DocumentType */
    public static final String COLUMNNAME_DocumentType = "DocumentType";

	/** Set Document Type.
	  * Document Type
	  */
	public void setDocumentType(String DocumentType);

	/** Get Document Type.
	  * Document Type
	  */
	public String getDocumentType();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive(boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name NroLocal */
    public static final String COLUMNNAME_NroLocal = "NroLocal";

	/** Set NroLocal.
	  * Número de Local
	  */
	public void setNroLocal(String NroLocal);

	/** Get NroLocal.
	  * Número de Local
	  */
	public String getNroLocal();

    /** Column name TaxID */
    public static final String COLUMNNAME_TaxID = "TaxID";

	/** Set Tax ID.
	  * Tax Identification
	  */
	public void setTaxID(String TaxID);

	/** Get Tax ID.
	  * Tax Identification
	  */
	public String getTaxID();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name Z_ContyAsientoCpra_ID */
    public static final String COLUMNNAME_Z_ContyAsientoCpra_ID = "Z_ContyAsientoCpra_ID";

	/** Set Z_ContyAsientoCpra ID	  */
	public void setZ_ContyAsientoCpra_ID(int Z_ContyAsientoCpra_ID);

	/** Get Z_ContyAsientoCpra ID	  */
	public int getZ_ContyAsientoCpra_ID();
}
