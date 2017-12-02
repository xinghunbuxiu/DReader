package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.duokan.b.e;
import com.duokan.core.app.b;
import com.duokan.core.app.m;
import com.duokan.core.app.s;
import com.duokan.core.app.x;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dn;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.t;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.common.bitmap.a;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.ax;

class pc extends FrameLayout {
    private final gs a;
    private t b = null;
    private boolean c = false;

    public pc(Context context, gs gsVar) {
        super(context);
        this.a = gsVar;
        Rect bounds = this.a.getPageDrawable().getBounds();
        Rect a = this.a.getPageDrawable().p().a();
        int y = this.a.getPageDrawable().y();
        for (int i = 0; i < y; i++) {
            Rect t = this.a.getPageDrawable().t(i);
            View imageView = new ImageView(getContext());
            Drawable drawable = getResources().getDrawable(e.reading__shared__preformatted_text);
            int intrinsicWidth = drawable.getIntrinsicWidth() - dv.b(getContext(), 8.0f);
            int intrinsicHeight = drawable.getIntrinsicHeight() - dv.b(getContext(), 8.0f);
            imageView.setImageDrawable(drawable);
            imageView.setOnClickListener(new pd(this, i));
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 51);
            layoutParams.leftMargin = t.right - intrinsicWidth;
            layoutParams.topMargin = t.bottom - intrinsicHeight;
            layoutParams.leftMargin = Math.max(bounds.left + a.left, Math.min(layoutParams.leftMargin, (bounds.right - a.right) - intrinsicWidth));
            layoutParams.topMargin = Math.max(bounds.top + a.top, Math.min(layoutParams.topMargin, (bounds.bottom - a.bottom) - intrinsicHeight));
            addView(imageView, layoutParams);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        if (canvas.getDrawFilter() == null || !(canvas.getDrawFilter() instanceof oh) || !((oh) canvas.getDrawFilter()).b()) {
            super.dispatchDraw(canvas);
        }
    }

    private void a(int i) {
        sh shVar = (sh) x.a(getContext()).queryFeature(sh.class);
        as pageDrawable = this.a.getPageDrawable();
        ax s = pageDrawable.s(i);
        Rect t = pageDrawable.t(i);
        Bitmap c = a.c(this.a.getWidth() / 2, this.a.getHeight() / 2, Config.ARGB_8888);
        Canvas canvas = new Canvas(c);
        DrawFilter ohVar = new oh();
        ohVar.a();
        canvas.setDrawFilter(ohVar);
        canvas.scale(0.5f, 0.5f);
        this.a.draw(canvas);
        View imageView = new ImageView(getContext());
        imageView.setImageDrawable(pageDrawable.q().a.mutate());
        imageView.setScaleType(ScaleType.FIT_XY);
        View imageView2 = new ImageView(getContext());
        DkUtils.blurBitmap(c, 8);
        imageView2.setImageBitmap(c);
        imageView2.setScaleType(ScaleType.FIT_XY);
        View xkVar = new xk(getContext(), s.b());
        xkVar.setTextSize(pageDrawable.p().f);
        View zoomView = new ZoomView(getContext());
        int b = dv.b(getContext(), 5.0f);
        int b2 = dv.b(getContext(), 10.0f);
        zoomView.setThumbEnabled(false);
        zoomView.setClipChildren(false);
        zoomView.setClipToPadding(false);
        zoomView.setPadding(b, b2, b, b2);
        zoomView.a(xkVar, true);
        zoomView.setMaxOverScrollWidth(dv.f(getContext()));
        zoomView.setMaxOverScrollHeight(dv.g(getContext()));
        zoomView.addView(xkVar, new LayoutParams(s.a(), s.b().c()));
        View diVar = new di(getContext());
        diVar.addView(imageView, new dn(-1, -1, 17));
        diVar.addView(imageView2, new dn(-1, -1, 17));
        diVar.addView(zoomView, new dn(-1, -1, 17));
        dl dlVar = new dl(0.0f);
        dl dlVar2 = new dl(1.0f);
        dl dlVar3 = new dl(0.0f);
        dl dlVar4 = new dl(0.2f);
        dl dlVar5 = new dl(0.0f);
        dl dlVar6 = new dl(1.0f);
        s peVar = new pe(this, xkVar, diVar, zoomView);
        diVar.getViewTreeObserver().addOnPreDrawListener(new ph(this, xkVar, dlVar5, t, zoomView, diVar, imageView, dlVar, dlVar2, imageView2, dlVar3, dlVar4, dlVar6, peVar));
        pj pjVar = new pj(this, xkVar, diVar, zoomView, peVar, imageView, dlVar, imageView2, dlVar3, dlVar5);
        zoomView.setOnClickListener(new pm(this, zoomView, pjVar));
        this.b = new pn(this, getContext(), pjVar);
        this.b.setCancelOnBack(false);
        this.b.setCancelOnTouchOutside(false);
        ((m) b.a(getContext())).lockCurrentOrientation();
        this.b.setGravity(17);
        this.b.setContentView(diVar, new LayoutParams(shVar.y(), shVar.z()));
        this.b.show();
    }
}
