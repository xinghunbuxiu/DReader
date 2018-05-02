package com.duokan.reader.ui;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ui.general.fs;

/* renamed from: com.duokan.reader.ui.l */
class C1387l extends fs {
    /* renamed from: a */
    final /* synthetic */ C1384i f8191a;
    /* renamed from: b */
    private final FrameLayout f8192b;
    /* renamed from: d */
    private final float f8193d;

    public C1387l(C1384i c1384i, IFeature mFeature, ActivatedController c0303e, float f) {
        this.f8191a = c1384i;
        super(c1384i, mFeature, c0303e);
        this.f8193d = f;
        this.f8192b = new C1388m(this, getContext(), c1384i);
        this.f8192b.setLayoutParams(new LayoutParams(-1, -1));
        View view = new View(getContext());
        view.setBackgroundColor(-16777216);
        view.setEnabled(false);
        view.setClickable(true);
        this.f8192b.addView(view, new LayoutParams(-1, -1));
        this.f8192b.addView(m10671c(), new LayoutParams(-1, -1));
        setContentView(this.f8192b);
        if (Float.compare(this.f8193d, 1.0f) < 0) {
            this.f8192b.setOnTouchListener(new C1389n(this, c1384i));
        }
    }

    /* renamed from: a */
    public final float m11333a() {
        return this.f8193d;
    }

    protected boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return false;
        }
        return true;
    }

    protected boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return false;
        }
        return true;
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.f8192b.removeAllViews();
    }
}
