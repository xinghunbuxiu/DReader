package com.duokan.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/**
 * context 转换
 */
public abstract class TansFormUtils {
    public static final Activity getContext(Context context) {
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
