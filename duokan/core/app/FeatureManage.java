package com.duokan.core.app;

import java.util.Iterator;
import java.util.LinkedList;

class FeatureManage {
    private final LinkedList<FeatureListening> featureListenings = new LinkedList();

    public final synchronized FeatureListening addFirst(Class cls) {
        FeatureListening featurelistening = null;
        if (cls != null) {
            Iterator<FeatureListening> it = this.featureListenings.iterator();
            while (it.hasNext()) {
                featurelistening = it.next();
                if (cls.isAssignableFrom(featurelistening.getClass())) {
                    featurelistening = (FeatureListening) cls.cast(featurelistening);
                    break;
                }
            }
        }
        return featurelistening;
    }

    public final synchronized boolean addFirst(FeatureListening featurelistening) {
        if (featurelistening != null) {
            this.featureListenings.remove(featurelistening);
            this.featureListenings.addFirst(featurelistening);
            return true;
        }
        return false;
    }

    public final synchronized boolean remove(FeatureListening featurelistening) {
        boolean z = true;
        if (featurelistening != null) {
            z = this.featureListenings.remove(featurelistening);
        }
        return z;
    }

    public final synchronized void clear() {
        this.featureListenings.clear();
    }
}
