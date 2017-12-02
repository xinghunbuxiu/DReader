package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.duokan.core.ui.dv;

public class mh extends LinearLayout implements mu {
    private final mm a;
    private final mm b;
    private final mm c;
    private final LinearLayout d = new LinearLayout(getContext());
    private final mn e;

    public mh(Context context, int i, mn mnVar) {
        super(context);
        this.e = mnVar;
        this.b = new mm(this, context);
        this.c = new mm(this, context);
        this.a = new mm(this, context);
        this.b.setOnClickListener(new mi(this));
        this.c.setOnClickListener(new mj(this));
        this.a.setOnClickListener(new mk(this));
        this.d.setOrientation(0);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.setMargins(dv.b(context, 10.0f), 0, dv.b(context, 10.0f), 0);
        this.d.addView(this.a, layoutParams);
        for (int i2 = 1; i2 <= i; i2++) {
            View mmVar = new mm(this, context);
            mmVar.a("" + i2);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.setMargins(dv.b(context, 10.0f), 0, dv.b(context, 10.0f), 0);
            this.d.addView(mmVar, layoutParams2);
            mmVar.setOnClickListener(new ml(this, i2));
        }
        addView(this.b, new LinearLayout.LayoutParams(-2, -1));
        View frameLayout = new FrameLayout(context);
        frameLayout.addView(this.d, new FrameLayout.LayoutParams(-2, -1, 17));
        addView(frameLayout, new LinearLayout.LayoutParams(0, -1, 1.0f));
        addView(this.c, new LinearLayout.LayoutParams(-2, -1));
        setShowInFullScreen(false);
        a(-1);
    }

    public void setShowInFullScreen(boolean z) {
        int i;
        if (z) {
            this.b.b(e.reading__callout_indicator_view__left_1);
            this.c.b(e.reading__callout_indicator_view__right_1);
            this.a.b(e.reading__callout_indicator_view__all_1);
            this.a.a(false);
            for (i = 1; i < this.d.getChildCount(); i++) {
                mm mmVar = (mm) this.d.getChildAt(i);
                mmVar.a(-1);
                mmVar.a(false);
                mmVar.b(e.reading__callout_indicator_view__item_bg_1);
            }
            setPadding(dv.b(getContext(), 10.0f), dv.b(getContext(), 3.0f), dv.b(getContext(), 10.0f), dv.b(getContext(), 3.0f));
            setBackgroundResource(e.reading__callout_indicator_view__bg);
            return;
        }
        this.b.b(e.reading__callout_indicator_view__left);
        this.c.b(e.reading__callout_indicator_view__right);
        this.a.b(e.reading__callout_indicator_view__all);
        for (i = 1; i < this.d.getChildCount(); i++) {
            mmVar = (mm) this.d.getChildAt(i);
            mmVar.a(-16777216);
            mmVar.b(e.reading__callout_indicator_view__item_bg);
        }
        setBackgroundDrawable(new ColorDrawable(0));
        setPadding(0, dv.b(getContext(), 1.0f), dv.b(getContext(), 10.0f), dv.b(getContext(), 1.0f));
    }

    public void a(int i) {
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            boolean z;
            View childAt = this.d.getChildAt(i2);
            if (i + 1 == i2) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
        }
    }
}
