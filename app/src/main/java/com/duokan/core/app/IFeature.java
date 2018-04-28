package com.duokan.core.app;

public interface IFeature {
    <T extends FeatureListening> T queryFeature(Class<T> cls);

    boolean registerGlobalFeature(FeatureListening featureListening);

    boolean unregisterGlobalFeature(FeatureListening featureListening);
}
