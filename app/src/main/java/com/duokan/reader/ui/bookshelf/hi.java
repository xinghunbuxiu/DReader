package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.widget.FrameLayout;
import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.gs;
import org.apache.http.HttpStatus;

public class hi extends gs {
    /* renamed from: a */
    protected boolean f6548a;
    /* renamed from: b */
    protected boolean f6549b;
    /* renamed from: c */
    private final FrameLayout f6550c;
    /* renamed from: d */
    private final View f6551d;
    /* renamed from: e */
    private Runnable f6552e;

    /* renamed from: a */
    public View m9791a() {
        return this.f6550c;
    }

    /* renamed from: b */
    public View m9793b() {
        return this.f6551d;
    }

    /* renamed from: a */
    public void m9792a(boolean z) {
        this.f6548a = z;
    }

    protected boolean onBack() {
        if (getPopupCount() > 0) {
            return getTopPopup().requestDetach();
        }
        if (!m9790c()) {
            return true;
        }
        this.f6549b = true;
        dv.startTranslateAnimation(m9791a(), 0.0f, 0.0f, 0.0f, 1.0f, HttpStatus.SC_OK, true, new hj(this));
        dv.startAlphaAnimation(m9793b(), 1.0f, 0.0f, HttpStatus.SC_OK, true, null);
        return true;
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.f6552e != null) {
            this.f6552e.run();
        }
    }

    /* renamed from: c */
    private boolean m9790c() {
        if (!this.f6548a || this.f6549b) {
            return false;
        }
        return true;
    }
}
