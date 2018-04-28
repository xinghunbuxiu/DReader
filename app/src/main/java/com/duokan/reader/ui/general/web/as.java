package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.store.C1502o;
import com.duokan.reader.ui.store.ao;
import com.duokan.reader.ui.store.ap;
import java.util.Iterator;
import java.util.LinkedList;

class as implements ao {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7595a;

    as(StorePageController storePageController) {
        this.f7595a = storePageController;
    }

    /* renamed from: a */
    public void mo1833a(String str, ap apVar) {
        LinkedList linkedList = (LinkedList) this.f7595a.mListeners.get(str);
        if (linkedList != null) {
            linkedList.remove(apVar);
        }
    }

    /* renamed from: a */
    public void mo1832a(DkStoreFictionDetail dkStoreFictionDetail) {
        if (dkStoreFictionDetail != null) {
            String bookUuid = dkStoreFictionDetail.getFiction().getBookUuid();
            this.f7595a.mFictionCache = dkStoreFictionDetail;
            m11031a(bookUuid, dkStoreFictionDetail);
        } else if (this.f7595a.mFictionCache != null) {
            C1502o.m15413a(this.f7595a.mFictionCache);
        }
    }

    /* renamed from: b */
    public void mo1834b(String str, ap apVar) {
        LinkedList linkedList = (LinkedList) this.f7595a.mListeners.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.f7595a.mListeners.put(str, linkedList);
        }
        linkedList.add(apVar);
    }

    /* renamed from: a */
    private void m11031a(String str, DkStoreFictionDetail dkStoreFictionDetail) {
        LinkedList linkedList = (LinkedList) this.f7595a.mListeners.get(str);
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((ap) it.next()).mo2528a(dkStoreFictionDetail);
            }
        }
    }
}
