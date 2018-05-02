package com.duokan.reader.domain.b;

import android.content.Context;

import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ap;

class l extends ap {
    final /* synthetic */ k a;

    l(k kVar, Context context) {
        this.a = kVar;
        super(context);
    }

    protected void onOk() {
        this.a.c.a(FlowChargingTransferChoice.NoTransfer);
        this.a.c.a(this.a.a);
        super.onOk();
    }

    protected void onCancel() {
        this.a.c.a(this.a.a);
        super.onCancel();
    }
}
