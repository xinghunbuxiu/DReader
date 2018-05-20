package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.duokan.common.CommonUtils;
import com.duokan.core.ui.C0343f;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.AnimUtils;

public final class bd extends C0343f {
    /* renamed from: a */
    private jn f9824a;
    /* renamed from: b */
    private ViewGroup f9825b = ((ViewGroup) this.f9824a.getCenterView());
    /* renamed from: c */
    private LinearScrollView f9826c;
    /* renamed from: d */
    private Runnable f9827d;

    public bd(Context context) {
        super(context);
        this.f9824a = new jn(context, new be(this));
        this.f9824a.setOnTouchListener(new bf(this));
        this.f9824a.setVerticalOffset(AnimUtils.m1932b(getContext(), 10.0f));
        setDimAmount(0.0f);
        setContentView(this.f9824a, new LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public void m13771a(View view, int i, int i2, boolean z) {
        this.f9826c = new LinearScrollView(getContext());
        this.f9826c.setFadingEdgeLength(0);
        this.f9826c.setClipChildren(true);
        this.f9826c.setBackgroundColor(0);
        this.f9826c.setPadding(0, 0, CommonUtils.dip2px(getContext(), 20.0f), 0);
        this.f9826c.setOrientation(1);
        this.f9826c.addView(view, new LinearLayout.LayoutParams(-2, -2));
        this.f9826c.mo435a(view, z);
        this.f9825b.removeAllViews();
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (i2 > displayMetrics.heightPixels / 3) {
            this.f9825b.addView(this.f9826c, -2, displayMetrics.heightPixels / 3);
        } else {
            this.f9825b.addView(this.f9826c, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: a */
    public void m13770a(Rect rect) {
        this.f9824a.m14488a(rect);
        if (!isShowing()) {
            show();
        }
    }

    /* renamed from: a */
    public void m13772a(Runnable runnable) {
        this.f9827d = runnable;
    }

    public void dismiss() {
        super.dismiss();
        if (this.f9827d != null) {
            this.f9827d.run();
        }
    }
}
