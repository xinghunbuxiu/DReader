package com.duokan.core.app;

import android.content.Context;

public class QueryFeatureWrapper extends MyContextWrapper {
    private final IFeature feature;

    public QueryFeatureWrapper(Context context) {
        super(TansFormUtils.getContext(context));
        this.feature = MyContextWrapper.getFeature(context);
    }

    public FeatureListening queryFeature(Class cls) {
        FeatureListening listening = registerLocalFeature(cls);
        if (listening != null) {
            return listening;
        }
        listening = this.feature.queryFeature(cls);
        return listening == null ? getFeature().queryFeature(cls) : listening;
    }
}
