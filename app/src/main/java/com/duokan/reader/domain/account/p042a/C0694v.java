package com.duokan.reader.domain.account.p042a;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.ui.account.p050a.C1240e;
import com.duokan.reader.ui.account.p050a.C1247l;

/* renamed from: com.duokan.reader.domain.account.a.v */
public class C0694v implements C0673p, C0420b {
    /* renamed from: a */
    private final C0672a f2336a;
    /* renamed from: b */
    private final C0675g f2337b;
    /* renamed from: c */
    private final C1240e f2338c = new C1247l(DkApp.get().getTopActivity(), this.f2336a, this);

    public C0694v(C0672a c0672a, C0675g c0675g) {
        this.f2336a = c0672a;
        this.f2337b = c0675g;
    }

    /* renamed from: a */
    public void mo854a() {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null) {
            onLoginError(this.f2336a, "");
            return;
        }
        IFeature a = AppContext.getAppContext(topActivity);
        if (a == null) {
            onLoginError(this.f2336a, "");
        } else if (((ReaderFeature) a.queryFeature(ReaderFeature.class)) == null) {
            onLoginError(this.f2336a, "");
        } else if (TextUtils.isEmpty(C0709k.m3476a().m3514i())) {
            onLoginOk(this.f2336a);
        } else {
            DkApp.get().addActivityLifecycleMonitor(this.f2338c);
            this.f2338c.m8831c();
        }
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2337b.mo855a(this.f2337b.mo859d());
        DkApp.get().removeActivityLifecycleMonitor(this.f2338c);
    }

    public void onLoginError(C0672a c0672a, String str) {
        C0673p f = this.f2337b.mo861f();
        f.m3304a(str);
        this.f2337b.mo855a(f);
        DkApp.get().removeActivityLifecycleMonitor(this.f2338c);
    }
}
