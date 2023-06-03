package com.c0d3m4513r.pluginapiimpl.spigot_v112;

import com.c0d3m4513r.pluginapi.PluginInfo;
import com.c0d3m4513r.pluginapi.config.MainConfig;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.IOException;

public class ActualPlugin extends PluginLoader<${mainConfigPath}> {
    public final PluginInfo pluginInfo = new PluginInfo(
            "${pluginid}",
            "${pluginname}",
            "${plugindescription}",
            "${versionName}",
            "${mainConfigPath}"
    );
    @NonNull
    Plugin plugin;
    public ActualPlugin() throws IOException {
        super();
        plugin = new Plugin(this);
    }
    public void onLoad() {
        plugin.onLoad();
    }
    public void onEnable() {
        plugin.onEnable();
    }
    public void onDisable() {
        plugin.onDisable();
    }

    @Override
    public void setPluginEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    @Override
    public ${mainConfigPath} getNewConfig() {
        return new ${mainConfigPath}();
    }

    @Override
    public PluginInfo getPluginInfo() {
        return pluginInfo;
    }
}
