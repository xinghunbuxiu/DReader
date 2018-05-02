package com.duokan.core.sys;

final class ai implements Runnable {
    /* renamed from: a */
    final /* synthetic */ al f640a;
    /* renamed from: b */
    final /* synthetic */ String f641b;

    ai(al alVar, String str) {
        this.f640a = alVar;
        this.f641b = str;
    }

    public void run() {
        ah.f639c.add(this.f640a);
        ah.m872b(this.f641b);
    }
}
