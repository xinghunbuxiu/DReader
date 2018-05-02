package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.store.ao;
import com.duokan.reader.ui.store.ap;
import com.duokan.reader.ui.store.o;

import java.util.Iterator;
import java.util.LinkedList;

class aq implements ao {
    final /* synthetic */ StorePageController a;

    aq(StorePageController storePageController) {
        this.a = storePageController;
    }

    public void a(String str, ap apVar) {
        LinkedList linkedList = (LinkedList) this.a.mListeners.get(str);
        if (linkedList != null) {
            linkedList.remove(apVar);
        }
    }

    public void a(DkStoreFictionDetail dkStoreFictionDetail) {
        if (dkStoreFictionDetail != null) {
            String bookUuid = dkStoreFictionDetail.getFiction().getBookUuid();
            this.a.mFictionCache = dkStoreFictionDetail;
            a(bookUuid, dkStoreFictionDetail);
        } else if (this.a.mFictionCache != null) {
            o.a(this.a.mFictionCache);
        }
    }

    public void b(String str, ap apVar) {
        LinkedList linkedList = (LinkedList) this.a.mListeners.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.a.mListeners.put(str, linkedList);
        }
        linkedList.add(apVar);
    }

    private void a(String str, DkStoreFictionDetail dkStoreFictionDetail) {
        LinkedList linkedList = (LinkedList) this.a.mListeners.get(str);
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((ap) it.next()).a(dkStoreFictionDetail);
            }
        }
    }
}
