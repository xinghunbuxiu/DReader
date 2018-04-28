package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.p044b.C0781b;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

class eq implements cm {
    /* renamed from: a */
    final /* synthetic */ eo f10097a;

    eq(eo eoVar) {
        this.f10097a = eoVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            C0781b.m3667b().m3687a(flowChargingTransferChoice);
        }
    }
}
