package com.duokan.reader.ui.store;

import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

/* renamed from: com.duokan.reader.ui.store.q */
class C1504q implements am {
    /* renamed from: a */
    final /* synthetic */ String f11464a;
    /* renamed from: b */
    final /* synthetic */ DkStoreBookDetail f11465b;
    /* renamed from: c */
    final /* synthetic */ al f11466c;
    /* renamed from: d */
    final /* synthetic */ FlowChargingTransferChoice f11467d;
    /* renamed from: e */
    final /* synthetic */ C1502o f11468e;

    C1504q(C1502o c1502o, String str, DkStoreBookDetail dkStoreBookDetail, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.f11468e = c1502o;
        this.f11464a = str;
        this.f11465b = dkStoreBookDetail;
        this.f11466c = alVar;
        this.f11467d = flowChargingTransferChoice;
    }

    /* renamed from: a */
    public void mo1842a() {
        this.f11468e.m15424c(this.f11464a, this.f11465b, this.f11466c, this.f11467d);
    }

    /* renamed from: b */
    public void mo1843b() {
        this.f11466c.onDownloadCloudBookCanceled();
    }
}
