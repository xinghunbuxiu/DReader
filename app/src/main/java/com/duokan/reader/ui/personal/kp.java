package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.in;
import com.duokan.reader.domain.bookshelf.ip;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import java.util.Iterator;

class kp implements in, ip {
    private kp() {
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof C0800c) && (i & 72) != 0) {
            C0800c c0800c = (C0800c) anVar;
            Iterator it = PurchasedBookItemView.f8224b.iterator();
            while (it.hasNext()) {
                PurchasedBookItemView purchasedBookItemView = (PurchasedBookItemView) it.next();
                if ((purchasedBookItemView.f8227e instanceof DkCloudPurchasedBook) && ((DkCloudPurchasedBook) purchasedBookItemView.f8227e).getBookUuid().equals(c0800c.m4156I())) {
                    purchasedBookItemView.m11361a(true);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo1683a(C0800c c0800c) {
        Iterator it = PurchasedBookItemView.f8224b.iterator();
        while (it.hasNext()) {
            PurchasedBookItemView purchasedBookItemView = (PurchasedBookItemView) it.next();
            if ((purchasedBookItemView.f8227e instanceof DkCloudPurchasedBook) && ((DkCloudPurchasedBook) purchasedBookItemView.f8227e).getBookUuid().equals(c0800c.m4156I())) {
                purchasedBookItemView.m11361a(false);
                return;
            }
        }
    }
}
