package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewGroup;

import com.duokan.reader.ui.general.cr;
import com.duokan.reader.ui.general.gh;
import com.duokan.reader.ui.general.gi;

class fk extends cr {
    final /* synthetic */ fi a;

    private fk(fi fiVar) {
        this.a = fiVar;
    }

    public /* synthetic */ gh c(int i) {
        return e(i);
    }

    public int a() {
        return this.a.c == null ? 0 : this.a.c.f();
    }

    public int a(int i) {
        return this.a.c.b(i);
    }

    public int b(int i) {
        return this.a.c.c(i);
    }

    public fm e(int i) {
        return this.a.b(this.a.c.a((long) i));
    }

    public int a(gh ghVar) {
        return ((fm) ghVar).a();
    }

    public boolean a(gi giVar) {
        return this.a.c.h(((gn) giVar).g());
    }

    public boolean b(gi giVar) {
        return this.a.c.i(((gn) giVar).g());
    }

    protected gi a(gh ghVar, View view, ViewGroup viewGroup) {
        fm fmVar = null;
        if (view == null) {
            view = new gs(this.a.getContext(), this.a);
            this.a.getDocument().a(new fl(this, view));
        } else {
            gs gsVar = (gs) view;
            if (gsVar.getPage() != null) {
                fmVar = (fm) gsVar.getPage().c();
            }
        }
        if (view.getPageDrawable() != null && !view.getPageDrawable().F() && view.getPageDrawable().p() == this.a.c.k() && r0 != null && r0.a() == ((fm) ghVar).a()) {
            return view.getPage();
        }
        gi fnVar = new fn(this.a, (fm) ghVar, this.a.a((fm) ghVar), view);
        view.setPage(fnVar);
        return fnVar;
    }
}
