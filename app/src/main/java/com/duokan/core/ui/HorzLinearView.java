package com.duokan.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public class HorzLinearView extends bt {
    /* renamed from: a */
    private ScaleType f837a;
    /* renamed from: b */
    private Drawable f838b;
    /* renamed from: c */
    private Drawable f839c;
    /* renamed from: d */
    private Drawable f840d;

    public HorzLinearView(Context context) {
        this(context, null);
    }

    public HorzLinearView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f837a = ScaleType.CENTER;
        this.f838b = null;
        this.f839c = null;
        this.f840d = null;
        super.setOrientation(0);
    }

    public ScaleType getDividerScaleType() {
        return this.f837a;
    }

    public void setDividerScaleType(ScaleType scaleType) {
        this.f837a = scaleType;
        m1270a();
        requestLayout();
        invalidate();
    }

    public Drawable getFirstDivider() {
        return this.f838b;
    }

    public void setFirstDivider(int i) {
        setFirstDivider(getResources().getDrawable(i));
    }

    public void setFirstDivider(Drawable drawable) {
        this.f838b = drawable;
        m1270a();
        requestLayout();
        invalidate();
    }

    public Drawable getMiddleDivider() {
        return this.f839c;
    }

    public void setMiddleDivider(int i) {
        setMiddleDivider(getResources().getDrawable(i));
    }

    public void setMiddleDivider(Drawable drawable) {
        this.f839c = drawable;
        m1270a();
        requestLayout();
        invalidate();
    }

    public Drawable getLastDivider() {
        return this.f840d;
    }

    public void setLastDivider(int i) {
        setLastDivider(getResources().getDrawable(i));
    }

    public void setLastDivider(Drawable drawable) {
        this.f840d = drawable;
        m1270a();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public int mo455a(View view, LayoutParams layoutParams) {
        addView(m1269a(view), layoutParams);
        m1270a();
        return getCellCount() - 1;
    }

    /* renamed from: a */
    public View getTabView(int i) {
        return m1271b(i).getChildAt(0);
    }

    public int getCellCount() {
        return getChildCount();
    }

    public void setOrientation(int i) {
    }

    /* renamed from: a */
    private final void m1270a() {
        if (getCellCount() >= 1) {
            int i;
            for (i = 0; i < getCellCount(); i++) {
                ar b = m1271b(i);
                b.setLeftDrawable(null);
                b.setRightDrawable(null);
            }
            ar b2 = m1271b(0);
            ar b3 = m1271b(getCellCount() - 1);
            b2.setLeftDrawable(this.f838b);
            b2.setScaleType(this.f837a);
            b3.setRightDrawable(this.f840d);
            b3.setScaleType(this.f837a);
            for (i = 1; i < getCellCount(); i++) {
                b3 = m1271b(i);
                b3.setLeftDrawable(this.f839c);
                b3.setScaleType(this.f837a);
            }
        }
    }

    /* renamed from: b */
    private final ar m1271b(int i) {
        return (ar) getChildAt(i);
    }

    /* renamed from: a */
    private final ar m1269a(View view) {
        ar arVar = new ar(getContext());
        if (view.getLayoutParams() != null) {
            arVar.setLayoutParams(view.getLayoutParams());
        }
        arVar.setScaleType(this.f837a);
        arVar.addView(view, new FrameLayout.LayoutParams(-1, -1));
        return arVar;
    }
}
