package com.duokan.reader;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;

import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.ui.UTools;
import com.duokan.reader.common.async.work.g;
import com.duokan.reader.common.bitmap.BitmapsRecycler.RecycleReason;
import com.duokan.reader.common.classc;
import com.duokan.reader.common.d;
import com.duokan.reader.common.download.e;
import com.duokan.reader.common.m;
import com.duokan.reader.domain.account.bt;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.bv;
import com.duokan.reader.domain.bookshelf.dh;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.bd;
import com.duokan.reader.domain.cloud.gn;
import com.duokan.reader.domain.cloud.h;
import com.duokan.reader.domain.cloud.push.b;
import com.duokan.reader.domain.cmread.CmBookManager;
import com.duokan.reader.domain.document.Document_a.o;
import com.duokan.reader.domain.document.epub.ah;
import com.duokan.reader.domain.document.txt.aa;
import com.duokan.reader.domain.downloadcenter.r;
import com.duokan.reader.domain.micloud.MiCloudCreateFileTaskCacheFactory;
import com.duokan.reader.domain.micloud.MiCloudDownloadFileTaskCacheFactory;
import com.duokan.reader.domain.micloud.ao;
import com.duokan.reader.domain.micloud.ba;
import com.duokan.reader.domain.payment.PaymentManager;
import com.duokan.reader.domain.plugins.dict.j;
import com.duokan.reader.domain.social.message.bb;
import com.duokan.reader.domain.social.message.k;
import com.duokan.reader.domain.statistics.dailystats.a;
import com.duokan.reader.ui.account.MiAccountAssist;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import com.xiaomi.passport.PassportExternal;
import com.xiaomi.payment.PaymentApp;

import java.io.File;

public abstract class DkReader extends DkApp {
    public static DkReader get() {
        return (DkReader) DkApp.get();
    }

