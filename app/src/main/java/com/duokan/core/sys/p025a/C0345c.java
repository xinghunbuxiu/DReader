package com.duokan.core.sys.p025a;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;

/* renamed from: com.duokan.core.sys.a.c */
public class C0345c {
    /* renamed from: a */
    public static String m830a() {
        String str;
        if (ReaderEnv.get().onMiui()) {
            try {
                Class cls = Class.forName("miui.telephony.TelephonyManagerEx");
                str = (String) cls.getDeclaredMethod("getMiuiDeviceId", new Class[0]).invoke(cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]), new Object[0]);
            } catch (Throwable th) {
                str = null;
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return ((TelephonyManager) DkApp.get().getSystemService("phone")).getDeviceId();
        }
        return str;
    }
}
