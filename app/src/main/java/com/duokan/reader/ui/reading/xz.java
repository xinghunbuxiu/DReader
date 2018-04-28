package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.hb;
import com.duokan.reader.domain.bookshelf.ke;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.sbk.C0820o;
import com.duokan.reader.domain.document.sbk.C0965b;
import com.duokan.reader.domain.document.sbk.C0969f;
import com.duokan.reader.domain.document.sbk.C0977p;
import com.duokan.reader.domain.document.sbk.C0981w;
import com.duokan.reader.domain.document.sbk.C0983y;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.gc;

public class xz extends aab implements C0820o {
    /* renamed from: a */
    static final /* synthetic */ boolean f11170a = (!xz.class.desiredAssertionStatus());
    /* renamed from: J */
    private PageAnimationMode f11171J;
    /* renamed from: b */
    private final boolean f11172b = this.f.mo1018u();

    public xz(IFeature mFeature, C0800c c0800c, C0896a c0896a) {
        super(mFeature, c0800c, c0896a);
    }

    /* renamed from: c */
    protected sv mo2235c() {
        return new yd(getContext(), this.c, this.e);
    }

    /* renamed from: d */
    protected wy mo2236d() {
        return new yl(getContext(), this);
    }

    /* renamed from: e */
    protected si mo2237e() {
        return new yb();
    }

    /* renamed from: f */
    protected C0917k mo2238f() {
        C0917k c0977p = new C0977p();
        mo2348a(c0977p);
        return c0977p;
    }

    /* renamed from: k */
    protected C0923m mo2239k() {
        C0923m c0981w = new C0981w();
        mo2349a(c0981w);
        return c0981w;
    }

    /* renamed from: a */
    protected void mo2349a(C0923m c0923m) {
        super.mo2349a(c0923m);
        c0923m.f4368p = true;
    }

    /* renamed from: a */
    protected ak mo2234a(C0901g c0901g) {
        return this.h.mo1230c(c0901g.mo1203f());
    }

    /* renamed from: a */
    protected float mo2233a(ak akVar) {
        if (f11170a || akVar.m5777b()) {
            return m15076C().m7224j(akVar) * 100.0f;
        }
        throw new AssertionError();
    }

    /* renamed from: l */
    protected void mo2240l() {
        hb b = this.f.m4152E().m4819b();
        this.f11171J = b.m4626g();
        if (ReaderEnv.get().forHd()) {
            getActivity().setRequestedOrientation(2);
        } else if (this.c.aj() && b.m4625f() == ReadingOrientation.LANDSCAPE) {
            ReaderUi.m10153a(getActivity(), 11);
        } else {
            getActivity().setRequestedOrientation(1);
        }
    }

    /* renamed from: a */
    protected void mo2461a(ke keVar) {
        super.mo2461a(keVar);
        keVar.f3450f = this.c.mo2095b();
        keVar.f3450f.m4617a(this.c.am() ? ReadingOrientation.LANDSCAPE : ReadingOrientation.PORTRAIT);
        keVar.f3450f.m4616a(this.c.mo2004U());
    }

    /* renamed from: b */
    protected void mo2351b(gc gcVar) {
        super.mo2351b(gcVar);
        C0965b c0965b = (C0965b) ((C0983y) this.c.aa()).mo1332l().mo1198g();
        if (Math.min(c0965b.m7142h() + 1, (long) ((int) m15076C().m7204c(c0965b.m7141g()))) < 1) {
            ((yl) this.e).m15171a(4, "", "");
            return;
        }
        ((yl) this.e).m15171a(0, String.format(getString(C0258j.reading__comic_view__chapter), new Object[]{Long.valueOf(r4 + 1)}), String.format("%d / %d", new Object[]{Long.valueOf(r2 + 1), Integer.valueOf(r1)}));
    }

    /* renamed from: a */
    protected void mo2513a(Runnable runnable, Runnable runnable2) {
        ap apVar = new ap(getContext());
        apVar.setTitle(C0258j.reading__pull_comic_by_mobile_network_dlg__title);
        apVar.setPrompt(C0258j.reading__pull_comic_by_mobile_network_dlg__prompt);
        apVar.setOkLabelResid(C0258j.general__shared__allow);
        apVar.setCancelLabel(C0258j.general__shared__disallow);
        apVar.open(new ya(this, runnable, runnable2));
    }

    /* renamed from: B */
    protected int mo1978B() {
        return 2;
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        C0559f.m2476b().m2481a((C0563j) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        C0559f.m2476b().m2483b((C0563j) this);
    }

    /* renamed from: C */
    private C0969f m15076C() {
        return (C0969f) this.h;
    }
}
