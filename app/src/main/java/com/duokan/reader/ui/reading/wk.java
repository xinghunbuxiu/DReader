package com.duokan.reader.ui.reading;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;

public abstract class wk extends ActivatedController {
    private Runnable a = null;

    public wk(IFeature featrue) {
        super(featrue);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.a != null) {
            this.a.run();
            this.a = null;
        }
    }

    protected void a(Runnable runnable) {
        this.a = runnable;
        requestHideMenu();
    }
}
