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
import com.duokan.core.ui.dv;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.document.epub.at;
import com.duokan.reader.domain.document.epub.av;
import java.util.concurrent.Future;
import org.apache.http.HttpStatus;

class la extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ kz f10546a;
    /* renamed from: b */
    private boolean f10547b = false;
    /* renamed from: c */
    private float f10548c = 1.0f;
    /* renamed from: d */
    private final ImageView f10549d;
    /* renamed from: e */
    private final ImageView f10550e;
    /* renamed from: f */
    private final ImageView f10551f;
    /* renamed from: g */
    private Bitmap f10552g = null;
    /* renamed from: h */
    private Bitmap f10553h = null;
    /* renamed from: i */
    private boolean f10554i = false;
    /* renamed from: j */
    private boolean f10555j = false;
    /* renamed from: k */
    private Future<?> f10556k = null;
    /* renamed from: l */
    private Transformation f10557l = new Transformation();
    /* renamed from: m */
    private AlphaAnimation f10558m = null;
    /* renamed from: n */
    private av f10559n = null;

    public la(kz kzVar, Context context) {
        this.f10546a = kzVar;
        super(context);
        this.f10550e = new ImageView(context);
        this.f10549d = new ImageView(context);
        this.f10551f = new ImageView(context);
        addView(this.f10549d, new LayoutParams(-1, -1, 17));
        addView(this.f10550e, new LayoutParams(-1, -1, 17));
        addView(this.f10551f, new LayoutParams(-1, -1, 17));
        this.f10549d.setScaleType(ScaleType.FIT_CENTER);
        this.f10550e.setScaleType(ScaleType.FIT_CENTER);
        this.f10551f.setScaleType(ScaleType.FIT_CENTER);
        this.f10551f.setVisibility(4);
        setBackgroundColor(Color.argb(Math.round(12.75f), 0, 0, 0));
    }

    /* renamed from: a */
    public void m14609a(boolean z) {
        boolean z2 = z || C0559f.m2476b().m2486e();
        av b = m14594b(z2);
        if (!(b == null || this.f10559n == b)) {
            fp fpVar = (fp) this.f10546a.f10541b.mo1992G();
            this.f10559n = b;
            if (this.f10556k != null) {
                this.f10556k.cancel(true);
                this.f10556k = null;
            }
            this.f10556k = fpVar.m4477a(b, toString(), new lb(this, b));
        }
        if (z) {
            m14598c();
            if (!this.f10547b) {
                this.f10547b = true;
                return;
            }
            return;
        }
        m14595b();
        if (this.f10547b) {
            dv.m1921a((View) this, new lc(this));
            if (this.f10550e.getVisibility() == 0) {
                this.f10558m = new AlphaAnimation(1.0f, 0.0f);
                this.f10558m.setDuration(500);
                this.f10550e.invalidate();
                this.f10549d.setVisibility(0);
                dv.startAlphaAnimation(this.f10550e, 1.0f, 0.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, false, new ld(this));
            }
        }
    }

    /* renamed from: a */
    public float m14608a() {
        return this.f10548c;
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int b = this.f10546a.f10542c.mo1396k().mo1402b();
        int c = this.f10546a.f10542c.mo1396k().mo1403c();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            measureChild(getChildAt(i3), MeasureSpec.makeMeasureSpec(b, 1073741824), MeasureSpec.makeMeasureSpec(c, 1073741824));
        }
        if (this.f10547b) {
            this.f10548c = Math.min(((float) size) / ((float) b), ((float) size2) / ((float) c));
        } else {
            this.f10548c = Math.max(((float) size) / ((float) b), ((float) size2) / ((float) c));
        }
        setMeasuredDimension(b, c);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view != this.f10550e || this.f10558m == null) {
            return super.drawChild(canvas, view, j);
        }
        float f;
        int e = this.f10546a.f10542c.mo1390e();
        int f2 = this.f10546a.f10542c.mo1391f();
        int width = getWidth();
        int height = getHeight();
        if (this.f10558m == null || this.f10558m.hasEnded()) {
            f = 1.0f;
        } else {
            if (!this.f10558m.hasStarted()) {
                this.f10558m.setStartTime(j);
            }
            this.f10558m.getTransformation(j, this.f10557l);
            f = this.f10557l.getAlpha();
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
        m14609a(false);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10550e.setImageBitmap(null);
        if (this.f10553h != null) {
            this.f10553h.recycle();
            this.f10553h = null;
        }
        this.f10549d.setImageBitmap(null);
        if (this.f10552g != null) {
            this.f10552g.recycle();
            this.f10552g = null;
        }
        if (this.f10556k != null) {
            this.f10556k.cancel(true);
            this.f10556k = null;
        }
    }

    /* renamed from: b */
    private void m14595b() {
        if (this.f10552g == null || !this.f10554i) {
            this.f10546a.f10542c.mo1383a(new le(this));
        }
    }

    /* renamed from: c */
    private void m14598c() {
        if (this.f10553h == null || !this.f10555j) {
            this.f10546a.f10542c.mo1387b(new lh(this));
        } else if (this.f10550e.getVisibility() != 0) {
            this.f10558m = new AlphaAnimation(0.0f, 1.0f);
            this.f10558m.setDuration(500);
            this.f10550e.invalidate();
            this.f10549d.invalidate();
            this.f10551f.invalidate();
            this.f10550e.setVisibility(0);
            dv.startAlphaAnimation(this.f10550e, 0.0f, 1.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, false, new lg(this));
        }
    }

    /* renamed from: b */
    private av m14594b(boolean z) {
        av a = ((at) this.f10546a.f10542c).mo1409a(false);
        av a2 = ((at) this.f10546a.f10542c).mo1409a(true);
        if (a == null) {
            return null;
        }
        if (a.mo1073i()) {
            a2 = a;
        } else if (z) {
            a2 = a;
        } else if (a2 == null) {
            a2 = a;
        }
        if (a2.mo1073i()) {
            a2 = null;
        }
        return a2;
    }
}
