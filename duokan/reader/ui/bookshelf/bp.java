package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.micloud.i;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

import java.util.Iterator;

class bp implements cm {
    final /* synthetic */ bn a;

    bp(bn bnVar) {
        this.a = bnVar;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            Iterator it = this.a.d.iterator();
            while (it.hasNext()) {
                c cVar = ((bm) it.next()).a;
                i b = iz.a().b(cVar.e());
                if (b == null) {
                    b = iz.a().a(cVar.e(), cVar.d().getName());
                }
                if (b != null) {
                    iz.a().a(b, flowChargingTransferChoice);
                }
            }
        }
    }
}
