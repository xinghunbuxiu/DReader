package com.duokan.core.sys;

final class aj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ an f642a;
    /* renamed from: b */
    final /* synthetic */ String f643b;

    aj(an anVar, String str) {
        this.f642a = anVar;
        this.f643b = str;
    }

    public void run() {
        ah.f639c.add(this.f642a);
        ah.m872b(this.f643b);
    }
}
