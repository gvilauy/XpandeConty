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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for Z_ContyConfigTax
 *  @author Adempiere (generated) 
 *  @version Release 3.9.0 - $Id$ */
public class X_Z_ContyConfigTax extends PO implements I_Z_ContyConfigTax, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20180219L;

    /** Standard Constructor */
    public X_Z_ContyConfigTax (Properties ctx, int Z_ContyConfigTax_ID, String trxName)
    {
      super (ctx, Z_ContyConfigTax_ID, trxName);
      /** if (Z_ContyConfigTax_ID == 0)
        {
			setC_Tax_ID (0);
			setV_Liability_Acct (0);
			setZ_ContyConfig_ID (0);
			setZ_ContyConfigTax_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_ContyConfigTax (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Z_ContyConfigTax[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_C_Tax getC_Tax() throws RuntimeException
    {
		return (I_C_Tax)MTable.get(getCtx(), I_C_Tax.Table_Name)
			.getPO(getC_Tax_ID(), get_TrxName());	}

	/** Set Tax.
		@param C_Tax_ID 
		Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID)
	{
		if (C_Tax_ID < 1) 
			set_Value (COLUMNNAME_C_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
	}

	/** Get Tax.
		@return Tax identifier
	  */
	public int getC_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_ValidCombination getV_Liability_A() throws RuntimeException
    {
		return (I_C_ValidCombination)MTable.get(getCtx(), I_C_ValidCombination.Table_Name)
			.getPO(getV_Liability_Acct(), get_TrxName());	}

	/** Set Vendor Liability.
		@param V_Liability_Acct 
		Account for Vendor Liability
	  */
	public void setV_Liability_Acct (int V_Liability_Acct)
	{
		set_Value (COLUMNNAME_V_Liability_Acct, Integer.valueOf(V_Liability_Acct));
	}

	/** Get Vendor Liability.
		@return Account for Vendor Liability
	  */
	public int getV_Liability_Acct () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_V_Liability_Acct);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.xpande.conty.model.I_Z_ContyConfig getZ_ContyConfig() throws RuntimeException
    {
		return (org.xpande.conty.model.I_Z_ContyConfig)MTable.get(getCtx(), org.xpande.conty.model.I_Z_ContyConfig.Table_Name)
			.getPO(getZ_ContyConfig_ID(), get_TrxName());	}

	/** Set Z_ContyConfig ID.
		@param Z_ContyConfig_ID Z_ContyConfig ID	  */
	public void setZ_ContyConfig_ID (int Z_ContyConfig_ID)
	{
		if (Z_ContyConfig_ID < 1) 
			set_Value (COLUMNNAME_Z_ContyConfig_ID, null);
		else 
			set_Value (COLUMNNAME_Z_ContyConfig_ID, Integer.valueOf(Z_ContyConfig_ID));
	}

	/** Get Z_ContyConfig ID.
		@return Z_ContyConfig ID	  */
	public int getZ_ContyConfig_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_ContyConfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Z_ContyConfigTax ID.
		@param Z_ContyConfigTax_ID Z_ContyConfigTax ID	  */
	public void setZ_ContyConfigTax_ID (int Z_ContyConfigTax_ID)
	{
		if (Z_ContyConfigTax_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_ContyConfigTax_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_ContyConfigTax_ID, Integer.valueOf(Z_ContyConfigTax_ID));
	}

	/** Get Z_ContyConfigTax ID.
		@return Z_ContyConfigTax ID	  */
	public int getZ_ContyConfigTax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_ContyConfigTax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}