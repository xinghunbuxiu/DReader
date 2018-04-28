package com.duokan.reader.ui.general;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;

class gv extends gy {
    /* renamed from: a */
    final /* synthetic */ gs f7307a;
    /* renamed from: c */
    private final FrameLayout f7308c;

    public gv(gs gsVar, IFeature mFeature, ActivatedController c0303e, int i, int i2) {
        this.f7307a = gsVar;
        super(gsVar, mFeature, c0303e);
        this.f7308c = new gw(this, getContext(), gsVar, i);
        this.f7308c.setOnTouchListener(new gx(this, gsVar, i2));
        setContentView(this.f7308c);
        this.f7308c.addView(m10733b(), new LayoutParams(-1, -1, i));
        addSubController(m10732a());
        activate(m10732a());
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.f7308c.removeAllViews();
    }
}
