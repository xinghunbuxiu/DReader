package com.duokan.reader.domain.document;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;

import com.duokan.core.ui.UTools;

import org.apache.http.HttpStatus;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public abstract class as extends Drawable {
    static final /* synthetic */ boolean b = (!as.class.desiredAssertionStatus());
    private static Handler c = new Handler(Looper.getMainLooper());
    private static WeakReference d = new WeakReference(null);
    private static Bitmap e = null;
    protected final Paint a = new Paint();
    private int f = 0;
    private int g = 0;
    private Rect h = new Rect();
    private int i = 0;
    private boolean j = false;

    public abstract Rect A();

    public abstract int B();

    public abstract boolean E();

    public abstract boolean F();

    public abstract boolean G();

    public abstract void H();

    public abstract String I();

    public abstract String J();

    public abstract String K();

    protected abstract void O();

    public abstract int a(Point point, int i);

    public abstract int a(bb bbVar);

    public abstract Rect a(au auVar);

    public abstract ae a(Point point);

    public abstract bb a(Point point, Point point2);

    public abstract void a(m mVar);

    public abstract void a(Runnable runnable, Runnable runnable2);

    public abstract void a(boolean z);

    protected abstract int b(Canvas canvas, long j);

    public abstract Rect b(Rect rect);

    public abstract bb b(Point point);

    public abstract String b(bb bbVar);

    public abstract int c(Point point);

    public abstract Rect c(Rect rect);

    public abstract af c(int i);

    public abstract String c(bb bbVar);

    public abstract int d(Point point);

    public abstract Rect d(bb bbVar);

    public abstract aw d(int i);

    public abstract int e(Point point);

    public abstract ab e(int i);

    public abstract Rect[] e(bb bbVar);

    public abstract int f(Point point);

    public abstract Point f(bb bbVar);

    public abstract ah f(int i);

    public abstract int g(Point point);

    public abstract Point g(bb bbVar);

    public abstract Rect g(int i);

    public abstract Rect h(int i);

    public abstract Rect i(int i);

    public abstract long j();

    public abstract Rect j(int i);

    public abstract ac k(int i);

    public abstract boolean k();

    public abstract Rect l(int i);

    public abstract ak l();

    public abstract Rect m(int i);

    public abstract bb m();

    public abstract aj n(int i);

    public abstract d[] n();

    public abstract Rect o(int i);

    public abstract CharSequence o();

    public abstract Rect p(int i);

    public abstract k p();

    public abstract ad q(int i);

    public abstract m q();

    public abstract int r();

    public abstract Rect r(int i);

    public abstract int s();

    public abstract ax s(int i);

    public abstract int t();

    public abstract Rect t(int i);

    public abstract int u();

    public abstract Rect u(int i);

    public abstract int v();

    public abstract int v(int i);

    public abstract int w();

    public abstract int x();

    public abstract int y();

    public abstract Rect z();

    public int f() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public int g() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }

    public Rect h() {
        return this.h;
    }

    public void a(Rect rect) {
        this.h.set(rect);
        d(this.h);
    }

    public int i() {
        return this.i;
    }

    public final boolean C() {
        return this.j;
    }

    public List D() {
        return Collections.emptyList();
    }

    public final void a(Canvas canvas, long j) {
        this.i = 0;
        this.j = false;
        if (!F() && !q().o) {
            canvas.save();
            canvas.clipRect(getBounds());
            canvas.translate((float) getBounds().left, (float) getBounds().top);
            m q = q();
            this.a.setColor(q.e == 0 ? Color.rgb(HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING, HttpStatus.SC_PROCESSING) : q.e);
            this.a.setSubpixelText(true);
            this.a.setAntiAlias(true);
            this.i = b(canvas, j);
            canvas.restore();
        }
    }

    public int getIntrinsicWidth() {
        return p().a;
    }

    public int getIntrinsicHeight() {
        return p().b;
    }

    public final void draw(Canvas canvas) {
        a(canvas, 0);
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.j = true;
    }

    protected void d(Rect rect) {
    }

    protected void a(Canvas canvas) {
        a.c().b(N());
        int i = p().a;
        int i2 = p().b;
        Drawable drawable = q().a;
        if (p().c()) {
            canvas.drawColor(-1);
        } else if (p().e) {
            canvas.drawColor(0);
        } else if (drawable != null) {
            drawable.setBounds(0, 0, i, i2);
            drawable.draw(canvas);
        } else {
            canvas.drawColor(0);
        }
        this.i = 2;
        invalidateSelf();
    }

    protected Bitmap L() {
        return e;
    }

    protected boolean M() {
        a.c().b(N());
        Drawable drawable = (Drawable) d.get();
        if (p().c()) {
            if (drawable == null && e == null) {
                return false;
            }
            if (e != null) {
                synchronized (e) {
                    b();
                }
            } else {
                b();
            }
            return true;
        } else if (!q().p) {
            int i = p().a;
            int i2 = p().b;
            if (drawable == q().a && e != null && e.getWidth() == i && e.getHeight() == i2) {
                return false;
            }
            if (e != null) {
                synchronized (e) {
                    a();
                }
            } else {
                a();
            }
            return true;
        } else if (drawable == null && e == null) {
            return false;
        } else {
            if (e != null) {
                synchronized (e) {
                    b();
                }
            } else {
                b();
            }
            return true;
        }
    }

    private void a() {
        if (b || e == null || Thread.holdsLock(e)) {
            b();
            int i = p().a;
            int i2 = p().b;
            Drawable drawable = q().a;
            if (drawable != null) {
                Bitmap c = com.duokan.reader.common.bitmap.a.c(i, i2, Config.RGB_565);
                Canvas canvas = new Canvas(c);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                d = new WeakReference(drawable);
                e = c;
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private void b() {
        if (b || e == null || Thread.holdsLock(e)) {
            if (e != null) {
                e.recycle();
                e = null;
            }
            d = new WeakReference(null);
            return;
        }
        throw new AssertionError();
    }

    protected void a(Canvas canvas, String str, int i, int i2, Paint paint) {
        k p = p();
        RectF rectF = (RectF) UTools.h.getRect();
        if (i == 3) {
            rectF.set((float) p.c.left, 0.0f, (float) Math.min(getBounds().width() - p.c.right, p.c.left + i2), (float) p.c.top);
        } else {
            rectF.set((float) Math.max((getBounds().width() - p.c.right) - i2, p.c.left), 0.0f, (float) (getBounds().width() - p.c.right), (float) p.c.top);
        }
        UTools.addAnimation(canvas, str, rectF, i | 80, paint);
        UTools.h.getRect(rectF);
    }

    protected void a(Canvas canvas, String str, int i, Paint paint) {
        k p = p();
        Rect rect = (Rect) UTools.g.getRect();
        rect.set(p.c.left, getBounds().height() - p.c.bottom, getBounds().width() - p.c.right, (getBounds().height() - p.c.bottom) + q().f);
        UTools.addAnimation(canvas, str, rect, i | 16, paint);
        UTools.g.getRect(rect);
    }

    protected void a(Runnable runnable) {
        c.post(runnable);
    }

    protected boolean N() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
