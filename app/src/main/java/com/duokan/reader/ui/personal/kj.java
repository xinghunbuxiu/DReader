package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.store.C1502o;

class kj implements cm {
    /* renamed from: a */
    final /* synthetic */ DkStoreItem f8812a;
    /* renamed from: b */
    final /* synthetic */ ki f8813b;

    kj(ki kiVar, DkStoreItem dkStoreItem) {
        this.f8813b = kiVar;
        this.f8812a = dkStoreItem;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) this.f8813b.f8810a;
            C1502o.m15410a().m15431a(dkCloudPurchasedBook.getBookUuid(), (DkStoreBookDetail) this.f8812a, new kk(this, dkCloudPurchasedBook), flowChargingTransferChoice);
            return;
        }
        C1502o.m15410a().m15436c(this.f8813b.f8810a.getBookUuid());
        if (this.f8813b.f8811b.f8227e == this.f8813b.f8810a) {
            this.f8813b.f8811b.f8226d.setEnabled(true);
            this.f8813b.f8811b.m11363b();
        }
    }
}
