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

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.bx;

import org.apache.http.HttpStatus;

public class abs extends View {
    static final /* synthetic */ boolean a = (!abs.class.desiredAssertionStatus());
    private aca b = null;
    private aca c = null;
    private ValueAnimator d = null;
    private ValueAnimator e = null;
    private final sh f = ((sh) MyContextWrapper.getFeature(getContext()).queryFeature(sh.class));
    private final bx g = new bx(getContext(), new AccelerateDecelerateInterpolator());
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final Rect j = new Rect();
    private final Rect k = new Rect();
    private final Rect l = new Rect();
    private final Paint m = new Paint();

    public abs(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final float getFrameScale() {
        return this.b != null ? this.b.h : 1.0f;
    }

    public final Point getProjectionCenter() {
        return this.b != null ? this.b.f : new Point(0, 0);
    }

    public final void a(abp com_duokan_reader_ui_reading_abp, Rect rect, Runnable runnable) {
        float min = Math.min(((float) getWidth()) / ((float) com_duokan_reader_ui_reading_abp.a()), ((float) getHeight()) / ((float) com_duokan_reader_ui_reading_abp.b()));
        int round = Math.round(((float) com_duokan_reader_ui_reading_abp.a()) * min);
        int round2 = Math.round(min * ((float) com_duokan_reader_ui_reading_abp.b()));
        this.b = new aca();
        this.b.a = com_duokan_reader_ui_reading_abp;
        this.b.b = com_duokan_reader_ui_reading_abp.a(round, round2);
        this.b.c = 0.0f;
        this.b.d = 1.0f;
        this.b.e = new Point(rect.centerX(), rect.centerY());
        this.b.f = new Point(getWidth() / 2, getHeight() / 2);
        this.b.g = Math.min(((float) rect.width()) / ((float) this.b.b.getWidth()), ((float) rect.height()) / ((float) this.b.b.getHeight()));
        this.b.h = 1.0f;
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        this.d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.d.setDuration(500);
        this.d.addUpdateListener(new abt(this));
        this.d.addListener(new abu(this, runnable));
        this.d.start();
        invalidate();
    }

    public final void a(Rect rect, Runnable runnable) {
        this.c = new aca();
        this.c.a = this.b.a;
        this.c.b = this.b.b;
        this.c.c = 1.0f;
        this.c.d = 0.0f;
        this.c.e = this.b.f;
        this.c.f = new Point(rect.centerX(), rect.centerY());
        this.c.g = this.b.h;
        this.c.h = Math.min(((float) rect.width()) / ((float) this.b.b.getWidth()), ((float) rect.height()) / ((float) this.b.b.getHeight()));
        this.b = null;
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        this.d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.d.setDuration(500);
        this.d.addUpdateListener(new abv(this));
        this.d.addListener(new abw(this, runnable));
        this.d.start();
        invalidate();
    }

    public final void a(abp com_duokan_reader_ui_reading_abp, boolean z, Runnable runnable) {
        if (this.b != null) {
            this.c = new aca();
            this.c.a = this.b.a;
            this.c.b = this.b.b;
            this.c.c = this.b.d;
            this.c.d = this.b.c;
            this.c.e = new Point(this.b.f);
            this.c.f = new Point(this.b.f);
            this.c.g = this.b.h;
            this.c.h = this.b.h;
        }
        float min = Math.min(((float) getWidth()) / ((float) com_duokan_reader_ui_reading_abp.a()), ((float) getHeight()) / ((float) com_duokan_reader_ui_reading_abp.b()));
        int round = Math.round(((float) com_duokan_reader_ui_reading_abp.a()) * min);
        int round2 = Math.round(min * ((float) com_duokan_reader_ui_reading_abp.b()));
        this.b = new aca();
        this.b.a = com_duokan_reader_ui_reading_abp;
        this.b.b = com_duokan_reader_ui_reading_abp.a(round, round2);
        this.b.c = 0.0f;
        this.b.d = 1.0f;
        this.b.e = new Point(getWidth() / 2, getHeight() / 2);
        this.b.f = this.b.e;
        this.b.g = 1.0f;
        this.b.h = 1.0f;
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
        this.d = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.d.setDuration(z ? 500 : 0);
        this.d.addUpdateListener(new abx(this));
        this.d.addListener(new aby(this, runnable));
        this.d.start();
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
        this.g.a(true);
        invalidate();
    }

    public final void a(float f, float f2) {
        if (this.b != null) {
            float scrollScaleX = f * getScrollScaleX();
            float scrollScaleY = f2 * getScrollScaleY();
            this.g.a(true);
            this.g.a(this.b.f.x, this.b.f.y, Math.round(scrollScaleX), Math.round(scrollScaleY), getMinScrollX(), getMaxScrollX(), getMinScrollY(), getMaxScrollY(), UTools.defaultClose(getContext()), UTools.getMinimumHeight(getContext()));
            invalidate();
        }
    }

    public final void a(int i, int i2, boolean z) {
        if (this.b != null) {
            int round = Math.round(((float) i) * getScrollScaleX());
            int round2 = Math.round(((float) i2) * getScrollScaleY());
            this.g.a(true);
            this.g.a(this.b.f.x, this.b.f.y, round, round2, z ? HttpStatus.SC_INTERNAL_SERVER_ERROR : 0);
            invalidate();
        }
    }

    public final void a(Point point, float f, boolean z) {
        int i = 0;
        if (this.b != null) {
            if (this.e != null) {
                this.e.cancel();
                this.e = null;
            }
            this.e = ValueAnimator.ofFloat(new float[]{this.b.h, f});
            this.e.setDuration(z ? 500 : 0);
            this.e.setInterpolator(new AccelerateDecelerateInterpolator());
            this.e.addUpdateListener(new abz(this));
            this.e.start();
            this.g.a(true);
            bx bxVar = this.g;
            int i2 = this.b.f.x;
            int i3 = this.b.f.y;
            int i4 = point.x - this.b.f.x;
            int i5 = point.y - this.b.f.y;
            if (z) {
                i = HttpStatus.SC_INTERNAL_SERVER_ERROR;
            }
            bxVar.a(i2, i3, i4, i5, i);
            invalidate();
        }
    }

    public final void a() {
        if (this.b != null) {
            this.g.a(true);
            this.g.a(this.b.f.x, this.b.f.y, 0, 0, 0);
            this.g.h();
            this.g.a(this.b.f.x, this.b.f.y, getMinScrollX(), getMaxScrollX(), getMinScrollY(), getMaxScrollY());
            invalidate();
        }
    }

    public final void a(Point point, float f) {
        if (this.b != null) {
            this.b.h *= f;
            int i = this.b.f.x - point.x;
            int i2 = this.b.f.y - point.y;
            this.b.f.x = Math.round((((float) i) * f) + ((float) point.x));
            this.b.f.y = Math.round((((float) i2) * f) + ((float) point.y));
            invalidate();
        }
    }

    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.d == null || !this.d.isRunning()) {
            this.d = null;
            f = 1.0f;
        } else {
            f = ((Float) this.d.getAnimatedValue()).floatValue();
        }
        if (this.c != null) {
            int round = Math.round(((float) this.c.e.x) + (((float) (this.c.f.x - this.c.e.x)) * f));
            int round2 = Math.round(((float) this.c.e.y) + (((float) (this.c.f.y - this.c.e.y)) * f));
            float f2 = this.c.g + ((this.c.h - this.c.g) * f);
            int round3 = Math.round(((float) this.c.b.getWidth()) * f2);
            int round4 = Math.round(f2 * ((float) this.c.b.getHeight()));
            this.i.set(0, 0, this.c.b.getWidth(), this.c.b.getHeight());
            this.j.set(round - (round3 / 2), round2 - (round4 / 2), (round - (round3 / 2)) + round3, (round2 - (round4 / 2)) + round4);
        }
        if (this.b != null) {
            if (this.e == null || !this.e.isRunning()) {
                this.e = null;
            } else {
                this.b.h = ((Float) this.e.getAnimatedValue()).floatValue();
            }
            if (!this.g.a()) {
                this.g.h();
                this.b.f.x = this.g.b();
                this.b.f.y = this.g.c();
                invalidate();
            }
            round = Math.round(((float) this.b.e.x) + (((float) (this.b.f.x - this.b.e.x)) * f));
            round2 = Math.round(((float) this.b.e.y) + (((float) (this.b.f.y - this.b.e.y)) * f));
            f2 = this.b.g + ((this.b.h - this.b.g) * f);
            round3 = Math.round(((float) this.b.b.getWidth()) * f2);
            round4 = Math.round(f2 * ((float) this.b.b.getHeight()));
            this.k.set(0, 0, this.b.b.getWidth(), this.b.b.getHeight());
            this.l.set(round - (round3 / 2), round2 - (round4 / 2), (round - (round3 / 2)) + round3, (round2 - (round4 / 2)) + round4);
        }
        if (this.c == null && this.b != null) {
            canvas.drawARGB(Math.round(f * 255.0f), 0, 0, 0);
        } else if (this.b == null && this.c != null) {
            canvas.drawARGB(Math.round((1.0f - f) * 255.0f), 0, 0, 0);
        } else if (!(this.b == null || this.c == null)) {
            canvas.drawARGB(255, 0, 0, 0);
        }
        if (!(this.c == null || this.b == null)) {
            this.h.set(this.j);
            Rect rect = this.h;
            rect.left += Math.round(((float) (this.l.left - this.j.left)) * f);
            rect = this.h;
            rect.top += Math.round(((float) (this.l.top - this.j.top)) * f);
            rect = this.h;
            rect.right += Math.round(((float) (this.l.right - this.j.right)) * f);
            rect = this.h;
            rect.bottom += Math.round(((float) (this.l.bottom - this.j.bottom)) * f);
            canvas.clipRect(this.h);
        }
        if (this.c != null) {
            this.m.setAlpha(Math.round((this.c.c + ((this.c.d - this.c.c) * f)) * 255.0f));
            canvas.drawBitmap(this.c.b, this.i, this.j, this.m);
        }
        if (this.b != null) {
            this.m.setAlpha(Math.round((this.b.c + (f * (this.b.d - this.b.c))) * 255.0f));
            canvas.drawBitmap(this.b.b, this.k, this.l, this.m);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.b != null) {
            float min = Math.min(((float) getWidth()) / ((float) this.b.a.a()), ((float) getHeight()) / ((float) this.b.a.b()));
            int round = Math.round(((float) this.b.a.a()) * min);
            int round2 = Math.round(min * ((float) this.b.a.b()));
            this.b.b = this.b.a.a(round, round2);
            this.b.c = 0.0f;
            this.b.d = 1.0f;
            this.b.e.set(getWidth() / 2, getHeight() / 2);
            this.b.f = this.b.e;
            this.b.g = 1.0f;
            this.b.h = 1.0f;
        }
    }

    private final float getScrollScaleX() {
        float minOverScrollX = (float) getMinOverScrollX();
        float maxOverScrollX = (float) getMaxOverScrollX();
        float minScrollX = (float) getMinScrollX();
        float maxScrollX = (float) getMaxScrollX();
        float f = (float) this.b.f.x;
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
        if (a || Float.compare(f, 0.0f) >= 0) {
            return minOverScrollX;
        }
        throw new AssertionError();
    }

    private final float getScrollScaleY() {
        float minOverScrollY = (float) getMinOverScrollY();
        float maxOverScrollY = (float) getMaxOverScrollY();
        float minScrollY = (float) getMinScrollY();
        float maxScrollY = (float) getMaxScrollY();
        float f = (float) this.b.f.y;
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
        if (a || Float.compare(f, 0.0f) >= 0) {
            return minOverScrollY;
        }
        throw new AssertionError();
    }

    private final int getMinOverScrollX() {
        return Float.compare(((float) this.b.b.getWidth()) * this.b.h, (float) getWidth()) <= 0 ? getMinScrollX() : getMinScrollX() - UTools.defaultClose(getContext());
    }

    private final int getMaxOverScrollX() {
        return Float.compare(((float) this.b.b.getWidth()) * this.b.h, (float) getWidth()) <= 0 ? getMaxScrollX() : getMaxScrollX() + UTools.defaultClose(getContext());
    }

    private final int getMinOverScrollY() {
        return Float.compare(((float) this.b.b.getHeight()) * this.b.h, (float) getHeight()) <= 0 ? getMinScrollY() : getMinScrollY() - UTools.getMinimumHeight(getContext());
    }

    private final int getMaxOverScrollY() {
        return Float.compare(((float) this.b.b.getHeight()) * this.b.h, (float) getHeight()) <= 0 ? getMaxScrollY() : getMaxScrollY() + UTools.getMinimumHeight(getContext());
    }

    private int getMinScrollX() {
        return (getWidth() / 2) - Math.max(0, Math.round(((((float) this.b.b.getWidth()) * this.b.h) - ((float) getWidth())) / 2.0f));
    }

    private int getMaxScrollX() {
        return (getWidth() / 2) + Math.max(0, Math.round(((((float) this.b.b.getWidth()) * this.b.h) - ((float) getWidth())) / 2.0f));
    }

    private int getMinScrollY() {
        return (getHeight() / 2) - Math.max(0, Math.round(((((float) this.b.b.getHeight()) * this.b.h) - ((float) getHeight())) / 2.0f));
    }

    private int getMaxScrollY() {
        return (getHeight() / 2) + Math.max(0, Math.round(((((float) this.b.b.getHeight()) * this.b.h) - ((float) getHeight())) / 2.0f));
    }
}
