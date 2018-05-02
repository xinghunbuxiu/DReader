package com.duokan.core.app;

import android.content.Context;

import java.lang.ref.WeakReference;

final class ContextManager extends AppContext {
    private final IFeature feature;
    private final WeakReference<ActivatedController> controllerWeakReference;

    protected ContextManager(IFeature mFeature, ActivatedController controller) {
        super(AppManage.getCurrentActivity((Context) mFeature));
        this.feature = mFeature;
        this.controllerWeakReference = new WeakReference(controller);
    }

    public <T extends FeatureListening> T isContainsListener(Class<T> cls) {
        if (this.controllerWeakReference.get() == null) {
            return null;
        }
        return super.isContainsListener(cls);
    }

    public <T extends FeatureListening> T queryFeature(Class<T> cls) {
        T feature = isContainsListener(cls);
        if (feature != null) {
            return feature;
        }
        IFeature b = getFeature();
        if (b != null) {
            feature = b.queryFeature(cls);
        }
        if (feature != null) {
            return feature;
        }
        IFeature c = getCurrentFeature();
        if (!(c == null || c == b)) {
            feature = c.queryFeature(cls);
        }
        if (feature == null) {
            return getAppContext().queryFeature(cls);
        }
        return feature;
    }

    private final IFeature getFeature() {
        ActivatedController activatedController = this.controllerWeakReference.get();
        if (activatedController == null) {
            return null;
        }
        ISubControllerParent parent = activatedController.getParent();
        if (parent == null) {
            return null;
        }
        return parent.getContext();
    }

    private final IFeature getCurrentFeature() {
        return this.feature;
    }
}
