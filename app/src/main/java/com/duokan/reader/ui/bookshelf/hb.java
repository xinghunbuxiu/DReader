package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.hd;

import org.apache.http.HttpStatus;

public class hb extends hd {
    protected boolean a;
    protected boolean b;
    private final FrameLayout c;
    private final View d;
    private Runnable e;

    public View a() {
        return this.c;
    }

    public View b() {
        return this.d;
    }

    public void a(boolean z) {
        this.a = z;
    }

    protected boolean onBack() {
        if (getPopupCount() > 0) {
            return getTopPopup().requestDetach();
        }
        if (!c()) {
            return true;
        }
        this.b = true;
        UTools.addAnimation(a(), 0.0f, 0.0f, 0.0f, 1.0f, HttpStatus.SC_OK, true, new hc(this));
        UTools.addAnimation(b(), 1.0f, 0.0f, HttpStatus.SC_OK, true, null);
        return true;
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.e != null) {
            this.e.run();
        }
    }

    private boolean c() {
        if (!this.a || this.b) {
            return false;
        }
        return true;
    }
}
