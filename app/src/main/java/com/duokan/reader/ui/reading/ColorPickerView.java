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

import com.duokan.p023b.C0243e;
import com.duokan.reader.common.bitmap.C0544a;

public class ColorPickerView extends View {
    /* renamed from: A */
    private int f9061A;
    /* renamed from: a */
    private Context f9062a;
    /* renamed from: b */
    private Paint f9063b;
    /* renamed from: c */
    private int f9064c;
    /* renamed from: d */
    private int f9065d;
    /* renamed from: e */
    private int[] f9066e;
    /* renamed from: f */
    private int f9067f;
    /* renamed from: g */
    private int f9068g;
    /* renamed from: h */
    private Drawable f9069h;
    /* renamed from: i */
    private Drawable f9070i;
    /* renamed from: j */
    private Paint f9071j;
    /* renamed from: k */
    private final int f9072k;
    /* renamed from: l */
    private boolean f9073l;
    /* renamed from: m */
    private boolean f9074m;
    /* renamed from: n */
    private PointF f9075n;
    /* renamed from: o */
    private PointF f9076o;
    /* renamed from: p */
    private by f9077p;
    /* renamed from: q */
    private boolean f9078q;
    /* renamed from: r */
    private boolean f9079r;
    /* renamed from: s */
    private float f9080s;
    /* renamed from: t */
    private Bitmap f9081t;
    /* renamed from: u */
    private float f9082u;
    /* renamed from: v */
    private int f9083v;
    /* renamed from: w */
    private int f9084w;
    /* renamed from: x */
    private int f9085x;
    /* renamed from: y */
    private float f9086y;
    /* renamed from: z */
    private float f9087z;

    public ColorPickerView(Context context) {
        this(context, null);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9073l = false;
        this.f9074m = false;
        this.f9078q = false;
        this.f9079r = false;
        this.f9061A = Integer.MAX_VALUE;
        this.f9062a = context;
        m12399a();
        this.f9072k = this.f9069h.getIntrinsicWidth() / 2;
        this.f9084w = this.f9083v;
        this.f9085x = this.f9083v;
        this.f9086y = -1.0f;
    }

    public void setOnColorChangedListenner(by byVar) {
        this.f9077p = byVar;
    }

