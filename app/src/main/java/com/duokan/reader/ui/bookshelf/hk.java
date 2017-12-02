package com.duokan.reader.ui.bookshelf;

import android.view.View;

import com.duokan.core.ui.ay;
import com.duokan.core.ui.bf;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.c;

import java.util.ArrayList;
import java.util.List;

class hk implements bf {
    final /* synthetic */ hd a;
    final /* synthetic */ List b;
    final /* synthetic */ hh c;

    hk(hh hhVar, hd hdVar, List list) {
        this.c = hhVar;
        this.a = hdVar;
        this.b = list;
    }

    public void a(ay ayVar, View view, int i) {
        if (this.c.b.b.g()) {
            List arrayList = new ArrayList();
            arrayList.add((c) this.c.b.a);
            this.c.b.b.a(arrayList, (aa) this.b.get(i));
            this.c.b.dismiss();
            this.c.b.b.h();
        }
    }
}
