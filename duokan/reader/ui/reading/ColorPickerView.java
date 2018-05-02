package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ColorPickerView extends View {
    private int A;
    private Context a;
    private Paint b;
    private int c;
    private int d;
    private int[] e;
    private int f;
    private int g;
    private Drawable h;
    private Drawable i;
    private Paint j;
    private final int k;
    private boolean l;
    private boolean m;
    private PointF n;
    private PointF o;
    private bw p;
    private boolean q;
    private boolean r;
    private float s;
    private Bitmap t;
    private float u;
    private int v;
    private int w;
    private int x;
    private float y;
    private float z;

    public ColorPickerView(Context context) {
        this(context, null);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = false;
        this.m = false;
        this.q = false;
        this.r = false;
        this.A = Integer.MAX_VALUE;
        this.a = context;
        a();
        this.k = this.h.getIntrinsicWidth() / 2;
        this.w = this.v;
        this.x = this.v;
        this.y = -1.0f;
    }

    public void setOnColorChangedListenner(bw bwVar) {
        this.p = bwVar;
    }

    public void a(int i, float f) {
        this.v = i;
        this.z = f;
        requestLayout();
        invalidate();
    }

    private void a() {
        this.b = new Paint();
        this.b.setStyle(Style.FILL);
        this.b.setStrokeWidth(1.0f);
        this.e = new int[3];
        this.e[0] = -1;
        this.e[2] = -16777216;
        this.j = new Paint();
        this.h = getResources().getDrawable(e.reading__color_view__button);
        this.s = (float) (this.h.getIntrinsicWidth() / 2);
        this.n = new PointF((float) this.k, (float) this.k);
        this.i = getResources().getDrawable(e.reading__color_view__saturation);
        this.o = new PointF((float) this.k, (float) this.k);
        this.u = (float) (this.i.getIntrinsicHeight() / 2);
        this.f = this.i.getIntrinsicWidth() / 2;
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(getGradual(), null, new Rect(this.k, this.k, this.k + this.g, this.c - this.k), this.j);
        this.e[1] = this.b.getColor();
        this.b.setShader(new LinearGradient((float) ((this.d - this.k) - (this.f / 2)), (float) this.k, (float) ((this.d - this.k) - (this.f / 2)), (float) (this.c - this.k), this.e, null, TileMode.MIRROR));
        canvas.drawRect(new Rect((this.d - this.f) - this.k, this.k, this.d - this.k, this.c - this.k), this.b);
        int round = Math.round(this.n.x - this.s);
        int round2 = Math.round(this.n.y - this.s);
        this.h.setBounds(round, round2, this.h.getIntrinsicWidth() + round, this.h.getIntrinsicHeight() + round2);
        this.h.draw(canvas);
        round = ((this.d - this.f) - this.k) - ((this.i.getIntrinsicWidth() - this.f) / 2);
        round2 = Math.round(this.o.y - this.u);
        this.i.setBounds(round, round2, this.i.getIntrinsicWidth() + round, this.i.getIntrinsicHeight() + round2);
        this.i.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.d = size;
        } else {
            this.d = 480;
        }
        if (mode2 == 1073741824) {
            this.c = size2;
        } else {
            this.c = 350;
        }
        this.g = (this.d - (this.k * 3)) - this.f;
        setMeasuredDimension(this.d, this.c);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.o.y = (((float) (this.c - (this.k * 2))) * this.z) + ((float) this.k);
        Bitmap gradual = getGradual();
        for (int i5 = 0; i5 < gradual.getWidth(); i5++) {
            for (int i6 = 0; i6 < gradual.getHeight(); i6++) {
                if (gradual.getPixel(i5, i6) == this.v) {
                    this.n.x = (float) (i5 + this.k);
                    this.n.y = (float) (this.k + i6);
                    this.b.setColor(this.v);
                    super.onLayout(z, i, i2, i3, i4);
                    return;
                }
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.l = a(x, y);
                this.m = b(x, y);
                if (this.l) {
                    this.q = true;
                    c(x, y);
                    this.b.setColor(e(this.n.x - ((float) this.k), this.n.y - ((float) this.k)));
                } else if (this.m) {
                    this.r = true;
                    d(x, y);
                }
                invalidate();
                int b = b(this.o.y - ((float) this.k));
                if (this.A == Integer.MAX_VALUE || this.A != b) {
                    this.A = b;
                    x = (this.o.y - ((float) this.k)) / ((float) (this.c - (this.k * 2)));
                    if (this.p != null && a(x)) {
                        this.w = this.A;
                        this.x = this.b.getColor();
                        this.y = x;
                        this.p.a(this.A, this.b.getColor(), x);
                        break;
                    }
                }
            case 1:
                if (this.l) {
                    this.l = false;
                } else if (this.m) {
                    this.m = false;
                }
                this.q = false;
                this.r = false;
                invalidate();
                if (this.p != null) {
                    this.p.a(b(this.o.y - ((float) this.k)), this.b.getColor(), (this.o.y - ((float) this.k)) / ((float) (this.c - (this.k * 2))));
                    break;
                }
                break;
        }
        return true;
    }

    private boolean a(float f) {
        return (this.w == this.A && this.x == this.b.getColor() && this.y == f) ? false : true;
    }

    protected void onDetachedFromWindow() {
        if (!(this.t == null || this.t.isRecycled())) {
            this.t.recycle();
        }
        super.onDetachedFromWindow();
    }

    private Bitmap getGradual() {
        if (this.t == null) {
            Paint paint = new Paint();
            paint.setStrokeWidth(1.0f);
            this.t = a.c(this.g, this.c - (this.k * 2), Config.RGB_565);
            Canvas canvas = new Canvas(this.t);
            int width = this.t.getWidth();
            this.g = width;
            int height = this.t.getHeight();
            paint.setShader(new ComposeShader(new LinearGradient(0.0f, (float) (height / 2), (float) width, (float) (height / 2), new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281}, null, TileMode.REPEAT), new LinearGradient((float) (width / 2), 0.0f, (float) (width / 2), (float) height, -1, -16777216, TileMode.CLAMP), Mode.SCREEN));
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, paint);
        }
        return this.t;
    }

    private boolean a(float f, float f2) {
        if (0.0f >= f || f >= ((float) ((this.k + this.g) + (this.k / 2))) || 0.0f >= f2 || f2 >= ((float) this.d)) {
            return false;
        }
        return true;
    }

    private boolean b(float f, float f2) {
        if (((float) (((this.d - this.k) - this.f) - (this.k / 2))) >= f || f >= ((float) this.d) || 0.0f >= f2 || f2 >= ((float) this.c)) {
            return false;
        }
        return true;
    }

    private void c(float f, float f2) {
        if (f < ((float) this.k)) {
            this.n.x = (float) this.k;
        } else if (f > ((float) (this.k + this.g))) {
            this.n.x = (float) (this.k + this.g);
        } else {
            this.n.x = f;
        }
        if (f2 < ((float) this.k)) {
            this.n.y = (float) this.k;
        } else if (f2 > ((float) (this.c - this.k))) {
            this.n.y = (float) (this.c - this.k);
        } else {
            this.n.y = f2;
        }
    }

    private void d(float f, float f2) {
        if (f < ((float) this.k)) {
            this.o.x = (float) this.k;
        } else if (f > ((float) (this.k + this.g))) {
            this.o.x = (float) (this.k + this.g);
        } else {
            this.o.x = f;
        }
        if (f2 < ((float) this.k)) {
            this.o.y = (float) this.k;
        } else if (f2 > ((float) (this.c - this.k))) {
            this.o.y = (float) (this.c - this.k);
        } else {
            this.o.y = f2;
        }
    }

    private int e(float f, float f2) {
        Bitmap gradual = getGradual();
        int i = (int) f;
        int i2 = (int) f2;
        if (i >= gradual.getWidth()) {
            i = gradual.getWidth() - 1;
        }
        if (i2 >= gradual.getHeight()) {
            i2 = gradual.getHeight() - 1;
        }
        return gradual.getPixel(i, i2);
    }

    private int b(float f) {
        int i;
        int i2;
        float f2 = (((float) this.c) - (((float) this.k) * 2.0f)) / 2.0f;
        if (f < f2) {
            i = this.e[0];
            i2 = this.e[1];
            f2 = f / f2;
        } else {
            i = this.e[1];
            i2 = this.e[2];
            f2 = (f - f2) / f2;
        }
        return Color.argb(a(Color.alpha(i), Color.alpha(i2), f2), a(Color.red(i), Color.red(i2), f2), a(Color.green(i), Color.green(i2), f2), a(Color.blue(i), Color.blue(i2), f2));
    }

    private int a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
