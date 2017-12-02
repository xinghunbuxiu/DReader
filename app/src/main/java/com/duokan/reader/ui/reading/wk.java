package com.duokan.reader.ui.reading;

import com.duokan.core.app.e;
import com.duokan.core.app.y;

public abstract class wk extends e {
    private Runnable a = null;

    public wk(y yVar) {
        super(yVar);
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
