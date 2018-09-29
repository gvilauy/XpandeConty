package org.xpande.conty.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Modelo para interface de asientos de compra a Conty.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 2/19/18.
 */
public class MZContyAsientoCpra extends X_Z_ContyAsientoCpra {

    public MZContyAsientoCpra(Properties ctx, int Z_ContyAsientoCpra_ID, String trxName) {
        super(ctx, Z_ContyAsientoCpra_ID, trxName);
    }

    public MZContyAsientoCpra(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
