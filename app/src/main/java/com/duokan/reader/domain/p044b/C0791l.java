package com.duokan.reader.domain.p044b;

import android.content.Context;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.domain.b.l */
class C0791l extends ap {
    /* renamed from: a */
    final /* synthetic */ C0790k f2648a;

    C0791l(C0790k c0790k, Context context) {
        this.f2648a = c0790k;
        super(context);
    }

    protected void onOk() {
        this.f2648a.f2647c.m3687a(FlowChargingTransferChoice.NoTransfer);
        this.f2648a.f2647c.m3658a(this.f2648a.f2645a);
        super.onOk();
    }

    protected void onCancel() {
        this.f2648a.f2647c.m3658a(this.f2648a.f2645a);
        super.onCancel();
    }
}
