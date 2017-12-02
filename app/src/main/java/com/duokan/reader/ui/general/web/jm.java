package com.duokan.reader.ui.general.web;

import android.content.pm.PackageInfo;

import org.json.JSONObject;

import java.util.concurrent.Callable;

class jm implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    jm(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        try {
            PackageInfo packageInfo = this.b.b.getContext().getPackageManager().getPackageInfo(this.a, 0);
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
