package com.duokan.reader.domain.b;

import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

class g implements Runnable {
    final /* synthetic */ FlowChargingTransferChoice a;
    final /* synthetic */ b b;

    g(b bVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.b = bVar;
        this.a = flowChargingTransferChoice;
    }

    public void run() {
        this.b.b(this.a);
    }
}
