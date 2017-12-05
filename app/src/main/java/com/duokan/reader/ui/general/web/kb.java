package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.b.UrlTools;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.o;
import com.duokan.core.sys.z;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.i;

import org.apache.http.cookie.SM;

import java.io.File;
import java.util.Scanner;

class kb implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ StoreWebController b;

    kb(StoreWebController storeWebController, boolean z) {
        this.b = storeWebController;
        this.a = z;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        long j = -1;
        StoreWebController.waitForStoreMirrorReady();
        if (StoreWebController.sStoreMirrorDir != null) {
            File file = new File(ReaderEnv.get().getStoreCacheDirectory(), "updating-mirror.tmp");
            File file2 = new File(file, "cache.appcache");
            a.d(file);
            try {
                UrlTools.a aVar = new UrlTools.a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(String.format("app_id=%s;device_id=%s;build=%getScaledTouchSlop;channel=%s;", new Object[]{ReaderEnv.get().getAppId(), ReaderEnv.get().getDeviceId(), Integer.valueOf(ReaderEnv.get().getVersionCode()), ReaderEnv.get().getDistChannel()}));
                if (!TextUtils.isEmpty(i.f().i())) {
                    stringBuilder.append(String.format("device_hash=%s;", new Object[]{i.f().i()}));
                }
                Iterable j2 = i.f().j();
                if (j2 != null && j2.size() > 0) {
                    stringBuilder.append(String.format("device_hash_set=%s;", new Object[]{TextUtils.join(",", j2)}));
                }
                if (ReaderEnv.get().getBuildName().equals("Reader")) {
                    stringBuilder.append("_n=1;");
                }
                if (z.a()) {
                    stringBuilder.append("_m=1;");
                }
                aVar.a(3).a(SM.COOKIE, stringBuilder.toString());
                file.mkdirs();
                b.b(p.i().z() + "/phone/" + "cache.appcache", file2, aVar);
                String a = o.a(file2, "md5");
                if (!TextUtils.isEmpty(a)) {
                    File access$600 = StoreWebController.storeMirrorDirectory(a);
                    if (this.a || !TextUtils.equals(StoreWebController.sStoreMirrorDir.getAbsolutePath(), access$600.getAbsolutePath())) {
                        WebLog.c().c(LogLevel.EVENT, "store", "updating store mirror");
                        File file3 = new File(file, "index.html");
                        if (b.b(p.i().z() + "/phone/", file3, aVar) < 0) {
                            com.duokan.reader.domain.statistics.a.k().a(str, -1);
                            a.d(file);
                            return;
                        }
                        try {
                            if (new Scanner(file3).findWithinHorizon("\\<body\\>", 0) == null) {
                                WebLog.c().c(LogLevel.WARNING, "store", "bad store mirror index file");
                                if (DkApp.get().forCommunity()) {
                                    a.a(file3, new File(DkApp.get().getDiagnosticDirectory(), "index.html.bad"));
                                }
                                com.duokan.reader.domain.statistics.a.k().a("fail-bad-index", -1);
                                a.d(file);
                                return;
                            }
                            String[] access$700 = StoreWebController.parseStoreMirrorManifest(file2);
                            if (access$700.length < 1) {
                                com.duokan.reader.domain.statistics.a.k().a("fail-bad-manifest", -1);
                                a.d(file);
                                return;
                            }
                            for (String str2 : access$700) {
                                try {
                                    File file4 = new File(StoreWebController.sStoreMirrorDir, str2);
                                    File file5 = new File(file, str2);
                                    if (!(file5.exists() || (!this.a && file4.exists() && a.a(file4, file5)))) {
                                        a.d(file5);
                                        b.a(p.i().z() + "/phone/" + str2, file5, aVar);
                                    }
                                } catch (Throwable th) {
                                }
                            }
                            a.d(access$600);
                            if (file.renameTo(access$600)) {
                                str = "ok";
                                j = System.currentTimeMillis() - currentTimeMillis;
                                StoreWebController.sStoreMirrorDir = access$600;
                                ReaderEnv.get().setPrefString(PrivatePref.STORE, "mirror_version", a);
                                ReaderEnv.get().commitPrefs();
                                WebLog.c().print(LogLevel.EVENT, "store", "store mirror updated(ver=%s)", a);
                                TaskHandler.getTaskHandler(new kc(this));
                                com.duokan.reader.domain.statistics.a.k().a(str, j);
                                a.d(file);
                                return;
                            }
                            com.duokan.reader.domain.statistics.a.k().a("fail-rename", -1);
                            a.d(file);
                            return;
                        } catch (Throwable th2) {
                            com.duokan.reader.domain.statistics.a.k().a("fail-others", -1);
                            a.d(file);
                            return;
                        }
                    }
                    com.duokan.reader.domain.statistics.a.k().a(str, -1);
                    a.d(file);
                }
            } finally {
                com.duokan.reader.domain.statistics.a.k().a(str, j);
                a.d(file);
            }
        }
    }
}
