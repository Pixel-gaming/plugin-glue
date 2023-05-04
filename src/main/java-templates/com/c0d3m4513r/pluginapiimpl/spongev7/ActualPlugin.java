package com.c0d3m4513r.pluginapiimpl.spongev7;

import com.google.inject.Inject;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.plugin.PluginContainer;

import java.io.IOException;
import java.nio.file.Path;

@org.spongepowered.api.plugin.Plugin(
        id = "${pluginid}",
        name = "${pluginname}",
        description = "${plugindescriptionb}",
        version = "${version}"
)
public class ActualPlugin {

    @Nullable
    @Inject(optional = true)
    @ConfigDir(sharedRoot = false)
    private Path configDir;

    @Nullable
    @Inject(optional = true)
    @DefaultConfig(sharedRoot = false)
    private Path configFile;

    @Inject
    public ActualPlugin(PluginContainer container, final org.slf4j.Logger logger) {
        new com.c0d3m4513r.pluginapiimpl.spongev7.Plugin(container, logger);
    }
}
