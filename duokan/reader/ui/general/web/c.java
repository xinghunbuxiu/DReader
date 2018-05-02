package com.duokan.reader.ui.general.web;

class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    c(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    public void run() {
        this.b.a.setPageTitle(this.a);
    }
}
