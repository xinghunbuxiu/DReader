package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewGroup;
import com.duokan.reader.ui.general.cr;
import com.duokan.reader.ui.general.gb;
import com.duokan.reader.ui.general.gc;

class fo extends cr {
    /* renamed from: a */
    final /* synthetic */ fm f10164a;

    private fo(fm fmVar) {
        this.f10164a = fmVar;
    }

    /* renamed from: c */
    public /* synthetic */ gb mo2323c(int i) {
        return m14096e(i);
    }

    /* renamed from: a */
    public int mo2316a() {
        return this.f10164a.f10154c == null ? 0 : this.f10164a.f10154c.mo1236f();
    }

    /* renamed from: a */
    public int mo2317a(int i) {
        return this.f10164a.f10154c.mo1222b(i);
    }

    /* renamed from: b */
    public int mo2321b(int i) {
        return this.f10164a.f10154c.mo1226c(i);
    }

    /* renamed from: e */
    public fq m14096e(int i) {
        return this.f10164a.m14076b(this.f10164a.f10154c.mo1213a((long) i));
    }

    /* renamed from: a */
    public int mo2318a(gb gbVar) {
        return ((fq) gbVar).m14099a();
    }

    /* renamed from: a */
    public boolean mo2320a(gc gcVar) {
        return this.f10164a.f10154c.mo1241h(((gs) gcVar).mo2331g());
    }

    /* renamed from: b */
    public boolean mo2322b(gc gcVar) {
        return this.f10164a.f10154c.mo1243i(((gs) gcVar).mo2331g());
    }

    /* renamed from: a */
    protected gc mo2319a(gb gbVar, View view, ViewGroup viewGroup) {
        gx gxVar;
        fq fqVar = null;
        if (view == null) {
            gxVar = new gx(this.f10164a.getContext(), this.f10164a);
            this.f10164a.getDocument().m5906a(new fp(this, gxVar));
        } else {
            gxVar = (gx) view;
            if (gxVar.getPage() != null) {
                fqVar = (fq) gxVar.getPage().mo2327c();
            }
        }
        if (gxVar.getPageDrawable() != null && !gxVar.getPageDrawable().mo1283F() && gxVar.getPageDrawable().mo1340p() == this.f10164a.f10154c.mo1245k() && fqVar != null && fqVar.m14099a() == ((fq) gbVar).m14099a()) {
            return gxVar.getPage();
        }
        gc frVar = new fr(this.f10164a, (fq) gbVar, this.f10164a.m14069a((fq) gbVar), gxVar);
        gxVar.setPage(frVar);
        return frVar;
    }
}
