package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.cloud.ah;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

/* renamed from: com.duokan.reader.ui.store.x */
class C1511x implements C0466h {
    /* renamed from: a */
    final /* synthetic */ C0800c f11485a;
    /* renamed from: b */
    final /* synthetic */ FlowChargingTransferChoice f11486b;
    /* renamed from: c */
    final /* synthetic */ ah f11487c;
    /* renamed from: d */
    final /* synthetic */ C1502o f11488d;

    C1511x(C1502o c1502o, C0800c c0800c, FlowChargingTransferChoice flowChargingTransferChoice, ah ahVar) {
        this.f11488d = c1502o;
        this.f11485a = c0800c;
        this.f11486b = flowChargingTransferChoice;
        this.f11487c = ahVar;
    }

    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
        C1502o.m15417a(((DkStoreBookDetail) dkStoreItem).getMinKernelVersion(), new C1512y(this));
    }

    public void onFetchBookDetailError(String str) {
        this.f11488d.f11462g.remove(this.f11485a.m4156I());
        this.f11487c.mo1048a("", str);
    }
}
