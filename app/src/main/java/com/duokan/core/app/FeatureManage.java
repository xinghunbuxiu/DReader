package com.duokan.core.app;

import java.util.Iterator;
import java.util.LinkedList;

class FeatureManage {
    private final LinkedList<FeatureListening> featureListenings = new LinkedList();

    public final synchronized <T extends FeatureListening> T isContainsListener(Class<T> cls) {
        T t;
        if (cls == null) {
            t = null;
        } else {
            Iterator<FeatureListening> it = this.featureListenings.iterator();
            while (it.hasNext()) {
                FeatureListening featureListening = it.next();
                if (cls.isAssignableFrom(featureListening.getClass())) {
                    featureListening = cls.cast(featureListening);
                    break;
                }
            }
            t = null;
        }
        return t;
    }

    /* renamed from: a */
    public final synchronized boolean addFeatureListener(FeatureListening featureListening) {
        boolean z;
        if (featureListening == null) {
            z = false;
        } else {
            this.featureListenings.remove(featureListening);
            this.featureListenings.addFirst(featureListening);
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public final synchronized boolean removeFeatureListener(FeatureListening featureListening) {
        boolean z;
        if (featureListening == null) {
            z = true;
        } else {
            z = this.featureListenings.remove(featureListening);
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized void clearFeatureListener() {
        this.featureListenings.clear();
    }
}
