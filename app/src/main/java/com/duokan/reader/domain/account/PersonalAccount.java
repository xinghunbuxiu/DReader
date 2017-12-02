package com.duokan.reader.domain.account;

import android.app.Activity;
import android.text.TextUtils;

import com.duokan.b.i;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.domain.social.b.b;
import com.duokan.reader.domain.statistics.a;
import com.duokan.reader.ui.general.jq;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;

import java.util.List;
import java.util.Map;

public class PersonalAccount extends a {
    static final /* synthetic */ boolean e = (!PersonalAccount.class.desiredAssertionStatus());
    private a f = null;
    private final MiAccount g = ((MiAccount) this.a.a(MiAccount.class));
    private final MiGuestAccount h = ((MiGuestAccount) this.a.a(MiGuestAccount.class));
    private final AnonymousAccount i = ((AnonymousAccount) this.a.a(AnonymousAccount.class));
    private b j;
    private boolean k = false;

    public PersonalAccount(e eVar) {
        super(eVar);
    }

    protected void k() {
    }

    protected void a(String str, String str2, String str3) {
    }

    protected String m() {
        return "";
    }

    public AccountType e() {
        if (t() == null) {
            return AccountType.NONE;
        }
        return t().e();
    }

    public long a() {
        if (t() == null) {
            return -1;
        }
        return t().a();
    }

    public String b() {
        if (t() == null) {
            return "";
        }
        return t().b();
    }

    public String c() {
        if (t() == null) {
            return "";
        }
        return t().c();
    }

    public String d() {
        if (t() == null) {
            return "";
        }
        return t().d();
    }

    public g f() {
        if (t() != null) {
            return t().f();
        }
        if (e) {
            return new bu(this);
        }
        throw new AssertionError();
    }

    public Map g() {
        if (t() == null) {
            return null;
        }
        return t().g();
    }

    public Map h() {
        if (t() == null) {
            return null;
        }
        return t().h();
    }

    public void a(Activity activity, d dVar) {
        if (t() == null) {
            dVar.a(this);
        } else {
            t().a(activity, new bv(this, dVar));
        }
    }

    public boolean n() {
        o();
        return this.f != null && ((this.f.e().equals(AccountType.XIAO_MI) || this.f.e().equals(AccountType.XIAOMI_GUEST)) && !this.f.i());
    }

    public synchronized void a(b bVar) {
        if (!(n() || this.k)) {
            this.k = true;
            this.f = this.g;
            this.g.b(new bw(this, bVar));
        }
    }

    public void b(b bVar) {
        a(null, i.f().d(), bVar);
    }

    public void c(b bVar) {
        List d = i.f().d();
        d.remove("WX_LOGIN");
        a(DkApp.get().getString(i.account__mi_login_view__title), d, bVar);
    }

    private void a(String str, List list, b bVar) {
        if (list.size() == 1) {
            e(bVar);
        } else {
            new w(DkApp.get().getTopActivity(), str, list, new bx(this, bVar)).show();
        }
    }

    public synchronized void d(b bVar) {
        if (!(n() || this.k)) {
            this.k = true;
            this.f = this.g;
            this.g.c(new by(this, bVar));
        }
    }

    public synchronized void e(b bVar) {
        if (!(n() || this.k)) {
            this.k = true;
            this.f = this.g;
            this.g.d(new bz(this, bVar));
        }
    }

    public synchronized void f(b bVar) {
        if (!this.k) {
            this.k = true;
            jq jqVar = new jq(DkApp.get().getTopActivity());
            jqVar.a(DkApp.get().getString(i.account__shared__duokan_logging_in));
            jqVar.a(true);
            jqVar.setCancelOnBack(false);
            jqVar.setCancelOnTouchOutside(false);
            jqVar.show();
            new ThirdWeiXin().login();
            a.k().b("login", "wechat", "click");
            this.j = new ca(this, jqVar, bVar);
        }
    }

    public synchronized void g(b bVar) {
        if (!n()) {
            f(bVar);
        }
    }

    public synchronized void a(Resp resp) {
        if (this.j != null) {
            b bVar = this.j;
            this.j = null;
            if (resp == null || TextUtils.isEmpty(resp.code)) {
                this.k = false;
                o();
                a.k().b("login", "wechat", "canceled");
                bVar.a(i.f().b(MiGuestAccount.class), "");
            } else {
                this.f = this.h;
                this.h.a(new cb(this, bVar), resp.code);
            }
        }
    }

    public void a(c cVar) {
        if (this.f instanceof UserAccount) {
            this.f.a(new cc(this, cVar));
        }
    }

    public RequestEnv j() {
        return t().j();
    }

    private a t() {
        if (this.f != null) {
            return this.f;
        }
        o();
        return this.f;
    }

    public void o() {
        if (!this.g.i()) {
            this.f = this.g;
        } else if (!this.h.i()) {
            this.f = this.h;
        } else if (this.i.i() || (DkApp.get().getAutoLogin() && MiAccount.a(DkApp.get()))) {
            this.f = null;
        } else {
            this.f = this.i;
        }
    }

    public boolean i() {
        o();
        return t() == null || t().i();
    }

    public boolean p() {
        return t() != null && t().p();
    }

    public boolean q() {
        return t() != null && t().q();
    }

    public boolean r() {
        return t() != null && t().r();
    }

    public b s() {
        if (t() instanceof UserAccount) {
            return ((UserAccount) t()).s();
        }
        return null;
    }
}
