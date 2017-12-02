package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.store.o;

class jv implements cm {
    final /* synthetic */ DkStoreItem a;
    final /* synthetic */ ju b;

    jv(ju juVar, DkStoreItem dkStoreItem) {
        this.b = juVar;
        this.a = dkStoreItem;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) this.b.a;
            o.a().a(dkCloudPurchasedBook.getBookUuid(), (DkStoreBookDetail) this.a, new jw(this, dkCloudPurchasedBook), flowChargingTransferChoice);
            return;
        }
        o.a().c(this.b.a.getBookUuid());
        if (this.b.b.e == this.b.a) {
            this.b.b.d.setEnabled(true);
            this.b.b.b();
        }
    }
}
