package com.duokan.reader.ui.personal;

import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

class fj implements cm {
    /* renamed from: a */
    final /* synthetic */ fi f8542a;

    fj(fi fiVar) {
        this.f8542a = fiVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            this.f8542a.f8541a.f8524b.checkUpdate();
            this.f8542a.f8541a.f8524b.downUpdate();
        }
    }
}
