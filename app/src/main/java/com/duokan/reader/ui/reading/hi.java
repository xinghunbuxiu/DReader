package com.duokan.reader.ui.reading;

import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.cm;

class hi implements cm {
    /* renamed from: a */
    final /* synthetic */ hg f10326a;

    hi(hg hgVar) {
        this.f10326a = hgVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (!z) {
            this.f10326a.m14317c();
        } else if (!this.f10326a.m14313a(flowChargingTransferChoice)) {
            be.m10286a(this.f10326a.getContext(), C0258j.bookshelf__general_shared__download_failed, 0).show();
            this.f10326a.m14317c();
        }
    }
}
