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
import com.duokan.core.ui.C0343f;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ui.general.BubbleFloatingView;
import org.apache.http.HttpStatus;

public class agc extends C0343f {
    /* renamed from: a */
    private final su f9712a;
    /* renamed from: b */
    private BubbleFloatingView f9713b;
    /* renamed from: c */
    private ViewGroup f9714c;
    /* renamed from: d */
    private LinearScrollView f9715d;
    /* renamed from: e */
    private Runnable f9716e;

    public agc(Context context, su suVar) {
        super(context);
        this.f9712a = suVar;
        this.f9713b = (BubbleFloatingView) LayoutInflater.from(context).inflate(C0256h.general__bubble_floating_view, null);
        this.f9713b.setOnTouchListener(new agd(this));
        this.f9713b.setCenterViewResource(C0256h.reading__note_view);
        this.f9714c = (ViewGroup) this.f9713b.getCenterView();
        this.f9714c.setBackgroundResource(C0254f.reading__shared__floating_background1);
        int b = dv.m1932b(getContext(), 8.0f);
        this.f9713b.m9924a(b, b, b, b);
        this.f9713b.setUpArrow(C0254f.reading__shared__floating_top_pointer1);
        this.f9713b.setDownArrow(C0254f.reading__shared__floating_bottom_pointer1);
        setDimAmount(0.0f);
        setContentView(this.f9713b, new LayoutParams(-1, -1));
    }

    public agc(Context context, OnClickListener onClickListener, su suVar) {
        this(context, suVar);
        this.f9714c.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    public void m13664a(View view, int i, int i2, boolean z) {
        this.f9715d = new LinearScrollView(getContext());
        this.f9715d.setFadingEdgeLength(0);
        this.f9715d.setClipChildren(true);
        this.f9715d.setBackgroundColor(0);
        this.f9715d.setPadding(0, 0, dv.m1932b(getContext(), 8.0f), 0);
        int b = dv.m1932b(getContext(), 25.0f);
        this.f9714c.setPadding(b, b, dv.m1932b(getContext(), 17.0f), b);
        this.f9715d.setOrientation(1);
        this.f9715d.addView(view, new LinearLayout.LayoutParams(-2, -2));
        this.f9715d.mo435a(view, z);
        this.f9714c.removeAllViews();
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (i2 > displayMetrics.heightPixels / 3) {
            this.f9714c.addView(this.f9715d, -2, displayMetrics.heightPixels / 3);
        } else {
            this.f9714c.addView(this.f9715d, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: a */
    public void m13663a(Rect rect) {
        int b = dv.m1932b(getContext(), 2.0f);
        rect.top -= b;
        rect.bottom = b + rect.bottom;
        this.f9713b.m9926a(new Rect[]{rect}, true, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        if (!isShowing()) {
            show();
        }
    }

    /* renamed from: a */
    public void m13665a(Runnable runnable) {
        this.f9716e = runnable;
    }

    public void dismiss() {
        super.dismiss();
        if (this.f9716e != null) {
            this.f9716e.run();
        }
    }
}
