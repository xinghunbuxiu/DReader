package com.duokan.reader.ui.general;

import android.content.Context;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

final class cl extends ap {
    /* renamed from: a */
    final /* synthetic */ cm f7035a;

    cl(Context context, cm cmVar) {
        this.f7035a = cmVar;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.f7035a.onChoice(true, FlowChargingTransferChoice.Transfer);
    }

    protected void onCancel() {
        super.onCancel();
        this.f7035a.onChoice(false, FlowChargingTransferChoice.NoTransfer);
    }
}
