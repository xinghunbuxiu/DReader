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
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.ui.general.io;

public class PagesFrameView extends FrameLayout {
    /* renamed from: a */
    private final su f9108a;
    /* renamed from: b */
    private final Paint f9109b;
    /* renamed from: c */
    private final bc f9110c;
    /* renamed from: d */
    private final io f9111d;
    /* renamed from: e */
    private int f9112e;
    /* renamed from: f */
    private float f9113f;
    /* renamed from: g */
    private String f9114g;
    /* renamed from: h */
    private String f9115h;
    /* renamed from: i */
    private Bitmap f9116i;
    /* renamed from: j */
    private Bitmap f9117j;
    /* renamed from: k */
    private boolean f9118k;
    /* renamed from: l */
    private final BroadcastReceiver f9119l;
    /* renamed from: m */
    private final BroadcastReceiver f9120m;
    /* renamed from: n */
    private boolean f9121n;
    /* renamed from: o */
    private long f9122o;
    /* renamed from: p */
    private AlphaAnimation f9123p;
    /* renamed from: q */
    private Bitmap f9124q;
    /* renamed from: r */
    private Paint f9125r;
    /* renamed from: s */
    private Transformation f9126s;

    public PagesFrameView(Context context) {
        this(context, null);
    }

    public PagesFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9109b = new Paint();
        this.f9112e = 0;
        this.f9113f = 1.0f;
        this.f9114g = "";
        this.f9115h = "";
        this.f9116i = null;
        this.f9117j = null;
        this.f9118k = false;
        this.f9119l = new os(this);
        this.f9120m = new ot(this);
        this.f9121n = false;
        this.f9122o = 0;
        this.f9123p = null;
        this.f9124q = null;
        this.f9125r = null;
        this.f9126s = null;
        this.f9108a = (su) AppContext.getAppContext(context).queryFeature(su.class);
        this.f9109b.setSubpixelText(true);
        this.f9109b.setAntiAlias(true);
        this.f9110c = new bc(getContext());
        this.f9111d = new io(getContext());
        this.f9111d.m10797a().setSubpixelText(true);
        this.f9111d.m10797a().setTextSize((float) dv.m1932b(getContext(), 14.0f));
        this.f9111d.m10797a().setAntiAlias(true);
        this.f9111d.m10798a(19);
        getContext().registerReceiver(this.f9119l, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        getContext().registerReceiver(this.f9120m, new IntentFilter("android.intent.action.TIME_TICK"));
        m12432a(getSystemTime());
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
    }

    public void setStatusColor(int i) {
        this.f9112e = i;
        int argb = Color.argb(Math.round(((float) Color.alpha(this.f9112e)) * this.f9113f), Color.red(this.f9112e), Color.green(this.f9112e), Color.blue(this.f9112e));
        this.f9111d.m10797a().setColor(argb);
        this.f9110c.m13767b(argb);
        invalidate();
    }

    public void setStatusOpacity(float f) {
        this.f9113f = (float) Math.pow((double) f, 10.0d);
        int argb = Color.argb(Math.round(((float) Color.alpha(this.f9112e)) * this.f9113f), Color.red(this.f9112e), Color.green(this.f9112e), Color.blue(this.f9112e));
        this.f9111d.m10797a().setColor(argb);
        this.f9110c.m13767b(argb);
        invalidate();
    }

    /* renamed from: a */
    public void m12435a() {
        boolean z = true;
        if (this.f9108a.mo1992G().m4239l()) {
            this.f9118k = false;
            return;
        }
        C0903n document = this.f9108a.getDocument();
        gs X = this.f9108a.mo2007X();
        if (X != null && X.mo2329e()) {
            C0896a g = X.mo2331g();
            as h = X.mo2332h();
            C0911h h2 = document.mo1240h();
            this.f9115h = h2.mo1264a();
            C0901g b = h2.mo1267b(g);
            if (!(b == null || b.mo1203f().equals(g.mo1198g()))) {
                this.f9115h = b.mo1202e();
            }
            if (document.mo1246l().f4363k) {
                this.f9115h = DkUtils.chs2chtText(this.f9115h);
            }
            if (document.mo1234e() > 0 && h.mo1327j() >= 0) {
                this.f9114g = String.format("%d / %d", new Object[]{Long.valueOf(h.mo1327j() + 1), Long.valueOf(r6)});
            }
            if (X.mo2331g().m5817f()) {
                z = false;
            }
            this.f9118k = z;
            invalidate();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f9119l != null) {
            getContext().unregisterReceiver(this.f9119l);
        }
        if (this.f9120m != null) {
            getContext().unregisterReceiver(this.f9120m);
        }
    }

