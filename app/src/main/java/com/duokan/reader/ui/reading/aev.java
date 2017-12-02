package com.duokan.reader.ui.reading;

import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.txt.ad;
import com.duokan.reader.domain.document.txt.ah;
import com.duokan.reader.domain.document.txt.b;
import com.duokan.reader.domain.document.txt.p;
import com.duokan.reader.domain.document.txt.z;
import com.duokan.reader.ui.general.ReaderUi;

public class aev extends qh implements z {
    static final /* synthetic */ boolean a = (!aev.class.desiredAssertionStatus());

    public aev(y yVar, c cVar, a aVar) {
        super(yVar, cVar, aVar);
    }

    protected si c() {
        return new aey(getContext(), this.c, this.e);
    }

    protected wl d() {
        return new afb(getContext(), this);
    }

    protected rx e() {
        return new aex();
    }

    protected k f() {
        k adVar = new ad();
        a(adVar);
        return adVar;
    }

    protected m k() {
        m ahVar = new ah();
        a(ahVar);
        return ahVar;
    }

    protected ak a(g gVar) {
        return this.h.c(gVar.f());
    }

    protected float a(ak akVar) {
        if (a || akVar.b()) {
            p pVar = (p) this.h;
            b bVar = (b) akVar.g();
            if (pVar.e() >= 0) {
                return (((float) (pVar.b(akVar) + 1)) / ((float) pVar.e())) * 100.0f;
            }
            return pVar.B() != 0 ? (((float) bVar.g()) / ((float) pVar.B())) * 100.0f : 100.0f;
        } else {
            throw new AssertionError();
        }
    }

    protected void l() {
        if (ReaderEnv.get().forHd()) {
            getActivity().setRequestedOrientation(2);
        } else if (this.c.aj() && this.d.a() == ReadingOrientation.LANDSCAPE) {
            ReaderUi.a(getActivity(), 11);
        } else {
            getActivity().setRequestedOrientation(1);
        }
    }
}
