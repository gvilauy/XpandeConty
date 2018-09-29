package org.xpande.conty.model;

import org.compiere.model.Query;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Modelo para configuraciones de interface contra sistema contable Conty.
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 2/19/18.
 */
public class MZContyConfig extends X_Z_ContyConfig {

    public MZContyConfig(Properties ctx, int Z_ContyConfig_ID, String trxName) {
        super(ctx, Z_ContyConfig_ID, trxName);
    }

    public MZContyConfig(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }


    /***
     * Obtiene modelo único de configuración de interface Conty.
     * Xpande. Created by Gabriel Vila on 2/19/18.
     * @param ctx
     * @param trxName
     * @return
     */
    public static MZContyConfig getDefault(Properties ctx, String trxName){

        MZContyConfig model = new Query(ctx, I_Z_ContyConfig.Table_Name, "", trxName).first();

        return model;
    }

}
