package com.duokan.reader.ui.store;

import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.jq;

class aa implements h {
    final /* synthetic */ jq a;
    final /* synthetic */ String b;
    final /* synthetic */ al c;
    final /* synthetic */ FlowChargingTransferChoice d;
    final /* synthetic */ o e;

    aa(o oVar, jq jqVar, String str, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.e = oVar;
        this.a = jqVar;
        this.b = str;
        this.c = alVar;
        this.d = flowChargingTransferChoice;
    }

    public void onFetchBookDetailError(String str) {
        o.d(str);
        this.a.dismiss();
        this.e.g.remove(this.b);
        this.c.onDownloadCloudBookError(str);
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        this.e.b(this.b, (DkStoreBookDetail) dkStoreItem, new ab(this), this.d);
    }
}
