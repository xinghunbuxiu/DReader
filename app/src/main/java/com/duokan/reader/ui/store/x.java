package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.ao;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

class x implements h {
    final /* synthetic */ c a;
    final /* synthetic */ FlowChargingTransferChoice b;
    final /* synthetic */ ao c;
    final /* synthetic */ o d;

    x(o oVar, c cVar, FlowChargingTransferChoice flowChargingTransferChoice, ao aoVar) {
        this.d = oVar;
        this.a = cVar;
        this.b = flowChargingTransferChoice;
        this.c = aoVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        o.a(((DkStoreBookDetail) dkStoreItem).getMinKernelVersion(), new y(this));
    }

    public void onFetchBookDetailError(String str) {
        this.d.g.remove(this.a.H());
        this.c.a("", str);
    }
}
