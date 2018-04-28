package com.duokan.reader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import com.duokan.core.app.C0286x;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.ui.dv;
import com.duokan.reader.common.C0590d;
import com.duokan.reader.common.C0615m;
import com.duokan.reader.common.C0616o;
import com.duokan.reader.common.async.work.C0526f;
import com.duokan.reader.common.async.work.C0528g;
import com.duokan.reader.common.bitmap.BitmapsRecycler.RecycleReason;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.common.download.C0596e;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.bx;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.domain.ad.C0750g;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.bu;
import com.duokan.reader.domain.bookshelf.de;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.bookshelf.lb;
import com.duokan.reader.domain.cloud.C0848h;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.av;
import com.duokan.reader.domain.cloud.ft;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.cmread.CmBookManager;
import com.duokan.reader.domain.document.epub.ah;
import com.duokan.reader.domain.document.p045a.C0915o;
import com.duokan.reader.domain.document.txt.aa;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.C1030r;
import com.duokan.reader.domain.micloud.MiCloudCreateFileTaskCacheFactory;
import com.duokan.reader.domain.micloud.MiCloudDownloadFileTaskCacheFactory;
import com.duokan.reader.domain.micloud.ao;
import com.duokan.reader.domain.micloud.ba;
import com.duokan.reader.domain.p041a.C0664a;
import com.duokan.reader.domain.p044b.C0781b;
import com.duokan.reader.domain.payment.PaymentManager;
import com.duokan.reader.domain.plugins.dict.C1115j;
import com.duokan.reader.domain.social.message.C1148h;
import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.domain.social.message.C1153o;
import com.duokan.reader.domain.social.message.aw;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.domain.store.C1189o;
import com.duokan.reader.domain.tts.TtsManager;
import com.duokan.reader.ui.p051b.C1275a;
import com.duokan.reader.ui.p051b.C1278d;
import com.duokan.reader.ui.store.C1502o;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.micloudsdk.request.Request;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import com.xiaomi.passport.PassportExternal;
import com.xiaomi.payment.PaymentApp;
import java.io.File;

public abstract class DkReader extends DkApp {

    /* renamed from: com.duokan.reader.DkReader$1 */
    class C04281 implements RequestEnv {
        /* renamed from: a */
        final /* synthetic */ DkReader f1410a;
        /* renamed from: b */
        private RequestEnv f1411b;

        C04281(DkReader dkReader) {
            this.f1410a = dkReader;
        }

        public synchronized String getAccountName() {
            resetProxy();
            return this.f1411b.getAccountName();
        }

        public String queryEncryptedAccountName() {
            resetProxy();
            return this.f1411b.queryEncryptedAccountName();
        }

        public synchronized ExtendedAuthToken queryAuthToken() {
            resetProxy();
            return this.f1411b.queryAuthToken();
        }

        public synchronized void invalidateAuthToken() {
            resetProxy();
            this.f1411b.invalidateAuthToken();
        }

        public String getUserAgent() {
            return "DUOKANREADER; Android/" + ReaderEnv.get().getVersionName();
        }

        public boolean shouldUpdateHost() {
            return true;
        }

        private void resetProxy() {
            this.f1411b = C0709k.m3476a().m3508d().mo840j();
        }
    }

    /* renamed from: com.duokan.reader.DkReader$2 */
    class C04292 implements C0286x {
        /* renamed from: a */
        final /* synthetic */ DkReader f1412a;

        C04292(DkReader dkReader) {
            this.f1412a = dkReader;
        }

