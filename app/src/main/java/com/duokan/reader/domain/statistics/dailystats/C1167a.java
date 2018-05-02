package com.duokan.reader.domain.statistics.dailystats;

import android.net.Uri;
import com.duokan.core.app.C0286x;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.p026a.C0272a;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.bookshelf.C0800c;
import java.io.File;
import java.io.Serializable;

/* renamed from: com.duokan.reader.domain.statistics.dailystats.a */
public class C1167a implements ai, C0286x {
    /* renamed from: h */
    private static final aj<C1167a> f5608h = new aj();
    /* renamed from: a */
    private final C0272a f5609a;
    /* renamed from: b */
    private final ReaderEnv f5610b;
    /* renamed from: c */
    private final C0559f f5611c;
    /* renamed from: d */
    private StatStartApp f5612d = null;
    /* renamed from: e */
    private StatOpenBook f5613e = null;
    /* renamed from: f */
    private StatLoginResult f5614f = null;
    /* renamed from: g */
    private long f5615g = 0;

    public C1167a(ReaderEnv readerEnv, C0559f c0559f) {
        this.f5610b = readerEnv;
        this.f5609a = new C0272a(Uri.fromFile(new File(readerEnv.getDatabaseDirectory(), "statistics.db")).toString());
        this.f5611c = c0559f;
        if (this.f5610b.getIsSendNow()) {
            this.f5615g = System.currentTimeMillis();
            this.f5610b.setIsSendNow(false);
        }
        this.f5611c.m2481a(new C1168b(this));
    }

    /* renamed from: a */
    public boolean m8680a() {
        try {
            this.f5613e = new StatOpenBook();
            this.f5613e.event = "rd";
            this.f5613e.openTime = System.currentTimeMillis();
            this.f5613e.closeTime = 0;
        } catch (Throwable th) {
        }
        return true;
    }

