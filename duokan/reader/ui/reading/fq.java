package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewGroup;

import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.db;
import com.duokan.reader.ui.general.gh;
import com.duokan.reader.ui.general.gi;

public class fq extends db {
    final /* synthetic */ fo a;

    protected fq(fo foVar) {
        this.a = foVar;
    }

    public boolean a(gi giVar) {
        return this.a.b.h(((gn) giVar).g());
    }

    public boolean b(gi giVar) {
        return this.a.b.i(((gn) giVar).g());
    }

    protected gi a(gh ghVar, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = a();
            view.setStatusColor(this.a.k);
            this.a.getDocument().a(new fr(this, view));
        } else {
            gs gsVar = (gs) view;
        }
        gi ftVar = new ft(this.a, (fs) ghVar, a((fs) ghVar), view);
        view.setPage(ftVar);
        viewGroup.setClipChildren(false);
        return ftVar;
    }

    protected gs a() {
        return new gs(this.a.getContext(), this.a);
    }

    protected as a(fs fsVar) {
        return this.a.b.a(fsVar.a());
    }
}
