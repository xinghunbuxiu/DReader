package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.bx;
import com.duokan.core.ui.dv;
import org.apache.http.HttpStatus;

public class acf extends View {
    /* renamed from: a */
    static final /* synthetic */ boolean f9437a = (!acf.class.desiredAssertionStatus());
    /* renamed from: b */
    private acn f9438b = null;
    /* renamed from: c */
    private acn f9439c = null;
    /* renamed from: d */
    private ValueAnimator f9440d = null;
    /* renamed from: e */
    private ValueAnimator f9441e = null;
    /* renamed from: f */
    private final su f9442f = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class));
    /* renamed from: g */
    private final bx f9443g = new bx(getContext(), new AccelerateDecelerateInterpolator());
    /* renamed from: h */
    private final Rect f9444h = new Rect();
    /* renamed from: i */
    private final Rect f9445i = new Rect();
    /* renamed from: j */
    private final Rect f9446j = new Rect();
    /* renamed from: k */
    private final Rect f9447k = new Rect();
    /* renamed from: l */
    private final Rect f9448l = new Rect();
    /* renamed from: m */
    private final Paint f9449m = new Paint();

    public acf(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final float getFrameScale() {
        return this.f9438b != null ? this.f9438b.f9467h : 1.0f;
    }

    public final Point getProjectionCenter() {
        return this.f9438b != null ? this.f9438b.f9465f : new Point(0, 0);
    }

    /* renamed from: a */
    public final void m13310a(acc acc, Rect rect, Runnable runnable) {
        float min = Math.min(((float) getWidth()) / ((float) acc.mo2304a()), ((float) getHeight()) / ((float) acc.mo2306b()));
        int round = Math.round(((float) acc.mo2304a()) * min);
        int round2 = Math.round(min * ((float) acc.mo2306b()));
        this.f9438b = new acn();
        this.f9438b.f9460a = acc;
        this.f9438b.f9461b = acc.mo2305a(round, round2);
        this.f9438b.f9462c = 0.0f;
        this.f9438b.f9463d = 1.0f;
        this.f9438b.f9464e = new Point(rect.centerX(), rect.centerY());
        this.f9438b.f9465f = new Point(getWidth() / 2, getHeight() / 2);
        this.f9438b.f9466g = Math.min(((float) rect.width()) / ((float) this.f9438b.f9461b.getWidth()), ((float) rect.height()) / ((float) this.f9438b.f9461b.getHeight()));
        this.f9438b.f9467h = 1.0f;
        if (this.f9440d != null) {
            this.f9440d.cancel();
            this.f9440d = null;
        }
        this.f9440d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f9440d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f9440d.setDuration(500);
        this.f9440d.addUpdateListener(new acg(this));
        this.f9440d.addListener(new ach(this, runnable));
        this.f9440d.start();
        invalidate();
    }

    /* renamed from: a */
    public final void m13309a(Rect rect, Runnable runnable) {
        this.f9439c = new acn();
        this.f9439c.f9460a = this.f9438b.f9460a;
        this.f9439c.f9461b = this.f9438b.f9461b;
        this.f9439c.f9462c = 1.0f;
        this.f9439c.f9463d = 0.0f;
        this.f9439c.f9464e = this.f9438b.f9465f;
        this.f9439c.f9465f = new Point(rect.centerX(), rect.centerY());
        this.f9439c.f9466g = this.f9438b.f9467h;
        this.f9439c.f9467h = Math.min(((float) rect.width()) / ((float) this.f9438b.f9461b.getWidth()), ((float) rect.height()) / ((float) this.f9438b.f9461b.getHeight()));
        this.f9438b = null;
        if (this.f9440d != null) {
            this.f9440d.cancel();
            this.f9440d = null;
        }
        this.f9440d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f9440d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f9440d.setDuration(500);
        this.f9440d.addUpdateListener(new aci(this));
        this.f9440d.addListener(new acj(this, runnable));
        this.f9440d.start();
        invalidate();
    }

    /* renamed from: a */
    public final void m13311a(acc acc, boolean z, Runnable runnable) {
        if (this.f9438b != null) {
            this.f9439c = new acn();
            this.f9439c.f9460a = this.f9438b.f9460a;
            this.f9439c.f9461b = this.f9438b.f9461b;
            this.f9439c.f9462c = this.f9438b.f9463d;
            this.f9439c.f9463d = this.f9438b.f9462c;
            this.f9439c.f9464e = new Point(this.f9438b.f9465f);
            this.f9439c.f9465f = new Point(this.f9438b.f9465f);
            this.f9439c.f9466g = this.f9438b.f9467h;
            this.f9439c.f9467h = this.f9438b.f9467h;
        }
        float min = Math.min(((float) getWidth()) / ((float) acc.mo2304a()), ((float) getHeight()) / ((float) acc.mo2306b()));
        int round = Math.round(((float) acc.mo2304a()) * min);
        int round2 = Math.round(min * ((float) acc.mo2306b()));
        this.f9438b = new acn();
        this.f9438b.f9460a = acc;
        this.f9438b.f9461b = acc.mo2305a(round, round2);
        this.f9438b.f9462c = 0.0f;
        this.f9438b.f9463d = 1.0f;
        this.f9438b.f9464e = new Point(getWidth() / 2, getHeight() / 2);
        this.f9438b.f9465f = this.f9438b.f9464e;
        this.f9438b.f9466g = 1.0f;
        this.f9438b.f9467h = 1.0f;
        if (this.f9440d != null) {
            this.f9440d.cancel();
            this.f9440d = null;
        }
        this.f9440d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f9440d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f9440d.setDuration(z ? 500 : 0);
        this.f9440d.addUpdateListener(new ack(this));
        this.f9440d.addListener(new acl(this, runnable));
        this.f9440d.start();
        if (this.f9441e != null) {
            this.f9441e.cancel();
            this.f9441e = null;
        }
        this.f9443g.m1711a(true);
        invalidate();
    }

    /* renamed from: a */
    public final void m13305a(float f, float f2) {
        if (this.f9438b != null) {
            float scrollScaleX = f * getScrollScaleX();
            float scrollScaleY = f2 * getScrollScaleY();
            this.f9443g.m1711a(true);
            this.f9443g.m1709a(this.f9438b.f9465f.x, this.f9438b.f9465f.y, Math.round(scrollScaleX), Math.round(scrollScaleY), getMinScrollX(), getMaxScrollX(), getMinScrollY(), getMaxScrollY(), dv.m1959f(getContext()), dv.m1962g(getContext()));
            invalidate();
        }
    }

    /* renamed from: a */
    public final void m13306a(int i, int i2, boolean z) {
        if (this.f9438b != null) {
            int round = Math.round(((float) i) * getScrollScaleX());
            int round2 = Math.round(((float) i2) * getScrollScaleY());
            this.f9443g.m1711a(true);
            this.f9443g.m1708a(this.f9438b.f9465f.x, this.f9438b.f9465f.y, round, round2, z ? HttpStatus.SC_INTERNAL_SERVER_ERROR : 0);
            invalidate();
        }
    }

    /* renamed from: a */
    public final void m13308a(Point point, float f, boolean z) {
        int i = 0;
        if (this.f9438b != null) {
            if (this.f9441e != null) {
                this.f9441e.cancel();
                this.f9441e = null;
            }
            this.f9441e = ValueAnimator.ofFloat(new float[]{this.f9438b.f9467h, f});
            this.f9441e.setDuration(z ? 500 : 0);
            this.f9441e.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f9441e.addUpdateListener(new acm(this));
            this.f9441e.start();
            this.f9443g.m1711a(true);
            bx bxVar = this.f9443g;
            int i2 = this.f9438b.f9465f.x;
            int i3 = this.f9438b.f9465f.y;
            int i4 = point.x - this.f9438b.f9465f.x;
            int i5 = point.y - this.f9438b.f9465f.y;
            if (z) {
                i = HttpStatus.SC_INTERNAL_SERVER_ERROR;
            }
            bxVar.m1708a(i2, i3, i4, i5, i);
            invalidate();
        }
    }

    /* renamed from: a */
    public final void m13304a() {
        if (this.f9438b != null) {
            this.f9443g.m1711a(true);
            this.f9443g.m1708a(this.f9438b.f9465f.x, this.f9438b.f9465f.y, 0, 0, 0);
            this.f9443g.m1721h();
            this.f9443g.m1713a(this.f9438b.f9465f.x, this.f9438b.f9465f.y, getMinScrollX(), getMaxScrollX(), getMinScrollY(), getMaxScrollY());
            invalidate();
        }
    }

    /* renamed from: a */
    public final void m13307a(Point point, float f) {
        if (this.f9438b != null) {
            this.f9438b.f9467h *= f;
            int i = this.f9438b.f9465f.x - point.x;
            int i2 = this.f9438b.f9465f.y - point.y;
            this.f9438b.f9465f.x = Math.round((((float) i) * f) + ((float) point.x));
            this.f9438b.f9465f.y = Math.round((((float) i2) * f) + ((float) point.y));
            invalidate();
        }
    }

    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.f9440d == null || !this.f9440d.isRunning()) {
            this.f9440d = null;
            f = 1.0f;
        } else {
            f = ((Float) this.f9440d.getAnimatedValue()).floatValue();
        }
        if (this.f9439c != null) {
            int round = Math.round(((float) this.f9439c.f9464e.x) + (((float) (this.f9439c.f9465f.x - this.f9439c.f9464e.x)) * f));
            int round2 = Math.round(((float) this.f9439c.f9464e.y) + (((float) (this.f9439c.f9465f.y - this.f9439c.f9464e.y)) * f));
            float f2 = this.f9439c.f9466g + ((this.f9439c.f9467h - this.f9439c.f9466g) * f);
            int round3 = Math.round(((float) this.f9439c.f9461b.getWidth()) * f2);
            int round4 = Math.round(f2 * ((float) this.f9439c.f9461b.getHeight()));
            this.f9445i.set(0, 0, this.f9439c.f9461b.getWidth(), this.f9439c.f9461b.getHeight());
            this.f9446j.set(round - (round3 / 2), round2 - (round4 / 2), (round - (round3 / 2)) + round3, (round2 - (round4 / 2)) + round4);
        }
        if (this.f9438b != null) {
            if (this.f9441e == null || !this.f9441e.isRunning()) {
                this.f9441e = null;
            } else {
                this.f9438b.f9467h = ((Float) this.f9441e.getAnimatedValue()).floatValue();
            }
            if (!this.f9443g.m1712a()) {
                this.f9443g.m1721h();
                this.f9438b.f9465f.x = this.f9443g.m1714b();
                this.f9438b.f9465f.y = this.f9443g.m1716c();
                invalidate();
            }
            round = Math.round(((float) this.f9438b.f9464e.x) + (((float) (this.f9438b.f9465f.x - this.f9438b.f9464e.x)) * f));
            round2 = Math.round(((float) this.f9438b.f9464e.y) + (((float) (this.f9438b.f9465f.y - this.f9438b.f9464e.y)) * f));
            f2 = this.f9438b.f9466g + ((this.f9438b.f9467h - this.f9438b.f9466g) * f);
            round3 = Math.round(((float) this.f9438b.f9461b.getWidth()) * f2);
            round4 = Math.round(f2 * ((float) this.f9438b.f9461b.getHeight()));
            this.f9447k.set(0, 0, this.f9438b.f9461b.getWidth(), this.f9438b.f9461b.getHeight());
            this.f9448l.set(round - (round3 / 2), round2 - (round4 / 2), (round - (round3 / 2)) + round3, (round2 - (round4 / 2)) + round4);
        }
        if (this.f9439c == null && this.f9438b != null) {
            canvas.drawARGB(Math.round(f * 255.0f), 0, 0, 0);
        } else if (this.f9438b == null && this.f9439c != null) {
            canvas.drawARGB(Math.round((1.0f - f) * 255.0f), 0, 0, 0);
        } else if (!(this.f9438b == null || this.f9439c == null)) {
            canvas.drawARGB(255, 0, 0, 0);
        }
        if (!(this.f9439c == null || this.f9438b == null)) {
            this.f9444h.set(this.f9446j);
            Rect rect = this.f9444h;
            rect.left += Math.round(((float) (this.f9448l.left - this.f9446j.left)) * f);
            rect = this.f9444h;
            rect.top += Math.round(((float) (this.f9448l.top - this.f9446j.top)) * f);
            rect = this.f9444h;
            rect.right += Math.round(((float) (this.f9448l.right - this.f9446j.right)) * f);
            rect = this.f9444h;
            rect.bottom += Math.round(((float) (this.f9448l.bottom - this.f9446j.bottom)) * f);
            canvas.clipRect(this.f9444h);
        }
        if (this.f9439c != null) {
            this.f9449m.setAlpha(Math.round((this.f9439c.f9462c + ((this.f9439c.f9463d - this.f9439c.f9462c) * f)) * 255.0f));
            canvas.drawBitmap(this.f9439c.f9461b, this.f9445i, this.f9446j, this.f9449m);
        }
        if (this.f9438b != null) {
            this.f9449m.setAlpha(Math.round((this.f9438b.f9462c + (f * (this.f9438b.f9463d - this.f9438b.f9462c))) * 255.0f));
            canvas.drawBitmap(this.f9438b.f9461b, this.f9447k, this.f9448l, this.f9449m);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.f9438b != null) {
            float min = Math.min(((float) getWidth()) / ((float) this.f9438b.f9460a.mo2304a()), ((float) getHeight()) / ((float) this.f9438b.f9460a.mo2306b()));
            int round = Math.round(((float) this.f9438b.f9460a.mo2304a()) * min);
            int round2 = Math.round(min * ((float) this.f9438b.f9460a.mo2306b()));
            this.f9438b.f9461b = this.f9438b.f9460a.mo2305a(round, round2);
            this.f9438b.f9462c = 0.0f;
            this.f9438b.f9463d = 1.0f;
            this.f9438b.f9464e.set(getWidth() / 2, getHeight() / 2);
            this.f9438b.f9465f = this.f9438b.f9464e;
            this.f9438b.f9466g = 1.0f;
            this.f9438b.f9467h = 1.0f;
        }
    }

    private final float getScrollScaleX() {
        float minOverScrollX = (float) getMinOverScrollX();
        float maxOverScrollX = (float) getMaxOverScrollX();
        float minScrollX = (float) getMinScrollX();
        float maxScrollX = (float) getMaxScrollX();
        float f = (float) this.f9438b.f9465f.x;
        if (Float.compare(f, minScrollX) <= 0) {
            if (Float.compare(minOverScrollX, 0.0f) == 0) {
                minOverScrollX = 0.0f;
            } else if (Float.compare(f, minOverScrollX) <= 0) {
                minOverScrollX = 0.0f;
            } else {
                minOverScrollX = Math.abs((f - minOverScrollX) / (minScrollX - minOverScrollX));
            }
        } else if (Float.compare(f, maxScrollX) < 0) {
            minOverScrollX = 1.0f;
        } else if (Float.compare(maxOverScrollX, 0.0f) == 0) {
            minOverScrollX = 0.0f;
        } else if (Float.compare(f, maxOverScrollX) >= 0) {
            minOverScrollX = 0.0f;
        } else {
            minOverScrollX = Math.abs((f - maxOverScrollX) / (maxScrollX - maxOverScrollX));
        }
        if (f9437a || Float.compare(f, 0.0f) >= 0) {
            return minOverScrollX;
        }
        throw new AssertionError();
    }

    private final float getScrollScaleY() {
        float minOverScrollY = (float) getMinOverScrollY();
        float maxOverScrollY = (float) getMaxOverScrollY();
        float minScrollY = (float) getMinScrollY();
        float maxScrollY = (float) getMaxScrollY();
        float f = (float) this.f9438b.f9465f.y;
        if (Float.compare(f, minScrollY) <= 0) {
            if (Float.compare(minOverScrollY, 0.0f) == 0) {
                minOverScrollY = 0.0f;
            } else if (Float.compare(f, minOverScrollY) <= 0) {
                minOverScrollY = 0.0f;
            } else {
                minOverScrollY = Math.abs((f - minOverScrollY) / (minScrollY - minOverScrollY));
            }
        } else if (Float.compare(f, maxScrollY) < 0) {
            minOverScrollY = 1.0f;
        } else if (Float.compare(maxOverScrollY, 0.0f) == 0) {
            minOverScrollY = 0.0f;
        } else if (Float.compare(f, maxOverScrollY) >= 0) {
            minOverScrollY = 0.0f;
        } else {
            minOverScrollY = Math.abs((f - maxOverScrollY) / (maxScrollY - maxOverScrollY));
        }
        if (f9437a || Float.compare(f, 0.0f) >= 0) {
            return minOverScrollY;
        }
        throw new AssertionError();
    }

    private final int getMinOverScrollX() {
        return Float.compare(((float) this.f9438b.f9461b.getWidth()) * this.f9438b.f9467h, (float) getWidth()) <= 0 ? getMinScrollX() : getMinScrollX() - dv.m1959f(getContext());
    }

    private final int getMaxOverScrollX() {
        return Float.compare(((float) this.f9438b.f9461b.getWidth()) * this.f9438b.f9467h, (float) getWidth()) <= 0 ? getMaxScrollX() : getMaxScrollX() + dv.m1959f(getContext());
    }

    private final int getMinOverScrollY() {
        return Float.compare(((float) this.f9438b.f9461b.getHeight()) * this.f9438b.f9467h, (float) getHeight()) <= 0 ? getMinScrollY() : getMinScrollY() - dv.m1962g(getContext());
    }

    private final int getMaxOverScrollY() {
        return Float.compare(((float) this.f9438b.f9461b.getHeight()) * this.f9438b.f9467h, (float) getHeight()) <= 0 ? getMaxScrollY() : getMaxScrollY() + dv.m1962g(getContext());
    }

    private int getMinScrollX() {
        return (getWidth() / 2) - Math.max(0, Math.round(((((float) this.f9438b.f9461b.getWidth()) * this.f9438b.f9467h) - ((float) getWidth())) / 2.0f));
    }

    private int getMaxScrollX() {
        return (getWidth() / 2) + Math.max(0, Math.round(((((float) this.f9438b.f9461b.getWidth()) * this.f9438b.f9467h) - ((float) getWidth())) / 2.0f));
    }

    private int getMinScrollY() {
        return (getHeight() / 2) - Math.max(0, Math.round(((((float) this.f9438b.f9461b.getHeight()) * this.f9438b.f9467h) - ((float) getHeight())) / 2.0f));
    }

    private int getMaxScrollY() {
        return (getHeight() / 2) + Math.max(0, Math.round(((((float) this.f9438b.f9461b.getHeight()) * this.f9438b.f9467h) - ((float) getHeight())) / 2.0f));
    }
}
