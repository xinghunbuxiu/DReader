package com.duokan.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class SysTools {
    /**
     * 发彩信
     *
     * @param context
     * @param str
     */
    public static void sendMmsSms(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("sms_body", str);
            intent.setType("vnd.android-dir/mms-sms");
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发邮件
     *
     * @param context
     * @param msg
     * @param value
     */
    public static void sendSms(Context context, String msg, String value) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("smsto:" + msg));
            if (!TextUtils.isEmpty(value)) {
                intent.putExtra("sms_body", value);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isSupportTelephony(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.sendSms");
    }
}
