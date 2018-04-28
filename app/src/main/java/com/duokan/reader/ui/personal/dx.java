package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.micloud.C1068i;
import java.util.ArrayList;
import java.util.List;

class dx implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1068i f8474a;
    /* renamed from: b */
    final /* synthetic */ dr f8475b;

    dx(dr drVar, C1068i c1068i) {
        this.f8475b = drVar;
        this.f8474a = c1068i;
    }

    public void run() {
        if (this.f8475b.f8465a.f8457b != null) {
            List arrayList = new ArrayList();
            arrayList.add(this.f8474a);
            this.f8475b.f8465a.f8457b.setfilterCreateFileTaskItems(arrayList);
        }
    }
}
