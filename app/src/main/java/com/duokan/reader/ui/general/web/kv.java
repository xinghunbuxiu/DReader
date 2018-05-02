package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p027b.p028a.C0320a;
import com.duokan.core.p027b.p028a.C0321b;
import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.C0373z;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.statistics.C1163a;
import java.io.File;
import java.util.Scanner;
import org.apache.http.cookie.SM;

class kv implements Runnable {
    /* renamed from: a */
    private final boolean f8118a;

    kv(boolean z) {
        this.f8118a = z;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        long j = -1;
        StoreWebController.waitForStoreMirrorReady();
        if (StoreWebController.sStoreMirrorDir != null) {
            File file = new File(ReaderEnv.get().getStoreCacheDirectory(), "updating-mirror.tmp");
            File file2 = new File(file, "cache.appcache");
            FileUtil.deleteFile(file);
            try {
                C0320a c0320a = new C0320a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(String.format("app_id=%s;device_id=%s;build=%d;channel=%s;", new Object[]{ReaderEnv.get().getAppId(), ReaderEnv.get().getDeviceId(), Integer.valueOf(ReaderEnv.get().getVersionCode()), ReaderEnv.get().getDistChannel()}));
                if (!TextUtils.isEmpty(C0709k.m3476a().m3514i())) {
                    stringBuilder.append(String.format("device_hash=%s;", new Object[]{C0709k.m3476a().m3514i()}));
                }
                Iterable j2 = C0709k.m3476a().m3515j();
                if (j2 != null && j2.size() > 0) {
                    stringBuilder.append(String.format("device_hash_set=%s;", new Object[]{TextUtils.join(",", j2)}));
                }
                if (ReaderEnv.get().getBuildName().equals("Reader")) {
                    stringBuilder.append("_n=1;");
                }
                if (C0373z.m1052a()) {
                    stringBuilder.append("_m=1;");
                }
                c0320a.m721a(3).m722a(SM.COOKIE, stringBuilder.toString());
                file.mkdirs();
                C0321b.m732b(C0641o.m2934i().m2999z() + "/phone/" + "cache.appcache", file2, c0320a);
                String a = C0366o.m1028a(file2, "md5");
                if (!TextUtils.isEmpty(a)) {
                    File access$600 = StoreWebController.storeMirrorDirectory(a);
                    if (this.f8118a || !TextUtils.equals(StoreWebController.sStoreMirrorDir.getAbsolutePath(), access$600.getAbsolutePath())) {
                        WebLog.init().c(LogLevel.EVENT, "store", "updating store mirror");
                        File file3 = new File(file, "index.html");
                        if (C0321b.m732b(C0641o.m2934i().m2999z() + "/phone/", file3, c0320a) < 0) {
                            C1163a.m8627k().m8644a(str, -1);
                            FileUtil.deleteFile(file);
                            return;
                        }
                        str = "fail-others";
                        try {
                            if (new Scanner(file3).findWithinHorizon("\\<body\\>", 0) == null) {
                                WebLog.init().c(LogLevel.WARNING, "store", "bad store mirror index file");
                                if (DkApp.get().forCommunity()) {
                                    FileUtil.doCopyFile(file3, new File(DkApp.get().getDiagnosticDirectory(), "index.html.bad"));
                                }
                                C1163a.m8627k().m8644a("fail-bad-index", -1);
                                FileUtil.deleteFile(file);
                                return;
                            }
                            String[] access$700 = StoreWebController.parseStoreMirrorManifest(file2);
                            if (access$700.length < 1) {
                                C1163a.m8627k().m8644a("fail-bad-manifest", -1);
                                FileUtil.deleteFile(file);
                                return;
                            }
                            int length = access$700.length;
                            int i = 0;
                            while (i < length) {
                                try {
                                    ku a2 = ku.m11274a(access$700[i]);
                                    if (a2 == null) {
                                        C1163a.m8627k().m8644a(str, -1);
                                        FileUtil.deleteFile(file);
                                        return;
                                    }
                                    File file4 = new File(StoreWebController.sStoreMirrorDir, a2.f8116a);
                                    File file5 = new File(file, a2.f8116a);
                                    if (!file5.exists()) {
                                        file5.getParentFile().mkdirs();
                                        if (this.f8118a || !file4.exists() || !FileUtil.doCopyFile(file4, file5)) {
                                            FileUtil.deleteFile(file5);
                                            C0321b.m725a(a2.f8117b, file5, c0320a);
                                        }
                                    }
                                    i++;
                                } catch (Throwable th) {
                                }
                            }
                            FileUtil.deleteFile(access$600);
                            if (file.renameTo(access$600)) {
                                str = "ok";
                                j = System.currentTimeMillis() - currentTimeMillis;
                                StoreWebController.sStoreMirrorDir = access$600;
                                ReaderEnv.get().setPrefString(PrivatePref.STORE, "mirror_version", a);
                                ReaderEnv.get().commitPrefs();
                                WebLog.init().a(LogLevel.EVENT, "store", "store mirror updated(ver=%s)", a);
                                UThread.m1035a(new kw(this));
                                C1163a.m8627k().m8644a(str, j);
                                FileUtil.deleteFile(file);
                                return;
                            }
                            C1163a.m8627k().m8644a("fail-rename", -1);
                            FileUtil.deleteFile(file);
                            return;
                        } catch (Throwable th2) {
                            C1163a.m8627k().m8644a(str, -1);
                            FileUtil.deleteFile(file);
                            return;
                        }
                    }
                    C1163a.m8627k().m8644a(str, -1);
                    FileUtil.deleteFile(file);
                }
            } finally {
                C1163a.m8627k().m8644a(str, j);
                FileUtil.deleteFile(file);
            }
        }
    }
}
