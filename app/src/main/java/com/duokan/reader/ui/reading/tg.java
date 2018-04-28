package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.duokan.reader.domain.document.ah;

class tg implements mg {
    /* renamed from: a */
    final /* synthetic */ ah f10970a;
    /* renamed from: b */
    final /* synthetic */ gx f10971b;
    /* renamed from: c */
    final /* synthetic */ Pair f10972c;
    /* renamed from: d */
    final /* synthetic */ Drawable f10973d;
    /* renamed from: e */
    final /* synthetic */ tf f10974e;

    tg(tf tfVar, ah ahVar, gx gxVar, Pair pair, Drawable drawable) {
        this.f10974e = tfVar;
        this.f10970a = ahVar;
        this.f10971b = gxVar;
        this.f10972c = pair;
        this.f10973d = drawable;
    }

    /* renamed from: a */
    public void mo2503a() {
        if (this.f10970a.mo1414e()) {
            this.f10971b.m14290a(((Integer) this.f10972c.second).intValue(), this.f10973d);
        }
        this.f10971b.setActiveMedia(-1);
        this.f10974e.f10968a.f9656a.mo2180v().setScreenTimeout(this.f10974e.f10968a.f9656a.ae().m12519m());
    }

    /* renamed from: b */
    public void mo2504b() {
        this.f10971b.setActiveMedia(-1);
    }

    /* renamed from: c */
    public void mo2505c() {
        this.f10971b.setActiveMedia(((Integer) this.f10972c.second).intValue());
        this.f10974e.f10968a.f9656a.mo2180v().setScreenTimeout(Integer.MAX_VALUE);
    }
}
