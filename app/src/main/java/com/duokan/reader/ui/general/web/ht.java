package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.store.C1502o;

class ht implements cm {
    /* renamed from: a */
    final /* synthetic */ hp f7949a;

    ht(hp hpVar) {
        this.f7949a = hpVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            C1502o.m15410a().m15429a(ai.m3980a().m3906b(this.f7949a.f7944a.f7941d), new hu(this), flowChargingTransferChoice);
            return;
        }
        this.f7949a.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7949a.f7944a.f7939b, 4, new Object[0]);
    }
}
