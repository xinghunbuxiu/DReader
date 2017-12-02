package com.duokan.reader.ui.reading;

import com.duokan.c.j;
import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.gd;
import com.duokan.reader.ui.general.gi;

class rj implements gd {
    final /* synthetic */ qh a;

    rj(qh qhVar) {
        this.a = qhVar;
    }

    public void a(PagesView pagesView) {
        this.a.A().prompt(this.a.getString(j.reading__shared__reach_first_page));
    }

    public void b(PagesView pagesView) {
        this.a.A().prompt(this.a.getString(j.reading__shared__reach_last_page));
    }

    public void a(PagesView pagesView, gi giVar) {
        this.a.a((gn) giVar);
    }

    public void b(PagesView pagesView, gi giVar) {
        this.a.b((gn) giVar);
    }
}
