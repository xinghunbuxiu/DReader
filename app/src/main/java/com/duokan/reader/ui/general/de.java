package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.MeasureSpec;
import com.duokan.core.ui.bd;

public class de extends bd {
    /* renamed from: b */
    final /* synthetic */ dc f7057b;

    public de(dc dcVar, Context context) {
        this.f7057b = dcVar;
        super(dcVar, context);
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f7057b.f7055a.getPageLeftShadowWidth() != 0) {
            this.f7057b.f7055a.f6850c.setBounds(0, 0, this.f7057b.f7055a.getPageLeftShadowWidth(), getHeight());
            this.f7057b.f7055a.f6850c.draw(canvas);
        }
        if (this.f7057b.f7055a.getPageRightShadowWidth() != 0) {
            this.f7057b.f7055a.f6851d.setBounds(getWidth() - this.f7057b.f7055a.getPageRightShadowWidth(), 0, getWidth(), getHeight());
            this.f7057b.f7055a.f6851d.draw(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth() - (this.f7057b.f7055a.getPageLeftShadowWidth() + this.f7057b.f7055a.getPageRightShadowWidth());
        int height = getHeight() - (this.f7057b.f7055a.getPageTopShadowHeight() + this.f7057b.f7055a.getPageBottomShadowHeight());
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            childAt.layout(this.f7057b.f7055a.getPageLeftShadowWidth(), this.f7057b.f7055a.getPageTopShadowHeight(), this.f7057b.f7055a.getPageLeftShadowWidth() + childAt.getMeasuredWidth(), this.f7057b.f7055a.getPageTopShadowHeight() + childAt.getMeasuredHeight());
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
        int g = this.f7057b.f7055a.getPageLeftShadowWidth() + this.f7057b.f7055a.getPageRightShadowWidth();
        int i3 = this.f7057b.f7055a.getPageTopShadowHeight() + this.f7057b.f7055a.getPageBottomShadowHeight();
        if (mode != 0) {
            i = MeasureSpec.makeMeasureSpec(size - g, mode);
        }
        if (mode2 != 0) {
            i2 = MeasureSpec.makeMeasureSpec(size2 - i3, mode2);
        }
        super.onMeasure(i, i2);
        if (Float.compare(this.f7057b.f7055a.getZoomFactor(), 1.0f) != 0) {
            size = mode == 1073741824 ? getMeasuredWidth() : Math.round(((float) getMeasuredWidth()) * this.f7057b.f7055a.getZoomFactor());
            mode = mode2 == 1073741824 ? getMeasuredHeight() : Math.round(((float) getMeasuredHeight()) * this.f7057b.f7055a.getZoomFactor());
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
