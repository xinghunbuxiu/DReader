package com.duokan.reader.ui.personal;

import com.duokan.core.sys.TaskHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class nc implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ Runnable d;
    final /* synthetic */ mz e;

    nc(mz mzVar, List list, List list2, List list3, Runnable runnable) {
        this.e = mzVar;
        this.a = list;
        this.b = list2;
        this.c = list3;
        this.d = runnable;
    }

    public void run() {
        Comparator ndVar = new nd(this);
        Object arrayList = new ArrayList();
        arrayList.ensureCapacity(this.a.size());
        arrayList.addAll(this.a);
        Collections.sort(arrayList, ndVar);
        TaskHandler.PostTask(new ne(this, arrayList));
    }
}
