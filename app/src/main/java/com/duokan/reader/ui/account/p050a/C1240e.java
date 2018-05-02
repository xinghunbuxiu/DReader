package com.duokan.reader.ui.account.p050a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.duokan.core.app.C0297a;
import com.duokan.core.app.ag;
import com.duokan.core.app.ah;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.ui.general.ak;
import com.duokan.reader.ui.general.ja;

/* renamed from: com.duokan.reader.ui.account.a.e */
public abstract class C1240e implements C0297a, ah, C1239d {
    /* renamed from: a */
    protected final Context f5756a;
    /* renamed from: b */
    final C0672a f5757b;
    /* renamed from: c */
    private final C0420b f5758c;
    /* renamed from: d */
    private final C1236a f5759d = new C1236a();
    /* renamed from: e */
    private final ja f5760e;
    /* renamed from: f */
    private final C1241f f5761f;
    /* renamed from: g */
    private ak f5762g;

    C1240e(Context context, C0672a c0672a, C0420b c0420b, C1241f c1241f) {
        this.f5756a = context;
        this.f5757b = c0672a;
        this.f5758c = c0420b;
        if (DkApp.get().getTopActivity() == null) {
            this.f5760e = null;
        } else {
            this.f5760e = new ja(DkApp.get().getTopActivity());
            this.f5760e.m10843a(context.getString(C0247i.account__shared__duokan_logging_in));
        }
        this.f5761f = c1241f;
    }

    /* renamed from: c */
    public void m8831c() {
        this.f5759d.m8823b(this);
    }

    /* renamed from: a */
    public void mo1561a() {
        this.f5758c.onLoginOk(this.f5757b);
        if (this.f5760e != null) {
            this.f5760e.dismiss();
        }
    }

    /* renamed from: a */
    public void mo1563a(boolean z) {
        if (this.f5760e != null) {
            this.f5760e.dismiss();
        }
        if (z) {
            this.f5759d.m8822a(this);
        } else {
            this.f5762g = this.f5761f.mo1568a(C0709k.m3476a().m3512g(), this);
        }
    }

    /* renamed from: b */
    public void mo1564b() {
        this.f5758c.onLoginError(this.f5757b, "");
        if (this.f5760e != null) {
            this.f5760e.dismiss();
        }
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        if (this.f5760e != null) {
            this.f5760e.show();
        }
        this.f5759d.m8822a(this);
    }

    public void onActivityPaused(Activity activity) {
        if (this.f5762g != null) {
            this.f5762g.dismiss();
        }
        mo1564b();
        if (this.f5760e != null) {
            this.f5760e.dismiss();
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
