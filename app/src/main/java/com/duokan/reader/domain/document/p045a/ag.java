package com.duokan.reader.domain.document.p045a;

import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;

/* renamed from: com.duokan.reader.domain.document.a.ag */
public class ag extends bb {
    /* renamed from: a */
    private final C0898a f4240a;
    /* renamed from: b */
    private final C0898a f4241b;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return m5833j();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return m5834k();
    }

    protected ag() {
        this(new C0898a(0, 0, 0), new C0898a(0, 0, 0));
    }

    protected ag(C0898a c0898a, C0898a c0898a2) {
        this.f4240a = c0898a;
        this.f4241b = c0898a2;
    }

    /* renamed from: a */
    protected static ag m5823a(ag agVar, ag agVar2) {
        if (agVar.m5817f()) {
            return agVar2;
        }
        if (agVar2.m5817f()) {
            return agVar;
        }
        return new ag(agVar.m5833j().mo1188a(agVar2.m5833j()) ? agVar.m5833j() : agVar2.m5833j(), agVar.m5834k().mo1190c(agVar2.m5834k()) ? agVar.m5834k() : agVar2.m5834k());
    }

    /* renamed from: b */
    protected static ag m5824b(ag agVar, ag agVar2) {
        if (agVar.m5817f() || agVar2.m5817f()) {
            return agVar;
        }
        return new ag(agVar.m5833j().mo1188a(agVar2.m5833j()) ? agVar2.m5833j() : agVar.m5833j(), agVar.m5834k().mo1188a(agVar2.m5834k()) ? agVar.m5834k() : agVar2.m5834k());
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        return false;
    }

    /* renamed from: e */
    public boolean mo1192e() {
        return true;
    }

    /* renamed from: a */
    public boolean mo1187a(long j) {
        return true;
    }

    /* renamed from: j */
    public C0898a m5833j() {
        return this.f4240a;
    }

    /* renamed from: k */
    public C0898a m5834k() {
        return this.f4241b;
    }

    /* renamed from: a */
    public bb mo1196a(bb bbVar) {
        return ag.m5823a(this, (ag) bbVar);
    }

    /* renamed from: b */
    public bb mo1197b(bb bbVar) {
        return ag.m5824b(this, (ag) bbVar);
    }
}
