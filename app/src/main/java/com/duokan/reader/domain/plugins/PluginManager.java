package com.duokan.reader.domain.plugins;

public abstract class PluginManager {
    static final /* synthetic */ boolean a = (!PluginManager.class.desiredAssertionStatus());

    public enum PluginState {
        INSTALLED,
        INSTALLING,
        INSTALL_FAILED,
        DISABLE
    }
}
