package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.duokan.c.h;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.f;
import com.duokan.reader.ui.general.BubbleFloatingView;

import org.apache.http.HttpStatus;

public class afc extends f {
    private final sh a;
    private BubbleFloatingView b;
    private ViewGroup c;
    private LinearScrollView d;
    private Runnable e;

    public afc(Context context, sh shVar) {
        super(context);
        this.a = shVar;
        this.b = (BubbleFloatingView) LayoutInflater.from(context).inflate(h.general__bubble_floating_view, null);
        this.b.setOnTouchListener(new afd(this));
        this.b.setCenterViewResource(h.reading__note_view);
        this.c = (ViewGroup) this.b.getCenterView();
        this.c.setBackgroundResource(com.duokan.c.f.reading__shared__floating_background1);
        int b = UTools.closeAnimation(getContext(), 8.0f);
        this.b.a(b, b, b, b);
        this.b.setUpArrow(com.duokan.c.f.reading__shared__floating_top_pointer1);
        this.b.setDownArrow(com.duokan.c.f.reading__shared__floating_bottom_pointer1);
        setDimAmount(0.0f);
        setContentView(this.b, new LayoutParams(-1, -1));
    }

    public afc(Context context, OnClickListener onClickListener, sh shVar) {
        this(context, shVar);
        this.c.setOnClickListener(onClickListener);
    }

    public void a(View view, int i, int i2, boolean z) {
        this.d = new LinearScrollView(getContext());
        this.d.setFadingEdgeLength(0);
        this.d.setClipChildren(true);
        this.d.setBackgroundColor(0);
        this.d.setPadding(0, 0, UTools.closeAnimation(getContext(), 8.0f), 0);
        int b = UTools.closeAnimation(getContext(), 25.0f);
        this.c.setPadding(b, b, UTools.closeAnimation(getContext(), 17.0f), b);
        this.d.setOrientation(1);
        this.d.addView(view, new LinearLayout.LayoutParams(-2, -2));
        this.d.a(view, z);
        this.c.removeAllViews();
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (i2 > displayMetrics.heightPixels / 3) {
            this.c.addView(this.d, -2, displayMetrics.heightPixels / 3);
        } else {
            this.c.addView(this.d, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    public void a(Rect rect) {
        int b = UTools.closeAnimation(getContext(), 2.0f);
        rect.top -= b;
        rect.bottom = b + rect.bottom;
        this.b.a(new Rect[]{rect}, true, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        if (!isShowing()) {
            show();
        }
    }

    public void a(Runnable runnable) {
        this.e = runnable;
    }

    public void dismiss() {
        super.dismiss();
        if (this.e != null) {
            this.e.run();
        }
    }
}
