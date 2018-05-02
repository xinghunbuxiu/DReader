package com.duokan.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;

public abstract class AppManage {
    public static Activity getCurrentActivity(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    public static boolean isFinishing(Activity activity) {
        if (VERSION.SDK_INT >= 17) {
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return false;
            }
            return true;
        } else if (activity == null || activity.isFinishing()) {
            return false;
        } else {
            return true;
        }
    }
}
