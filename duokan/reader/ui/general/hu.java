package com.duokan.reader.ui.general;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

class hu implements cm {
    final /* synthetic */ c a;
    final /* synthetic */ hs b;

    hu(hs hsVar, c cVar) {
        this.b = hsVar;
        this.a = cVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            this.a.b(flowChargingTransferChoice.wifiOnly());
        }
    }
}
