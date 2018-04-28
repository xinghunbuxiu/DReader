package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import java.util.LinkedList;

class lu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ LinkedList f8907a;
    /* renamed from: b */
    final /* synthetic */ LinkedList f8908b;
    /* renamed from: c */
    final /* synthetic */ LinkedList f8909c;
    /* renamed from: d */
    final /* synthetic */ kq f8910d;
    /* renamed from: e */
    final /* synthetic */ lc f8911e;

    lu(lc lcVar, LinkedList linkedList, LinkedList linkedList2, LinkedList linkedList3, kq kqVar) {
        this.f8911e = lcVar;
        this.f8907a = linkedList;
        this.f8908b = linkedList2;
        this.f8909c = linkedList3;
        this.f8910d = kqVar;
    }

    public void run() {
        this.f8911e.m12144a(this.f8907a, this.f8908b, this.f8909c);
        UThread.post(new lv(this));
    }
}
