package com.duokan.reader.ui.store;

import android.content.Context;

import com.duokan.reader.ui.general.ap;

final class ai extends ap {
    final /* synthetic */ am a;

    ai(Context context, am amVar) {
        this.a = amVar;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.a.a();
    }

    protected void onCancel() {
        super.onCancel();
        this.a.b();
    }
}
