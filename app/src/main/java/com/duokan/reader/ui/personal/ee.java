package com.duokan.reader.ui.personal;

import com.duokan.reader.UmengManager;
import java.util.List;

class ee implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f8494a;
    /* renamed from: b */
    final /* synthetic */ ed f8495b;

    ee(ed edVar, List list) {
        this.f8495b = edVar;
        this.f8494a = list;
    }

    public void run() {
        for (int i = 0; i < this.f8494a.size(); i++) {
            UmengManager.get().onEvent("V3_SHELF_BOOK_ACTION", "DeleteCloud");
        }
        this.f8495b.f8492a.mo1902a(this.f8494a, null);
    }
}
