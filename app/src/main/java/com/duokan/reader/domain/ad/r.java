package com.duokan.reader.domain.ad;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;

import com.duokan.b.i;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.classc;
import com.duokan.reader.ui.general.be;
import com.miui.systemAdSolution.landingPage.ILandingPageService;

import org.json.JSONException;
import org.json.JSONObject;

public class r {
    private boolean a = false;
    private final String b = "com.miui.systemAdSolution";
    private ILandingPageService c = null;
    private final WebLog d;

    public r(WebLog aVar) {
        boolean z = true;
        try {
            int i;
            if (ReaderEnv.get().onMiui()) {
                i = DkApp.get().getPackageManager().getPackageInfo("com.miui.systemAdSolution", 0).versionCode;
            } else {
                i = 0;
            }
            Intent intent = new Intent("miui.intent.action.MyTask.LANDING_PAGE_SERVICE");
            intent.setPackage("com.miui.systemAdSolution");
            ServiceConnection sVar = new s(this);
            if (i < DkApp.get().supportAdSdkVersion() || !DkApp.get().bindService(intent, sVar, 1)) {
                z = false;
            }
            this.a = z;
        } catch (Throwable th) {
        }
        this.d = aVar;
    }

    public boolean a() {
        return this.a;
    }

    public void a(e eVar) {
        if (x.a(DkApp.get(), eVar.r) || !a()) {
            try {
                DkApp.get().getTopActivity().startActivity(Intent.parseUri(eVar.p, 0));
                return;
            } catch (Throwable th) {
                return;
            }
        }
        if (!eVar.u) {
            if (classc.ConnectivityReceiver.b().d()) {
                be.a(DkApp.get(), i.general__shared__start_download, 0).show();
                a.c().c(LogLevel.INFO, "task_wall", "wifi connected");
            }
            eVar.u = true;
        }
        String b = b(eVar);
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("startAppFlags", false);
            bundle.putBoolean("showCancelFlags", true);
            this.c.registerListener(b, new t(this, eVar));
            this.c.startDownload(b, bundle);
            a.c().c(LogLevel.INFO, "task_wall", "download start");
        } catch (Throwable th2) {
            a.c().a(LogLevel.ERROR, "task_wall", "unexpected exception!", th2);
        }
    }

    private String b(e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("package", eVar.r);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
