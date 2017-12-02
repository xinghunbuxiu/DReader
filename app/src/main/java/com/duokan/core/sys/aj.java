package com.duokan.core.sys;

final class aj implements Runnable {
    final /* synthetic */ an a;
    final /* synthetic */ String b;

    aj(an anVar, String str) {
        this.a = anVar;
        this.b = str;
    }

    public void run() {
        ah.c.add(this.a);
        ah.b(this.b);
    }
}
