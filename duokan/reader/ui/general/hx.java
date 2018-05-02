package com.duokan.reader.ui.general;

import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.store.o;

class hx implements cm {
    final /* synthetic */ DkStoreBookDetail a;
    final /* synthetic */ hw b;

    hx(hw hwVar, DkStoreBookDetail dkStoreBookDetail) {
        this.b = hwVar;
        this.a = dkStoreBookDetail;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            o.a().a(this.b.c.getBookUuid(), this.a, new hy(this), flowChargingTransferChoice);
        }
    }
}
