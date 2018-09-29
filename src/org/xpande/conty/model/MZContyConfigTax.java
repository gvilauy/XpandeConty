package org.xpande.conty.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Modelo de parametrización de cuentas contables de mercaderia segun tipo de impuesto.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 2/19/18.
 */
public class MZContyConfigTax extends X_Z_ContyConfigTax {

    public MZContyConfigTax(Properties ctx, int Z_ContyConfigTax_ID, String trxName) {
        super(ctx, Z_ContyConfigTax_ID, trxName);
    }

    public MZContyConfigTax(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
