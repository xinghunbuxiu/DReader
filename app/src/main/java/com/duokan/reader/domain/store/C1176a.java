package com.duokan.reader.domain.store;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0630c;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cmread.CmBookManager;

/* renamed from: com.duokan.reader.domain.store.a */
public class C1176a implements ai {
    /* renamed from: c */
    static final /* synthetic */ boolean f5628c = (!C1176a.class.desiredAssertionStatus());
    /* renamed from: d */
    private static final aj<C1176a> f5629d = new aj();
    /* renamed from: a */
    protected final Context f5630a;
    /* renamed from: b */
    protected final C0709k f5631b;
    /* renamed from: e */
    private C1186l f5632e = null;
    /* renamed from: f */
    private WebSession f5633f = null;
    /* renamed from: g */
    private WebSession f5634g = null;

    protected C1176a(Context context, C0709k c0709k) {
        this.f5630a = context;
        this.f5631b = c0709k;
    }

    /* renamed from: a */
    public void m8703a(String str, boolean z, C0466h c0466h) {
        m8697a(str, z, 0, null, c0466h);
    }

    /* renamed from: a */
    private void m8697a(String str, boolean z, int i, String str2, C0466h c0466h) {
        if (!f5628c && str == null) {
            throw new AssertionError();
        } else if (f5628c || c0466h != null) {
            WebSession c1177b = new C1177b(this, C0630c.f2119a, c0466h, str, z, str2);
            if (i > 0) {
                int max = Math.max(5000, i);
                c1177b.setConnectTimeout(max);
                c1177b.setReadTimeout(max);
            }
            c1177b.open();
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public void m8705b(String str, boolean z, C0466h c0466h) {
        m8704a(str, z, false, -1, -1, 0, c0466h);
    }

    /* renamed from: a */
    public void m8704a(String str, boolean z, boolean z2, int i, int i2, int i3, C0466h c0466h) {
        if (!f5628c && str == null) {
            throw new AssertionError();
        } else if (!f5628c && c0466h == null) {
            throw new AssertionError();
        } else if (new C0650x(str).m3047b() == 1) {
            CmBookManager.get().fetchFictionDetail(str, z, z2, i, i2, i3, c0466h);
        } else {
            new C1178c(this, C0630c.f2119a, c0466h, str, z, z2, i, i2, i3).open();
        }
    }

    /* renamed from: a */
    public void m8701a(String str, int i, int i2, C1183i c1183i) {
        if (this.f5634g != null) {
            this.f5634g.close();
            this.f5634g = null;
        }
        this.f5634g = new C1179d(this, C0630c.f2119a, str, i, i2, c1183i);
        this.f5634g.open();
    }

    /* renamed from: a */
    public void m8702a(String str, C1185k c1185k) {
        if (this.f5633f != null) {
            this.f5633f.close();
            this.f5633f = null;
        }
        this.f5633f = new C1180e(this, C0630c.f2119a, str, c1185k);
        this.f5633f.open();
    }

    /* renamed from: a */
    public void m8700a(String str, int i, int i2, C1182g c1182g) {
        if (f5628c || c1182g != null) {
            new C1181f(this, C0630c.f2119a, str, i, i2, c1182g).open();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m8699a(C1186l c1186l) {
        this.f5632e = c1186l;
    }

    /* renamed from: a */
    public static void m8696a(Context context, C0709k c0709k) {
        f5629d.m709a(new C1176a(context, c0709k));
    }

    /* renamed from: a */
    public static C1176a m8695a() {
        return (C1176a) f5629d.m707a();
    }
}
