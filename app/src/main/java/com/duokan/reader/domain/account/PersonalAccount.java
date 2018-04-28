package com.duokan.reader.domain.account;

import android.app.Activity;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.social.p048b.C1135b;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import java.util.Map;

public class PersonalAccount extends C0672a {
    /* renamed from: e */
    static final /* synthetic */ boolean f2265e = (!PersonalAccount.class.desiredAssertionStatus());
    /* renamed from: f */
    private C0672a f2266f;
    /* renamed from: g */
    private final MiAccount f2267g;
    /* renamed from: h */
    private final MiGuestAccount f2268h;
    /* renamed from: i */
    private final AnonymousAccount f2269i;

    private PersonalAccount(C0706e c0706e) {
        super(c0706e);
        this.f2266f = null;
        this.f2267g = (MiAccount) this.a.mo876a(MiAccount.class);
        this.f2268h = (MiGuestAccount) this.a.mo876a(MiGuestAccount.class);
        this.f2269i = (AnonymousAccount) this.a.mo876a(AnonymousAccount.class);
    }

    /* renamed from: k */
    protected void mo841k() {
    }

    /* renamed from: a */
    protected void mo831a(String str, String str2, String str3) {
    }

    /* renamed from: m */
    protected String mo842m() {
        return "";
    }

    /* renamed from: e */
    public AccountType mo835e() {
        if (m3252t() == null) {
            return AccountType.NONE;
        }
        return m3252t().mo835e();
    }

    /* renamed from: a */
    public long mo853a() {
        if (m3252t() == null) {
            return -1;
        }
        return m3252t().mo853a();
    }

    /* renamed from: b */
    public String mo832b() {
        if (m3252t() == null) {
            return "";
        }
        return m3252t().mo832b();
    }

    /* renamed from: c */
    public String mo833c() {
        if (m3252t() == null) {
            return "";
        }
        return m3252t().mo833c();
    }

    /* renamed from: d */
    public String mo834d() {
        if (m3252t() == null) {
            return "";
        }
        return m3252t().mo834d();
    }

    /* renamed from: f */
    public C0705g mo836f() {
        if (m3252t() != null) {
            return m3252t().mo836f();
        }
        if (f2265e) {
            return new by(this);
        }
        throw new AssertionError();
    }

    /* renamed from: g */
    public Map<String, String> mo837g() {
        if (m3252t() == null) {
            return null;
        }
        return m3252t().mo837g();
    }

    /* renamed from: h */
    public Map<String, String> mo838h() {
        if (m3252t() == null) {
            return null;
        }
        return m3252t().mo838h();
    }

    /* renamed from: a */
    public void mo829a(Activity activity, C0700d c0700d) {
        if (m3252t() == null) {
            c0700d.mo868a(this);
        } else {
            m3252t().mo829a(activity, new bz(this, c0700d));
        }
    }

    /* renamed from: n */
    public boolean mo843n() {
        mo848r();
        return this.f2266f != null && ((this.f2266f.mo835e().equals(AccountType.XIAO_MI) || this.f2266f.mo835e().equals(AccountType.XIAOMI_GUEST)) && !this.f2266f.mo839i());
    }

    /* renamed from: a */
    public void mo830a(C0699c c0699c) {
        if (this.f2266f instanceof UserAccount) {
            this.f2266f.mo830a(new ca(this, c0699c));
        }
    }

    /* renamed from: j */
    public RequestEnv mo840j() {
        return m3252t().mo840j();
    }

    /* renamed from: t */
    private C0672a m3252t() {
        if (this.f2266f != null) {
            return this.f2266f;
        }
        mo848r();
        return this.f2266f;
    }

    /* renamed from: r */
    public void mo848r() {
        if (!this.f2267g.mo839i()) {
            this.f2266f = this.f2267g;
        } else if (!this.f2268h.mo839i()) {
            this.f2266f = this.f2268h;
        } else if (this.f2269i.mo839i() || (DkApp.get().getAutoLogin() && MiAccount.m3186b(DkApp.get()))) {
            this.f2266f = null;
        } else {
            this.f2266f = this.f2269i;
        }
    }

    /* renamed from: a */
    public void m3255a(C0672a c0672a) {
        this.f2266f = c0672a;
    }

    /* renamed from: i */
    public boolean mo839i() {
        mo848r();
        return m3252t() == null || m3252t().mo839i();
    }

    /* renamed from: o */
    public boolean mo844o() {
        return m3252t() != null && m3252t().mo844o();
    }

    /* renamed from: p */
    public boolean mo845p() {
        return m3252t() != null && m3252t().mo845p();
    }

    /* renamed from: q */
    public boolean mo846q() {
        return m3252t() != null && m3252t().mo846q();
    }

    /* renamed from: s */
    public C1135b m3274s() {
        if (m3252t() instanceof UserAccount) {
            return ((UserAccount) m3252t()).mo849s();
        }
        return null;
    }
}
