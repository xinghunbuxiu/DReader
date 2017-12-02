package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.mipay.sdk.Mipay;

class hk implements cm {
    final /* synthetic */ hj a;

    hk(hj hjVar) {
        this.a = hjVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            ai.a().a(this.a.a, flowChargingTransferChoice.wifiOnly()).j(this.a.b.a.e);
            this.a.b.a.f.b.b.web_notifyWeb(this.a.b.a.b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
            return;
        }
        this.a.b.a.f.b.b.web_notifyWeb(this.a.b.a.b, 4, new Object[0]);
    }
}
