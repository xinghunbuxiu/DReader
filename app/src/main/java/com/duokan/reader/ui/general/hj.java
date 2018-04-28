package com.duokan.reader.ui.general;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

class hj implements cm {
    /* renamed from: a */
    final /* synthetic */ C0800c f7336a;
    /* renamed from: b */
    final /* synthetic */ hh f7337b;

    hj(hh hhVar, C0800c c0800c) {
        this.f7337b = hhVar;
        this.f7336a = c0800c;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            this.f7336a.m4208b(flowChargingTransferChoice.wifiOnly());
        }
    }
}
