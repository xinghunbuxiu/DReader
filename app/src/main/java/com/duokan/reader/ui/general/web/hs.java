package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.mipay.sdk.Mipay;

class hs implements cm {
    /* renamed from: a */
    final /* synthetic */ hr f7948a;

    hs(hr hrVar) {
        this.f7948a = hrVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            ai.m3980a().m3871a(this.f7948a.f7946a, flowChargingTransferChoice.wifiOnly()).m4235j(this.f7948a.f7947b.f7944a.f7942e);
            this.f7948a.f7947b.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7948a.f7947b.f7944a.f7939b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
            return;
        }
        this.f7948a.f7947b.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7948a.f7947b.f7944a.f7939b, 4, new Object[0]);
    }
}
