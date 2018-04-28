package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.micloud.C1068i;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class dl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1068i f6339a;
    /* renamed from: b */
    final /* synthetic */ dk f6340b;

    dl(dk dkVar, C1068i c1068i) {
        this.f6340b = dkVar;
        this.f6339a = c1068i;
    }

    public void run() {
        Iterator it = de.f6048d.iterator();
        while (it.hasNext()) {
            de deVar = (de) ((WeakReference) it.next()).get();
            if (deVar != null && (deVar.getItem() instanceof C0800c) && ((C0800c) deVar.getItem()).m4222e().equals(this.f6339a.m8228w())) {
                deVar.m9099a(this.f6339a);
                return;
            }
        }
    }
}