    /* renamed from: b */
    public void m8681b() {
        if (this.f5613e != null) {
            try {
                this.f5613e.bookOpenTime = System.currentTimeMillis() - this.f5613e.openTime;
                this.f5613e.openTime = System.currentTimeMillis();
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public void m8676a(C0800c c0800c, int i, int i2, int i3) {
        if (this.f5613e != null) {
            try {
                this.f5613e.closeTime = System.currentTimeMillis();
                this.f5613e.bookId = c0800c.ak() ? c0800c.ar() : c0800c.ay();
                this.f5613e.bookType = c0800c.ak() ? "dk" : "lc";
                this.f5613e.bookStatus = "s";
                this.f5613e.exit = i;
                this.f5613e.autoBuyCount = i2;
                this.f5613e.autoBuyPrice = i3;
                this.f5613e.traceId = c0800c.m4155H().f3455c;
                this.f5613e.timeStamp = System.currentTimeMillis();
                m8667a(System.currentTimeMillis() + "", this.f5613e);
                this.f5613e = null;
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public void m8675a(C0800c c0800c) {
        if (this.f5613e != null) {
            try {
                this.f5613e.bookOpenTime = System.currentTimeMillis() - this.f5613e.openTime;
                this.f5613e.openTime = System.currentTimeMillis();
                this.f5613e.closeTime = System.currentTimeMillis();
                this.f5613e.bookId = c0800c.ak() ? c0800c.ar() : c0800c.ay();
                this.f5613e.bookType = c0800c.ak() ? "dk" : "lc";
                this.f5613e.bookStatus = "f";
                this.f5613e.exit = 0;
                this.f5613e.autoBuyCount = 0;
                this.f5613e.autoBuyPrice = 0;
                this.f5613e.traceId = c0800c.m4155H().f3455c;
                this.f5613e.timeStamp = System.currentTimeMillis();
                m8667a(System.currentTimeMillis() + "", this.f5613e);
                this.f5613e = null;
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public void m8677a(String str) {
        try {
            Serializable statLogin = new StatLogin();
            statLogin.event = "login";
            statLogin.loginType = str;
            statLogin.timeStamp = System.currentTimeMillis();
            m8667a(System.currentTimeMillis() + "", statLogin);
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public void m8684c() {
        try {
            this.f5614f = new StatLoginResult();
            this.f5614f.event = "login_r";
            this.f5614f.costTime = System.currentTimeMillis();
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    public void m8682b(String str) {
        if (this.f5614f != null) {
            try {
                this.f5614f.resultType = str;
                this.f5614f.costTime = System.currentTimeMillis() - this.f5614f.costTime;
                this.f5614f.timeStamp = System.currentTimeMillis();
                m8667a(System.currentTimeMillis() + "", this.f5614f);
                this.f5614f = null;
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public void m8678a(String str, String str2) {
        try {
            Serializable statDelete = new StatDelete();
            statDelete.event = "del";
            statDelete.bookName = str;
            statDelete.deleteType = "c";
            statDelete.traceId = str2;
            statDelete.timeStamp = System.currentTimeMillis();
            m8667a(System.currentTimeMillis() + "", statDelete);
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    public void m8683b(String str, String str2) {
        try {
            Serializable statAddBookshelf = new StatAddBookshelf();
            statAddBookshelf.event = "abs";
            statAddBookshelf.bookUuid = str;
            statAddBookshelf.traceId = str2;
            statAddBookshelf.timeStamp = System.currentTimeMillis();
            m8667a(System.currentTimeMillis() + "", statAddBookshelf);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void m8679a(String str, String str2, String str3) {
        try {
            Serializable statShare = new StatShare();
            statShare.event = "sh";
            statShare.bookUuid = str;
            statShare.traceId = str2;
            statShare.channelCode = str3;
            statShare.timeStamp = System.currentTimeMillis();
            m8667a(System.currentTimeMillis() + "", statShare);
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public void m8685c(String str) {
        try {
            Serializable statUpload = new StatUpload();
            statUpload.event = "upl";
            statUpload.bookName = str;
            statUpload.timeStamp = System.currentTimeMillis();
            m8667a(System.currentTimeMillis() + "", statUpload);
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public void m8686c(String str, String str2) {
        try {
            Serializable statDownload = new StatDownload();
            statDownload.event = "dl";
            statDownload.bookId = str;
            statDownload.traceId = str2;
            statDownload.timeStamp = System.currentTimeMillis();
            m8667a(System.currentTimeMillis() + "", statDownload);
        } catch (Throwable th) {
        }
    }

    /* renamed from: d */
    public void m8687d(String str) {
        try {
            Serializable statFontDownload = new StatFontDownload();
            statFontDownload.event = "dlf";
            statFontDownload.status = str;
            statFontDownload.timeStamp = System.currentTimeMillis();
            m8667a(System.currentTimeMillis() + "", statFontDownload);
        } catch (Throwable th) {
        }
    }

    /* renamed from: e */
    private void m8673e() {
        new C1169c(this, C0643q.f2173a).open();
    }

    /* renamed from: a */
    private void m8667a(String str, Serializable serializable) {
        this.f5609a.m634b(str, serializable);
        if (System.currentTimeMillis() - this.f5615g < 300000) {
            m8673e();
        }
    }

    /* renamed from: f */
    private String m8674f() {
        UserInfo userInfo = new UserInfo();
        try {
            userInfo.userId = ((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo832b();
            userInfo.deviceId = this.f5610b.getDeviceId();
            userInfo.imeiMd5 = C0709k.m3476a().m3514i();
            userInfo.deviceType = this.f5610b.getDeviceType();
            userInfo.version = this.f5610b.getVersionName();
        } catch (Throwable th) {
        }
        return userInfo.toString();
    }

    /* renamed from: d */
    public static C1167a m8671d() {
        return (C1167a) f5608h.m707a();
    }

    /* renamed from: a */
    public static void m8666a(ReaderEnv readerEnv, C0559f c0559f) {
        try {
            f5608h.m709a(new C1167a(readerEnv, c0559f));
            ManagedApp.get().addOnRunningStateChangedListener(C1167a.m8671d());
        } catch (Throwable th) {
        }
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.BACKGROUND) {
            m8673e();
        }
    }
}
