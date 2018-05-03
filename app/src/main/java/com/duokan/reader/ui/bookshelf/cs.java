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
import com.duokan.core.ui.AnimUtils;
import com.duokan.reader.ui.general.DkSimulationInterpolator;
import com.duokan.reader.ui.general.DkSimulationInterpolator.Mode;

class cs extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ bp f6291a;
    /* renamed from: b */
    private final float f6292b = 1.1f;
    /* renamed from: c */
    private final float f6293c = 0.9f;
    /* renamed from: d */
    private final de f6294d = new de(getContext());
    /* renamed from: e */
    private final PointF f6295e = new PointF();
    /* renamed from: f */
    private final PointF f6296f = new PointF();
    /* renamed from: g */
    private final PointF f6297g = new PointF();
    /* renamed from: h */
    private final RectF f6298h = new RectF();
    /* renamed from: i */
    private AlphaAnimation f6299i = null;
    /* renamed from: j */
    private float f6300j = 1.0f;
    /* renamed from: k */
    private float f6301k = 1.0f;
    /* renamed from: l */
    private Runnable f6302l = null;

    public cs(bp bpVar, Context context, de deVar) {
        this.f6291a = bpVar;
        super(context);
        this.f6294d.setItemData(deVar.getItem());
        this.f6294d.setItemStatus(DragItemStatus.Dragging);
        this.f6294d.m9114b();
        addView(this.f6294d, deVar.getWidth(), deVar.getHeight());
        this.f6295e.set(deVar.getDragBounds().width() / 2.0f, deVar.getDragBounds().height() / 2.0f);
        AnimUtils.m1953d(this.f6295e, (View) deVar);
        this.f6297g.set(this.f6295e);
        this.f6296f.set(deVar.getViewCenter());
        setStaticTransformationsEnabled(true);
        setClipChildren(false);
        m9423a();
    }

    /* renamed from: a */
    public void m9423a() {
        m9419a(1.1f, 300);
    }

    /* renamed from: b */
    public void m9429b() {
        m9419a(0.9f, 300);
    }

    /* renamed from: a */
    public void m9424a(int i, int i2) {
        this.f6295e.offset((float) i, (float) i2);
        this.f6296f.offset((float) i, (float) i2);
        getChildAt(0).invalidate();
    }

    /* renamed from: c */
    public PointF m9430c() {
        return this.f6296f;
    }

    /* renamed from: a */
    public void m9428a(RectF rectF) {
        float width = this.f6294d.getViewBounds().width();
        width *= this.f6300j;
        float height = this.f6294d.getViewBounds().height() * this.f6300j;
        float f = this.f6296f.x - (width / 2.0f);
        float f2 = this.f6296f.y - (height / 2.0f);
        rectF.set(f, f2, width + f, height + f2);
    }

    /* renamed from: a */
    public void m9426a(PointF pointF) {
        this.f6297g.set(pointF);
    }

    /* renamed from: a */
    public void m9427a(Rect rect, long j, Runnable runnable) {
        this.f6298h.set(rect);
        this.f6302l = runnable;
        m9419a(0.42105263f, j);
    }

    /* renamed from: a */
    public void m9425a(long j, Runnable runnable) {
        float f = this.f6295e.x;
        float f2 = this.f6295e.y;
        float f3 = this.f6297g.x;
        float f4 = this.f6297g.y;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DkSimulationInterpolator(Mode.DECELERATE));
        alphaAnimation.initialize(0, 0, 0, 0);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new ct(this, runnable));
        Runnable cuVar = new cu(this, alphaAnimation, f, f3, f2, f4);
        m9419a(1.0f, j);
        cuVar.run();
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        float f;
        PointF pointF = (PointF) AnimUtils.f1197f.addAnimation();
        pointF.set(this.f6295e);
        AnimUtils.m1935b(pointF, (View) this);
        transformation.clear();
        transformation.setTransformationType(2);
        if (this.f6299i == null) {
            this.f6300j = this.f6301k;
        } else if (!this.f6299i.hasEnded()) {
            Transformation transformation2 = new Transformation();
            this.f6299i.getTransformation(AnimationUtils.currentAnimationTimeMillis(), transformation2);
            this.f6300j = (transformation2.getAlpha() * (this.f6301k - this.f6300j)) + this.f6300j;
        }
        float width = ((float) this.f6294d.getWidth()) / 2.0f;
        float height = ((float) this.f6294d.getHeight()) / 2.0f;
        transformation.getMatrix().preTranslate(width, height);
        transformation.getMatrix().preScale(this.f6300j, this.f6300j);
        if (this.f6298h.isEmpty()) {
            f = ((this.f6300j - 1.0f) / 2.0f) + 1.0f;
            width = pointF.x - (((float) this.f6294d.getWidth()) * f);
            f = pointF.y - (f * ((float) this.f6294d.getHeight()));
        } else {
            Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
            this.f6294d.getItemDrawable().getPadding(rect);
            float centerX = (((-width) - ((float) (rect.left / 2))) + this.f6298h.centerX()) - ((this.f6298h.width() * this.f6300j) / 2.0f);
            width = (((-height) - ((float) (rect.top / 2))) + this.f6298h.centerY()) - ((this.f6298h.height() * this.f6300j) / 2.0f);
            AnimUtils.f1198g.clearAnimation(rect);
            f = width;
            width = centerX;
        }
        transformation.getMatrix().postTranslate(width, f);
        AnimUtils.f1197f.clearAnimation(pointF);
        return true;
    }

    /* renamed from: a */
    private void m9418a(float f, float f2) {
        this.f6295e.set(f, f2);
        getChildAt(0).invalidate();
    }

    /* renamed from: a */
    private void m9419a(float f, long j) {
        if (this.f6299i != null) {
            this.f6299i.cancel();
            this.f6299i = null;
        }
        this.f6301k = f;
        this.f6299i = new AlphaAnimation(0.0f, 1.0f);
        this.f6299i.setFillEnabled(true);
        this.f6299i.setFillAfter(true);
        this.f6299i.setDuration(j);
        this.f6299i.start();
        post(new cv(this));
    }
}
