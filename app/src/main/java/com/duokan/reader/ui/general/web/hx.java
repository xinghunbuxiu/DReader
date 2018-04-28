package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.webservices.duokan.C0651y;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.mipay.sdk.Mipay;

class hx implements cm {
    /* renamed from: a */
    final /* synthetic */ hw f7957a;

    hx(hw hwVar) {
        this.f7957a = hwVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            C0800c a = ai.m3980a().m3872a(this.f7957a.f7954b.f7951a, (C0651y) this.f7957a.f7956d.f2058a, flowChargingTransferChoice.wifiOnly());
            if (a != null) {
                a.m4235j(this.f7957a.f7954b.f7952b.f7944a.f7942e);
                this.f7957a.f7954b.f7952b.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7957a.f7954b.f7952b.f7944a.f7939b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
                return;
            }
            this.f7957a.f7954b.f7952b.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7957a.f7954b.f7952b.f7944a.f7939b, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
            return;
        }
        this.f7957a.f7954b.f7952b.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7957a.f7954b.f7952b.f7944a.f7939b, 4, new Object[0]);
    }
}
