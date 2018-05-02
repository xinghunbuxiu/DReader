package com.duokan.reader.ui.general.web;

import java.util.concurrent.Callable;

class fo implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    fo(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        String str = (String) ke.sParcelMap.get(this.a);
        ke.sParcelMap.remove(this.a);
        return str;
    }
}
