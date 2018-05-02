package com.duokan.reader.ui.personal;

import com.duokan.reader.UmengManager;

import java.util.List;

class el implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ ek b;

    el(ek ekVar, List list) {
        this.b = ekVar;
        this.a = list;
    }

    public void run() {
        for (int i = 0; i < this.a.size(); i++) {
            UmengManager.get().onEvent("V3_SHELF_BOOK_ACTION", "DeleteCloud");
        }
        this.b.a.a(this.a, null);
    }
}
