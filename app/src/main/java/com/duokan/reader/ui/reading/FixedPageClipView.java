package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.domain.bookshelf.hb;
import com.duokan.reader.ui.general.BubbleFloatingView;
import org.apache.http.HttpStatus;

public class FixedPageClipView extends FrameLayout {
    /* renamed from: a */
    private RectF[] f9088a = new RectF[1];
    /* renamed from: b */
    private final ji f9089b;
    /* renamed from: c */
    private final BubbleFloatingView f9090c;
    /* renamed from: d */
    private final hb f9091d;
    /* renamed from: e */
    private final su f9092e;
    /* renamed from: f */
    private final Drawable f9093f;
    /* renamed from: g */
    private final jk f9094g;

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

    public FixedPageClipView(Context context, su suVar, jk jkVar) {
        super(context);
        this.f9094g = jkVar;
        this.f9092e = suVar;
        this.f9093f = getResources().getDrawable(C0243e.reading__fixed_page_view__clip_slider);
        this.f9091d = suVar.mo2095b();
        this.f9089b = new ji(this, context, suVar);
        addView(this.f9089b, new LayoutParams(-1, -1));
        this.f9090c = new BubbleFloatingView(context);
        this.f9090c.m9925a(LayoutInflater.from(context).inflate(C0245g.reading__page_clip_tool_view, null), new LayoutParams(-2, AnimUtils.m1932b(getContext(), 40.0f)));
        addView(this.f9090c);
        m12409a();
    }

    /* renamed from: a */
    public ClipIndicator m12416a(PointF pointF) {
        return this.f9089b.m14477a(pointF);
    }

    /* renamed from: a */
    public void m12417a(ClipIndicator clipIndicator, PointF pointF, int i) {
        if (i == 1) {
            m12411b();
            return;
        }
        this.f9090c.setVisibility(4);
        this.f9089b.m14478a(clipIndicator, pointF, i);
    }

    /* renamed from: a */
    private void m12409a() {
        View findViewById = this.f9090c.findViewById(C0244f.reading__page_clip_tool_view__odd_even_symmetry);
        findViewById.setSelected(!this.f9091d.m4627h());
        findViewById.setOnClickListener(new jd(this, findViewById));
        this.f9090c.findViewById(C0244f.reading__page_clip_tool_view__rollback).setOnClickListener(new je(this));
        if (this.f9091d.m4628i()) {
            this.f9090c.findViewById(C0244f.reading__page_clip_tool_view__rollback).setVisibility(8);
        } else {
            this.f9090c.findViewById(C0244f.reading__page_clip_tool_view__rollback).setVisibility(0);
        }
        this.f9090c.findViewById(C0244f.reading__page_clip_tool_view__cancel).setOnClickListener(new jf(this));
        this.f9090c.findViewById(C0244f.reading__page_clip_tool_view__ok).setOnClickListener(new jg(this, findViewById));
    }

    /* renamed from: b */
    private void m12411b() {
        this.f9090c.setVisibility(0);
        this.f9088a[0] = new RectF(this.f9089b.m14474c());
        RectF rectF = this.f9088a[0];
        rectF.top -= (float) (this.f9093f.getIntrinsicHeight() / 2);
        rectF = this.f9088a[0];
        rectF.bottom += (float) (this.f9093f.getIntrinsicHeight() / 2);
        this.f9090c.m9927a(this.f9088a, false, (int) HttpStatus.SC_MULTIPLE_CHOICES);
    }
}
