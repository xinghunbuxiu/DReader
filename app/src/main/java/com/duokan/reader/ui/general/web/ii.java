package com.duokan.reader.ui.general.web;

class ii implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ig b;

    ii(ig igVar, String str) {
        this.b = igVar;
        this.a = str;
    }

    public void run() {
        this.b.b.pageController.web_notifyWeb(this.a, 2, new Object[0]);
    }
}
