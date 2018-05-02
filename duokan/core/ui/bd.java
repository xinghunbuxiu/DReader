package com.duokan.core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class bd extends FrameLayout {
    final /* synthetic */ ay a;
    private bc b;

    public bd(ay ayVar, Context context) {
        this(ayVar, context, null);
    }

    public bd(ay ayVar, Context context, AttributeSet attributeSet) {
        this.a = ayVar;
        super(context, attributeSet);
        this.b = null;
        setVisibility(4);
    }

    public void a() {
        super.forceLayout();
    }

    public View getItemView() {
        return this.b.c;
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
        a();
        if (this.b != null) {
            this.b.f = -1;
            this.b.g = -1;
            this.b.b(false);
            this.a.j();
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public final void requestLayout() {
        forceLayout();
    }
}
