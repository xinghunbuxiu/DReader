package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.webservices.duokan.z;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.mipay.sdk.Mipay;

class hp implements cm {
    final /* synthetic */ ho a;

    hp(ho hoVar) {
        this.a = hoVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            c a = ai.a().a(this.a.b.a, (z) this.a.d.a, flowChargingTransferChoice.wifiOnly());
            if (a != null) {
                a.j(this.a.b.b.a.e);
                this.a.b.b.a.f.b.b.web_notifyWeb(this.a.b.b.a.b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
                return;
            }
            this.a.b.b.a.f.b.b.web_notifyWeb(this.a.b.b.a.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
            return;
        }
        this.a.b.b.a.f.b.b.web_notifyWeb(this.a.b.b.a.b, 4, new Object[0]);
    }
}
