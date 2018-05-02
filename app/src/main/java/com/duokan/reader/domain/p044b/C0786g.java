package com.duokan.reader.domain.p044b;

import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

/* renamed from: com.duokan.reader.domain.b.g */
class C0786g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FlowChargingTransferChoice f2637a;
    /* renamed from: b */
    final /* synthetic */ C0781b f2638b;

    C0786g(C0781b c0781b, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.f2638b = c0781b;
        this.f2637a = flowChargingTransferChoice;
    }

    public void run() {
        this.f2638b.m3669b(this.f2637a);
    }
}
