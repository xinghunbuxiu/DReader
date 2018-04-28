package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class bd extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ ay f1009a;
    /* renamed from: b */
    private bc f1010b;

    public bd(ay ayVar, Context context) {
        this(ayVar, context, null);
    }

    public bd(ay ayVar, Context context, AttributeSet attributeSet) {
        this.f1009a = ayVar;
        super(context, attributeSet);
        this.f1010b = null;
        setVisibility(4);
    }

    /* renamed from: a */
    public void m1677a() {
        super.forceLayout();
    }

    public View getItemView() {
        return this.f1010b.f995c;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getAnimation() == null) {
                removeViewInLayout(childAt);
            }
        }
    }

    public final void forceLayout() {
        m1677a();
        if (this.f1010b != null) {
            this.f1010b.f998f = -1;
            this.f1010b.f999g = -1;
            this.f1010b.m1665b(false);
            this.f1009a.m1150j();
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public final void requestLayout() {
        forceLayout();
    }
}
