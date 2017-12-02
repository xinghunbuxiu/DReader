package com.duokan.reader.ui.personal;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;

class gt extends e {
    final /* synthetic */ fl a;

    gt(fl flVar, y yVar) {
        this.a = flVar;
        super(yVar);
    }

    protected void onDetachFromStub() {
        ReaderEnv.get().setShowPurchasedHint(false);
        this.a.activate(this.a.b);
    }
}
