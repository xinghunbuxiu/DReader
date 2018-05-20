package com.duokan.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;

import com.duokan.reader.ui.general.iv;

public class MyListView extends bt {
    
    private ScaleType scaleType;
    
    private Drawable firstDivederDrawable;
    
    private Drawable middleDivider;
    
    private Drawable lastDivider;

    public MyListView(Context context) {
        this(context, null);
    }

    public MyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scaleType = ScaleType.CENTER;
        this.firstDivederDrawable = null;
        this.middleDivider = null;
        this.lastDivider = null;
        super.setOrientation(VERTICAL);
    }

    public ScaleType getDividerScaleType() {
        return this.scaleType;
    }

    public void setDividerScaleType(ScaleType scaleType) {
        this.scaleType = scaleType;
        m2026a();
        requestLayout();
        invalidate();
    }

    public Drawable getFirstDivider() {
        return this.firstDivederDrawable;
    }

    public void setFirstDivider(int resId) {
        setFirstDivider(getResources().getDrawable(resId));
    }

    public void setFirstDivider(Drawable drawable) {
        this.firstDivederDrawable = drawable;
        m2026a();
        requestLayout();
        invalidate();
    }

    public Drawable getMiddleDivider() {
        return this.middleDivider;
    }

    public void setMiddleDivider(int i) {
        setMiddleDivider(getResources().getDrawable(i));
    }

    public void setMiddleDivider(Drawable drawable) {
        this.middleDivider = drawable;
        m2026a();
        requestLayout();
        invalidate();
    }

    public Drawable getLastDivider() {
        return this.lastDivider;
    }

    public void setLastDivider(int id) {
        setLastDivider(getResources().getDrawable(id));
    }

    public void setLastDivider(Drawable drawable) {
        this.lastDivider = drawable;
        m2026a();
        requestLayout();
        invalidate();
    }

    
    public int mo455a(View view, LayoutParams layoutParams) {
        addView(m2025a(view), layoutParams);
        m2026a();
        return getCellCount() - 1;
    }

    
    public View getTabView(int i) {
        return m2027b(i).getChildAt(0);
    }

    public int getCellCount() {
        return getChildCount();
    }

    public void setOrientation(int i) {
    }

    
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
            b2.setTopDrawable(this.firstDivederDrawable);
            b2.setScaleType(this.scaleType);
            b3.setBottomDrawable(this.lastDivider);
            b3.setScaleType(this.scaleType);
            for (i = 1; i < getCellCount(); i++) {
                b3 = m2027b(i);
                b3.setTopDrawable(this.middleDivider);
                b3.setScaleType(this.scaleType);
            }
        }
    }

    
    private final iv m2027b(int i) {
        return (iv) getChildAt(i);
    }

    
    private final iv m2025a(View view) {
        iv ivVar = new iv(getContext());
        if (view.getLayoutParams() != null) {
            ivVar.setLayoutParams(view.getLayoutParams());
        }
        ivVar.setScaleType(this.scaleType);
        ivVar.addView(view, new FrameLayout.LayoutParams(-1, -1));
        return ivVar;
    }
}
