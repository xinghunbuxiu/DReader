package com.duokan.reader.ui.personal;

import com.duokan.core.sys.t;

import java.util.LinkedList;

class lg implements Runnable {
    final /* synthetic */ LinkedList a;
    final /* synthetic */ LinkedList b;
    final /* synthetic */ LinkedList c;
    final /* synthetic */ kc d;
    final /* synthetic */ ko e;

    lg(ko koVar, LinkedList linkedList, LinkedList linkedList2, LinkedList linkedList3, kc kcVar) {
        this.e = koVar;
        this.a = linkedList;
        this.b = linkedList2;
        this.c = linkedList3;
        this.d = kcVar;
    }

    public void run() {
        this.e.a(this.a, this.b, this.c);
        t.b(new lh(this));
    }
}
