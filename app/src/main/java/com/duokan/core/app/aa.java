package com.duokan.core.app;

import android.content.Context;

public class aa extends AppContext {
    /* renamed from: a */
    private final IFeature f506a;

    public aa(Context context) {
        super(AppManage.getCurrentActivity(context));
        this.f506a = AppContext.getAppContext(context);
    }

    public <T extends FeatureListening> T queryFeature(Class<T> cls) {
        T a = isContainsListener((Class) cls);
        if (a != null) {
            return a;
        }
        a = this.f506a.queryFeature(cls);
        return a == null ? getAppContext().queryFeature(cls) : a;
    }
}
