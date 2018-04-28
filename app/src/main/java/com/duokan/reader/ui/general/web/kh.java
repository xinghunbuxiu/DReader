package com.duokan.reader.ui.general.web;

import android.app.Activity;
import android.content.Intent;
import com.duokan.core.app.AppManage;
import com.duokan.reader.domain.ad.C0745b;
import com.duokan.reader.domain.ad.C0748e;
import org.json.JSONObject;

class kh implements C0745b {
    /* renamed from: a */
    final /* synthetic */ JSONObject f8095a;
    /* renamed from: b */
    final /* synthetic */ C0748e f8096b;
    /* renamed from: c */
    final /* synthetic */ kg f8097c;

    kh(kg kgVar, JSONObject jSONObject, C0748e c0748e) {
        this.f8097c = kgVar;
        this.f8095a = jSONObject;
        this.f8096b = c0748e;
    }

    /* renamed from: a */
    public void mo1849a() {
        m11255a("CODE_DOWNLOAD_START");
    }

    /* renamed from: b */
    public void mo1851b() {
        m11255a("CODE_DOWNLOAD_SUCCESS");
    }

    /* renamed from: c */
    public void mo1852c() {
        m11255a("CODE_INSTALL_SUCCESS");
        if (Boolean.valueOf(this.f8095a.optString("openAfterInstall", "false")).booleanValue()) {
            Intent launchIntentForPackage = this.f8097c.f8094b.f7581b.getContext().getPackageManager().getLaunchIntentForPackage(this.f8096b.f2533r);
            if (launchIntentForPackage != null) {
                Activity a = AppManage.getCurrentActivity(this.f8097c.f8094b.f7581b.getContext());
                if (a != null) {
                    a.startActivity(launchIntentForPackage);
                }
            }
        }
    }

    /* renamed from: d */
    public void mo1853d() {
    }

    /* renamed from: e */
    public void mo1854e() {
        m11255a("CODE_INSTALL_START");
    }

    /* renamed from: a */
    public void mo1850a(int i) {
        m11256a("CODE_DOWNLOAD_PROGRESS", i);
    }

    /* renamed from: a */
    private void m11255a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", str);
            jSONObject.put("packageName", this.f8096b.f2533r);
            this.f8097c.f8094b.f7581b.triggerEventOnCurrentUrl("adAppInstallStatus", jSONObject.toString());
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    private void m11256a(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", str);
            jSONObject.put("packageName", this.f8096b.f2533r);
            jSONObject.put("progress", i);
            this.f8097c.f8094b.f7581b.triggerEventOnCurrentUrl("adAppInstallStatus", jSONObject.toString());
        } catch (Throwable th) {
        }
    }
}
