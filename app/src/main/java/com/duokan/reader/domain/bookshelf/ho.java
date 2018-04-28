package com.duokan.reader.domain.bookshelf;

import java.util.LinkedList;

class ho implements Runnable {
    /* renamed from: a */
    final /* synthetic */ LinkedList f3312a;
    /* renamed from: b */
    final /* synthetic */ Runnable f3313b;
    /* renamed from: c */
    final /* synthetic */ hc f3314c;

    ho(hc hcVar, LinkedList linkedList, Runnable runnable) {
        this.f3314c = hcVar;
        this.f3312a = linkedList;
        this.f3313b = runnable;
    }

    public void run() {
        this.f3314c.m3829a(this.f3312a, this.f3313b);
    }
}
