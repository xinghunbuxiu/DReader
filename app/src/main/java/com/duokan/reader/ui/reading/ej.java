package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.C0623g;
import com.duokan.reader.domain.p041a.C0669e;
import com.duokan.reader.ui.general.be;

class ej implements C0669e {
    /* renamed from: a */
    final /* synthetic */ el f10074a;
    /* renamed from: b */
    final /* synthetic */ int f10075b;
    /* renamed from: c */
    final /* synthetic */ String f10076c;
    /* renamed from: d */
    final /* synthetic */ ei f10077d;

    ej(ei eiVar, el elVar, int i, String str) {
        this.f10077d = eiVar;
        this.f10074a = elVar;
        this.f10075b = i;
        this.f10076c = str;
    }

    /* renamed from: a */
    public void mo2309a(C0623g c0623g) {
        if (this.f10077d.f10073a.m13979j()) {
            this.f10077d.f10073a.m13974h();
        } else if (!dg.f9991b.m862b(this.f10074a)) {
        } else {
            if (this.f10074a.f10083e == this.f10075b && this.f10074a.f10082d.f2067l.equals(this.f10076c)) {
                this.f10077d.f10073a.f10015p.setVisibility(0);
                this.f10077d.f10073a.f10014o.setVisibility(8);
                return;
            }
            this.f10074a.f10083e = this.f10075b;
            this.f10074a.f10082d.f2065j.copy(c0623g.f2065j);
            this.f10074a.f10082d.f2067l = this.f10076c;
            if (this.f10074a.f10082d.m2817a() == 0) {
                this.f10074a.f10082d.m2818a(System.currentTimeMillis() / 1000);
            }
            if (this.f10075b > 3) {
                ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
            }
            this.f10077d.f10073a.m13964c(this.f10074a);
        }
    }

    /* renamed from: a */
    public void mo2310a(String str) {
        if (this.f10077d.f10073a.m13979j()) {
            this.f10077d.f10073a.m13974h();
        } else if (dg.f9991b.m862b(this.f10074a)) {
            be.m10287a(this.f10077d.f10073a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
