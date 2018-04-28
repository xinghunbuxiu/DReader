package com.duokan.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.duokan.reader.ui.general.iv;

public class eq extends bt {
    /* renamed from: a */
    private ScaleType f1218a;
    /* renamed from: b */
    private Drawable f1219b;
    /* renamed from: c */
    private Drawable f1220c;
    /* renamed from: d */
    private Drawable f1221d;

    public eq(Context context) {
        this(context, null);
    }

    public eq(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1218a = ScaleType.CENTER;
        this.f1219b = null;
        this.f1220c = null;
        this.f1221d = null;
        super.setOrientation(1);
    }

    public ScaleType getDividerScaleType() {
        return this.f1218a;
    }

    public void setDividerScaleType(ScaleType scaleType) {
        this.f1218a = scaleType;
        m2026a();
        requestLayout();
        invalidate();
    }

    public Drawable getFirstDivider() {
        return this.f1219b;
    }

    public void setFirstDivider(int i) {
        setFirstDivider(getResources().getDrawable(i));
    }

    public void setFirstDivider(Drawable drawable) {
        this.f1219b = drawable;
        m2026a();
        requestLayout();
        invalidate();
    }

    public Drawable getMiddleDivider() {
        return this.f1220c;
    }

    public void setMiddleDivider(int i) {
        setMiddleDivider(getResources().getDrawable(i));
    }

    public void setMiddleDivider(Drawable drawable) {
        this.f1220c = drawable;
        m2026a();
        requestLayout();
        invalidate();
    }

    public Drawable getLastDivider() {
        return this.f1221d;
    }

    public void setLastDivider(int i) {
        setLastDivider(getResources().getDrawable(i));
    }

    public void setLastDivider(Drawable drawable) {
        this.f1221d = drawable;
        m2026a();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public int mo455a(View view, LayoutParams layoutParams) {
        addView(m2025a(view), layoutParams);
        m2026a();
        return getCellCount() - 1;
    }

    /* renamed from: a */
    public View mo456a(int i) {
        return m2027b(i).getChildAt(0);
    }

    public int getCellCount() {
        return getChildCount();
    }

    public void setOrientation(int i) {
    }

    /* renamed from: a */
    private final void m2026a() {
        if (getCellCount() >= 1) {
            int i;
            for (i = 0; i < getCellCount(); i++) {
                iv b = m2027b(i);
                b.setTopDrawable(null);
                b.setBottomDrawable(null);
            }
            iv b2 = m2027b(0);
            iv b3 = m2027b(getCellCount() - 1);
            b2.setTopDrawable(this.f1219b);
            b2.setScaleType(this.f1218a);
            b3.setBottomDrawable(this.f1221d);
            b3.setScaleType(this.f1218a);
            for (i = 1; i < getCellCount(); i++) {
                b3 = m2027b(i);
                b3.setTopDrawable(this.f1220c);
                b3.setScaleType(this.f1218a);
            }
        }
    }

    /* renamed from: b */
    private final iv m2027b(int i) {
        return (iv) getChildAt(i);
    }

    /* renamed from: a */
    private final iv m2025a(View view) {
        iv ivVar = new iv(getContext());
        if (view.getLayoutParams() != null) {
            ivVar.setLayoutParams(view.getLayoutParams());
        }
        ivVar.setScaleType(this.f1218a);
        ivVar.addView(view, new FrameLayout.LayoutParams(-1, -1));
        return ivVar;
    }
}
