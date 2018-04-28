package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.bb;

public class at extends bb {
    /* renamed from: a */
    private final C0986b f4917a;
    /* renamed from: b */
    private final C0986b f4918b;

    /* renamed from: g */
    public /* synthetic */ av mo1198g() {
        return m7513j();
    }

    /* renamed from: h */
    public /* synthetic */ av mo1199h() {
        return m7514k();
    }

    protected at() {
        this(new C0986b(0), new C0986b(0));
    }

    protected at(C0986b c0986b, C0986b c0986b2) {
        this.f4917a = c0986b;
        this.f4918b = c0986b2;
    }

    /* renamed from: a */
    protected static at m7503a(at atVar, at atVar2) {
        if (atVar.m5817f()) {
            return atVar2;
        }
        if (atVar2.m5817f()) {
            return atVar;
        }
        return new at(atVar.m7513j().mo1188a(atVar2.m7513j()) ? atVar.m7513j() : atVar2.m7513j(), atVar.m7514k().mo1190c(atVar2.m7514k()) ? atVar.m7514k() : atVar2.m7514k());
    }

    /* renamed from: b */
    static at m7504b(at atVar, at atVar2) {
        if (atVar.m5817f() || atVar2.m5817f()) {
            return atVar;
        }
        return new at(atVar.m7513j().mo1188a(atVar2.m7513j()) ? atVar2.m7513j() : atVar.m7513j(), atVar.m7514k().mo1188a(atVar2.m7514k()) ? atVar.m7514k() : atVar2.m7514k());
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
    public C0986b m7513j() {
        return this.f4917a;
    }

    /* renamed from: k */
    public C0986b m7514k() {
        return this.f4918b;
    }

    /* renamed from: a */
    public bb mo1196a(bb bbVar) {
        return m7503a(this, (at) bbVar);
    }

    /* renamed from: b */
    public bb mo1197b(bb bbVar) {
        return m7504b(this, (at) bbVar);
    }
}
