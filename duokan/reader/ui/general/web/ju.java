package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.ad.b;
import com.duokan.reader.domain.ad.e;

import org.json.JSONObject;

class ju implements b {
    final /* synthetic */ e a;
    final /* synthetic */ jt b;

    ju(jt jtVar, e eVar) {
        this.b = jtVar;
        this.a = eVar;
    }

    public void a() {
        a("CODE_DOWNLOAD_START");
    }

    public void b() {
        a("CODE_DOWNLOAD_SUCCESS");
    }

    public void c() {
        a("CODE_INSTALL_SUCCESS");
    }

    public void d() {
    }

    public void e() {
        a("CODE_INSTALL_START");
    }

    public void a(int i) {
        a("CODE_DOWNLOAD_PROGRESS", i);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", str);
            jSONObject.put("packageName", this.a.r);
            this.b.b.pageController.triggerEventOnCurrentUrl("adAppInstallStatus", jSONObject.toString());
        } catch (Throwable th) {
        }
    }

    private void a(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", str);
            jSONObject.put("packageName", this.a.r);
            jSONObject.put("progress", i);
            this.b.b.pageController.triggerEventOnCurrentUrl("adAppInstallStatus", jSONObject.toString());
        } catch (Throwable th) {
        }
    }
}
