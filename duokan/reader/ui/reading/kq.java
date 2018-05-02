package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.document.epub.at;
import com.duokan.reader.domain.document.epub.av;

import org.apache.http.HttpStatus;

import java.util.concurrent.Future;

class kq extends FrameLayout {
    final /* synthetic */ kp a;
    private boolean b = false;
    private float c = 1.0f;
    private final ImageView d;
    private final ImageView e;
    private final ImageView f;
    private Bitmap g = null;
    private Bitmap h = null;
    private boolean i = false;
    private boolean j = false;
    private Future k = null;
    private Transformation l = new Transformation();
    private AlphaAnimation m = null;
    private av n = null;

    public kq(kp kpVar, Context context) {
        this.a = kpVar;
        super(context);
        this.e = new ImageView(context);
        this.d = new ImageView(context);
        this.f = new ImageView(context);
        addView(this.d, new LayoutParams(-1, -1, 17));
        addView(this.e, new LayoutParams(-1, -1, 17));
        addView(this.f, new LayoutParams(-1, -1, 17));
        this.d.setScaleType(ScaleType.FIT_CENTER);
        this.e.setScaleType(ScaleType.FIT_CENTER);
        this.f.setScaleType(ScaleType.FIT_CENTER);
        this.f.setVisibility(4);
        setBackgroundColor(Color.argb(Math.round(12.75f), 0, 0, 0));
    }

    public void a(boolean z) {
        boolean z2 = z || f.b().e();
        av b = b(z2);
        if (!(b == null || this.n == b)) {
            fv fvVar = (fv) this.a.b.G();
            this.n = b;
            if (this.k != null) {
                this.k.cancel(true);
                this.k = null;
            }
            this.k = fvVar.a(b, toString(), new kr(this, b));
        }
        if (z) {
            c();
            if (!this.b) {
                this.b = true;
                return;
            }
            return;
        }
        b();
        if (this.b) {
            UTools.creatCallTask((View) this, new ks(this));
            if (this.e.getVisibility() == 0) {
                this.m = new AlphaAnimation(1.0f, 0.0f);
                this.m.setDuration(500);
                this.e.invalidate();
                this.d.setVisibility(0);
                UTools.addAnimation(this.e, 1.0f, 0.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, false, new kt(this));
            }
        }
    }

    public float a() {
        return this.c;
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int b = this.a.c.k().b();
        int c = this.a.c.k().c();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            measureChild(getChildAt(i3), MeasureSpec.makeMeasureSpec(b, 1073741824), MeasureSpec.makeMeasureSpec(c, 1073741824));
        }
        if (this.b) {
            this.c = Math.min(((float) size) / ((float) b), ((float) size2) / ((float) c));
        } else {
            this.c = Math.max(((float) size) / ((float) b), ((float) size2) / ((float) c));
        }
        setMeasuredDimension(b, c);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view != this.e || this.m == null) {
            return super.drawChild(canvas, view, j);
        }
        float f;
        int e = this.a.c.e();
        int f2 = this.a.c.f();
        int width = getWidth();
        int height = getHeight();
        if (this.m == null || this.m.hasEnded()) {
            f = 1.0f;
        } else {
            if (!this.m.hasStarted()) {
                this.m.setStartTime(j);
            }
            this.m.getTransformation(j, this.l);
            f = this.l.getAlpha();
            invalidate();
        }
        float f3 = (((float) (width - e)) * f) + ((float) e);
        f = (f * ((float) (height - f2))) + ((float) f2);
        float width2 = (((float) getWidth()) - f3) / 2.0f;
        float height2 = (((float) getHeight()) - f) / 2.0f;
        canvas.save();
        canvas.clipRect(width2, height2, f3 + width2, f + height2);
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.setImageBitmap(null);
        if (this.h != null) {
            this.h.recycle();
            this.h = null;
        }
        this.d.setImageBitmap(null);
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
        if (this.k != null) {
            this.k.cancel(true);
            this.k = null;
        }
    }

    private void b() {
        if (this.g == null || !this.i) {
            this.a.c.a(new ku(this));
        }
    }

    private void c() {
        if (this.h == null || !this.j) {
            this.a.c.b(new kx(this));
        } else if (this.e.getVisibility() != 0) {
            this.m = new AlphaAnimation(0.0f, 1.0f);
            this.m.setDuration(500);
            this.e.invalidate();
            this.d.invalidate();
            this.f.invalidate();
            this.e.setVisibility(0);
            UTools.addAnimation(this.e, 0.0f, 1.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, false, new kw(this));
        }
    }

    private av b(boolean z) {
        av a = ((at) this.a.c).a(false);
        av a2 = ((at) this.a.c).a(true);
        if (a == null) {
            return null;
        }
        if (a.i()) {
            a2 = a;
        } else if (z) {
            a2 = a;
        } else if (a2 == null) {
            a2 = a;
        }
        if (a2.i()) {
            a2 = null;
        }
        return a2;
    }
}
