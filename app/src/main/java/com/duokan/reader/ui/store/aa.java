package com.duokan.reader.ui.store;

import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ja;

class aa implements C0466h {
    /* renamed from: a */
    final /* synthetic */ ja f11298a;
    /* renamed from: b */
    final /* synthetic */ String f11299b;
    /* renamed from: c */
    final /* synthetic */ al f11300c;
    /* renamed from: d */
    final /* synthetic */ FlowChargingTransferChoice f11301d;
    /* renamed from: e */
    final /* synthetic */ C1502o f11302e;

    aa(C1502o c1502o, ja jaVar, String str, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.f11302e = c1502o;
        this.f11298a = jaVar;
        this.f11299b = str;
        this.f11300c = alVar;
        this.f11301d = flowChargingTransferChoice;
    }

    public void onFetchBookDetailError(String str) {
        C1502o.m15426d(str);
        this.f11298a.dismiss();
        this.f11302e.f11462g.remove(this.f11299b);
        this.f11300c.onDownloadCloudBookError(str);
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        this.f11302e.m15421b(this.f11299b, (DkStoreBookDetail) dkStoreItem, new ab(this), this.f11301d);
    }
}
