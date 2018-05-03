package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0243e;

public class mr extends LinearLayout implements ne {
    /* renamed from: a */
    private final mw f10639a;
    /* renamed from: b */
    private final mw f10640b;
    /* renamed from: c */
    private final mw f10641c;
    /* renamed from: d */
    private final LinearLayout f10642d = new LinearLayout(getContext());
    /* renamed from: e */
    private final mx f10643e;

    public mr(Context context, int i, mx mxVar) {
        super(context);
        this.f10643e = mxVar;
        this.f10640b = new mw(this, context);
        this.f10641c = new mw(this, context);
        this.f10639a = new mw(this, context);
        this.f10640b.setOnClickListener(new ms(this));
        this.f10641c.setOnClickListener(new mt(this));
        this.f10639a.setOnClickListener(new mu(this));
        this.f10642d.setOrientation(0);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(AnimUtils.m1932b(context, 10.0f), 0, AnimUtils.m1932b(context, 10.0f), 0);
        this.f10642d.addView(this.f10639a, layoutParams);
        for (int i2 = 1; i2 <= i; i2++) {
            View mwVar = new mw(this, context);
            mwVar.m14682a("" + i2);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.setMargins(AnimUtils.m1932b(context, 10.0f), 0, AnimUtils.m1932b(context, 10.0f), 0);
            this.f10642d.addView(mwVar, layoutParams2);
            mwVar.setOnClickListener(new mv(this, i2));
        }
        addView(this.f10640b, new LinearLayout.LayoutParams(-2, -1));
        View frameLayout = new FrameLayout(context);
        frameLayout.addView(this.f10642d, new FrameLayout.LayoutParams(-2, -1, 17));
        addView(frameLayout, new LinearLayout.LayoutParams(0, -1, 1.0f));
        addView(this.f10641c, new LinearLayout.LayoutParams(-2, -1));
        setShowInFullScreen(false);
        mo2430a(-1);
    }

    public void setShowInFullScreen(boolean z) {
        int i;
        if (z) {
            this.f10640b.m14684b(C0243e.reading__callout_indicator_view__left_1);
            this.f10641c.m14684b(C0243e.reading__callout_indicator_view__right_1);
            this.f10639a.m14684b(C0243e.reading__callout_indicator_view__all_1);
            this.f10639a.m14683a(false);
            for (i = 1; i < this.f10642d.getChildCount(); i++) {
                mw mwVar = (mw) this.f10642d.getChildAt(i);
                mwVar.m14681a(-1);
                mwVar.m14683a(false);
                mwVar.m14684b(C0243e.reading__callout_indicator_view__item_bg_1);
            }
            setPadding(AnimUtils.m1932b(getContext(), 10.0f), AnimUtils.m1932b(getContext(), 3.0f), AnimUtils.m1932b(getContext(), 10.0f), AnimUtils.m1932b(getContext(), 3.0f));
            setBackgroundResource(C0243e.reading__callout_indicator_view__bg);
            return;
        }
        this.f10640b.m14684b(C0243e.reading__callout_indicator_view__left);
        this.f10641c.m14684b(C0243e.reading__callout_indicator_view__right);
        this.f10639a.m14684b(C0243e.reading__callout_indicator_view__all);
        for (i = 1; i < this.f10642d.getChildCount(); i++) {
            mwVar = (mw) this.f10642d.getChildAt(i);
            mwVar.m14681a(-16777216);
            mwVar.m14684b(C0243e.reading__callout_indicator_view__item_bg);
        }
        setBackgroundDrawable(new ColorDrawable(0));
        setPadding(0, AnimUtils.m1932b(getContext(), 1.0f), AnimUtils.m1932b(getContext(), 10.0f), AnimUtils.m1932b(getContext(), 1.0f));
    }

    /* renamed from: a */
    public void mo2430a(int i) {
        for (int i2 = 0; i2 < this.f10642d.getChildCount(); i2++) {
            boolean z;
            View childAt = this.f10642d.getChildAt(i2);
            if (i + 1 == i2) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
    }
}
