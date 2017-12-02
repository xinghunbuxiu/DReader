package com.duokan.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class j {
    public static void a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("sms_body", str);
            intent.setType("vnd.android-dir/mms-sms");
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("smsto:" + str));
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("sms_body", str2);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }
}
