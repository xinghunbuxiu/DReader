package com.duokan.reader.ui.reading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.et;
import com.duokan.reader.ui.general.ReaderUi;

public class NavigationFrameView extends FrameLayout {
    private final sh a;
    private et b;
    private nh c;

    public NavigationFrameView(Context context) {
        this(context, null);
    }

    public NavigationFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        if (isInEditMode()) {
            this.a = null;
        } else {
            this.a = (sh) MyContextWrapper.getFeature(getContext()).queryFeature(sh.class);
        }
    }

    public void setViewGestureDetector(et etVar) {
        this.b = etVar;
    }

    public void setSizeChangedListener(nh nhVar) {
        this.c = nhVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.b != null) {
            return this.b.a((View) this, motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.b != null) {
            return this.b.onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        if (isInEditMode()) {
            i3 = 0;
        } else if (ReaderUi.m(getContext())) {
            i3 = (ReaderUi.m(getContext()) && this.a.am()) ? getMeasuredWidth() / 2 : ReaderUi.a(getContext(), MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) : UTools.getWidthPixels(getContext()), 0.618f);
        } else {
            i3 = UTools.closeAnimation(getContext(), 40.0f);
        }
        if (getPaddingRight() != i3) {
            setPadding(0, 0, i3, 0);
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.c != null) {
            this.c.a();
        }
    }
}
