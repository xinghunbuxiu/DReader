package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.b.b;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

class em implements cm {
    final /* synthetic */ ek a;

    em(ek ekVar) {
        this.a = ekVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            b.b().a(flowChargingTransferChoice);
        }
    }
}
