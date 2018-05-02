package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.micloud.i;

import java.lang.ref.WeakReference;
import java.util.Iterator;

class de implements Runnable {
    final /* synthetic */ i a;
    final /* synthetic */ dd b;

    de(dd ddVar, i iVar) {
        this.b = ddVar;
        this.a = iVar;
    }

    public void run() {
        Iterator it = cz.d.iterator();
        while (it.hasNext()) {
            cz czVar = (cz) ((WeakReference) it.next()).get();
            if (czVar != null && (czVar.getItem() instanceof c) && ((c) czVar.getItem()).e().equals(this.a.w())) {
                czVar.a(this.a);
                return;
            }
        }
    }
}
