package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.duokan.b.g;
import com.duokan.core.app.x;
import com.duokan.core.sys.t;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.s;

public class ik extends LinearLayout {
    protected final FrameLayout a;
    protected final FrameLayout b;
    protected int c = -1;
    private final View d;
    private final ViewGroup e;
    private final cw f;
    private iq g = null;

    public ik(Context context) {
        super(context);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(c.general__shared__ffffff));
        this.d = LayoutInflater.from(getContext()).inflate(g.surfing__surfing_base_view, this, false);
        this.d.setBackgroundDrawable(new il(this));
        this.d.setPadding(0, ((s) x.a(getContext()).queryFeature(ReaderFeature.class)).getTheme().getPageHeaderPaddingTop(), 0, 0);
        this.e = (ViewGroup) this.d.findViewById(f.surfing__surfing_base_view__tabs);
        this.a = (FrameLayout) this.d.findViewById(f.surfing__surfing_base_view__left);
        this.b = (FrameLayout) this.d.findViewById(f.surfing__surfing_base_view__right);
        this.f = new im(this, context);
        this.f.setBackgroundColor(getResources().getColor(c.general__shared__page_background));
        this.f.setOnScrollListener(new in(this));
        this.f.setOnFlipListener(new io(this));
        addView(this.d);
        addView(this.f, new LayoutParams(-1, -1));
    }

    public int a(String str, View view) {
        View a = a(str);
        this.e.addView(a);
        this.f.addView(view, new LayoutParams(-1, -1));
        a.setOnClickListener(new ip(this, a));
        return this.e.getChildCount() - 1;
    }

    public void a(int i) {
        if (this.c != i && i >= 0 && i < this.f.getChildCount()) {
            this.f.b(i);
        }
    }

    public void b(int i) {
        a(i, null);
    }

    public void a(int i, Runnable runnable) {
        if (this.c == i) {
            t.b(runnable);
        } else if (i >= 0 && i < this.f.getChildCount()) {
            this.f.a(i, runnable, null);
        }
    }

    public void setTabBarWeight(float f) {
        ((LayoutParams) this.e.getLayoutParams()).weight = f;
        ((LayoutParams) this.a.getLayoutParams()).weight = (1.0f - f) / 2.0f;
        ((LayoutParams) this.b.getLayoutParams()).weight = (1.0f - f) / 2.0f;
        requestLayout();
    }

    public void setOnCurrentPageChangedListener(iq iqVar) {
        this.g = iqVar;
    }

    public FrameLayout getLeftLayout() {
        return this.a;
    }

    public FrameLayout getRightLayout() {
        return this.b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected boolean a() {
        return true;
    }

    protected void a(Canvas canvas) {
        for (int i = 0; i < this.f.getChildCount(); i++) {
            Rect rect = (Rect) dv.g.a();
            View childAt = this.f.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (this.e.getChildAt(i) instanceof TextView) {
                if (rect.right < this.f.getViewportBounds().left || rect.left > this.f.getViewportBounds().right) {
                    ((TextView) this.e.getChildAt(i)).setTextColor(Color.rgb(163, 163, 163));
                } else if (rect.left < this.f.getViewportBounds().left) {
                    r0 = ((float) (rect.right - this.f.getViewportBounds().left)) / ((float) rect.width());
                    ((TextView) this.e.getChildAt(i)).setTextColor(Color.rgb(a(255, 163, r0), a(132, 163, r0), a(0, 163, r0)));
                } else if (rect.right > this.f.getViewportBounds().right) {
                    r0 = ((float) (this.f.getViewportBounds().right - rect.left)) / ((float) rect.width());
                    ((TextView) this.e.getChildAt(i)).setTextColor(Color.rgb(a(255, 163, r0), a(132, 163, r0), a(0, 163, r0)));
                } else {
                    ((TextView) this.e.getChildAt(i)).setTextColor(Color.rgb(255, 108, 0));
                    dv.g.a(rect);
                }
            }
        }
    }

    protected int a(int i, int i2, float f) {
        return Math.min(255, (int) (((float) i2) + (((float) (i - i2)) * f)));
    }

    private int a(TextView textView) {
        return this.e.indexOfChild(textView);
    }

    private void c(int i) {
        if (this.c != i) {
            int i2 = this.c;
            this.c = i;
            if (this.g != null) {
                this.g.a(i2, this.c);
            }
        }
    }

    private TextView a(String str) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(g.surfing__surfing_tab_view, this.e, false);
        textView.setText(str);
        textView.getPaint().setFakeBoldText(true);
        return textView;
    }
}
