package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import java.util.Iterator;

class bu implements cm {
    /* renamed from: a */
    final /* synthetic */ bs f6216a;

    bu(bs bsVar) {
        this.f6216a = bsVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            Iterator it = this.f6216a.f6212d.iterator();
            while (it.hasNext()) {
                C0800c c0800c = ((br) it.next()).f6207a;
                it.m4692a().m4721a(c0800c.m4222e(), c0800c.m4219d().getName(), flowChargingTransferChoice);
            }
        }
    }
}
