package com.duokan.reader.domain.statistics;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p027b.C0324a;
import com.duokan.core.sys.UThread;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0628a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.mipay.sdk.Mipay;
import com.xiaomi.mistatistic.sdk.MiStatInterface;
import com.xiaomi.mistatistic.sdk.URLStatsRecorder;
import java.io.BufferedReader;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class C1163a {
    
    static final  boolean assertionStatus = (!C1163a.class.desiredAssertionStatus());
    
    private static C1163a f5590b = null;
    
    private final ReaderEnv readerEnv;
    
    private final UmengManager umengManager;
    
    private final C0559f f5593e;
    
    private final ConcurrentLinkedQueue<String> f5594f = new ConcurrentLinkedQueue();
    
    private final ConcurrentLinkedQueue<C1174h> f5595g = new ConcurrentLinkedQueue();
    
    private final ConcurrentLinkedQueue<C0628a> f5596h = new ConcurrentLinkedQueue();
    
    private int f5597i = 0;
    
    private String f5598j = "";
    
    private long f5599k = -1;
    
    private long f5600l = 0;
    
    private long app_bginit_timer = 0;
    
    private long f5602n = 0;
    
    private long f5603o = 0;
    
    private File f5604p = null;

    public C1163a(ReaderEnv readerEnv, UmengManager umengManager, C0559f c0559f) {
        this.readerEnv = readerEnv;
        this.umengManager = umengManager;
        this.f5593e = c0559f;
        this.f5593e.m2481a(new C1164b(this));
        try {
            Context context = DkApp.get();
            String miAppId = DkApp.get().getMiAppId();
            DkApp.get();
            MiStatInterface.initialize(context, miAppId, DkApp.get().getMiAppKey(), this.readerEnv.getDistChannel());
            MiStatInterface.setUploadPolicy(5, 0);
            URLStatsRecorder.enableAutoRecord();
        } catch (Throwable th) {
        }
    }

    
    public void m8638a(C0800c c0800c, String str) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "fiction/chapter-damaged";
            c1174h.f5625b = new String[]{"id", c0800c.m4156I(), "chapter", str};
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8639a(C0800c c0800c, String str, String str2, String str3) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "book/res-badmd5";
            c1174h.f5625b = new String[]{"id", c0800c.m4156I(), "res", Uri.encode(str), "md5", str2, "bad-md5", str3};
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8637a(C0800c c0800c, long j) {
        try {
            if (c0800c.ak() && !c0800c.m4239l()) {
                String str;
                if (c0800c.mo1038k()) {
                    str = "M_OPENFICTION_TIME_V1";
                } else {
                    str = "M_OPENBOOK_TIME_V1";
                }
                this.umengManager.onEvent(str, C1163a.m8617a(j, 1000, 2000, 3000, 4000, 5000, 6000));
            }
        } catch (Throwable th) {
        }
    }

    
    public void m8649a(String str, Throwable th) {
        try {
            Uri a = C0324a.m734a(str);
            if (a != null) {
                String str2 = "";
                try {
                    str2 = InetAddress.getByName(a.getHost()).getHostAddress();
                } catch (Throwable th2) {
                }
                C1174h c1174h = new C1174h();
                c1174h.f5624a = "e/" + a.getScheme() + "/" + a.getHost() + a.getPath();
                c1174h.f5625b = new String[]{"host-ip", str2, "msg", Uri.encode(th.getMessage())};
                this.f5595g.add(c1174h);
                m8628l();
            }
        } catch (Throwable th3) {
        }
    }

    
    public void m8634a(Uri uri, boolean z) {
        if (uri != null) {
            try {
                C1174h c1174h = new C1174h();
                c1174h.f5624a = String.format("splash?click=%s&url=%s", new Object[]{Boolean.valueOf(z), Uri.encode(uri.toString())});
                this.f5595g.add(c1174h);
                m8628l();
            } catch (Throwable th) {
            }
        }
    }

    
    public void m8633a(Intent intent) {
        try {
            Uri data = intent.getData();
            if (data != null && m8621a(data)) {
                C1174h c1174h = new C1174h();
                c1174h.f5624a = String.format("intent?url=%s", new Object[]{Uri.encode(data.toString())});
                this.f5595g.add(c1174h);
                m8628l();
            }
        } catch (Throwable th) {
        }
    }

    
    public void m8641a(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse != null && m8621a(parse)) {
                C1174h c1174h = new C1174h();
                c1174h.f5624a = String.format("web/?url=%s", new Object[]{Uri.encode(parse.toString())});
                this.f5595g.add(c1174h);
                m8628l();
            }
        } catch (Throwable th) {
        }
    }

    
    public void m8643a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, boolean z2) {
        if (i8 != 0) {
            try {
                C1174h c1174h = new C1174h();
                c1174h.f5624a = "fiction_ads?fiction_id=" + str + "&page_count=" + i + "&chapter_count=" + i2 + "&viewed=" + i3 + "&clicked=" + i4 + "&download=" + i5 + "&valid_ad=" + i6 + "&h5_ad=" + i7 + "&request_ad=" + i8 + "&no_ads=" + i9 + "&space_not_enough=" + i10 + "&is_chapter_end=" + z + "&is_miui=" + z2;
                this.f5595g.add(c1174h);
                m8628l();
            } catch (Throwable th) {
            }
        }
    }

    
    public void m8646a(String str, String str2, String str3) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "push_message?id=" + str + "&type=" + str2 + "&action=" + str3;
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8652b(String str, String str2, String str3) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "prefer";
            ArrayList arrayList = new ArrayList();
            arrayList.add("act");
            arrayList.add(str);
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(Mipay.KEY_RESULT);
                arrayList.add(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add("stream");
                arrayList.add(str3);
            }
            c1174h.f5625b = (String[]) arrayList.toArray(new String[0]);
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8651b(String str) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "initbook";
            c1174h.f5625b = new String[]{"act", "click", "id", str};
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8645a(String str, String str2) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "initbook";
            c1174h.f5625b = new String[]{"act", "read", "id", str, "time", str2};
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8654c(String str) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "tab/switch";
            c1174h.f5625b = new String[]{"stream", str};
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8655c(String str, String str2, String str3) {
        m8647a(str, str2, str3, 0, true);
    }

    
    public void m8648a(String str, String str2, String str3, boolean z) {
        m8647a(str, str2, str3, 0, z);
    }

    
    public void m8647a(String str, String str2, String str3, int i, boolean z) {
        C0628a c0628a = new C0628a();
        c0628a.f2093a = str;
        c0628a.f2094b = str3;
        c0628a.f2095c = str2;
        c0628a.f2096d = i;
        m8635a(c0628a, z);
    }

    
    public void m8635a(C0628a c0628a, boolean z) {
        try {
            this.f5596h.add(c0628a);
            if (z) {
                m8629a();
            }
        } catch (Throwable th) {
        }
    }

    
    public void m8657d(String str) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = str;
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8630a(long j) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "p/store/first";
            c1174h.f5625b = new String[]{"type", "index", "name", "webview_load", "t", "" + j};
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8631a(long j, long j2) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "p/store/first";
            c1174h.f5625b = new String[]{"type", "index", "name", "webview_start", "t", "" + j, "delta", "" + j2};
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8632a(long j, long j2, long j3) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "p/store/first";
            c1174h.f5625b = new String[]{"type", "index", "name", "webview_finish", "t", "" + j, "delta", "" + j2};
            this.f5595g.add(c1174h);
            m8628l();
            this.umengManager.onEvent("P_STORE_FIRSTLOAD_V1", C1163a.m8617a(j3, 500, 1000, 2000, 4000, 6000, 8000));
        } catch (Throwable th) {
        }
    }

    
    public void m8659e(String str) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "c/store/refresh?" + Uri.parse(str).getEncodedFragment();
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    public void m8636a(C0800c c0800c, int i, int i2) {
        try {
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "readnew";
            String[] strArr = new String[14];
            strArr[0] = "id";
            strArr[1] = c0800c.m4156I();
            strArr[2] = "name";
            strArr[3] = Uri.encode(c0800c.ay());
            strArr[4] = "serial";
            strArr[5] = c0800c.mo1038k() ? "1" : "0";
            strArr[6] = "rp";
            strArr[7] = "" + i;
            strArr[8] = "rt";
            strArr[9] = "" + i2;
            strArr[10] = "add";
            strArr[11] = c0800c.aI() ? "0" : "1";
            strArr[12] = "ts";
            strArr[13] = "" + System.currentTimeMillis();
            c1174h.f5625b = strArr;
            if (!TextUtils.isEmpty(c0800c.m4164Q())) {
                c1174h.f5626c = "&" + c0800c.m4164Q();
                c0800c.m4237k("");
            }
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th) {
        }
    }

    
    private void m8628l() {
        UThread.runOnThread(new C1165c(this));
    }

    
    public void m8629a() {
        UThread.runOnThread(new C1171e(this));
    }

    
    public void m8642a(String str, int i) {
        UThread.runOnThread(new C1173g(this, i, str));
    }

    
    public void m8650b() {
        try {
            boolean z;
            this.f5599k = System.currentTimeMillis();
            try {
                ReaderFeature readerFeature = (ReaderFeature) ManagedApp.get().queryFeature(ReaderFeature.class);
                z = readerFeature != null ? readerFeature.getReadingBook() != null : false;
            } catch (Throwable th) {
                z = false;
            }
            C1174h c1174h = new C1174h();
            c1174h.f5624a = "m/app/foreground";
            c1174h.f5625b = new String[]{"t", "" + this.f5599k, "reading", "" + z};
            this.f5595g.add(c1174h);
            m8628l();
        } catch (Throwable th2) {
        }
    }

    
    public void m8653c() {
        if (this.f5599k >= 0) {
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
                C1174h c1174h = new C1174h();
                c1174h.f5624a = "m/app/background";
                c1174h.f5625b = new String[]{"t", "" + currentTimeMillis, "d", "" + Math.max(0, currentTimeMillis - this.f5599k), "reading", "" + z};
                this.f5595g.add(c1174h);
                m8628l();
            } catch (Throwable th3) {
            }
        }
    }

    
    public void m8656d() {
        if (this.f5600l <= 0) {
            this.f5600l = WebLog.init().getAppBginitTimer("app_load_timer");
        }
    }

    
    public void m8658e() {
        if (this.app_bginit_timer <= 0) {
            this.app_bginit_timer = WebLog.init().getAppBginitTimer("app_bginit_timer");
        }
    }

    
    public void m8660f() {
        try {
            if (this.f5602n <= 0) {
                this.f5602n = WebLog.init().getAppBginitTimer("app_load_timer");
                try {
                    if (DkApp.get().isWebAccessEnabled()) {
                        MiStatInterface.triggerUploadManually();
                    }
                } catch (Throwable th) {
                }
                if (this.f5597i >= 3 && this.f5598j.endsWith("_store")) {
                    String str;
                    if (this.readerEnv.isFreshInstall()) {
                        str = "M_FRESHTOSTORE_TIME_V1";
                    } else {
                        str = "M_COLDTOSTORE_TIME_V1";
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.umengManager.onEvent(str, C1163a.m8617a(m8664j(), 1000, 2000, 3000, 4000, 5000, 6000));
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    
    public void m8640a(File file) {
        BufferedReader a;
        try {
            if (this.f5604p != file) {
                this.f5604p = file;
                String str = "";
                a = FileUtil.getBufferedReader(new File(this.f5604p, "index.html"), "utf-8");
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

    
    public void m8644a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                UmengManager.get().onEvent("M_STOREMIRROR_UPDATERESULT_V1", str);
            }
            if (j > 0) {
                UmengManager.get().onEvent("M_STOREMIRROR_UPDATETIME_V1", C1163a.m8617a(j / 1000, 3, 5, 10, 20, 30, 60, 120, 300));
            }
        } catch (Throwable th) {
        }
    }

    
    public long m8661g() {
        return this.f5600l;
    }

    
    public long m8662h() {
        return this.app_bginit_timer;
    }

    
    public long m8663i() {
        return this.f5602n - this.f5603o;
    }

    
    public long m8664j() {
        return this.f5600l + m8663i();
    }

    
    public static C1163a m8627k() {
        if (assertionStatus || f5590b != null) {
            return f5590b;
        }
        throw new AssertionError();
    }

    
    public static void m8619a(ReaderEnv readerEnv, UmengManager umengManager, C0559f c0559f) {
        try {
            f5590b = new C1163a(readerEnv, umengManager, c0559f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    
    private static String m8617a(long j, long... jArr) {
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

    
    private boolean m8621a(Uri uri) {
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
