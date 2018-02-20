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
/** Generated Model - DO NOT CHANGE */
package org.xpande.conty.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for Z_ContyAsientoCpra
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_ContyAsientoCpra extends PO implements I_Z_ContyAsientoCpra, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180219L;

    /** Standard Constructor */
    public X_Z_ContyAsientoCpra (Properties ctx, int Z_ContyAsientoCpra_ID, String trxName)
    {
      super (ctx, Z_ContyAsientoCpra_ID, trxName);
      /** if (Z_ContyAsientoCpra_ID == 0)
        {
			setAD_User_ID (0);
			setC_Invoice_ID (0);
			setZ_ContyAsientoCpra_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_ContyAsientoCpra (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_Z_ContyAsientoCpra[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AcctValueCr.
		@param AcctValueCr 
		Codigo de cuenta contable al Credito
	  */
	public void setAcctValueCr (String AcctValueCr)
	{
		set_Value (COLUMNNAME_AcctValueCr, AcctValueCr);
	}

	/** Get AcctValueCr.
		@return Codigo de cuenta contable al Credito
	  */
	public String getAcctValueCr () 
	{
		return (String)get_Value(COLUMNNAME_AcctValueCr);
	}

	/** Set AcctValueDr.
		@param AcctValueDr 
		Codigo de cuenta contable al Débito
	  */
	public void setAcctValueDr (String AcctValueDr)
	{
		set_Value (COLUMNNAME_AcctValueDr, AcctValueDr);
	}

	/** Get AcctValueDr.
		@return Codigo de cuenta contable al Débito
	  */
	public String getAcctValueDr () 
	{
		return (String)get_Value(COLUMNNAME_AcctValueDr);
	}

	public I_AD_User getAD_User() throws RuntimeException
    {
		return (I_AD_User)MTable.get(getCtx(), I_AD_User.Table_Name)
			.getPO(getAD_User_ID(), get_TrxName());	}

	/** Set User/Contact.
		@param AD_User_ID 
		User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1) 
			set_Value (COLUMNNAME_AD_User_ID, null);
		else 
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AmtTotal.
		@param AmtTotal 
		Monto total
	  */
	public void setAmtTotal (BigDecimal AmtTotal)
	{
		set_Value (COLUMNNAME_AmtTotal, AmtTotal);
	}

	/** Get AmtTotal.
		@return Monto total
	  */
	public BigDecimal getAmtTotal () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmtTotal);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (I_C_BPartner)MTable.get(getCtx(), I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (I_C_Invoice)MTable.get(getCtx(), I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1) 
			set_Value (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Conty_CodImpu.
		@param Conty_CodImpu 
		Codigo de impuesto para interface con Conty
	  */
	public void setConty_CodImpu (String Conty_CodImpu)
	{
		set_Value (COLUMNNAME_Conty_CodImpu, Conty_CodImpu);
	}

	/** Get Conty_CodImpu.
		@return Codigo de impuesto para interface con Conty
	  */
	public String getConty_CodImpu () 
	{
		return (String)get_Value(COLUMNNAME_Conty_CodImpu);
	}

	/** Set Conty_CodIva.
		@param Conty_CodIva 
		Codigo de IVA para interface con Conty
	  */
	public void setConty_CodIva (String Conty_CodIva)
	{
		set_Value (COLUMNNAME_Conty_CodIva, Conty_CodIva);
	}

	/** Get Conty_CodIva.
		@return Codigo de IVA para interface con Conty
	  */
	public String getConty_CodIva () 
	{
		return (String)get_Value(COLUMNNAME_Conty_CodIva);
	}

	/** Set Conty_Impu.
		@param Conty_Impu 
		Atributo de Impuesto para interface con Conty
	  */
	public void setConty_Impu (String Conty_Impu)
	{
		set_Value (COLUMNNAME_Conty_Impu, Conty_Impu);
	}

	/** Get Conty_Impu.
		@return Atributo de Impuesto para interface con Conty
	  */
	public String getConty_Impu () 
	{
		return (String)get_Value(COLUMNNAME_Conty_Impu);
	}

	/** Set Conty_IVA.
		@param Conty_IVA 
		Atributo de IVA para interface con Conty
	  */
	public void setConty_IVA (String Conty_IVA)
	{
		set_Value (COLUMNNAME_Conty_IVA, Conty_IVA);
	}

	/** Get Conty_IVA.
		@return Atributo de IVA para interface con Conty
	  */
	public String getConty_IVA () 
	{
		return (String)get_Value(COLUMNNAME_Conty_IVA);
	}

	/** Set Conty_Libro.
		@param Conty_Libro 
		Atributo de Libro para interface con Conty
	  */
	public void setConty_Libro (String Conty_Libro)
	{
		set_Value (COLUMNNAME_Conty_Libro, Conty_Libro);
	}

	/** Get Conty_Libro.
		@return Atributo de Libro para interface con Conty
	  */
	public String getConty_Libro () 
	{
		return (String)get_Value(COLUMNNAME_Conty_Libro);
	}

	/** Set Rate.
		@param CurrencyRate 
		Currency Conversion Rate
	  */
	public void setCurrencyRate (BigDecimal CurrencyRate)
	{
		set_Value (COLUMNNAME_CurrencyRate, CurrencyRate);
	}

	/** Get Rate.
		@return Currency Conversion Rate
	  */
	public BigDecimal getCurrencyRate () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CurrencyRate);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Symbol.
		@param CurSymbol 
		Symbol of the currency (opt used for printing only)
	  */
	public void setCurSymbol (String CurSymbol)
	{
		set_Value (COLUMNNAME_CurSymbol, CurSymbol);
	}

	/** Get Symbol.
		@return Symbol of the currency (opt used for printing only)
	  */
	public String getCurSymbol () 
	{
		return (String)get_Value(COLUMNNAME_CurSymbol);
	}

	/** Set Transaction Date.
		@param DateTrx 
		Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx)
	{
		set_Value (COLUMNNAME_DateTrx, DateTrx);
	}

	/** Get Transaction Date.
		@return Transaction Date
	  */
	public Timestamp getDateTrx () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTrx);
	}

	/** Set DiaNro.
		@param DiaNro 
		Número de día del mes
	  */
	public void setDiaNro (int DiaNro)
	{
		set_Value (COLUMNNAME_DiaNro, Integer.valueOf(DiaNro));
	}

	/** Get DiaNro.
		@return Número de día del mes
	  */
	public int getDiaNro () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DiaNro);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DocumentNoRef.
		@param DocumentNoRef 
		Numero de documento referenciado
	  */
	public void setDocumentNoRef (String DocumentNoRef)
	{
		set_Value (COLUMNNAME_DocumentNoRef, DocumentNoRef);
	}

	/** Get DocumentNoRef.
		@return Numero de documento referenciado
	  */
	public String getDocumentNoRef () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNoRef);
	}

	/** Set DocumentSerie.
		@param DocumentSerie 
		Serie de un Documento
	  */
	public void setDocumentSerie (String DocumentSerie)
	{
		set_Value (COLUMNNAME_DocumentSerie, DocumentSerie);
	}

	/** Get DocumentSerie.
		@return Serie de un Documento
	  */
	public String getDocumentSerie () 
	{
		return (String)get_Value(COLUMNNAME_DocumentSerie);
	}

	/** Set Document Type.
		@param DocumentType 
		Document Type
	  */
	public void setDocumentType (String DocumentType)
	{
		set_Value (COLUMNNAME_DocumentType, DocumentType);
	}

	/** Get Document Type.
		@return Document Type
	  */
	public String getDocumentType () 
	{
		return (String)get_Value(COLUMNNAME_DocumentType);
	}

	/** Set NroLocal.
		@param NroLocal 
		Número de Local
	  */
	public void setNroLocal (String NroLocal)
	{
		set_Value (COLUMNNAME_NroLocal, NroLocal);
	}

	/** Get NroLocal.
		@return Número de Local
	  */
	public String getNroLocal () 
	{
		return (String)get_Value(COLUMNNAME_NroLocal);
	}

	/** Set Tax ID.
		@param TaxID 
		Tax Identification
	  */
	public void setTaxID (String TaxID)
	{
		set_Value (COLUMNNAME_TaxID, TaxID);
	}

	/** Get Tax ID.
		@return Tax Identification
	  */
	public String getTaxID () 
	{
		return (String)get_Value(COLUMNNAME_TaxID);
	}

	/** Set Z_ContyAsientoCpra ID.
		@param Z_ContyAsientoCpra_ID Z_ContyAsientoCpra ID	  */
	public void setZ_ContyAsientoCpra_ID (int Z_ContyAsientoCpra_ID)
	{
		if (Z_ContyAsientoCpra_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_ContyAsientoCpra_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_ContyAsientoCpra_ID, Integer.valueOf(Z_ContyAsientoCpra_ID));
	}

	/** Get Z_ContyAsientoCpra ID.
		@return Z_ContyAsientoCpra ID	  */
	public int getZ_ContyAsientoCpra_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_ContyAsientoCpra_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}