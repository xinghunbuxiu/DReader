package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.aw;

public class pg extends fz {
    /* renamed from: a */
    private final aw f10779a;
    /* renamed from: b */
    private final pi f10780b = new pi(this, getContext());

    public pg(Context context, gs gsVar, aw awVar, Rect rect) {
        super(context, gsVar, rect, awVar);
        this.f10779a = awVar;
        getWatchingView().m14203a(this.f10780b, new LayoutParams(-2, -2));
        setDrawBorder(false);
        View imageView = new ImageView(getContext());
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageDrawable(getResources().getDrawable(C0243e.reading__shared__expand_poster));
        imageView.setOnClickListener(new ph(this));
        Rect a = gsVar.mo2332h().mo1291a(this.f10779a);
        int b = AnimUtils.m1932b(context, 15.0f);
        View frameLayout = new FrameLayout(context);
        frameLayout.setPadding(b, b, (rect.right - a.right) + b, (rect.bottom - a.bottom) + b);
        frameLayout.addView(imageView, new LayoutParams(-2, -2));
        m14166a(frameLayout, new LayoutParams(-2, -2, 85));
        mo2409n();
    }

    /* renamed from: a */
    public gd mo2403a(au auVar) {
        return new pl(this, getContext());
    }

    /* renamed from: a */
    public boolean mo2467a() {
        return false;
    }

    /* renamed from: b */
    public boolean mo2468b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo2469c() {
        return false;
    }

    /* renamed from: d */
    public void mo2470d() {
    }

    /* renamed from: e */
    public void mo2471e() {
    }
}
