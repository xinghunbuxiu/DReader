package com.duokan.reader.ui.personal;

import android.app.Activity;
import android.content.Context;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.ui.general.ap;
import com.wali.live.sdk.manager.MiLiveSdkController;
import com.wali.live.sdk.manager.SdkUpdateHelper;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.ServiceTokenResult.ErrorCode;

public class eu {
    /* renamed from: a */
    private final Activity f8523a;
    /* renamed from: b */
    private final SdkUpdateHelper f8524b = new SdkUpdateHelper(new ez(this));
    /* renamed from: c */
    private fn f8525c;

    public eu(Activity activity) {
        this.f8523a = activity;
        MiLiveSdkController.getInstance().init(this.f8523a.getApplication(), 50017, "", true, new ev(this));
    }

    /* renamed from: a */
    public void m11785a(C0672a c0672a) {
        String miLiveUser = ReaderEnv.get().getMiLiveUser();
        if (c0672a == null || !miLiveUser.equals(c0672a.mo832b())) {
            MiLiveSdkController.getInstance().clearAccount(null);
        }
        MiLiveSdkController.getInstance().openContestPrepare(this.f8523a, new fg(this));
    }

    /* renamed from: c */
    private void m11781c() {
        ap apVar = new ap(this.f8523a);
        apVar.setPrompt(C0258j.store__mi_live__need_update);
        apVar.setOkLabelResid(C0258j.store__mi_live__install);
        apVar.setNoLabel(C0258j.general__shared__cancel);
        apVar.open(new fi(this));
    }

    /* renamed from: b */
    private void m11778b(C0672a c0672a) {
        ah.m871b(new fk(this, c0672a));
    }

    /* renamed from: d */
    private void m11783d() {
        C0709k.m3476a().m3497a(MiAccount.class, new fl(this));
    }

    /* renamed from: a */
    private String m11775a(Context context) {
        ServiceTokenResult serviceTokenResult = MiAccountManager.get(context).getServiceToken(context, "xmzhibo").get();
        if (serviceTokenResult == null) {
            WebLog.init().c(LogLevel.ERROR, "miLive", "getServiceToken is null");
            return null;
        }
        ErrorCode errorCode = serviceTokenResult.errorCode;
        if (errorCode == ErrorCode.ERROR_NONE) {
            return serviceTokenResult.serviceToken;
        }
        WebLog.init().c(LogLevel.ERROR, "miLive", "account getServiceToken errCode=" + errorCode);
        return null;
    }

    /* renamed from: a */
    public boolean m11786a() {
        return MiLiveSdkController.getInstance().hasInstallLiveSdk(this.f8523a.getApplication());
    }

    /* renamed from: b */
    public void m11787b() {
        UThread.runOnThread(new fm(this));
    }
}
