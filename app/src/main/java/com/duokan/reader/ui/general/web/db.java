package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import java.util.Iterator;

class db implements as {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ PageController c;

    db(PageController cgVar, String str, String str2) {
        this.c = cgVar;
        this.a = str;
        this.b = str2;
    }

    public void a() {
        Iterator it = StoreWebController.sAttachedInstQueue.iterator();
        while (it.hasNext()) {
            StoreWebController storeWebController = (StoreWebController) it.next();
            if (storeWebController instanceof StorePageController) {
                ((StorePageController) storeWebController).broadcastEvent(this.a, this.b);
            }
        }
    }
}
