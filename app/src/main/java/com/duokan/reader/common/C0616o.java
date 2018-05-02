package com.duokan.reader.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.C0373z;

/* renamed from: com.duokan.reader.common.o */
public class C0616o implements ai {
    /* renamed from: a */
    static aj<C0616o> f2042a = new aj();
    /* renamed from: b */
    private final String f2043b = "1004465";
    /* renamed from: c */
    private final String f2044c = "887730266790";
    /* renamed from: d */
    private final String f2045d = "azu4PuDkoT4IDrn2wp9yUrxJfcCCcD2XHGWYSUErIFrY6GGp87ayZWPXSrfGCWk_Re41wQGXeSfFs5IzPyHQDA";
    /* renamed from: e */
    private final String f2046e = "293446969722930176";
    /* renamed from: f */
    private final String f2047f = "CbTmNeehyzoEY1PUp7VNfIS5U-R16hPtn-iE9FYKlgE";
    /* renamed from: g */
    private boolean f2048g = false;
    /* renamed from: h */
    private boolean f2049h = false;
    /* renamed from: i */
    private final Context f2050i;
    /* renamed from: j */
    private C0619r f2051j = null;

    private C0616o(Context context) {
        this.f2050i = context;
        this.f2048g = m2813c();
    }

    /* renamed from: a */
    public static void m2807a(Context context) {
        f2042a.m709a(new C0616o(context));
    }

    /* renamed from: a */
    public static C0616o m2804a() {
        return (C0616o) f2042a.m707a();
    }

    /* renamed from: a */
    public void m2811a(String str) {
        if (str.length() > 0) {
            UThread.runOnThread(new C0617p(this, str));
        }
    }

    /* renamed from: b */
    public final boolean m2812b() {
        return this.f2049h;
    }

    /* renamed from: c */
    public boolean m2813c() {
        if (!C0373z.m1052a()) {
            return false;
        }
        PackageInfo packageInfo;
        try {
            this.f2050i.getPackageManager().getPackageInfo("com.xiaomi.mibrain.speech", 0);
            packageInfo = this.f2050i.getPackageManager().getPackageInfo("com.xiaomi.mibrain.speech", 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null || C0616o.m2809b(packageInfo.versionName) <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static int m2809b(String str) {
        int i = 0;
        if (str == null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = "1.0.3".split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i2 = 0; i2 < min; i2++) {
            i = split[i2].length() - split2[i2].length();
            if (i != 0) {
                break;
            }
            i = split[i2].compareTo(split2[i2]);
            if (i != 0) {
                break;
            }
        }
        if (i == 0) {
            return split.length - split2.length;
        }
        return i;
    }

    /* renamed from: a */
    public void m2810a(C0619r c0619r) {
        WebLog.init().w();
        this.f2051j = c0619r;
        if (this.f2048g) {
            try {
                this.f2049h = true;
                Intent intent = new Intent("com.xiaomi.mibrain.action.RECOGNIZE_SPEECH");
                intent.setPackage("com.xiaomi.mibrain.speech");
                intent.putExtra("appId", "1004465");
                intent.putExtra("appToken", "887730266790");
                intent.putExtra("miref", ManagedApp.get().getPackageName());
                intent.putExtra("client_id", "293446969722930176");
                intent.putExtra("api_key", "CbTmNeehyzoEY1PUp7VNfIS5U-R16hPtn-iE9FYKlgE");
                intent.putExtra("sign_secret", "azu4PuDkoT4IDrn2wp9yUrxJfcCCcD2XHGWYSUErIFrY6GGp87ayZWPXSrfGCWk_Re41wQGXeSfFs5IzPyHQDA");
                Activity topActivity = ManagedApp.get().getTopActivity();
                if (topActivity instanceof BaseActivity) {
                    BaseActivity mActivity = (BaseActivity) topActivity;
                    mActivity.addOnActivityResultListener(new C0618q(this, mActivity));
                    topActivity.startActivityForResult(intent, 1001);
                }
            } catch (Throwable e) {
                WebLog.init().printStackTrace(LogLevel.ERROR, "xiaoAi", "xiaoai engine error", e);
            }
        }
    }

    /* renamed from: d */
    public boolean m2814d() {
        return this.f2048g;
    }
}
