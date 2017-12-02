package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.store.o;

import java.util.ArrayList;

class kh implements cm {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ Runnable c;
    final /* synthetic */ kg d;

    kh(kg kgVar, Runnable runnable, ArrayList arrayList, Runnable runnable2) {
        this.d = kgVar;
        this.a = runnable;
        this.b = arrayList;
        this.c = runnable2;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            if (this.a != null) {
                this.a.run();
            }
            int size = this.b.size();
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    c cVar = (c) this.b.get(i);
                    o.a().a(cVar, new ki(this, cVar), flowChargingTransferChoice);
                }
            } else if (this.c != null) {
                this.c.run();
            }
        }
    }
}
