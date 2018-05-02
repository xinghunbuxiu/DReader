package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.bookshelf.iv;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;

import java.util.Iterator;

class kb implements it, iv {
    private kb() {
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof c) && (i & 72) != 0) {
            c cVar = (c) anVar;
            Iterator it = PurchasedBookItemView.b.iterator();
            while (it.hasNext()) {
                PurchasedBookItemView purchasedBookItemView = (PurchasedBookItemView) it.next();
                if ((purchasedBookItemView.e instanceof DkCloudPurchasedBook) && ((DkCloudPurchasedBook) purchasedBookItemView.e).getBookUuid().equals(cVar.H())) {
                    purchasedBookItemView.a(true);
                    return;
                }
            }
        }
    }

    public void a(c cVar) {
        Iterator it = PurchasedBookItemView.b.iterator();
        while (it.hasNext()) {
            PurchasedBookItemView purchasedBookItemView = (PurchasedBookItemView) it.next();
            if ((purchasedBookItemView.e instanceof DkCloudPurchasedBook) && ((DkCloudPurchasedBook) purchasedBookItemView.e).getBookUuid().equals(cVar.H())) {
                purchasedBookItemView.a(false);
                return;
            }
        }
    }
}
