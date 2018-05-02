package com.duokan.reader.ui.store;

import android.content.Context;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ah;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.bookshelf.be;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

/* renamed from: com.duokan.reader.ui.store.r */
class C1505r implements ah {
    /* renamed from: a */
    final /* synthetic */ al f11469a;
    /* renamed from: b */
    final /* synthetic */ FlowChargingTransferChoice f11470b;
    /* renamed from: c */
    final /* synthetic */ DkStoreBookDetail f11471c;
    /* renamed from: d */
    final /* synthetic */ C1502o f11472d;

    C1505r(C1502o c1502o, al alVar, FlowChargingTransferChoice flowChargingTransferChoice, DkStoreBookDetail dkStoreBookDetail) {
        this.f11472d = c1502o;
        this.f11469a = alVar;
        this.f11470b = flowChargingTransferChoice;
        this.f11471c = dkStoreBookDetail;
    }

    /* renamed from: a */
    public void mo1047a(String str, DkCloudBookManifest dkCloudBookManifest) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            this.f11469a.onDownloadCloudBookError("");
        } else if (this.f11470b == FlowChargingTransferChoice.Default) {
            be.m9188a(topActivity, this.f11471c.getEpubSize(), new C1506s(this, dkCloudBookManifest));
        } else {
            this.f11472d.m15412a(this.f11471c, dkCloudBookManifest, this.f11470b, new C1508u(this));
        }
    }

    /* renamed from: a */
    public void mo1048a(String str, String str2) {
        com.duokan.reader.ui.general.be.m10287a(this.f11472d.f11458c, (CharSequence) str2, 1).show();
        this.f11469a.onDownloadCloudBookError(str2);
    }
}
