package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.i;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

import java.io.File;

class bi implements Runnable {
    final /* synthetic */ aq a;

    bi(aq aqVar) {
        this.a = aqVar;
    }

    public void run() {
        if (this.a.c().b(Boolean.valueOf(true)) && this.a.e.b() && this.a.d.d() && !this.a.b.e()) {
            for (c cVar : this.a.h.values()) {
                if (!cVar.ai() && cVar.ao() == -1 && this.a.b.b(cVar.e()) == null) {
                    break;
                }
            }
            c cVar2 = null;
            if (cVar2 != null) {
                File d = cVar2.d();
                i a = this.a.b.a(d.getAbsolutePath(), d.getName());
                if (a != null) {
                    this.a.b.a(a, FlowChargingTransferChoice.NoTransfer);
                }
            }
        }
    }
}
