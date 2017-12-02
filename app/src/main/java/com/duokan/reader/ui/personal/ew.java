package com.duokan.reader.ui.personal;

import com.duokan.common.a;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.bookshelf.jk;
import com.duokan.reader.domain.micloud.bj;
import com.duokan.reader.domain.micloud.i;

import java.util.ArrayList;
import java.util.List;

class ew implements jk {
    final /* synthetic */ eq a;

    ew(eq eqVar) {
        this.a = eqVar;
    }

    public void a() {
        bj b = iz.a().b().b();
        ArrayList arrayList = new ArrayList(iz.a().c());
        List<i> f = iz.a().f();
        ArrayList arrayList2 = new ArrayList(arrayList.size() + f.size());
        for (i customCloudItem : f) {
            arrayList2.add(new CustomCloudItem(customCloudItem));
        }
        a.a(new ex(this, arrayList, arrayList2, b), new Void[0]);
    }

    public void b() {
        this.a.setData(new ArrayList());
        c();
    }

    private void c() {
        this.a.p = false;
        if (this.a.q) {
            this.a.q = false;
            this.a.g();
        }
    }
}