    protected void onBackgroundInit() {
        StoreWebController.prepareStoreMirror();
        ThirdWeiXin.resetInstalledStatus();
        PaymentApp.init(this);
        Request.init(this);
        Request.setRequestEnv(new RequestEnv(this) {
            final /* synthetic */ DkReader a;
            private RequestEnv b;

            {
                this.a = r1;
            }

            public synchronized String getAccountName() {
                resetProxy();
                return this.b.getAccountName();
            }

            public String queryEncryptedAccountName() {
                resetProxy();
                return this.b.queryEncryptedAccountName();
            }

            public synchronized ExtendedAuthToken queryAuthToken() {
                resetProxy();
                return this.b.queryAuthToken();
            }

            public synchronized void invalidateAuthToken() {
                resetProxy();
                this.b.invalidateAuthToken();
            }

            public String getUserAgent() {
                return "DUOKANREADER; Android/" + ReaderEnv.get().getVersionName();
            }

            public boolean shouldUpdateHost() {
                return true;
            }

            private void resetProxy() {
                this.b = i.f().c().j();
            }
        });
        a.a(ReaderEnv.get(), classc.ConnectivityReceiver.b());
        addOnRunningStateChangedListener(new IActivityRunStatusChanged(this) {
            final /* synthetic */ DkReader a;

            {
                this.a = r1;
            }

            public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
                if (runningState2 == RunningState.UNDERGROUND) {
                    com.duokan.reader.common.bitmap.a.a(RecycleReason.ApplicationExit);
                }
            }
        });
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        UTools.async.a(com.duokan.reader.common.bitmap.a.a(displayMetrics.widthPixels, displayMetrics.heightPixels, Config.ARGB_8888) * 5);
        aa.a(this, ReaderEnv.get());
        ah.a(this, ReaderEnv.get());
        o.a(this, ReaderEnv.get());
        m.a((Context) this);
        DkNotificationManager.startup(this);
        e.a((Context) this, getDiagnosticDirectory());
        com.duokan.reader.common.async.work.f.a(new g(new File(getDiagnosticDirectory(), "async_work_trace_file.log")));
        PaymentManager.a((Context) this, i.f());
        MiAccountAssist.a((Context) this, i.f());
        DkSharedStorageManager.a((Context) this, ReaderEnv.get());
        DkCloudStorage.a(this, i.f(), ReaderEnv.get());
        h.a((Context) this, i.f());
        com.duokan.reader.domain.store.a.a((Context) this, i.f());
        com.duokan.reader.domain.a.a.a((Context) this, i.f());
        com.duokan.reader.domain.social.message.o.a((Context) this, i.f(), k.a);
        com.duokan.reader.domain.social.message.h.a(this, com.duokan.reader.domain.social.message.o.a(), i.f());
        bb.a(this, com.duokan.reader.domain.social.message.o.a(), i.f());
        b.a((Context) this, i.f(), bb.a(), ReaderEnv.get());
        bd.a((Context) this, i.f());
        gn.a(this, i.f());
        com.duokan.reader.ui.b.a.a(this, com.duokan.reader.domain.social.message.h.a());
        PassportExternal.initEnvironment(new bt());
        XMPassportSettings.setUserAgent("DUOKANREADER; Android/" + ReaderEnv.get().getVersionName());
        ba.a(MiCloudCreateFileTaskCacheFactory.a(), MiCloudDownloadFileTaskCacheFactory.a(), ao.a());
        iz.a((Context) this, i.f());
        CmBookManager.startup(ReaderEnv.get(), i.f());
        r.a(this, i.f(), new String[]{"duokan"});
        com.duokan.reader.domain.downloadcenter.b.a(this, r.a(), e.b(), DkNotificationManager.get());
        bv.a((Context) this);
        dh.a((Context) this);
        ai.a(this, ReaderEnv.get(), classc.ConnectivityReceiver.b(), i.f(), iz.a(), com.duokan.reader.domain.store.a.a(), DkCloudStorage.a(), com.duokan.reader.domain.downloadcenter.b.n());
        com.duokan.reader.domain.store.o.a((Context) this, b.a(), ai.a());
        com.duokan.reader.ui.store.o.a((Context) this, com.duokan.reader.domain.store.a.a(), DkCloudStorage.a(), classc.ConnectivityReceiver.b(), com.duokan.reader.domain.downloadcenter.b.n(), ai.a());
        AudioPlayer.a((Context) this);
        com.duokan.reader.domain.b.b.a((Context) this);
        j.a((Context) this);
        d.a(this, isWebAccessEnabled(), ReaderEnv.get(), b.a(), i.f());
        com.duokan.reader.ui.b.d.a(this, b.a(), com.duokan.reader.domain.social.message.h.a(), d.a());
        kp.a((Context) this, i.f(), classc.ConnectivityReceiver.b(), PersonalPrefs.a());
        com.duokan.reader.domain.ad.g.a((Context) this);
        runPreReady(new Runnable(this) {
            final /* synthetic */ DkReader a;

            {
                this.a = r1;
            }

            public void run() {
                com.duokan.reader.domain.social.message.o.a().b();
            }
        });
    }

    public void onTrimMemory(int i) {
        if (i >= 40) {
            com.duokan.reader.common.bitmap.a.a(RecycleReason.LowMemory);
        }
        super.onTrimMemory(i);
    }

    public Class getMainActivityClass() {
        return DkMainActivity.class;
    }

    public Class getReaderActivityClass() {
        return DkReaderActivity.class;
    }

    public boolean supportFreeFictionTab() {
        return false;
    }

    public String getFictionChapterEndAdUpId() {
        return "904ac958665462eaa13d0a17260d4fa6";
    }

    public String getSplashAdUpId() {
        return "5343c675da5f9341fd27176456b7bfbb";
    }

    public String getComicChapterEndAdUpId() {
        return "e2f99ebcf1a2d8fb79947cddab61b4fa";
    }
}
