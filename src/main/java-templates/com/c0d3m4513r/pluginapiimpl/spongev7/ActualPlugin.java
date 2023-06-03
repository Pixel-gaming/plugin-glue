package com.c0d3m4513r.pluginapiimpl.spongev7;

import com.c0d3m4513r.pluginapi.PluginInfo;
import com.c0d3m4513r.pluginapi.config.MainConfig;
import com.google.inject.Inject;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.spongepowered.api.asset.Asset;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.*;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.plugin.meta.PluginDependency;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@org.spongepowered.api.plugin.Plugin(
        id = "${pluginid}",
        name = "${pluginname}",
        description = "${plugindescription}",
        version = "${versionName}"
)
@SuppressWarnings("type.anno.before.decl.anno")
public class ActualPlugin extends PluginLoader<${mainConfigPath}> implements PluginContainer {
    public final PluginInfo pluginInfo = new PluginInfo(
            "${pluginid}",
            "${pluginname}",
            "${plugindescription}",
            "${versionName}",
            "${mainConfigPath}"
    );
    @Nullable
    @Inject(optional = true)
    @ConfigDir(sharedRoot = false)
    private Path configDir;

    @Nullable
    @Inject(optional = true)
    @DefaultConfig(sharedRoot = false)
    private Path configFile;
    private PluginContainer container;
    private Plugin plugin;
    @Inject
    public ActualPlugin(PluginContainer container, final org.slf4j.Logger logger) throws IOException{
        this.container = container;
        plugin = new com.c0d3m4513r.pluginapiimpl.spongev7.Plugin(this, logger, configDir, configFile);
    }

    @Listener
    public void Preinit(Event event) {
        handler.accept(event);
    }

    @Override
    public ${mainConfigPath} getNewConfig() {
        return new ${mainConfigPath}();
    }

    @Override
    public PluginInfo getPluginInfo(){
        return pluginInfo;
    }

    @Override
    public String getId(){
        return pluginInfo.getId();
    }

    @Override
    public @NonNull Optional<String> getVersion() {
        return Optional.of(pluginInfo.getVersion());
    }

    @Override
    public @NonNull Optional<String> getDescription() {
        return Optional.of(pluginInfo.getDescription());
    }


    public @NonNull Optional<String> getUrl() {
        return container.getUrl();
    }

    @Override
    public @NonNull List<String> getAuthors() {
        return container.getAuthors();
    }

    @Override
    public @NonNull Set<PluginDependency> getDependencies() {
        return container.getDependencies();
    }

    @Override
    public @NonNull Optional<PluginDependency> getDependency(@NonNull String id) {
        return container.getDependency(id);
    }

    @Override
    public @NonNull Optional<Asset> getAsset(@NonNull String name) {
        return container.getAsset(name);
    }

    @Override
    public @NonNull Optional<Path> getSource() {
        return container.getSource();
    }


    @Override
    public @NonNull Optional<?> getInstance() {
        return container.getInstance();
    }

    @Override
    public @NonNull Logger getLogger() {
        return container.getLogger();
    }
}
