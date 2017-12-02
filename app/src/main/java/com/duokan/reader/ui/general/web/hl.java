package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.store.o;

class hl implements cm {
    final /* synthetic */ hh a;

    hl(hh hhVar) {
        this.a = hhVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            o.a().a(ai.a().b(this.a.a.d), new hm(this), flowChargingTransferChoice);
            return;
        }
        this.a.a.f.b.b.web_notifyWeb(this.a.a.b, 4, new Object[0]);
    }
}
