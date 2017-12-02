package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.micloud.i;

import java.util.ArrayList;
import java.util.List;

class ee implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ dy b;

    ee(dy dyVar, i iVar) {
        this.b = dyVar;
        this.a = iVar;
    }

    public void run() {
        if (this.b.a.b != null) {
            List arrayList = new ArrayList();
            arrayList.add(this.a);
            this.b.a.b.setfilterCreateFileTaskItems(arrayList);
        }
    }
}
