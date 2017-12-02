package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.gc;
import com.duokan.reader.ui.general.gi;

class rk implements gc {
    final /* synthetic */ qh a;

    rk(qh qhVar) {
        this.a = qhVar;
    }

    public void a(PagesView pagesView, gi giVar, gi giVar2) {
        if (giVar2 != null) {
            this.a.C = null;
            this.a.z = this.a.y;
            this.a.y = ((gn) giVar2).g();
            this.a.a((gn) giVar, (gn) giVar2);
            this.a.a(this.a.z, this.a.c.Z());
        }
    }
}
