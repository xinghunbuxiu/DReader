package com.duokan.reader.domain.statistics.dailystats;

import android.net.Uri;
import android.telephony.TelephonyManager;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.app.w;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.c;

import java.io.File;
import java.io.Serializable;

public class a implements ah, w {
    private static final ai h = new ai();
    private final com.duokan.core.a.a a;
    private final ReaderEnv b;
    private final f c;
    private StatStartApp d = null;
    private StatOpenBook e = null;
    private StatLoginResult f = null;
    private long g = 0;

    public a(ReaderEnv readerEnv, f fVar) {
        this.b = readerEnv;
        this.a = new com.duokan.core.a.a(Uri.fromFile(new File(readerEnv.getDatabaseDirectory(), "statistics.db")).toString());
        this.c = fVar;
        if (this.b.getIsSendNow()) {
            this.g = System.currentTimeMillis();
            this.b.setIsSendNow(false);
        }
        this.c.a(new b(this));
    }

    public boolean a() {
        try {
            this.e = new StatOpenBook();
            this.e.event = "rd";
            this.e.openTime = System.currentTimeMillis();
            this.e.closeTime = 0;
        } catch (Throwable th) {
        }
        return true;
    }

    public void b() {
        if (this.e != null) {
            try {
                this.e.bookOpenTime = System.currentTimeMillis() - this.e.openTime;
                this.e.openTime = System.currentTimeMillis();
            } catch (Throwable th) {
            }
        }
    }

    public void a(c cVar, int i, int i2, int i3) {
        if (this.e != null) {
            try {
                this.e.closeTime = System.currentTimeMillis();
                this.e.bookId = cVar.ai() ? cVar.ap() : cVar.aw();
                this.e.bookType = cVar.ai() ? "dk" : "lc";
                this.e.bookStatus = "s";
                this.e.exit = i;
                this.e.autoBuyCount = i2;
                this.e.autoBuyPrice = i3;
                this.e.traceId = cVar.G().c;
                this.e.timeStamp = System.currentTimeMillis();
                a(System.currentTimeMillis() + "", this.e);
                this.e = null;
            } catch (Throwable th) {
            }
        }
    }

    public void a(c cVar) {
        if (this.e != null) {
            try {
                this.e.bookOpenTime = System.currentTimeMillis() - this.e.openTime;
                this.e.openTime = System.currentTimeMillis();
                this.e.closeTime = System.currentTimeMillis();
                this.e.bookId = cVar.ai() ? cVar.ap() : cVar.aw();
                this.e.bookType = cVar.ai() ? "dk" : "lc";
                this.e.bookStatus = "f";
                this.e.exit = 0;
                this.e.autoBuyCount = 0;
                this.e.autoBuyPrice = 0;
                this.e.traceId = cVar.G().c;
                this.e.timeStamp = System.currentTimeMillis();
                a(System.currentTimeMillis() + "", this.e);
                this.e = null;
            } catch (Throwable th) {
            }
        }
    }

    public void a(String str) {
        try {
            Serializable statLogin = new StatLogin();
            statLogin.event = "login";
            statLogin.loginType = str;
            statLogin.timeStamp = System.currentTimeMillis();
            a(System.currentTimeMillis() + "", statLogin);
        } catch (Throwable th) {
        }
    }

    public void c() {
        try {
            this.f = new StatLoginResult();
            this.f.event = "login_r";
            this.f.costTime = System.currentTimeMillis();
        } catch (Throwable th) {
        }
    }

    public void b(String str) {
        if (this.f != null) {
            try {
                this.f.resultType = str;
                this.f.costTime = System.currentTimeMillis() - this.f.costTime;
                this.f.timeStamp = System.currentTimeMillis();
                a(System.currentTimeMillis() + "", this.f);
                this.f = null;
            } catch (Throwable th) {
            }
        }
    }

    public void a(String str, String str2) {
        try {
            Serializable statDelete = new StatDelete();
            statDelete.event = "del";
            statDelete.bookName = str;
            statDelete.deleteType = "c";
            statDelete.traceId = str2;
            statDelete.timeStamp = System.currentTimeMillis();
            a(System.currentTimeMillis() + "", statDelete);
        } catch (Throwable th) {
        }
    }

    public void b(String str, String str2) {
        try {
            Serializable statAddBookshelf = new StatAddBookshelf();
            statAddBookshelf.event = "abs";
            statAddBookshelf.bookUuid = str;
            statAddBookshelf.traceId = str2;
            statAddBookshelf.timeStamp = System.currentTimeMillis();
            a(System.currentTimeMillis() + "", statAddBookshelf);
        } catch (Throwable th) {
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            Serializable statShare = new StatShare();
            statShare.event = "sh";
            statShare.bookUuid = str;
            statShare.traceId = str2;
            statShare.channelCode = str3;
            statShare.timeStamp = System.currentTimeMillis();
            a(System.currentTimeMillis() + "", statShare);
        } catch (Throwable th) {
        }
    }

    public void c(String str) {
        try {
            Serializable statUpload = new StatUpload();
            statUpload.event = "upl";
            statUpload.bookName = str;
            statUpload.timeStamp = System.currentTimeMillis();
            a(System.currentTimeMillis() + "", statUpload);
        } catch (Throwable th) {
        }
    }

    public void c(String str, String str2) {
        try {
            Serializable statDownload = new StatDownload();
            statDownload.event = "dl";
            statDownload.bookId = str;
            statDownload.traceId = str2;
            statDownload.timeStamp = System.currentTimeMillis();
            a(System.currentTimeMillis() + "", statDownload);
        } catch (Throwable th) {
        }
    }

    public void d(String str) {
        try {
            Serializable statFontDownload = new StatFontDownload();
            statFontDownload.event = "dlf";
            statFontDownload.status = str;
            statFontDownload.timeStamp = System.currentTimeMillis();
            a(System.currentTimeMillis() + "", statFontDownload);
        } catch (Throwable th) {
        }
    }

    private void e() {
        new c(this).open();
    }

    private void a(String str, Serializable serializable) {
        this.a.b(str, serializable);
        if (System.currentTimeMillis() - this.g < 300000) {
            e();
        }
    }

    private String f() {
        UserInfo userInfo = new UserInfo();
        userInfo.userId = ((PersonalAccount) i.f().b(PersonalAccount.class)).b();
        userInfo.deviceId = this.b.getDeviceId();
        userInfo.imei = ((TelephonyManager) DkApp.get().getSystemService("phone")).getDeviceId();
        userInfo.deviceType = this.b.getDeviceType();
        userInfo.version = this.b.getVersionName();
        return userInfo.toString();
    }

    public static a d() {
        return (a) h.a();
    }

    public static void a(ReaderEnv readerEnv, f fVar) {
        try {
            h.a(new a(readerEnv, fVar));
            ManagedApp.get().addOnRunningStateChangedListener(d());
        } catch (Throwable th) {
        }
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.BACKGROUND) {
            e();
        }
    }
}
