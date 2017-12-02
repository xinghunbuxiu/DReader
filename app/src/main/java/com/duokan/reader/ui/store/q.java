package com.duokan.reader.ui.store;

import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

class q implements am {
    final /* synthetic */ String a;
    final /* synthetic */ DkStoreBookDetail b;
    final /* synthetic */ al c;
    final /* synthetic */ FlowChargingTransferChoice d;
    final /* synthetic */ o e;

    q(o oVar, String str, DkStoreBookDetail dkStoreBookDetail, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.e = oVar;
        this.a = str;
        this.b = dkStoreBookDetail;
        this.c = alVar;
        this.d = flowChargingTransferChoice;
    }

    public void a() {
        this.e.c(this.a, this.b, this.c, this.d);
    }

    public void b() {
        this.c.onDownloadCloudBookCanceled();
    }
}
