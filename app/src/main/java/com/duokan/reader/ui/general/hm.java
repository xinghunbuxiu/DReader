package com.duokan.reader.ui.general;

import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.store.C1502o;

class hm implements cm {
    /* renamed from: a */
    final /* synthetic */ DkStoreBookDetail f7344a;
    /* renamed from: b */
    final /* synthetic */ hl f7345b;

    hm(hl hlVar, DkStoreBookDetail dkStoreBookDetail) {
        this.f7345b = hlVar;
        this.f7344a = dkStoreBookDetail;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            C1502o.m15410a().m15431a(this.f7345b.f7342c.getBookUuid(), this.f7344a, new hn(this), flowChargingTransferChoice);
        }
    }
}
