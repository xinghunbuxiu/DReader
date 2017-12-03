package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.je;

public class PagesFrameView extends FrameLayout {
    private final sh a;
    private final Paint b;
    private final bc c;
    private final je d;
    private int e;
    private float f;
    private String g;
    private String h;
    private Bitmap i;
    private Bitmap j;
    private boolean k;
    private final BroadcastReceiver l;
    private final BroadcastReceiver m;
    private boolean n;
    private long o;
    private AlphaAnimation p;
    private Bitmap q;
    private Paint r;
    private Transformation s;

    public PagesFrameView(Context context) {
        this(context, null);
    }

    public PagesFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Paint();
        this.e = 0;
        this.f = 1.0f;
        this.g = "";
        this.h = "";
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = new oi(this);
        this.m = new oj(this);
        this.n = false;
        this.o = 0;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.a = (sh) MyContextWrapper.getFeature(context).queryFeature(sh.class);
        this.b.setSubpixelText(true);
        this.b.setAntiAlias(true);
        this.c = new bc(getContext());
        this.d = new je(getContext());
        this.d.a().setSubpixelText(true);
        this.d.a().setTextSize((float) UTools.closeAnimation(getContext(), 14.0f));
        this.d.a().setAntiAlias(true);
        this.d.a(19);
        getContext().registerReceiver(this.l, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        getContext().registerReceiver(this.m, new IntentFilter("android.intent.action.TIME_TICK"));
        a(getSystemTime());
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
    }

    public void setStatusColor(int i) {
        this.e = i;
        int argb = Color.argb(Math.round(((float) Color.alpha(this.e)) * this.f), Color.red(this.e), Color.green(this.e), Color.blue(this.e));
        this.d.a().setColor(argb);
        this.c.b(argb);
        invalidate();
    }

    public void setStatusOpacity(float f) {
        this.f = (float) Math.pow((double) f, 10.0d);
        int argb = Color.argb(Math.round(((float) Color.alpha(this.e)) * this.f), Color.red(this.e), Color.green(this.e), Color.blue(this.e));
        this.d.a().setColor(argb);
        this.c.b(argb);
        invalidate();
    }

    public void a() {
        boolean z = true;
        if (this.a.G().l()) {
            this.k = false;
            return;
        }
        n document = this.a.getDocument();
        gn X = this.a.X();
        if (X != null && X.e()) {
            Document_a g = X.g();
            as h = X.h();
            h h2 = document.h();
            this.h = h2.a();
            g b = h2.b(g);
            if (!(b == null || b.f().equals(g.g()))) {
                this.h = b.e();
            }
            if (document.l().k) {
                this.h = DkUtils.chs2chtText(this.h);
            }
            if (document.e() > 0 && h.j() >= 0) {
                this.g = String.format("%getScaledTouchSlop / %getScaledTouchSlop", new Object[]{Long.valueOf(h.j() + 1), Long.valueOf(r6)});
            }
            if (X.g().f()) {
                z = false;
            }
            this.k = z;
            invalidate();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.l != null) {
            getContext().unregisterReceiver(this.l);
        }
        if (this.m != null) {
            getContext().unregisterReceiver(this.m);
        }
    }

