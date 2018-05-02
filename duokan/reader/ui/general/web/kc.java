package com.duokan.reader.ui.general.web;

import java.util.Iterator;
import java.util.concurrent.Callable;

class kc implements Callable {
    final /* synthetic */ kb a;

    kc(kb kbVar) {
        this.a = kbVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Void a() {
        if (StoreWebController.sMirrorEnabled) {
            Iterator it = StoreWebController.sAttachedInstQueue.iterator();
            while (it.hasNext()) {
                ((StoreWebController) it.next()).onStoreMirrorUpdated();
            }
        }
        return null;
    }
}
