package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import java.util.Iterator;

class dh implements as {
    /* renamed from: a */
    final /* synthetic */ String f7726a;
    /* renamed from: b */
    final /* synthetic */ String f7727b;
    /* renamed from: c */
    final /* synthetic */ ci f7728c;

    dh(ci ciVar, String str, String str2) {
        this.f7728c = ciVar;
        this.f7726a = str;
        this.f7727b = str2;
    }

    /* renamed from: a */
    public void mo1831a() {
        Iterator it = StoreWebController.sAttachedInstQueue.iterator();
        while (it.hasNext()) {
            StoreWebController storeWebController = (StoreWebController) it.next();
            if (storeWebController instanceof StorePageController) {
                ((StorePageController) storeWebController).broadcastEvent(this.f7726a, this.f7727b);
            }
        }
    }
}
