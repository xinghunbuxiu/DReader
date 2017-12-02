package com.duokan.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

public abstract class b {
    public static final Activity a(Context context) {
        Context context2 = context;
        while (!(context2 instanceof Activity)) {
            if (!(context2 instanceof ContextWrapper)) {
                return null;
            }
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        return (Activity) context2;
    }
}
