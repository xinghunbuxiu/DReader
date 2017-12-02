package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.DkSimulationInterpolator;
import com.duokan.reader.ui.general.DkSimulationInterpolator.Mode;

class cn extends FrameLayout {
    final /* synthetic */ bk a;
    private final float b = 1.1f;
    private final float c = 0.9f;
    private final cz d = new cz(getContext());
    private final PointF e = new PointF();
    private final PointF f = new PointF();
    private final PointF g = new PointF();
    private final RectF h = new RectF();
    private AlphaAnimation i = null;
    private float j = 1.0f;
    private float k = 1.0f;
    private Runnable l = null;

    public cn(bk bkVar, Context context, cz czVar) {
        this.a = bkVar;
        super(context);
        this.d.setItemData(czVar.getItem());
        this.d.setItemStatus(DragItemStatus.Dragging);
        this.d.b();
        addView(this.d, czVar.getWidth(), czVar.getHeight());
        this.e.set(czVar.getDragBounds().width() / 2.0f, czVar.getDragBounds().height() / 2.0f);
        dv.d(this.e, (View) czVar);
        this.g.set(this.e);
        this.f.set(czVar.getViewCenter());
        setStaticTransformationsEnabled(true);
        setClipChildren(false);
        a();
    }

    public void a() {
        a(1.1f, 300);
    }

    public void b() {
        a(0.9f, 300);
    }

    public void a(int i, int i2) {
        this.e.offset((float) i, (float) i2);
        this.f.offset((float) i, (float) i2);
        getChildAt(0).invalidate();
    }

    public PointF c() {
        return this.f;
    }

    public void a(RectF rectF) {
        float width = this.d.getViewBounds().width();
        width *= this.j;
        float height = this.d.getViewBounds().height() * this.j;
        float f = this.f.x - (width / 2.0f);
        float f2 = this.f.y - (height / 2.0f);
        rectF.set(f, f2, width + f, height + f2);
    }

    public void a(PointF pointF) {
        this.g.set(pointF);
    }

    public void a(Rect rect, long j, Runnable runnable) {
        this.h.set(rect);
        this.l = runnable;
        a(0.42105263f, j);
    }

    public void a(long j, Runnable runnable) {
        float f = this.e.x;
        float f2 = this.e.y;
        float f3 = this.g.x;
        float f4 = this.g.y;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DkSimulationInterpolator(Mode.DECELERATE));
        alphaAnimation.initialize(0, 0, 0, 0);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new co(this, runnable));
        Runnable cpVar = new cp(this, alphaAnimation, f, f3, f2, f4);
        a(1.0f, j);
        cpVar.run();
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        float f;
        PointF pointF = (PointF) dv.f.a();
        pointF.set(this.e);
        dv.b(pointF, (View) this);
        transformation.clear();
        transformation.setTransformationType(2);
        if (this.i == null) {
            this.j = this.k;
        } else if (!this.i.hasEnded()) {
            Transformation transformation2 = new Transformation();
            this.i.getTransformation(AnimationUtils.currentAnimationTimeMillis(), transformation2);
            this.j = (transformation2.getAlpha() * (this.k - this.j)) + this.j;
        }
        float width = ((float) this.d.getWidth()) / 2.0f;
        float height = ((float) this.d.getHeight()) / 2.0f;
        transformation.getMatrix().preTranslate(width, height);
        transformation.getMatrix().preScale(this.j, this.j);
        if (this.h.isEmpty()) {
            f = ((this.j - 1.0f) / 2.0f) + 1.0f;
            width = pointF.x - (((float) this.d.getWidth()) * f);
            f = pointF.y - (f * ((float) this.d.getHeight()));
        } else {
            Rect rect = (Rect) dv.g.a();
            this.d.getItemDrawable().getPadding(rect);
            float centerX = (((-width) - ((float) (rect.left / 2))) + this.h.centerX()) - ((this.h.width() * this.j) / 2.0f);
            width = (((-height) - ((float) (rect.top / 2))) + this.h.centerY()) - ((this.h.height() * this.j) / 2.0f);
            dv.g.a(rect);
            f = width;
            width = centerX;
        }
        transformation.getMatrix().postTranslate(width, f);
        dv.f.a(pointF);
        return true;
    }

    private void a(float f, float f2) {
        this.e.set(f, f2);
        getChildAt(0).invalidate();
    }

    private void a(float f, long j) {
        if (this.i != null) {
            this.i.cancel();
            this.i = null;
        }
        this.k = f;
        this.i = new AlphaAnimation(0.0f, 1.0f);
        this.i.setFillEnabled(true);
        this.i.setFillAfter(true);
        this.i.setDuration(j);
        this.i.start();
        post(new cq(this));
    }
}
