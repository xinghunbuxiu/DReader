package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.AppManage;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.IScreenRotationChangedListener;
import com.duokan.core.ui.C0394t;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dn;
import com.duokan.core.ui.dv;
import com.duokan.kernel.DkUtils;
import com.duokan.p023b.C0243e;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.ax;

class pm extends FrameLayout {
    /* renamed from: a */
    private final gx f10797a;
    /* renamed from: b */
    private C0394t f10798b = null;
    /* renamed from: c */
    private boolean f10799c = false;

    public pm(Context context, gx gxVar) {
        super(context);
        this.f10797a = gxVar;
        Rect bounds = this.f10797a.getPageDrawable().getBounds();
        Rect a = this.f10797a.getPageDrawable().mo1340p().m6083a();
        int y = this.f10797a.getPageDrawable().mo1355y();
        for (int i = 0; i < y; i++) {
            Rect t = this.f10797a.getPageDrawable().mo1348t(i);
            View imageView = new ImageView(getContext());
            Drawable drawable = getResources().getDrawable(C0243e.reading__shared__preformatted_text);
            int intrinsicWidth = drawable.getIntrinsicWidth() - dv.m1932b(getContext(), 8.0f);
            int intrinsicHeight = drawable.getIntrinsicHeight() - dv.m1932b(getContext(), 8.0f);
            imageView.setImageDrawable(drawable);
            imageView.setOnClickListener(new pn(this, i));
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 51);
            layoutParams.leftMargin = t.right - intrinsicWidth;
            layoutParams.topMargin = t.bottom - intrinsicHeight;
            layoutParams.leftMargin = Math.max(bounds.left + a.left, Math.min(layoutParams.leftMargin, (bounds.right - a.right) - intrinsicWidth));
            layoutParams.topMargin = Math.max(bounds.top + a.top, Math.min(layoutParams.topMargin, (bounds.bottom - a.bottom) - intrinsicHeight));
            addView(imageView, layoutParams);
        }
    }

    public void dispatchDraw(Canvas canvas) {
        if (canvas.getDrawFilter() == null || !(canvas.getDrawFilter() instanceof or) || !((or) canvas.getDrawFilter()).m14833b()) {
            super.dispatchDraw(canvas);
        }
    }

    /* renamed from: a */
    private void m14917a(int i) {
        su suVar = (su) AppContext.getAppContext(getContext()).queryFeature(su.class);
        as pageDrawable = this.f10797a.getPageDrawable();
        ax s = pageDrawable.mo1346s(i);
        Rect t = pageDrawable.mo1348t(i);
        Bitmap c = C0544a.m2447c(this.f10797a.getWidth() / 2, this.f10797a.getHeight() / 2, Config.ARGB_8888);
        Canvas canvas = new Canvas(c);
        DrawFilter orVar = new or();
        orVar.m14832a();
        canvas.setDrawFilter(orVar);
        canvas.scale(0.5f, 0.5f);
        this.f10797a.draw(canvas);
        View imageView = new ImageView(getContext());
        imageView.setImageDrawable(pageDrawable.mo1342q().f4353a.mutate());
        imageView.setScaleType(ScaleType.FIT_XY);
        View imageView2 = new ImageView(getContext());
        DkUtils.blurBitmap(c, 8);
        imageView2.setImageBitmap(c);
        imageView2.setScaleType(ScaleType.FIT_XY);
        View xxVar = new xx(getContext(), s.mo1423b());
        xxVar.setTextSize(pageDrawable.mo1340p().f4335f);
        View zoomView = new ZoomView(getContext());
        int b = dv.m1932b(getContext(), 5.0f);
        int b2 = dv.m1932b(getContext(), 10.0f);
        zoomView.setThumbEnabled(false);
        zoomView.setClipChildren(false);
        zoomView.setClipToPadding(false);
        zoomView.setPadding(b, b2, b, b2);
        zoomView.mo435a(xxVar, true);
        zoomView.setMaxOverScrollWidth(dv.m1959f(getContext()));
        zoomView.setMaxOverScrollHeight(dv.m1962g(getContext()));
        zoomView.addView(xxVar, new LayoutParams(s.mo1422a(), s.mo1423b().m6411c()));
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
        IScreenRotationChangedListener poVar = new po(this, xxVar, diVar, zoomView);
        diVar.getViewTreeObserver().addOnPreDrawListener(new pr(this, xxVar, dlVar5, t, zoomView, diVar, imageView, dlVar, dlVar2, imageView2, dlVar3, dlVar4, dlVar6, poVar));
        pt ptVar = new pt(this, xxVar, diVar, zoomView, poVar, imageView, dlVar, imageView2, dlVar3, dlVar5);
        zoomView.setOnClickListener(new pw(this, zoomView, ptVar));
        this.f10798b = new px(this, getContext(), ptVar);
        this.f10798b.setCancelOnBack(false);
        this.f10798b.setCancelOnTouchOutside(false);
        ((BaseActivity) AppManage.getCurrentActivity(getContext())).lockCurrentOrientation();
        this.f10798b.setGravity(17);
        this.f10798b.setContentView(diVar, new LayoutParams(suVar.mo2183y(), suVar.mo2184z()));
        this.f10798b.show();
    }
}
