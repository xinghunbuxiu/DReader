package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

class bd implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ar f2807a;

    bd(ar arVar) {
        this.f2807a = arVar;
    }

    public void run() {
        if (this.f2807a.mo971c().m862b(Boolean.valueOf(true)) && this.f2807a.e.m3507c() && this.f2807a.d.m2485d()) {
            List linkedList = new LinkedList();
            for (C0800c c0800c : this.f2807a.h.values()) {
                if (!c0800c.ak() && c0800c.aq() == -1) {
                    File d = c0800c.m4219d();
                    if (d != null && d.exists()) {
                        linkedList.add(d);
                    }
                }
            }
            if (linkedList.size() > 0) {
                this.f2807a.f2762b.m4722a(linkedList, FlowChargingTransferChoice.NoTransfer);
            }
        }
    }
}
