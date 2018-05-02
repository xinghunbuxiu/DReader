package com.duokan.reader.domain.bookshelf;

import java.util.LinkedList;

class hu implements Runnable {
    final /* synthetic */ LinkedList a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ hi c;

    hu(hi hiVar, LinkedList linkedList, Runnable runnable) {
        this.c = hiVar;
        this.a = linkedList;
        this.b = runnable;
    }

    public void run() {
        this.c.a(this.a, this.b);
    }
}
