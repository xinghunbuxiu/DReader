package com.duokan.reader.ui.reading;

import android.content.Context;

import com.duokan.reader.ui.general.ap;

class q extends ap {
    final /* synthetic */ k a;

    q(k kVar, Context context) {
        this.a = kVar;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.a.b.dismiss();
    }

    protected void onNo() {
        super.onNo();
    }

    protected void onCancel() {
        super.onCancel();
    }
}
