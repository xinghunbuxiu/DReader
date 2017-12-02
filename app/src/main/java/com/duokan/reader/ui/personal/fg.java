package com.duokan.reader.ui.personal;

import com.duokan.core.sys.t;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

class fg implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ List c;
    final /* synthetic */ Runnable d;
    final /* synthetic */ fd e;

    fg(fd fdVar, List list, List list2, List list3, Runnable runnable) {
        this.e = fdVar;
        this.a = list;
        this.b = list2;
        this.c = list3;
        this.d = runnable;
    }

    public void run() {
        Comparator fhVar = new fh(this, Collator.getInstance(Locale.CHINESE));
        Object arrayList = new ArrayList();
        arrayList.ensureCapacity(this.a.size());
        arrayList.addAll(this.a);
        Collections.sort(arrayList, fhVar);
        t.b(new fi(this, arrayList));
    }
}
