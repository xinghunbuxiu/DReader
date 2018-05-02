package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ReaderEnv;

class gt extends ActivatedController {
    final /* synthetic */ fl a;

    gt(fl flVar, IFeature featrue) {
        this.a = flVar;
        super(featrue);
    }

    protected void onDetachFromStub() {
        ReaderEnv.get().setShowPurchasedHint(false);
        this.a.activate(this.a.b);
    }
}
