package com.duokan.reader.ui.reading;

import com.duokan.c.j;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.hh;
import com.duokan.reader.domain.bookshelf.js;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.sbk.b;
import com.duokan.reader.domain.document.sbk.o;
import com.duokan.reader.domain.document.sbk.p;
import com.duokan.reader.domain.document.sbk.w;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.gi;

public class xm extends zo implements o {
    static final /* synthetic */ boolean a = (!xm.class.desiredAssertionStatus());
    private PageAnimationMode J;
    private final boolean b = this.f.u();

    public xm(y yVar, c cVar, a aVar) {
        super(yVar, cVar, aVar);
    }

    protected si c() {
        return new xq(getContext(), this.c, this.e);
    }

    protected wl d() {
        return new xy(getContext(), this);
    }

    protected rx e() {
        return new xo();
    }

    protected k f() {
        k pVar = new p();
        a(pVar);
        return pVar;
    }

    protected m k() {
        m wVar = new w();
        a(wVar);
        return wVar;
    }

    protected void a(m mVar) {
        super.a(mVar);
        mVar.p = true;
    }

    protected ak a(g gVar) {
        return this.h.c(gVar.f());
    }

    protected float a(ak akVar) {
        if (a || akVar.b()) {
            return C().j(akVar) * 100.0f;
        }
        throw new AssertionError();
    }

    protected void l() {
        hh b = this.f.D().b();
        this.J = b.g();
        if (ReaderEnv.get().forHd()) {
            getActivity().setRequestedOrientation(2);
        } else if (this.c.aj() && b.f() == ReadingOrientation.LANDSCAPE) {
            ReaderUi.a(getActivity(), 11);
        } else {
            getActivity().setRequestedOrientation(1);
        }
    }

    protected void a(js jsVar) {
        super.a(jsVar);
        jsVar.f = this.c.b();
        jsVar.f.a(this.c.am() ? ReadingOrientation.LANDSCAPE : ReadingOrientation.PORTRAIT);
        jsVar.f.a(this.c.U());
    }

    protected void b(gi giVar) {
        super.b(giVar);
        b bVar = (b) ((com.duokan.reader.domain.document.sbk.y) this.c.aa()).l().g();
        if (Math.min(bVar.h() + 1, (long) ((int) C().c(bVar.g()))) < 1) {
            ((xy) this.e).a(4, "", "");
            return;
        }
        ((xy) this.e).a(0, String.format(getString(j.reading__comic_view__chapter), new Object[]{Long.valueOf(r4 + 1)}), String.format("%d / %d", new Object[]{Long.valueOf(r2 + 1), Integer.valueOf(r1)}));
    }

    protected void a(Runnable runnable, Runnable runnable2) {
        ap apVar = new ap(getContext());
        apVar.setTitle(j.reading__pull_comic_by_mobile_network_dlg__title);
        apVar.setPrompt(j.reading__pull_comic_by_mobile_network_dlg__prompt);
        apVar.setOkLabel(j.general__shared__allow);
        apVar.setCancelLabel(j.general__shared__disallow);
        apVar.open(new xn(this, runnable, runnable2));
    }

    protected int B() {
        return 2;
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        f.b().a((com.duokan.reader.common.c.g) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        f.b().b(this);
    }

    private com.duokan.reader.domain.document.sbk.f C() {
        return (com.duokan.reader.domain.document.sbk.f) this.h;
    }
}
