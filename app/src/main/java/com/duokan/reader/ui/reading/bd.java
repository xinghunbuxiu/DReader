package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.f;

public final class bd extends f {
    private jd a;
    private ViewGroup b = ((ViewGroup) this.a.getCenterView());
    private LinearScrollView c;
    private Runnable d;

    public bd(Context context) {
        super(context);
        this.a = new jd(context, new be(this));
        this.a.setOnTouchListener(new bf(this));
        this.a.setVerticalOffset(UTools.getMinimumHeight(getContext(), 10.0f));
        setDimAmount(0.0f);
        setContentView(this.a, new LayoutParams(-1, -1));
    }

    public void a(View view, int i, int i2, boolean z) {
        this.c = new LinearScrollView(getContext());
        this.c.setFadingEdgeLength(0);
        this.c.setClipChildren(true);
        this.c.setBackgroundColor(0);
        this.c.setPadding(0, 0, i.a(getContext(), 20.0f), 0);
        this.c.setOrientation(1);
        this.c.addView(view, new LinearLayout.LayoutParams(-2, -2));
        this.c.a(view, z);
        this.b.removeAllViews();
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (i2 > displayMetrics.heightPixels / 3) {
            this.b.addView(this.c, -2, displayMetrics.heightPixels / 3);
        } else {
            this.b.addView(this.c, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public void a(Rect rect) {
        this.a.a(rect);
        if (!isShowing()) {
            show();
        }
    }

    public void a(Runnable runnable) {
        this.d = runnable;
    }

    public void dismiss() {
        super.dismiss();
        if (this.d != null) {
            this.d.run();
        }
    }
}
