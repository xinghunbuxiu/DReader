package com.duokan.core.app;

/**
 * 特征监听
 */
public interface IFeature {
    <T extends FeatureListening> T queryFeature(Class<T> cls);

    boolean registerGlobalFeature(FeatureListening featurelistening);

    boolean unregisterGlobalFeature(FeatureListening featurelistening);
}
