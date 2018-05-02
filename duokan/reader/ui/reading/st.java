package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.util.Pair;

import com.duokan.reader.domain.document.ah;

class st implements lw {
    final /* synthetic */ ah a;
    final /* synthetic */ gs b;
    final /* synthetic */ Pair c;
    final /* synthetic */ Drawable d;
    final /* synthetic */ ss e;

    st(ss ssVar, ah ahVar, gs gsVar, Pair pair, Drawable drawable) {
        this.e = ssVar;
        this.a = ahVar;
        this.b = gsVar;
        this.c = pair;
        this.d = drawable;
    }

    public void a() {
        if (this.a.e()) {
            this.b.a(((Integer) this.c.second).intValue(), this.d);
        }
        this.b.setActiveMedia(-1);
        this.e.a.a.v().setScreenTimeout(this.e.a.a.ae().m());
    }

    public void b() {
        this.b.setActiveMedia(-1);
    }

    public void c() {
        this.b.setActiveMedia(((Integer) this.c.second).intValue());
        this.e.a.a.v().setScreenTimeout(Integer.MAX_VALUE);
    }
}
