package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.im;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

class ea implements cm {
    /* renamed from: a */
    final /* synthetic */ CustomCloudItem f8481a;
    /* renamed from: b */
    final /* synthetic */ is f8482b;
    /* renamed from: c */
    final /* synthetic */ im f8483c;
    /* renamed from: d */
    final /* synthetic */ dm f8484d;

    ea(dm dmVar, CustomCloudItem customCloudItem, is isVar, im imVar) {
        this.f8484d = dmVar;
        this.f8481a = customCloudItem;
        this.f8482b = isVar;
        this.f8483c = imVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            C0800c b = this.f8481a.m11340b();
            if (b == null) {
                b = ai.m3980a().m3868a(this.f8482b, flowChargingTransferChoice.wifiOnly());
                if (b != null) {
                    this.f8483c.mo1021a(b);
                    return;
                } else {
                    this.f8483c.mo1022a("");
                    return;
                }
            } else if (b.m4233i() == BookState.CLOUD_ONLY) {
                ai.m3980a().m3867a(b, this.f8482b, flowChargingTransferChoice.wifiOnly());
                this.f8483c.mo1021a(b);
                return;
            } else {
                this.f8483c.mo1022a("");
                return;
            }
        }
        this.f8483c.mo1022a("");
    }
}
