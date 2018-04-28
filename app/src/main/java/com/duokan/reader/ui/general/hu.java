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
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.C0435s;

public class hu extends LinearLayout {
    /* renamed from: a */
    protected final FrameLayout f7350a;
    /* renamed from: b */
    protected final FrameLayout f7351b;
    /* renamed from: c */
    protected int f7352c = -1;
    /* renamed from: d */
    private final View f7353d;
    /* renamed from: e */
    private final ViewGroup f7354e;
    /* renamed from: f */
    private final cw f7355f;
    /* renamed from: g */
    private ia f7356g = null;

    public hu(Context context) {
        super(context);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(C0241c.general__shared__ffffff));
        this.f7353d = LayoutInflater.from(getContext()).inflate(C0245g.surfing__surfing_base_view, this, false);
        this.f7353d.setBackgroundDrawable(new hv(this));
        this.f7353d.setPadding(0, ((C0435s) AppContext.getAppContext(getContext()).queryFeature(ReaderFeature.class)).getTheme().getPageHeaderPaddingTop(), 0, 0);
        this.f7354e = (ViewGroup) this.f7353d.findViewById(C0244f.surfing__surfing_base_view__tabs);
        this.f7350a = (FrameLayout) this.f7353d.findViewById(C0244f.surfing__surfing_base_view__left);
        this.f7351b = (FrameLayout) this.f7353d.findViewById(C0244f.surfing__surfing_base_view__right);
        this.f7355f = new hw(this, context);
        this.f7355f.setBackgroundColor(getResources().getColor(C0241c.general__shared__page_background));
        this.f7355f.setOnScrollListener(new hx(this));
        this.f7355f.setOnFlipListener(new hy(this));
        addView(this.f7353d);
        addView(this.f7355f, new LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public int m10760a(String str, View view) {
        View a = m10756a(str);
        this.f7354e.addView(a);
        this.f7355f.addView(view, new LayoutParams(-1, -1));
        a.setOnClickListener(new hz(this, a));
        return this.f7354e.getChildCount() - 1;
    }

    /* renamed from: a */
    public void m10761a(int i) {
        if (this.f7352c != i && i >= 0 && i < this.f7355f.getChildCount()) {
            this.f7355f.m9070b(i);
        }
    }

    /* renamed from: b */
    public void m10765b(int i) {
        m10762a(i, null);
    }

    /* renamed from: a */
    public void m10762a(int i, Runnable runnable) {
        if (this.f7352c == i) {
            UThread.post(runnable);
        } else if (i >= 0 && i < this.f7355f.getChildCount()) {
            this.f7355f.m9069a(i, runnable, null);
        }
    }

    public void setTabBarWeight(float f) {
        ((LayoutParams) this.f7354e.getLayoutParams()).weight = f;
        ((LayoutParams) this.f7350a.getLayoutParams()).weight = (1.0f - f) / 2.0f;
        ((LayoutParams) this.f7351b.getLayoutParams()).weight = (1.0f - f) / 2.0f;
        requestLayout();
    }

    public void setOnCurrentPageChangedListener(ia iaVar) {
        this.f7356g = iaVar;
    }

    public FrameLayout getLeftLayout() {
        return this.f7350a;
    }

    public FrameLayout getRightLayout() {
        return this.f7351b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    protected boolean mo1797a() {
        return true;
    }

    /* renamed from: a */
    protected void m10763a(Canvas canvas) {
        for (int i = 0; i < this.f7355f.getChildCount(); i++) {
            Rect rect = (Rect) dv.f1198g.addAnimation();
            View childAt = this.f7355f.getChildAt(i);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (this.f7354e.getChildAt(i) instanceof TextView) {
                if (rect.right < this.f7355f.getViewportBounds().left || rect.left > this.f7355f.getViewportBounds().right) {
                    ((TextView) this.f7354e.getChildAt(i)).setTextColor(Color.rgb(163, 163, 163));
                } else if (rect.left < this.f7355f.getViewportBounds().left) {
                    r0 = ((float) (rect.right - this.f7355f.getViewportBounds().left)) / ((float) rect.width());
                    ((TextView) this.f7354e.getChildAt(i)).setTextColor(Color.rgb(m10759a(255, 163, r0), m10759a(132, 163, r0), m10759a(0, 163, r0)));
                } else if (rect.right > this.f7355f.getViewportBounds().right) {
                    r0 = ((float) (this.f7355f.getViewportBounds().right - rect.left)) / ((float) rect.width());
                    ((TextView) this.f7354e.getChildAt(i)).setTextColor(Color.rgb(m10759a(255, 163, r0), m10759a(132, 163, r0), m10759a(0, 163, r0)));
                } else {
                    ((TextView) this.f7354e.getChildAt(i)).setTextColor(Color.rgb(255, 108, 0));
                    dv.f1198g.clearAnimation(rect);
                }
            }
        }
    }

    /* renamed from: a */
    protected int m10759a(int i, int i2, float f) {
        return Math.min(255, (int) (((float) i2) + (((float) (i - i2)) * f)));
    }

    /* renamed from: a */
    private int m10753a(TextView textView) {
        return this.f7354e.indexOfChild(textView);
    }

    /* renamed from: c */
    private void m10758c(int i) {
        if (this.f7352c != i) {
            int i2 = this.f7352c;
            this.f7352c = i;
            if (this.f7356g != null) {
                this.f7356g.mo1798a(i2, this.f7352c);
            }
        }
    }

    /* renamed from: a */
    private TextView m10756a(String str) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C0245g.surfing__surfing_tab_view, this.f7354e, false);
        textView.setText(str);
        textView.getPaint().setFakeBoldText(true);
        return textView;
    }
}
