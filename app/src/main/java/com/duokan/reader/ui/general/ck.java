package com.duokan.reader.ui.general;

import android.content.Context;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;

final class ck extends ap {
    /* renamed from: a */
    final /* synthetic */ cm f7034a;

    ck(Context context, cm cmVar) {
        this.f7034a = cmVar;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.f7034a.onChoice(true, FlowChargingTransferChoice.Transfer);
    }

    protected void onCancel() {
        super.onCancel();
        this.f7034a.onChoice(false, FlowChargingTransferChoice.NoTransfer);
    }
}
