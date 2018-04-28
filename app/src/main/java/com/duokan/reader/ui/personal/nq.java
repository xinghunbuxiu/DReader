package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class nq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f9010a;
    /* renamed from: b */
    final /* synthetic */ List f9011b;
    /* renamed from: c */
    final /* synthetic */ List f9012c;
    /* renamed from: d */
    final /* synthetic */ Runnable f9013d;
    /* renamed from: e */
    final /* synthetic */ nn f9014e;

    nq(nn nnVar, List list, List list2, List list3, Runnable runnable) {
        this.f9014e = nnVar;
        this.f9010a = list;
        this.f9011b = list2;
        this.f9012c = list3;
        this.f9013d = runnable;
    }

    public void run() {
        Comparator nrVar = new nr(this);
        Object arrayList = new ArrayList();
        arrayList.ensureCapacity(this.f9010a.size());
        arrayList.addAll(this.f9010a);
        Collections.sort(arrayList, nrVar);
        UThread.post(new ns(this, arrayList));
    }
}