        public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
            if (runningState2 == RunningState.UNDERGROUND) {
                C0544a.m2440a(RecycleReason.ApplicationExit);
            }
        }
    }

    /* renamed from: com.duokan.reader.DkReader$3 */
    class C04303 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ DkReader f1413a;

        C04303(DkReader dkReader) {
            this.f1413a = dkReader;
        }

        public void run() {
            C1153o.m8590a().m8601b();
        }
    }

    public static DkReader get() {
        return (DkReader) DkApp.get();
    }

    protected void onBackgroundInit() {
        StoreWebController.prepareStoreMirror();
        ThirdWeiXin.resetInstalledStatus();
        PaymentApp.init(this);
        Request.init(this);
        Request.setRequestEnv(new C04281(this));
        C1167a.m8666a(ReaderEnv.get(), C0559f.m2476b());
        addOnRunningStateChangedListener(new C04292(this));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dv.f1204m.m814a(C0544a.m2425a(displayMetrics.widthPixels, displayMetrics.heightPixels, Config.ARGB_8888) * 5);
        aa.m7375a(this, ReaderEnv.get());
        ah.m6499a(this, ReaderEnv.get());
        C0915o.m6073a(this, ReaderEnv.get());
        C0615m.m2800a((Context) this);
        DkNotificationManager.startup(this);
        C0596e.m2756a((Context) this, getDiagnosticDirectory());
        C0526f.m2315a(new C0528g(new File(getDiagnosticDirectory(), "async_work_trace_file.log")));
        PaymentManager.m8336a((Context) this, C0709k.m3476a());
        DkSharedStorageManager.m5017a((Context) this, ReaderEnv.get());
        DkCloudStorage.m4996a(this, C0709k.m3476a(), ReaderEnv.get());
        C0848h.m5607a((Context) this, C0709k.m3476a());
        C1176a.m8696a((Context) this, C0709k.m3476a());
        C0664a.m3110a((Context) this, C0709k.m3476a());
        C1153o.m8592a((Context) this, C0709k.m3476a(), C1151k.f5554a);
        C1148h.m8568a(this, C1153o.m8590a(), C0709k.m3476a());
        aw.m8538a(this, C1153o.m8590a(), C0709k.m3476a());
        C0857b.m5651a((Context) this, C0709k.m3476a(), aw.m8537a(), ReaderEnv.get());
        av.m5322a((Context) this, C0709k.m3476a());
        ft.m5576a(this, C0709k.m3476a());
        C1275a.m9028a(this, C1148h.m8567a());
        PassportExternal.initEnvironment(new bx());
        XMPassportSettings.setUserAgent("DUOKANREADER; Android/" + ReaderEnv.get().getVersionName());
        ba.m8107a(MiCloudCreateFileTaskCacheFactory.m7997a(), MiCloudDownloadFileTaskCacheFactory.m8008a(), ao.m8071a());
        it.m4695a((Context) this, C0709k.m3476a());
        CmBookManager.startup(ReaderEnv.get(), C0709k.m3476a());
        C1030r.m7948a(this, C0709k.m3476a(), new String[]{"duokan"});
        C1016b.m7833a(this, C1030r.m7946a(), C0596e.m2757b(), DkNotificationManager.get());
        bu.m4079a((Context) this);
        de.m4315a((Context) this);
        C0616o.m2807a((Context) this);
        ai.m3981a(this, ReaderEnv.get(), C0559f.m2476b(), C0709k.m3476a(), it.m4692a(), C1176a.m8695a(), DkCloudStorage.m4994a(), C1016b.m7857p());
        C1189o.m8728a((Context) this, C0857b.m5649a(), ai.m3980a());
        C1502o.m15411a((Context) this, C1176a.m8695a(), DkCloudStorage.m4994a(), C0559f.m2476b(), C1016b.m7857p(), ai.m3980a());
        AudioPlayer.m3618a((Context) this);
        C0781b.m3659a((Context) this);
        C1115j.m8417a((Context) this);
        TtsManager.startup(this, C0709k.m3476a(), PersonalPrefs.m5175a(), C1016b.m7857p(), C0559f.m2476b());
        C0590d.m2645a(this, isWebAccessEnabled(), ReaderEnv.get(), C0857b.m5649a(), C0709k.m3476a());
        C1278d.m9038a(this, C0857b.m5649a(), C1148h.m8567a(), C0590d.m2643a());
        lb.m4897a((Context) this, C0709k.m3476a(), C0559f.m2476b(), PersonalPrefs.m5175a());
        C0750g.m3562a((Context) this);
        runPreReady(new C04303(this));
    }

    public void onTrimMemory(int i) {
        if (i >= 40) {
            C0544a.m2440a(RecycleReason.LowMemory);
        }
        super.onTrimMemory(i);
    }

    public Class<? extends Activity> getMainActivityClass() {
        return DkMainActivity.class;
    }

    public Class<? extends Activity> getReaderActivityClass() {
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
