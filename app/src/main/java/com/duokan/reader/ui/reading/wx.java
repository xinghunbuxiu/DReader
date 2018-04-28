package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;

public abstract class wx extends ActivatedController {
    /* renamed from: a */
    private Runnable f9940a = null;

    public wx(IFeature mFeature) {
        super(mFeature);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.f9940a != null) {
            this.f9940a.run();
            this.f9940a = null;
        }
    }

    /* renamed from: a */
    protected void m13847a(Runnable runnable) {
        this.f9940a = runnable;
        requestHideMenu();
    }
}
