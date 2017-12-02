package com.duokan.reader.ui.a;

import com.duokan.core.app.ab;
import com.duokan.core.app.ac;

class k implements ac {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void a(ab abVar) {
        int indexOf = this.a.c.f.indexOf(this.a.a);
        this.a.c.f.remove(indexOf);
        this.a.c.g.remove(indexOf);
        this.a.c.c.removeView(this.a.b);
    }

    public void b(ab abVar) {
    }
}