    public void draw(Canvas canvas) {
        if (this.f9108a.mo1993J()) {
            this.f9121n = false;
            if (this.f9122o == 0) {
                this.f9122o = getDrawingTime();
            }
            super.draw(canvas);
            m12427a(canvas);
            if (!this.f9121n) {
                this.f9122o = 0;
            }
            canvas.save();
            if (this.f9123p != null) {
                Rect rect = (Rect) dv.f1198g.addAnimation();
                rect.set(0, 0, getWidth(), getHeight());
                if (this.f9123p.hasEnded() || this.f9124q.getWidth() != getWidth() || this.f9124q.getHeight() != getHeight()) {
                    this.f9124q.recycle();
                    this.f9124q = null;
                    this.f9125r = null;
                    this.f9126s = null;
                    this.f9123p = null;
                } else if (!this.f9121n || this.f9123p.hasStarted()) {
                    if (!this.f9123p.hasStarted()) {
                        this.f9123p.start();
                    }
                    this.f9123p.getTransformation(getDrawingTime(), this.f9126s);
                    this.f9125r.setAlpha(Math.round(this.f9126s.getAlpha() * 255.0f));
                    canvas.drawBitmap(this.f9124q, null, rect, this.f9125r);
                    invalidate();
                } else {
                    this.f9125r.setAlpha(255);
                    canvas.drawBitmap(this.f9124q, null, rect, this.f9125r);
                }
                dv.f1198g.clearAnimation(rect);
            }
            canvas.restore();
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
        this.f9121n = true;
        super.invalidate();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m12434c();
    }

    /* renamed from: a */
    private void m12427a(Canvas canvas) {
        if (this.f9118k) {
            C0903n document = this.f9108a.getDocument();
            C0917k k = document.mo1245k();
            C0923m l = document.mo1246l();
            if (!k.mo1274c() && k.f4334e) {
                m12433b();
                this.f9109b.setTextSize((float) l.f4358f);
                if (k.f4332c.top >= l.f4358f && this.f9116i != null) {
                    this.f9109b.setAlpha(Math.round(this.f9113f * 255.0f));
                    canvas.drawBitmap(this.f9116i, 0.0f, 0.0f, this.f9109b);
                    if (l.f4365m && !TextUtils.isEmpty(this.f9115h)) {
                        this.f9109b.setColor(this.f9112e);
                        this.f9109b.setAlpha(Math.round(((float) Color.alpha(this.f9112e)) * this.f9113f));
                        m12428a(canvas, this.f9115h, 3, getWidth(), this.f9109b);
                    }
                }
                if (this.f9117j == null) {
                    return;
                }
                if (k.f4332c.bottom >= l.f4358f || this.f9108a.bg()) {
                    this.f9109b.setAlpha(Math.round(this.f9113f * 255.0f));
                    canvas.drawBitmap(this.f9117j, 0.0f, (float) (getHeight() - this.f9117j.getHeight()), this.f9109b);
                    if (k.f4332c.bottom >= l.f4358f) {
                        Rect rect = k.f4332c;
                        Rect rect2 = (Rect) dv.f1198g.addAnimation();
                        this.f9110c.m13768c(l.f4358f - dv.m1963g(getContext(), 2.0f));
                        rect2.set(getPaddingLeft() + rect.left, getHeight() - rect.bottom, rect.left + this.f9110c.getIntrinsicWidth(), (getHeight() - rect.bottom) + this.f9110c.getIntrinsicHeight());
                        this.f9110c.setBounds(rect2);
                        this.f9110c.draw(canvas);
                        Rect rect3 = (Rect) dv.f1198g.addAnimation();
                        rect3.set(rect2.right + dv.m1932b(getContext(), 8.0f), getHeight() - rect.bottom, getWidth() - rect.right, (getHeight() - rect.bottom) + this.f9110c.getIntrinsicHeight());
                        this.f9111d.setBounds(rect3);
                        this.f9111d.draw(canvas);
                        dv.f1198g.clearAnimation(rect3);
                        dv.f1198g.clearAnimation(rect2);
                        if (this.f9108a.bg()) {
                            this.f9108a.mo2017a(canvas, getWidth() / 2, (this.f9110c.getIntrinsicHeight() / 2) + (getHeight() - rect.bottom), getHeight() - dv.m1932b(getContext(), 65.0f), getHeight(), this.f9111d.m10797a().getColor());
                        }
                        if (!TextUtils.isEmpty(this.f9115h)) {
                            this.f9109b.setColor(this.f9112e);
                            this.f9109b.setAlpha(Math.round(((float) Color.alpha(this.f9112e)) * this.f9113f));
                            m12429a(canvas, this.f9114g, 53, this.f9109b);
                        }
                    } else if (this.f9108a.bg()) {
                        this.f9108a.mo2017a(canvas, getWidth() / 2, getHeight() - (this.f9117j.getHeight() / 2), getHeight() - dv.m1932b(getContext(), 65.0f), getHeight(), this.f9111d.m10797a().getColor());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m12433b() {
        C0917k k = this.f9108a.getDocument().mo1245k();
        C0923m l = this.f9108a.getDocument().mo1246l();
        Drawable background = getBackground();
        if (background != null) {
            int i = k.f4332c.top + k.f4333d.top;
            if (!(this.f9116i != null && this.f9116i.getWidth() == getWidth() && this.f9116i.getHeight() == i)) {
                if (this.f9116i != null) {
                    this.f9116i.recycle();
                    this.f9116i = null;
                }
                try {
                    this.f9116i = C0544a.m2447c(getWidth(), i, Config.ARGB_8888);
                } catch (Throwable th) {
                }
                if (this.f9116i != null) {
                    Canvas canvas = new Canvas(this.f9116i);
                    background.draw(canvas);
                    Paint paint = new Paint();
                    paint.setShader(new LinearGradient(0.0f, ((float) k.f4332c.top) + (((float) k.f4333d.top) * 0.3f), 0.0f, (float) i, -16777216, 0, TileMode.CLAMP));
                    paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                    canvas.drawRect(0.0f, 0.0f, (float) this.f9116i.getWidth(), (float) this.f9116i.getHeight(), paint);
                }
            }
            int b = (k.f4332c.bottom + k.f4333d.bottom) + dv.m1932b(getContext(), 5.0f);
            if (this.f9117j == null || this.f9117j.getWidth() != getWidth() || this.f9117j.getHeight() != b) {
                int intrinsicHeight;
                if (this.f9117j != null) {
                    this.f9117j.recycle();
                    this.f9117j = null;
                }
                if (this.f9108a.bg()) {
                    intrinsicHeight = b + ((this.f9108a.bh().getIntrinsicHeight() / 2) - ((l.f4358f - dv.m1963g(getContext(), 2.0f)) / 2));
                } else {
                    intrinsicHeight = b;
                }
                try {
                    this.f9117j = C0544a.m2447c(getWidth(), intrinsicHeight, Config.ARGB_8888);
                } catch (Throwable th2) {
                }
                if (this.f9117j != null) {
                    Canvas canvas2 = new Canvas(this.f9117j);
                    b = -(getHeight() - this.f9117j.getHeight());
                    canvas2.translate(0.0f, (float) b);
                    background.draw(canvas2);
                    canvas2.translate(0.0f, (float) (-b));
                    Paint paint2 = new Paint();
                    paint2.setShader(new LinearGradient(0.0f, Math.min((float) k.f4333d.bottom, ((float) intrinsicHeight) * 0.2f), 0.0f, 0.0f, -16777216, 0, TileMode.CLAMP));
                    paint2.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
                    canvas2.drawRect(0.0f, 0.0f, (float) this.f9117j.getWidth(), (float) this.f9117j.getHeight(), paint2);
                }
            }
        }
    }

    /* renamed from: c */
    private void m12434c() {
        if (this.f9116i != null) {
            this.f9116i.recycle();
            this.f9116i = null;
        }
        if (this.f9117j != null) {
            this.f9117j.recycle();
            this.f9117j = null;
        }
    }

    /* renamed from: a */
    private void m12432a(String str) {
        this.f9111d.m10799a(getSystemTime());
        invalidate();
    }

    /* renamed from: a */
    private void m12426a(int i) {
        this.f9110c.m13766a(i);
        invalidate();
    }

    private String getSystemTime() {
        if (DateFormat.is24HourFormat(getContext())) {
            return (String) DateFormat.format("kk:mm", System.currentTimeMillis());
        }
        return (String) DateFormat.format("hh:mm", System.currentTimeMillis());
    }

    /* renamed from: a */
    private void m12428a(Canvas canvas, String str, int i, int i2, Paint paint) {
        C0917k k = this.f9108a.getDocument().mo1245k();
        RectF rectF = (RectF) dv.f1199h.addAnimation();
        if (i == 3) {
            rectF.set((float) k.f4332c.left, 0.0f, (float) Math.min(getWidth() - k.f4332c.right, k.f4332c.left + i2), (float) k.f4332c.top);
        } else {
            rectF.set((float) Math.max((getWidth() - k.f4332c.right) - i2, k.f4332c.left), 0.0f, (float) (getWidth() - k.f4332c.right), (float) k.f4332c.top);
        }
        dv.m1914a(canvas, str, rectF, i | 80, paint);
        dv.f1199h.clearAnimation(rectF);
    }

    /* renamed from: a */
    private void m12429a(Canvas canvas, String str, int i, Paint paint) {
        C0917k k = this.f9108a.getDocument().mo1245k();
        this.f9108a.getDocument().mo1246l();
        Rect rect = (Rect) dv.f1198g.addAnimation();
        rect.set(k.f4332c.left, getHeight() - k.f4332c.bottom, getWidth() - k.f4332c.right, getHeight());
        dv.m1913a(canvas, str, rect, i | 16, paint);
        dv.f1198g.clearAnimation(rect);
    }
}
