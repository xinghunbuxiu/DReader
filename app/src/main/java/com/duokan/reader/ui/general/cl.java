package com.duokan.reader.ui.general;

import android.content.Context;

import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

final class cl extends ap {
    final /* synthetic */ cm a;

    cl(Context context, cm cmVar) {
        this.a = cmVar;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.a.onChoice(true, FlowChargingTransferChoice.Transfer);
    }

    protected void onCancel() {
        super.onCancel();
        this.a.onChoice(false, FlowChargingTransferChoice.NoTransfer);
    }
}
