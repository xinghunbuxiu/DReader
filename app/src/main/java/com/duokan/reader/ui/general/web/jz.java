package com.duokan.reader.ui.general.web;

import android.content.pm.PackageInfo;
import java.util.concurrent.Callable;
import org.json.JSONObject;

class jz implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ String f8080a;
    /* renamed from: b */
    final /* synthetic */ ci f8081b;

    jz(ci ciVar, String str) {
        this.f8081b = ciVar;
        this.f8080a = str;
    }

    public /* synthetic */ Object call() {
        return m11246a();
    }

    /* renamed from: a */
    public String m11246a() {
        try {
            PackageInfo packageInfo = this.f8081b.f7581b.getContext().getPackageManager().getPackageInfo(this.f8080a, 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version_name", packageInfo.versionName);
            jSONObject.put("version_code", packageInfo.versionCode);
            jSONObject.put("package_name", packageInfo.packageName);
            jSONObject.put("first_install_time", packageInfo.firstInstallTime);
            jSONObject.put("last_update_time", packageInfo.lastUpdateTime);
            jSONObject.put("install_location", packageInfo.installLocation);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
