package com.duokan.reader.domain.ad;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.ui.general.be;
import com.miui.systemAdSolution.landingPage.ILandingPageService;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.ad.r */
public class C0761r {
    /* renamed from: a */
    private boolean f2583a = false;
    /* renamed from: b */
    private final String f2584b = "com.miui.systemAdSolution";
    /* renamed from: c */
    private ILandingPageService f2585c = null;
    /* renamed from: d */
    private final C0744a f2586d;

    public C0761r(C0744a c0744a) {
        boolean z = true;
        try {
            int i;
            if (ReaderEnv.get().onMiui()) {
                i = DkApp.get().getPackageManager().getPackageInfo("com.miui.systemAdSolution", 0).versionCode;
            } else {
                i = 0;
            }
            Intent intent = new Intent("miui.intent.action.ad.LANDING_PAGE_SERVICE");
            intent.setPackage("com.miui.systemAdSolution");
            ServiceConnection c0762s = new C0762s(this);
            if (i < DkApp.get().supportAdSdkVersion() || !DkApp.get().bindService(intent, c0762s, 1)) {
                z = false;
            }
            this.f2583a = z;
        } catch (Throwable th) {
        }
        this.f2586d = c0744a;
    }

    /* renamed from: a */
    public boolean m3610a() {
        return this.f2583a;
    }

    /* renamed from: a */
    public void m3609a(C0748e c0748e) {
        if (C0767x.m3611a(DkApp.get(), c0748e.f2533r) || !m3610a()) {
            try {
                DkApp.get().getTopActivity().startActivity(Intent.parseUri(c0748e.f2531p, 0));
                return;
            } catch (Throwable th) {
                return;
            }
        }
        if (!c0748e.f2537v) {
            if (C0559f.m2476b().m2485d()) {
                be.m10286a(DkApp.get(), C0247i.general__shared__start_download, 0).show();
                WebLog.init().c(LogLevel.INFO, "task_wall", "wifi connected");
            }
            c0748e.f2537v = true;
        }
        String b = m3608b(c0748e);
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("startAppFlags", false);
            bundle.putBoolean("showCancelFlags", true);
            if (!TextUtils.isEmpty(c0748e.f2535t)) {
                bundle.putString("apkChannel", c0748e.f2535t);
            }
            this.f2585c.registerListener(b, new C0763t(this, c0748e));
            this.f2585c.startDownload(b, bundle);
            WebLog.init().c(LogLevel.INFO, "task_wall", "download start");
        } catch (Throwable th2) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "task_wall", "unexpected exception!", th2);
        }
    }

    /* renamed from: b */
    private String m3608b(C0748e c0748e) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("package", c0748e.f2533r);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
