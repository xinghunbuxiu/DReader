package com.duokan.common;

import android.content.Context;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.sys.p025a.C0347g;

/* renamed from: com.duokan.common.j */
public class C0268j {
    /* renamed from: a */
    public static void m612a(BaseActivity mActivity, String str) {
        C0347g.m835a(mActivity).m837a(new C0270k(str, mActivity));
    }

    /* renamed from: a */
    public static void m613a(BaseActivity mActivity, String str, String str2) {
        C0347g.m835a(mActivity).m837a(new C0271l(str, str2, mActivity));
    }

    /* renamed from: a */
    public static boolean m614a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }
}
