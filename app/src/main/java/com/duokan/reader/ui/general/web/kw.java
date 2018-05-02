package com.duokan.reader.ui.general.web;

import java.util.Iterator;
import java.util.concurrent.Callable;

class kw implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ kv f8119a;

    kw(kv kvVar) {
        this.f8119a = kvVar;
    }

    public /* synthetic */ Object call() {
        return m11275a();
    }

    /* renamed from: a */
    public Void m11275a() {
        if (StoreWebController.sMirrorEnabled) {
            Iterator it = StoreWebController.sAttachedInstQueue.iterator();
            while (it.hasNext()) {
                ((StoreWebController) it.next()).onStoreMirrorUpdated();
            }
        }
        return null;
    }
}
