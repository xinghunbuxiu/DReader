package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.duokan.g;
import com.duokan.reader.domain.a.f;
import com.duokan.reader.ui.general.be;

class ed implements f {
    final /* synthetic */ eh a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ ec d;

    ed(ec ecVar, eh ehVar, int i, String str) {
        this.d = ecVar;
        this.a = ehVar;
        this.b = i;
        this.c = str;
    }

    public void a(g gVar) {
        if (this.d.a.j()) {
            this.d.a.h();
        } else if (!de.b.b(this.a)) {
        } else {
            if (this.a.e == this.b && this.a.d.l.equals(this.c)) {
                this.d.a.o.setVisibility(0);
                this.d.a.n.setVisibility(8);
                return;
            }
            this.a.e = this.b;
            this.a.d.j.copy(gVar.j);
            this.a.d.l = this.c;
            if (this.a.d.a() == 0) {
                this.a.d.a(System.currentTimeMillis() / 1000);
            }
            if (this.b > 3) {
                ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
            }
            this.d.a.c(this.a);
        }
    }

    public void a(String str) {
        if (this.d.a.j()) {
            this.d.a.h();
        } else if (de.b.b(this.a)) {
            be.a(this.d.a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
