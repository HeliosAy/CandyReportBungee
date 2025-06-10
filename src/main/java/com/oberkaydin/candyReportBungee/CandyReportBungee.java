package com.oberkaydin.candyReportBungee;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class CandyReportBungee extends Plugin {

    @Override
    public void onEnable() {
        PluginManager pm = getProxy().getPluginManager();

        pm.registerListener(this, new CandyReportMessageListener(this));

        getLogger().info("CandyReport BungeeCord plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CandyReport BungeeCord plugin disabled!");
    }
}
