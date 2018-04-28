package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

class fu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f8565a;
    /* renamed from: b */
    final /* synthetic */ List f8566b;
    /* renamed from: c */
    final /* synthetic */ List f8567c;
    /* renamed from: d */
    final /* synthetic */ Runnable f8568d;
    /* renamed from: e */
    final /* synthetic */ fr f8569e;

    fu(fr frVar, List list, List list2, List list3, Runnable runnable) {
        this.f8569e = frVar;
        this.f8565a = list;
        this.f8566b = list2;
        this.f8567c = list3;
        this.f8568d = runnable;
    }

    public void run() {
        Comparator fvVar = new fv(this, Collator.getInstance(Locale.CHINESE));
        Object arrayList = new ArrayList();
        arrayList.ensureCapacity(this.f8565a.size());
        arrayList.addAll(this.f8565a);
        Collections.sort(arrayList, fvVar);
        UThread.post(new fw(this, arrayList));
    }
}
