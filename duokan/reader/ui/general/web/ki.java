package com.duokan.reader.ui.general.web;

class ki implements Runnable {
    final /* synthetic */ kg a;

    ki(kg kgVar) {
        this.a = kgVar;
    }

    public void run() {
        this.a.c.cancel();
    }
}
