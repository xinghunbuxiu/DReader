package com.duokan.reader.domain.document.sbk;

import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;

public class ah extends bb {
    /* renamed from: a */
    private final C0965b f4790a;
    /* renamed from: b */
    private final C0965b f4791b;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return m7130j();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return m7131k();
    }

    protected ah() {
        this(new C0965b(0, 0, 0), new C0965b(0, 0, 0));
    }

    protected ah(C0965b c0965b, C0965b c0965b2) {
        this.f4790a = c0965b;
        this.f4791b = c0965b2;
    }

    /* renamed from: a */
    protected static ah m7120a(ah ahVar, ah ahVar2) {
        if (ahVar.m5817f()) {
            return ahVar2;
        }
        if (ahVar2.m5817f()) {
            return ahVar;
        }
        return new ah(ahVar.m7130j().mo1188a(ahVar2.m7130j()) ? ahVar.m7130j() : ahVar2.m7130j(), ahVar.m7131k().mo1190c(ahVar2.m7131k()) ? ahVar.m7131k() : ahVar2.m7131k());
    }

    /* renamed from: b */
    protected static ah m7121b(ah ahVar, ah ahVar2) {
        if (ahVar.m5817f() || ahVar2.m5817f()) {
            return ahVar;
        }
        return new ah(ahVar.m7130j().mo1188a(ahVar2.m7130j()) ? ahVar2.m7130j() : ahVar.m7130j(), ahVar.m7131k().mo1188a(ahVar2.m7131k()) ? ahVar.m7131k() : ahVar2.m7131k());
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
    public C0965b m7130j() {
        return this.f4790a;
    }

    /* renamed from: k */
    public C0965b m7131k() {
        return this.f4791b;
    }

    /* renamed from: a */
    public bb mo1196a(bb bbVar) {
        return m7120a(this, (ah) bbVar);
    }

    /* renamed from: b */
    public bb mo1197b(bb bbVar) {
        return m7121b(this, (ah) bbVar);
    }
}
