package com.duokan.reader.domain.account.p042a;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.ui.account.p050a.C1244i;

/* renamed from: com.duokan.reader.domain.account.a.c */
public class C0678c implements C0673p, C0420b {
    /* renamed from: a */
    private final C0672a f2282a;
    /* renamed from: b */
    private final C0675g f2283b;
    /* renamed from: c */
    private final C1244i f2284c = new C1244i(DkApp.get().getTopActivity(), this.f2282a, this);

    public C0678c(C0672a c0672a, C0675g c0675g) {
        this.f2282a = c0672a;
        this.f2283b = c0675g;
    }

    /* renamed from: a */
    public void mo854a() {
        UmengManager.get().onEvent("ACCOUNT_AUTOLOGIN_V1", "done");
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null) {
            onLoginError(this.f2282a, "");
            return;
        }
        IFeature a = AppContext.getAppContext(topActivity);
        if (a == null) {
            onLoginError(this.f2282a, "");
        } else if (((ReaderFeature) a.queryFeature(ReaderFeature.class)) == null) {
            onLoginError(this.f2282a, "");
        } else if (TextUtils.isEmpty(C0709k.m3476a().m3514i())) {
            onLoginOk(this.f2282a);
        } else {
            DkApp.get().addActivityLifecycleMonitor(this.f2284c);
            this.f2284c.m8831c();
        }
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2283b.mo855a(this.f2283b.mo859d());
        DkApp.get().removeActivityLifecycleMonitor(this.f2284c);
    }

    public void onLoginError(C0672a c0672a, String str) {
        C0673p f = this.f2283b.mo861f();
        f.m3304a(str);
        this.f2283b.mo855a(f);
        DkApp.get().removeActivityLifecycleMonitor(this.f2284c);
    }
}
