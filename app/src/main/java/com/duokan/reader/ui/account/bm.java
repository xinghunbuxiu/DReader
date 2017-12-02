package com.duokan.reader.ui.account;

class bm implements Runnable {
    final /* synthetic */ cd a;
    final /* synthetic */ bi b;

    bm(bi biVar, cd cdVar) {
        this.b = biVar;
        this.a = cdVar;
    }

    public void run() {
        this.b.c.dismiss();
        this.a.a();
    }
}
