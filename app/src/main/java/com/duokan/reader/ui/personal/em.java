package com.duokan.reader.ui.personal;

import java.util.List;

class em implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ ek b;

    em(ek ekVar, List list) {
        this.b = ekVar;
        this.a = list;
    }

    public void run() {
        this.b.a.a(this.a, null);
    }
}
