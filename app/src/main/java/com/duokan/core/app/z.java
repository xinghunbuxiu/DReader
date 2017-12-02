package com.duokan.core.app;

import android.content.Context;

public class z extends x {
    private final y a;

    public z(Context context) {
        super(b.a(context));
        this.a = x.a(context);
    }

    public k queryFeature(Class cls) {
        k a = a(cls);
        if (a != null) {
            return a;
        }
        a = this.a.queryFeature(cls);
        return a == null ? a().queryFeature(cls) : a;
    }
}
