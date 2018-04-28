package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;
import com.duokan.reader.ui.store.C1502o;
import java.util.ArrayList;

class kv implements cm {
    /* renamed from: a */
    final /* synthetic */ Runnable f8836a;
    /* renamed from: b */
    final /* synthetic */ ArrayList f8837b;
    /* renamed from: c */
    final /* synthetic */ Runnable f8838c;
    /* renamed from: d */
    final /* synthetic */ ku f8839d;

    kv(ku kuVar, Runnable runnable, ArrayList arrayList, Runnable runnable2) {
        this.f8839d = kuVar;
        this.f8836a = runnable;
        this.f8837b = arrayList;
        this.f8838c = runnable2;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            if (this.f8836a != null) {
                this.f8836a.run();
            }
            int size = this.f8837b.size();
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    C0800c c0800c = (C0800c) this.f8837b.get(i);
                    C1502o.m15410a().m15429a(c0800c, new kw(this, c0800c), flowChargingTransferChoice);
                }
            } else if (this.f8838c != null) {
                this.f8838c.run();
            }
        }
    }
}
