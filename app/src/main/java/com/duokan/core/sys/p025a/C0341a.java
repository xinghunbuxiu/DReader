package com.duokan.core.sys.p025a;

import android.support.v4.content.ContextCompat;
import com.duokan.core.app.BaseActivity;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;

/* renamed from: com.duokan.core.sys.a.a */
public class C0341a implements C0340e {
    /* renamed from: a */
    private final String f592a = "android.permission.CAMERA";
    /* renamed from: b */
    private final BaseActivity f593b;

    private C0341a(BaseActivity mActivity) {
        this.f593b = mActivity;
    }

    /* renamed from: a */
    public static C0341a m822a(BaseActivity mActivity) {
        return new C0341a(mActivity);
    }

    /* renamed from: a */
    public void m824a(IPermissionsResultListener rermissionsResult) {
        if (!m826c()) {
            new RequestPermissionsResult(this.f593b, (C0340e) this, rermissionsResult).requestPermissions();
        } else if (m827d()) {
            rermissionsResult.onSuccess();
        } else {
            new C0344b(this.f593b, this, rermissionsResult).m829a();
        }
    }

    /* renamed from: a */
    public String mo399a() {
        return "android.permission.CAMERA";
    }

    /* renamed from: b */
    public String mo400b() {
        return DkApp.get().getString(C0247i.welcome__camera_access_view__prompt);
    }

    /* renamed from: c */
    public boolean m826c() {
        return ContextCompat.checkSelfPermission(DkApp.get(), "android.permission.CAMERA") == 0;
    }

    /* renamed from: d */
    public boolean m827d() {
        return !DkApp.get().inCtaMode() || DkApp.get().isCameraPermissionConfirmed();
    }

    /* renamed from: e */
    public void mo401e() {
        DkApp.get().setCameraPermissionConfirmed();
    }
}
