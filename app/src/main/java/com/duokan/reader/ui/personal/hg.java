package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;

class hg extends ActivatedController {
    /* renamed from: a */
    final /* synthetic */ fz f8650a;

    hg(fz fzVar, IFeature mFeature) {
        this.f8650a = fzVar;
        super(mFeature);
    }

    protected void onDetachFromStub() {
        this.f8650a.activate(this.f8650a.f8575b);
    }
}
