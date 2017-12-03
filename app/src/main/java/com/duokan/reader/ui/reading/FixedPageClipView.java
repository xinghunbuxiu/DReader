package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.bookshelf.hh;
import com.duokan.reader.ui.general.BubbleFloatingView;

import org.apache.http.HttpStatus;

public class FixedPageClipView extends FrameLayout {
    private RectF[] a = new RectF[1];
    private final iy b;
    private final BubbleFloatingView c;
    private final hh d;
    private final sh e;
    private final Drawable f;
    private final ja g;

    public enum ClipIndicator {
        UNKNOW,
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM,
        CENTER_TOP,
        CENTER_BOTTOM,
        CENTER_CENTER
    }

    public FixedPageClipView(Context context, sh shVar, ja jaVar) {
        super(context);
        this.g = jaVar;
        this.e = shVar;
        this.f = getResources().getDrawable(e.reading__fixed_page_view__clip_slider);
        this.d = shVar.b();
        this.b = new iy(this, context, shVar);
        addView(this.b, new LayoutParams(-1, -1));
        this.c = new BubbleFloatingView(context);
        this.c.a(LayoutInflater.from(context).inflate(g.reading__page_clip_tool_view, null), new LayoutParams(-2, UTools.closeAnimation(getContext(), 40.0f)));
        addView(this.c);
        a();
    }

    public ClipIndicator a(PointF pointF) {
        return this.b.a(pointF);
    }

    public void a(ClipIndicator clipIndicator, PointF pointF, int i) {
        if (i == 1) {
            b();
            return;
        }
        this.c.setVisibility(4);
        this.b.a(clipIndicator, pointF, i);
    }

    private void a() {
        View findViewById = this.c.findViewById(f.reading__page_clip_tool_view__odd_even_symmetry);
        findViewById.setSelected(!this.d.h());
        findViewById.setOnClickListener(new it(this, findViewById));
        this.c.findViewById(f.reading__page_clip_tool_view__rollback).setOnClickListener(new iu(this));
        if (this.d.i()) {
            this.c.findViewById(f.reading__page_clip_tool_view__rollback).setVisibility(8);
        } else {
            this.c.findViewById(f.reading__page_clip_tool_view__rollback).setVisibility(0);
        }
        this.c.findViewById(f.reading__page_clip_tool_view__cancel).setOnClickListener(new iv(this));
        this.c.findViewById(f.reading__page_clip_tool_view__ok).setOnClickListener(new iw(this, findViewById));
    }

    private void b() {
        this.c.setVisibility(0);
        this.a[0] = new RectF(this.b.c());
        RectF rectF = this.a[0];
        rectF.top -= (float) (this.f.getIntrinsicHeight() / 2);
        rectF = this.a[0];
        rectF.bottom += (float) (this.f.getIntrinsicHeight() / 2);
        this.c.a(this.a, false, (int) HttpStatus.SC_MULTIPLE_CHOICES);
    }
}
