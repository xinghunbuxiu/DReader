package com.duokan.reader.domain.statistics;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.b.UrlTools;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.io.FileUtils;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.classc;
import com.duokan.reader.domain.bookshelf.c;
import com.xiaomi.mistatistic.sdk.MiStatInterface;
import com.xiaomi.mistatistic.sdk.URLStatsRecorder;

import java.io.BufferedReader;
import java.io.File;
import java.net.InetAddress;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    static final /* synthetic */ boolean a = (!a.class.desiredAssertionStatus());
    private static a b = null;
    private final ReaderEnv c;
    private final UmengManager d;
    private final classc.ConnectivityReceiver e;
    private final ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();
    private final ConcurrentLinkedQueue g = new ConcurrentLinkedQueue();
    private final ConcurrentLinkedQueue h = new ConcurrentLinkedQueue();
    private int i = 0;
    private String j = "";
    private long k = -1;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private File p = null;

    public a(ReaderEnv readerEnv, UmengManager umengManager, classc.ConnectivityReceiver connectivity) {
        this.c = readerEnv;
        this.d = umengManager;
        this.e = connectivity;
        this.e.a(new b(this));
        try {
            Context context = DkApp.get();
            String miAppId = DkApp.get().getMiAppId();
            DkApp.get();
            MiStatInterface.initialize(context, miAppId, DkApp.get().getMiAppKey(), this.c.getDistChannel());
            MiStatInterface.setUploadPolicy(5, 0);
            URLStatsRecorder.enableAutoRecord();
        } catch (Throwable th) {
        }
    }

    public void a(long j) {
        if (this.o <= 0) {
            this.o = j;
        }
    }

    public void a(c cVar, String str) {
        try {
            h hVar = new h();
            hVar.a = "fiction/chapter-damaged";
            hVar.b = new String[]{"id", cVar.H(), "chapter", str};
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void a(c cVar, String str, String str2, String str3) {
        try {
            h hVar = new h();
            hVar.a = "book/res-badmd5";
            hVar.b = new String[]{"id", cVar.H(), "res", Uri.encode(str), "md5", str2, "bad-md5", str3};
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void a(c cVar, long j) {
        try {
            if (cVar.ai() && !cVar.l()) {
                String str;
                if (cVar.k()) {
                    str = "M_OPENFICTION_TIME_V1";
                } else {
                    str = "M_OPENBOOK_TIME_V1";
                }
                this.d.onEvent(str, a(j, 1000, 2000, 3000, 4000, 5000, 6000));
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str, Throwable th) {
        try {
            Uri a = UrlTools.parse(str);
            if (a != null) {
                String str2 = "";
                try {
                    str2 = InetAddress.getByName(a.getHost()).getHostAddress();
                } catch (Throwable th2) {
                }
                h hVar = new h();
                hVar.a = "getScaledPagingTouchSlop/" + a.getScheme() + "/" + a.getHost() + a.getPath();
                hVar.b = new String[]{"host-ip", str2, "msg", Uri.encode(th.getMessage())};
                this.g.add(hVar);
                l();
            }
        } catch (Throwable th3) {
        }
    }

    public void a(Uri uri, boolean z) {
        if (uri != null) {
            try {
                h hVar = new h();
                hVar.a = "splash/" + uri.getScheme() + "/" + uri.getHost() + uri.getPath() + "?" + "click=" + z + "&" + uri.getQuery();
                this.g.add(hVar);
                l();
            } catch (Throwable th) {
            }
        }
    }

    public void a(Intent intent) {
        try {
            Uri data = intent.getData();
            if (data != null && a(data)) {
                h hVar = new h();
                hVar.a = "intent/" + data.getScheme() + "/" + data.getHost() + data.getPath() + "?" + data.getQuery();
                this.g.add(hVar);
                l();
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse != null && a(parse)) {
                h hVar = new h();
                hVar.a = "web/" + parse.getScheme() + "/" + parse.getHost() + parse.getPath() + "?" + parse.getQuery();
                this.g.add(hVar);
                l();
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, boolean z2) {
        try {
            h hVar = new h();
            hVar.a = "fiction_ads?fiction_id=" + str + "&page_count=" + i + "&chapter_count=" + i2 + "&viewed=" + i3 + "&clicked=" + i4 + "&download=" + i5 + "&valid_ad=" + i6 + "&h5_ad=" + i7 + "&request_ad=" + i8 + "&no_ads=" + i9 + "&space_not_enough=" + i10 + "&is_chapter_end=" + z + "&is_miui=" + z2;
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            h hVar = new h();
            hVar.a = "push_message?id=" + str + "&type=" + str2 + "&action=" + str3;
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void b(String str) {
        try {
            h hVar = new h();
            hVar.a = "gender";
            hVar.b = new String[]{"act", str};
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void c(String str) {
        try {
            h hVar = new h();
            hVar.a = "initbook";
            hVar.b = new String[]{"act", "click", "id", str};
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void a(String str, String str2) {
        try {
            h hVar = new h();
            hVar.a = "initbook";
            hVar.b = new String[]{"act", "read", "id", str, "time", str2};
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void d(String str) {
        try {
            h hVar = new h();
            hVar.a = "tab/switch";
            hVar.b = new String[]{"stream", str};
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void b(String str, String str2, String str3) {
        a(str, str2, str3, 0, true);
    }

    public void a(String str, String str2, String str3, boolean z) {
        a(str, str2, str3, 0, z);
    }

    public void a(String str, String str2, String str3, int i, boolean z) {
        com.duokan.reader.common.webservices.duokan.a aVar = new com.duokan.reader.common.webservices.duokan.a();
        aVar.a = str;
        aVar.b = str3;
        aVar.c = str2;
        aVar.d = i;
        a(aVar, z);
    }

    public void a(com.duokan.reader.common.webservices.duokan.a aVar, boolean z) {
        try {
            this.h.add(aVar);
            if (z) {
                a();
            }
        } catch (Throwable th) {
        }
    }

    public void e(String str) {
        try {
            h hVar = new h();
            hVar.a = str;
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void b(long j) {
        try {
            h hVar = new h();
            hVar.a = "p/store/first";
            hVar.b = new String[]{"type", "index", "name", "webview_load", "TaskHandler", "" + j};
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void a(long j, long j2) {
        try {
            h hVar = new h();
            hVar.a = "p/store/first";
            hVar.b = new String[]{"type", "index", "name", "webview_start", "TaskHandler", "" + j, "delta", "" + j2};
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    public void a(long j, long j2, long j3) {
        try {
            h hVar = new h();
            hVar.a = "p/store/first";
            hVar.b = new String[]{"type", "index", "name", "webview_finish", "TaskHandler", "" + j, "delta", "" + j2};
            this.g.add(hVar);
            l();
            this.d.onEvent("P_STORE_FIRSTLOAD_V1", a(j3, 500, 1000, 2000, 4000, 6000, 8000));
        } catch (Throwable th) {
        }
    }

    public void f(String str) {
        try {
            h hVar = new h();
            hVar.a = "showAnimation/store/refresh?" + Uri.parse(str).getEncodedFragment();
            this.g.add(hVar);
            l();
        } catch (Throwable th) {
        }
    }

    private void l() {
        TaskHandler.a(new c(this));
    }

    public void a() {
        TaskHandler.postTask(new e(this));
    }

    public void a(String str, int i) {
        TaskHandler.postTask(new g(this, i, str));
    }

    public void b() {
        try {
            boolean z;
            this.k = System.currentTimeMillis();
            try {
                ReaderFeature readerFeature = (ReaderFeature) ManagedApp.get().queryFeature(ReaderFeature.class);
                z = readerFeature != null ? readerFeature.getReadingBook() != null : false;
            } catch (Throwable th) {
                z = false;
            }
            h hVar = new h();
            hVar.a = "BaseActivity/app/foreground";
            hVar.b = new String[]{"TaskHandler", "" + this.k, "reading", "" + z};
            this.g.add(hVar);
            l();
        } catch (Throwable th2) {
        }
    }

    public void c() {
        if (this.k >= 0) {
            try {
                if (DkApp.get().isWebAccessEnabled()) {
                    MiStatInterface.triggerUploadManually();
                }
            } catch (Throwable th) {
            }
            try {
                boolean z;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    ReaderFeature readerFeature = (ReaderFeature) ManagedApp.get().queryFeature(ReaderFeature.class);
                    z = readerFeature != null ? readerFeature.getReadingBook() != null : false;
                } catch (Throwable th2) {
                    z = false;
                }
                h hVar = new h();
                hVar.a = "BaseActivity/app/background";
                hVar.b = new String[]{"TaskHandler", "" + currentTimeMillis, "getScaledTouchSlop", "" + Math.max(0, currentTimeMillis - this.k), "reading", "" + z};
                this.g.add(hVar);
                l();
            } catch (Throwable th3) {
            }
        }
    }

    public void d() {
        if (this.l <= 0) {
            this.l = WebLog.c().a("app_load_timer");
        }
    }

    public void e() {
        if (this.m <= 0) {
            this.m = WebLog.c().a("app_bginit_timer");
        }
    }

    public void f() {
        try {
            if (this.n <= 0) {
                this.n = WebLog.c().a("app_load_timer");
                try {
                    if (DkApp.get().isWebAccessEnabled()) {
                        MiStatInterface.triggerUploadManually();
                    }
                } catch (Throwable th) {
                }
                if (this.i >= 3 && this.j.endsWith("_store")) {
                    String str;
                    if (this.c.isFreshInstall()) {
                        str = "M_FRESHTOSTORE_TIME_V1";
                    } else {
                        str = "M_COLDTOSTORE_TIME_V1";
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.d.onEvent(str, a(j(), 1000, 2000, 3000, 4000, 5000, 6000));
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    public void a(File file) {
        BufferedReader a;
        try {
            if (this.p != file) {
                this.p = file;
                String str = "";
                a = FileUtils.getBifferedReader(new File(this.p, "index.html"), "utf-8");
                CharSequence readLine = a.readLine();
                while (!TextUtils.isEmpty(readLine)) {
                    if (readLine.contains("duokan-version")) {
                        Matcher matcher = Pattern.compile("content.*\"(.*)\"").matcher(readLine);
                        if (matcher.find()) {
                            str = matcher.group(1);
                        }
                    } else {
                        readLine = a.readLine();
                    }
                }
                a.close();
                if (!TextUtils.isEmpty(str)) {
                    UmengManager.get().onEvent("M_STOREMIRROR_VERSION_V1", str);
                }
            }
        } catch (Throwable th) {
        }
    }

    public void a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                UmengManager.get().onEvent("M_STOREMIRROR_UPDATERESULT_V1", str);
            }
            if (j > 0) {
                UmengManager.get().onEvent("M_STOREMIRROR_UPDATETIME_V1", a(j / 1000, 3, 5, 10, 20, 30, 60, 120, 300));
            }
        } catch (Throwable th) {
        }
    }

    public long g() {
        return this.l;
    }

    public long h() {
        return this.m;
    }

    public long i() {
        return this.n - this.o;
    }

    public long j() {
        return this.l + i();
    }

    public static a k() {
        if (a || b != null) {
            return b;
        }
        throw new AssertionError();
    }

    public static void a(ReaderEnv readerEnv, UmengManager umengManager, classc.ConnectivityReceiver connectivity) {
        try {
            b = new a(readerEnv, umengManager, connectivity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String a(long j, long... jArr) {
        int i = 0;
        while (i < jArr.length) {
            if (j < jArr[i]) {
                return i == 0 ? "-" + jArr[i] : jArr[i - 1] + "-" + jArr[i];
            } else {
                i++;
            }
        }
        return jArr[jArr.length - 1] + "-";
    }

    private boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (!TextUtils.isEmpty(uri.getQueryParameter("miref"))) {
            return true;
        }
        if (!TextUtils.isEmpty(uri.getQueryParameter("ref"))) {
            return true;
        }
        if (TextUtils.isEmpty(uri.getQueryParameter("from"))) {
            return false;
        }
        return true;
    }
}
