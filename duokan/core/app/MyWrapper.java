package com.duokan.core.app;

import android.content.Context;

import java.lang.ref.WeakReference;

final class MyWrapper extends MyContextWrapper {
    private final IFeature feature;
    private final WeakReference<ActivatedController> reference;

    protected MyWrapper(IFeature feature, ActivatedController activatedController) {
        super(TansFormUtils.getContext((Context) feature));
        this.feature = feature;
        this.reference = new WeakReference(activatedController);
    }

    public  FeatureListening registerLocalFeature(Class cls) {
        if ((this.reference.get()) == null) {
            return null;
        }
        return super.registerLocalFeature(cls);
    }

    public FeatureListening queryFeature(Class cls) {
        FeatureListening featureListening = registerLocalFeature(cls);
        if (featureListening != null) {
            return featureListening;
        }
        IFeature feature = getWeakFeature();
        if (feature != null) {
            featureListening = feature.queryFeature(cls);
        }
        if (featureListening != null) {
            return featureListening;
        }
        IFeature c = getFeature();
        if (!(c == null || c == feature)) {
            featureListening = c.queryFeature(cls);
        }
        if (featureListening == null) {
            return getFeature().queryFeature(cls);
        }
        return featureListening;
    }

    private IFeature getWeakFeature() {
        ActivatedController activatedControllerVar = this.reference.get();
        if (activatedControllerVar == null) {
            return null;
        }
        IController parent = activatedControllerVar.getParent();
        if (parent == null) {
            return null;
        }
        return parent.getContext();
    }

    public final IFeature getFeature() {
        return this.feature;
    }
}
