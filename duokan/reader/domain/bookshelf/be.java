package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.i;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

import java.util.ArrayList;
import java.util.Iterator;

class be implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ aq b;

    be(aq aqVar, boolean z) {
        this.b = aqVar;
        this.a = z;
    }

    public void run() {
        ArrayList f = this.b.b.f();
        Iterator it;
        i iVar;
        if (this.a) {
            it = f.iterator();
            while (it.hasNext()) {
                iVar = (i) it.next();
                if (!iVar.g()) {
                    this.b.b.a(iVar, FlowChargingTransferChoice.NoTransfer);
                }
            }
            this.b.a();
            return;
        }
        it = f.iterator();
        while (it.hasNext()) {
            iVar = (i) it.next();
            if (iVar.g()) {
                this.b.b.b(iVar);
            }
        }
    }
}
