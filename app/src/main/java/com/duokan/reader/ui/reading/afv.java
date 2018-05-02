package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.txt.C0827z;
import com.duokan.reader.domain.document.txt.C0986b;
import com.duokan.reader.domain.document.txt.C1000p;
import com.duokan.reader.domain.document.txt.ad;
import com.duokan.reader.domain.document.txt.ah;
import com.duokan.reader.ui.general.ReaderUi;

public class afv extends qr implements C0827z {
    /* renamed from: a */
    static final /* synthetic */ boolean f9654a = (!afv.class.desiredAssertionStatus());

    public afv(IFeature mFeature, C0800c c0800c, C0896a c0896a) {
        super(mFeature, c0800c, c0896a);
    }

    /* renamed from: c */
    protected sv mo2235c() {
        return new afy(getContext(), this.c, this.e);
    }

    /* renamed from: d */
    protected wy mo2236d() {
        return new agb(getContext(), this);
    }

    /* renamed from: e */
    protected si mo2237e() {
        return new afx();
    }

    /* renamed from: f */
    protected C0917k mo2238f() {
        C0917k adVar = new ad();
        mo2348a(adVar);
        return adVar;
    }

    /* renamed from: k */
    protected C0923m mo2239k() {
        C0923m ahVar = new ah();
        mo2349a(ahVar);
        return ahVar;
    }

    /* renamed from: a */
    protected ak mo2234a(C0901g c0901g) {
        return this.h.mo1230c(c0901g.mo1203f());
    }

    /* renamed from: a */
    protected float mo2233a(ak akVar) {
        if (f9654a || akVar.m5777b()) {
            C1000p c1000p = (C1000p) this.h;
            C0986b c0986b = (C0986b) akVar.mo1198g();
            if (c1000p.mo1234e() >= 0) {
                return (((float) (c1000p.mo1223b(akVar) + 1)) / ((float) c1000p.mo1234e())) * 100.0f;
            }
            return c1000p.m7698B() != 0 ? (((float) c0986b.m7539g()) / ((float) c1000p.m7698B())) * 100.0f : 100.0f;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: l */
    protected void mo2240l() {
        if (ReaderEnv.get().forHd()) {
            getActivity().setRequestedOrientation(2);
        } else if (this.c.aj() && this.d.m12465a() == ReadingOrientation.LANDSCAPE) {
            ReaderUi.m10153a(getActivity(), 11);
        } else {
            getActivity().setRequestedOrientation(1);
        }
    }
}
