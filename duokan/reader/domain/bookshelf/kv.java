package com.duokan.reader.domain.bookshelf;

import android.content.Context;

import com.duokan.reader.ui.general.eo;

class kv extends eo {
    final /* synthetic */ kp a;

    kv(kp kpVar, Context context) {
        this.a = kpVar;
        super(context);
    }

    protected boolean onBack() {
        this.a.j();
        return super.onBack();
    }
}