    public void draw(Canvas canvas) {
        if (this.a.J()) {
            this.n = false;
            if (this.o == 0) {
                this.o = getDrawingTime();
            }
            super.draw(canvas);
            b(canvas);
            if (!this.n) {
                this.o = 0;
            }
            canvas.save();
            if (this.p != null) {
                Rect rect = (Rect) UTools.g.getRect();
                rect.set(0, 0, getWidth(), getHeight());
                if (this.p.hasEnded() || this.q.getWidth() != getWidth() || this.q.getHeight() != getHeight()) {
                    this.q.recycle();
                    this.q = null;
                    this.r = null;
                    this.s = null;
                    this.p = null;
                } else if (!this.n || this.p.hasStarted()) {
                    if (!this.p.hasStarted()) {
                        this.p.start();
                    }
                    this.p.getTransformation(getDrawingTime(), this.s);
                    this.r.setAlpha(Math.round(this.s.getAlpha() * 255.0f));
                    canvas.drawBitmap(this.q, null, rect, this.r);
                    invalidate();
                } else {
                    this.r.setAlpha(255);
                    canvas.drawBitmap(this.q, null, rect, this.r);
                }
                UTools.g.getRect(rect);
            }
            canvas.restore();
            a(canvas);
        }
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    public void invalidate(Rect rect) {
        invalidate();
        super.invalidate(rect);
    }

    public void invalidate(int i, int i2, int i3, int i4) {
        invalidate();
        super.invalidate(i, i2, i3, i4);
    }

    public void invalidate() {
        this.n = true;
        super.invalidate();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        c();
    }

    private void a(Canvas canvas) {
        if (this.a.s()) {
            Rect selectionStartIndicatorBounds = this.a.getSelectionStartIndicatorBounds();
            Rect selectionEndIndicatorBounds = this.a.getSelectionEndIndicatorBounds();
            if (!selectionStartIndicatorBounds.isEmpty()) {
                UTools.addAnimation(canvas, this.a.a(DecorDrawableStyle.SELECTION_INDICATOR_START), selectionStartIndicatorBounds, 17);
            }
            if (!selectionEndIndicatorBounds.isEmpty()) {
                UTools.addAnimation(canvas, this.a.a(DecorDrawableStyle.SELECTION_INDICATOR_END), selectionEndIndicatorBounds, 17);
            }
        }
    }

    private void b(Canvas canvas) {
        if (this.k) {
            n document = this.a.getDocument();
            k k = document.k();
            m l = document.l();
            if (!k.c() && k.e) {
                b();
                this.b.setTextSize((float) l.f);
                if (k.c.top >= l.f && this.i != null) {
                    this.b.setAlpha(Math.round(this.f * 255.0f));
                    canvas.drawBitmap(this.i, 0.0f, 0.0f, this.b);
                    if (l.m && !TextUtils.isEmpty(this.h)) {
                        this.b.setColor(this.e);
                        this.b.setAlpha(Math.round(((float) Color.alpha(this.e)) * this.f));
                        a(canvas, this.h, 3, getWidth(), this.b);
                    }
                }
                if (this.j == null) {
                    return;
                }
                if (k.c.bottom >= l.f || this.a.bf()) {
                    this.b.setAlpha(Math.round(this.f * 255.0f));
                    canvas.drawBitmap(this.j, 0.0f, (float) (getHeight() - this.j.getHeight()), this.b);
                    if (k.c.bottom >= l.f) {
                        Rect rect = k.c;
                        Rect rect2 = (Rect) UTools.g.getRect();
                        this.c.c(l.f - UTools.g(getContext(), 2.0f));
                        rect2.set(getPaddingLeft() + rect.left, getHeight() - rect.bottom, rect.left + this.c.getIntrinsicWidth(), (getHeight() - rect.bottom) + this.c.getIntrinsicHeight());
                        this.c.setBounds(rect2);
                        this.c.draw(canvas);
                        Rect rect3 = (Rect) UTools.g.getRect();
                        rect3.set(rect2.right + UTools.closeAnimation(getContext(), 8.0f), getHeight() - rect.bottom, getWidth() - rect.right, (getHeight() - rect.bottom) + this.c.getIntrinsicHeight());
                        this.d.setBounds(rect3);
                        this.d.draw(canvas);
                        UTools.g.getRect(rect3);
                        UTools.g.getRect(rect2);
                        if (this.a.bf()) {
                            this.a.a(canvas, getWidth() / 2, (this.c.getIntrinsicHeight() / 2) + (getHeight() - rect.bottom), getHeight() - UTools.closeAnimation(getContext(), 65.0f), getHeight(), this.d.a().getColor());
                        }
                        if (!TextUtils.isEmpty(this.h)) {
                            this.b.setColor(this.e);
                            this.b.setAlpha(Math.round(((float) Color.alpha(this.e)) * this.f));
                            a(canvas, this.g, 53, this.b);
                        }
                    } else if (this.a.bf()) {
                        this.a.a(canvas, getWidth() / 2, getHeight() - (this.j.getHeight() / 2), getHeight() - UTools.closeAnimation(getContext(), 65.0f), getHeight(), this.d.a().getColor());
                    }
                }
            }
        }
    }

    private void b() {
        k k = this.a.getDocument().k();
        m l = this.a.getDocument().l();
        Drawable background = getBackground();
        if (background != null) {
            int i = k.c.top + k.d.top;
            if (!(this.i != null && this.i.getWidth() == getWidth() && this.i.getHeight() == i)) {
                if (this.i != null) {
                    this.i.recycle();
                    this.i = null;
                }
                try {
                    this.i = com.duokan.reader.common.bitmap.a.c(getWidth(), i, Config.ARGB_8888);
                } catch (Throwable th) {
                }
                if (this.i != null) {
                    Canvas canvas = new Canvas(this.i);
                    background.draw(canvas);
                    Paint paint = new Paint();
                    paint.setShader(new LinearGradient(0.0f, ((float) k.c.top) + (((float) k.d.top) * 0.3f), 0.0f, (float) i, -16777216, 0, TileMode.CLAMP));
                    paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                    canvas.drawRect(0.0f, 0.0f, (float) this.i.getWidth(), (float) this.i.getHeight(), paint);
                }
            }
            int b = (k.c.bottom + k.d.bottom) + UTools.closeAnimation(getContext(), 5.0f);
            if (this.j == null || this.j.getWidth() != getWidth() || this.j.getHeight() != b) {
                int intrinsicHeight;
                if (this.j != null) {
                    this.j.recycle();
                    this.j = null;
                }
                if (this.a.bf()) {
                    intrinsicHeight = b + ((this.a.bg().getIntrinsicHeight() / 2) - ((l.f - UTools.g(getContext(), 2.0f)) / 2));
                } else {
                    intrinsicHeight = b;
                }
                try {
                    this.j = com.duokan.reader.common.bitmap.a.c(getWidth(), intrinsicHeight, Config.ARGB_8888);
                } catch (Throwable th2) {
                }
                if (this.j != null) {
                    Canvas canvas2 = new Canvas(this.j);
                    b = -(getHeight() - this.j.getHeight());
                    canvas2.translate(0.0f, (float) b);
                    background.draw(canvas2);
                    canvas2.translate(0.0f, (float) (-b));
                    Paint paint2 = new Paint();
                    paint2.setShader(new LinearGradient(0.0f, Math.min((float) k.d.bottom, ((float) intrinsicHeight) * 0.2f), 0.0f, 0.0f, -16777216, 0, TileMode.CLAMP));
                    paint2.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                    canvas2.drawRect(0.0f, 0.0f, (float) this.j.getWidth(), (float) this.j.getHeight(), paint2);
                }
            }
        }
    }

    private void c() {
        if (this.i != null) {
            this.i.recycle();
            this.i = null;
        }
        if (this.j != null) {
            this.j.recycle();
            this.j = null;
        }
    }

    private void a(String str) {
        this.d.a(getSystemTime());
        invalidate();
    }

    private void a(int i) {
        this.c.a(i);
        invalidate();
    }

    private String getSystemTime() {
        if (DateFormat.is24HourFormat(getContext())) {
            return (String) DateFormat.format("kk:mm", System.currentTimeMillis());
        }
        return (String) DateFormat.format("hh:mm", System.currentTimeMillis());
    }

    private void a(Canvas canvas, String str, int i, int i2, Paint paint) {
        k k = this.a.getDocument().k();
        RectF rectF = (RectF) UTools.h.getRect();
        if (i == 3) {
            rectF.set((float) k.c.left, 0.0f, (float) Math.min(getWidth() - k.c.right, k.c.left + i2), (float) k.c.top);
        } else {
            rectF.set((float) Math.max((getWidth() - k.c.right) - i2, k.c.left), 0.0f, (float) (getWidth() - k.c.right), (float) k.c.top);
        }
        UTools.addAnimation(canvas, str, rectF, i | 80, paint);
        UTools.h.getRect(rectF);
    }

    private void a(Canvas canvas, String str, int i, Paint paint) {
        k k = this.a.getDocument().k();
        this.a.getDocument().l();
        Rect rect = (Rect) UTools.g.getRect();
        rect.set(k.c.left, getHeight() - k.c.bottom, getWidth() - k.c.right, getHeight());
        UTools.addAnimation(canvas, str, rect, i | 16, paint);
        UTools.g.getRect(rect);
    }
}