    /* renamed from: a */
    public void m12407a(int i, float f) {
        this.f9083v = i;
        this.f9087z = f;
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    private void m12399a() {
        this.f9063b = new Paint();
        this.f9063b.setStyle(Style.FILL);
        this.f9063b.setStrokeWidth(1.0f);
        this.f9066e = new int[3];
        this.f9066e[0] = -1;
        this.f9066e[2] = -16777216;
        this.f9071j = new Paint();
        this.f9069h = getResources().getDrawable(C0243e.reading__color_view__button);
        this.f9080s = (float) (this.f9069h.getIntrinsicWidth() / 2);
        this.f9075n = new PointF((float) this.f9072k, (float) this.f9072k);
        this.f9070i = getResources().getDrawable(C0243e.reading__color_view__saturation);
        this.f9076o = new PointF((float) this.f9072k, (float) this.f9072k);
        this.f9082u = (float) (this.f9070i.getIntrinsicHeight() / 2);
        this.f9067f = this.f9070i.getIntrinsicWidth() / 2;
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(getGradual(), null, new Rect(this.f9072k, this.f9072k, this.f9072k + this.f9068g, this.f9064c - this.f9072k), this.f9071j);
        this.f9066e[1] = this.f9063b.getColor();
        this.f9063b.setShader(new LinearGradient((float) ((this.f9065d - this.f9072k) - (this.f9067f / 2)), (float) this.f9072k, (float) ((this.f9065d - this.f9072k) - (this.f9067f / 2)), (float) (this.f9064c - this.f9072k), this.f9066e, null, TileMode.MIRROR));
        canvas.drawRect(new Rect((this.f9065d - this.f9067f) - this.f9072k, this.f9072k, this.f9065d - this.f9072k, this.f9064c - this.f9072k), this.f9063b);
        int round = Math.round(this.f9075n.x - this.f9080s);
        int round2 = Math.round(this.f9075n.y - this.f9080s);
        this.f9069h.setBounds(round, round2, this.f9069h.getIntrinsicWidth() + round, this.f9069h.getIntrinsicHeight() + round2);
        this.f9069h.draw(canvas);
        round = ((this.f9065d - this.f9067f) - this.f9072k) - ((this.f9070i.getIntrinsicWidth() - this.f9067f) / 2);
        round2 = Math.round(this.f9076o.y - this.f9082u);
        this.f9070i.setBounds(round, round2, this.f9070i.getIntrinsicWidth() + round, this.f9070i.getIntrinsicHeight() + round2);
        this.f9070i.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.f9065d = size;
        } else {
            this.f9065d = 480;
        }
        if (mode2 == 1073741824) {
            this.f9064c = size2;
        } else {
            this.f9064c = 350;
        }
        this.f9068g = (this.f9065d - (this.f9072k * 3)) - this.f9067f;
        setMeasuredDimension(this.f9065d, this.f9064c);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.f9076o.y = (((float) (this.f9064c - (this.f9072k * 2))) * this.f9087z) + ((float) this.f9072k);
        Bitmap gradual = getGradual();
        for (int i5 = 0; i5 < gradual.getWidth(); i5++) {
            for (int i6 = 0; i6 < gradual.getHeight(); i6++) {
                if (gradual.getPixel(i5, i6) == this.f9083v) {
                    this.f9075n.x = (float) (i5 + this.f9072k);
                    this.f9075n.y = (float) (this.f9072k + i6);
                    this.f9063b.setColor(this.f9083v);
                    super.onLayout(changed, left, top, right, bottom);
                    return;
                }
            }
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.f9073l = m12401a(x, y);
                this.f9074m = m12403b(x, y);
                if (this.f9073l) {
                    this.f9078q = true;
                    m12404c(x, y);
                    this.f9063b.setColor(m12406e(this.f9075n.x - ((float) this.f9072k), this.f9075n.y - ((float) this.f9072k)));
                } else if (this.f9074m) {
                    this.f9079r = true;
                    m12405d(x, y);
                }
                invalidate();
                int b = m12402b(this.f9076o.y - ((float) this.f9072k));
                if (this.f9061A == Integer.MAX_VALUE || this.f9061A != b) {
                    this.f9061A = b;
                    x = (this.f9076o.y - ((float) this.f9072k)) / ((float) (this.f9064c - (this.f9072k * 2)));
                    if (this.f9077p != null && m12400a(x)) {
                        this.f9084w = this.f9061A;
                        this.f9085x = this.f9063b.getColor();
                        this.f9086y = x;
                        this.f9077p.mo2315a(this.f9061A, this.f9063b.getColor(), x);
                        break;
                    }
                }
            case 1:
                if (this.f9073l) {
                    this.f9073l = false;
                } else if (this.f9074m) {
                    this.f9074m = false;
                }
                this.f9078q = false;
                this.f9079r = false;
                invalidate();
                if (this.f9077p != null) {
                    this.f9077p.mo2315a(m12402b(this.f9076o.y - ((float) this.f9072k)), this.f9063b.getColor(), (this.f9076o.y - ((float) this.f9072k)) / ((float) (this.f9064c - (this.f9072k * 2))));
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m12400a(float f) {
        return (this.f9084w == this.f9061A && this.f9085x == this.f9063b.getColor() && this.f9086y == f) ? false : true;
    }

    protected void onDetachedFromWindow() {
        if (!(this.f9081t == null || this.f9081t.isRecycled())) {
            this.f9081t.recycle();
        }
        super.onDetachedFromWindow();
    }

    private Bitmap getGradual() {
        if (this.f9081t == null) {
            Paint paint = new Paint();
            paint.setStrokeWidth(1.0f);
            this.f9081t = C0544a.m2447c(this.f9068g, this.f9064c - (this.f9072k * 2), Config.RGB_565);
            Canvas canvas = new Canvas(this.f9081t);
            int width = this.f9081t.getWidth();
            this.f9068g = width;
            int height = this.f9081t.getHeight();
            paint.setShader(new ComposeShader(new LinearGradient(0.0f, (float) (height / 2), (float) width, (float) (height / 2), new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281}, null, TileMode.REPEAT), new LinearGradient((float) (width / 2), 0.0f, (float) (width / 2), (float) height, -1, -16777216, TileMode.CLAMP), Mode.SCREEN));
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, paint);
        }
        return this.f9081t;
    }

    /* renamed from: a */
    private boolean m12401a(float f, float f2) {
        if (0.0f >= f || f >= ((float) ((this.f9072k + this.f9068g) + (this.f9072k / 2))) || 0.0f >= f2 || f2 >= ((float) this.f9065d)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m12403b(float f, float f2) {
        if (((float) (((this.f9065d - this.f9072k) - this.f9067f) - (this.f9072k / 2))) >= f || f >= ((float) this.f9065d) || 0.0f >= f2 || f2 >= ((float) this.f9064c)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private void m12404c(float f, float f2) {
        if (f < ((float) this.f9072k)) {
            this.f9075n.x = (float) this.f9072k;
        } else if (f > ((float) (this.f9072k + this.f9068g))) {
            this.f9075n.x = (float) (this.f9072k + this.f9068g);
        } else {
            this.f9075n.x = f;
        }
        if (f2 < ((float) this.f9072k)) {
            this.f9075n.y = (float) this.f9072k;
        } else if (f2 > ((float) (this.f9064c - this.f9072k))) {
            this.f9075n.y = (float) (this.f9064c - this.f9072k);
        } else {
            this.f9075n.y = f2;
        }
    }

    /* renamed from: d */
    private void m12405d(float f, float f2) {
        if (f < ((float) this.f9072k)) {
            this.f9076o.x = (float) this.f9072k;
        } else if (f > ((float) (this.f9072k + this.f9068g))) {
            this.f9076o.x = (float) (this.f9072k + this.f9068g);
        } else {
            this.f9076o.x = f;
        }
        if (f2 < ((float) this.f9072k)) {
            this.f9076o.y = (float) this.f9072k;
        } else if (f2 > ((float) (this.f9064c - this.f9072k))) {
            this.f9076o.y = (float) (this.f9064c - this.f9072k);
        } else {
            this.f9076o.y = f2;
        }
    }

    /* renamed from: e */
    private int m12406e(float f, float f2) {
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

    /* renamed from: b */
    private int m12402b(float f) {
        int i;
        int i2;
        float f2 = (((float) this.f9064c) - (((float) this.f9072k) * 2.0f)) / 2.0f;
        if (f < f2) {
            i = this.f9066e[0];
            i2 = this.f9066e[1];
            f2 = f / f2;
        } else {
            i = this.f9066e[1];
            i2 = this.f9066e[2];
            f2 = (f - f2) / f2;
        }
        return Color.argb(m12398a(Color.alpha(i), Color.alpha(i2), f2), m12398a(Color.red(i), Color.red(i2), f2), m12398a(Color.green(i), Color.green(i2), f2), m12398a(Color.blue(i), Color.blue(i2), f2));
    }

    /* renamed from: a */
    private int m12398a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
