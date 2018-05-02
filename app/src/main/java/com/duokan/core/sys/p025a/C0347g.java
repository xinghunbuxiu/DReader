package com.duokan.core.sys.p025a;

import android.support.v4.content.ContextCompat;
import com.duokan.core.app.BaseActivity;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;

/* renamed from: com.duokan.core.sys.a.g */
public class C0347g implements C0340e {
    /* renamed from: a */
    private final String f619a = "android.permission.SEND_SMS";
    /* renamed from: b */
    private final BaseActivity f620b;

    private C0347g(BaseActivity mActivity) {
        this.f620b = mActivity;
    }

    /* renamed from: a */
    public void m837a(IPermissionsResultListener rermissionsResult) {
        if (!m839c()) {
            new RequestPermissionsResult(this.f620b, (C0340e) this, rermissionsResult).requestPermissions();
        } else if (m840d()) {
            rermissionsResult.onSuccess();
        } else {
            new C0344b(this.f620b, this, rermissionsResult).m829a();
        }
    }

    /* renamed from: a */
    public static C0347g m835a(BaseActivity mActivity) {
        return new C0347g(mActivity);
    }

    /* renamed from: a */
    public String mo399a() {
        return "android.permission.SEND_SMS";
    }

    /* renamed from: b */
    public String mo400b() {
        return DkApp.get().getString(C0247i.welcome__sms_access_view__prompt);
    }

    /* renamed from: c */
    public boolean m839c() {
        return ContextCompat.checkSelfPermission(DkApp.get(), "android.permission.SEND_SMS") == 0;
    }

    /* renamed from: d */
    public boolean m840d() {
        return true;
    }

    /* renamed from: e */
    public void mo401e() {
        DkApp.get().setSmsPermissionConfirmed();
    }
}
