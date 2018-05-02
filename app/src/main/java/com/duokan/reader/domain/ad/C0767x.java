package com.duokan.reader.domain.ad;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;

/* renamed from: com.duokan.reader.domain.ad.x */
public class C0767x {
    /* renamed from: a */
    public static boolean m3611a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (TextUtils.equals(resolveInfo.activityInfo.packageName, str)) {
                return true;
            }
        }
        return false;
    }
}
