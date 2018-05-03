package com.duokan.reader.ui.reading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.et;
import com.duokan.reader.ui.general.ReaderUi;

public class NavigationFrameView extends FrameLayout {
    /* renamed from: a */
    private final su f9105a;
    /* renamed from: b */
    private et f9106b;
    /* renamed from: c */
    private nr f9107c;

    public NavigationFrameView(Context context) {
        this(context, null);
    }

    public NavigationFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9106b = null;
        this.f9107c = null;
        if (isInEditMode()) {
            this.f9105a = null;
        } else {
            this.f9105a = (su) AppContext.getAppContext(getContext()).queryFeature(su.class);
        }
    }

    public void setViewGestureDetector(et etVar) {
        this.f9106b = etVar;
    }

    public void setSizeChangedListener(nr nrVar) {
        this.f9107c = nrVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f9106b != null) {
            return this.f9106b.m2044a((View) this, motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f9106b != null) {
            return this.f9106b.onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        if (isInEditMode()) {
            i3 = 0;
        } else if (ReaderUi.m10170m(getContext())) {
            i3 = (ReaderUi.m10170m(getContext()) && this.f9105a.am()) ? getMeasuredWidth() / 2 : ReaderUi.m10154a(getContext(), MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) : AnimUtils.getWidthPixels(getContext()), 0.618f);
        } else {
            i3 = AnimUtils.m1932b(getContext(), 40.0f);
        }
        if (getPaddingRight() != i3) {
            setPadding(0, 0, i3, 0);
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.f9107c != null) {
            this.f9107c.mo2449a();
        }
    }
}
