package com.duokan.reader.ui.general.web;

class jk implements Runnable {
    final /* synthetic */ jj a;

    jk(jj jjVar) {
        this.a = jjVar;
    }

    public void run() {
        this.a.a.release();
    }
}
