package com.duokan.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

import com.duokan.reader.ui.general.jl;

public class eq extends bt {
    private ScaleType a;
    private Drawable b;
    private Drawable c;
    private Drawable d;

    public eq(Context context) {
        this(context, null);
    }

    public eq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = ScaleType.CENTER;
        this.b = null;
        this.c = null;
        this.d = null;
        super.setOrientation(1);
    }

    public ScaleType getDividerScaleType() {
        return this.a;
    }

    public void setDividerScaleType(ScaleType scaleType) {
        this.a = scaleType;
        a();
        requestLayout();
        invalidate();
    }

    public Drawable getFirstDivider() {
        return this.b;
    }

    public void setFirstDivider(int i) {
        setFirstDivider(getResources().getDrawable(i));
    }

    public void setFirstDivider(Drawable drawable) {
        this.b = drawable;
        a();
        requestLayout();
        invalidate();
    }

    public Drawable getMiddleDivider() {
        return this.c;
    }

    public void setMiddleDivider(int i) {
        setMiddleDivider(getResources().getDrawable(i));
    }

    public void setMiddleDivider(Drawable drawable) {
        this.c = drawable;
        a();
        requestLayout();
        invalidate();
    }

    public Drawable getLastDivider() {
        return this.d;
    }

    public void setLastDivider(int i) {
        setLastDivider(getResources().getDrawable(i));
    }

    public void setLastDivider(Drawable drawable) {
        this.d = drawable;
        a();
        requestLayout();
        invalidate();
    }

    public int a(View view, LayoutParams layoutParams) {
        addView(a(view), layoutParams);
        a();
        return getCellCount() - 1;
    }

    public View a(int i) {
        return b(i).getChildAt(0);
    }

    public int getCellCount() {
        return getChildCount();
    }

    public void setOrientation(int i) {
    }

    private final void a() {
        if (getCellCount() >= 1) {
            int i;
            for (i = 0; i < getCellCount(); i++) {
                jl b = b(i);
                b.setTopDrawable(null);
                b.setBottomDrawable(null);
            }
            jl b2 = b(0);
            jl b3 = b(getCellCount() - 1);
            b2.setTopDrawable(this.b);
            b2.setScaleType(this.a);
            b3.setBottomDrawable(this.d);
            b3.setScaleType(this.a);
            for (i = 1; i < getCellCount(); i++) {
                b3 = b(i);
                b3.setTopDrawable(this.c);
                b3.setScaleType(this.a);
            }
        }
    }

    private final jl b(int i) {
        return (jl) getChildAt(i);
    }

    private final jl a(View view) {
        jl jlVar = new jl(getContext());
        if (view.getLayoutParams() != null) {
            jlVar.setLayoutParams(view.getLayoutParams());
        }
        jlVar.setScaleType(this.a);
        jlVar.addView(view, new FrameLayout.LayoutParams(-1, -1));
        return jlVar;
    }
}
