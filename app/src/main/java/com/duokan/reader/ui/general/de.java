package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.MeasureSpec;

import com.duokan.core.ui.bd;

public class de extends bd {
    final /* synthetic */ dc b;

    public de(dc dcVar, Context context) {
        this.b = dcVar;
        super(dcVar, context);
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.b.a.getPageLeftShadowWidth() != 0) {
            this.b.a.c.setBounds(0, 0, this.b.a.getPageLeftShadowWidth(), getHeight());
            this.b.a.c.draw(canvas);
        }
        if (this.b.a.getPageRightShadowWidth() != 0) {
            this.b.a.d.setBounds(getWidth() - this.b.a.getPageRightShadowWidth(), 0, getWidth(), getHeight());
            this.b.a.d.draw(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() - (this.b.a.getPageLeftShadowWidth() + this.b.a.getPageRightShadowWidth());
        int height = getHeight() - (this.b.a.getPageTopShadowHeight() + this.b.a.getPageBottomShadowHeight());
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            childAt.layout(this.b.a.getPageLeftShadowWidth(), this.b.a.getPageTopShadowHeight(), this.b.a.getPageLeftShadowWidth() + childAt.getMeasuredWidth(), this.b.a.getPageTopShadowHeight() + childAt.getMeasuredHeight());
            childAt.setPivotX(0.0f);
            childAt.setPivotY(0.0f);
            childAt.setScaleX(((float) width) / ((float) childAt.getWidth()));
            childAt.setScaleY(((float) height) / ((float) childAt.getHeight()));
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int g = this.b.a.getPageLeftShadowWidth() + this.b.a.getPageRightShadowWidth();
        int i3 = this.b.a.getPageTopShadowHeight() + this.b.a.getPageBottomShadowHeight();
        if (mode != 0) {
            i = MeasureSpec.makeMeasureSpec(size - g, mode);
        }
        if (mode2 != 0) {
            i2 = MeasureSpec.makeMeasureSpec(size2 - i3, mode2);
        }
        super.onMeasure(i, i2);
        if (Float.compare(this.b.a.getZoomFactor(), 1.0f) != 0) {
            size = mode == 1073741824 ? getMeasuredWidth() : Math.round(((float) getMeasuredWidth()) * this.b.a.getZoomFactor());
            mode = mode2 == 1073741824 ? getMeasuredHeight() : Math.round(((float) getMeasuredHeight()) * this.b.a.getZoomFactor());
            if (!(size == getMeasuredWidth() && mode == getMeasuredHeight())) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
            }
        }
        setMeasuredDimension(getMeasuredWidth() + g, getMeasuredHeight() + i3);
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (view == getItemView()) {
            super.measureChildWithMargins(view, MeasureSpec.makeMeasureSpec(0, 0), 0, MeasureSpec.makeMeasureSpec(0, 0), 0);
            return;
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }
}
