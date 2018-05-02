package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders.Builder;

import org.apache.http.HttpHost;

public class gw extends Drawable {
    public static final Paint a = new Paint();
    private Drawable b;
    private final Context c;
    private Paint d = null;
    private String e = null;
    private Drawable f = null;
    private PicStretch g = PicStretch.SCALE_INSIDE;
    private ColorMatrix h;
    private gz i = null;
    private Drawable j = null;
    private float k = 0.0f;
    private boolean l = true;
    private boolean m = false;
    private gy n;

    static {
        a.setFilterBitmap(true);
        a.setAntiAlias(true);
    }

    public gw(Context context) {
        this.c = context.getApplicationContext();
        this.d = a;
        this.n = new gy();
    }

    public final Drawable a() {
        return this.f;
    }

    public final void a(Drawable drawable) {
        if (this.f != drawable) {
            this.f = drawable;
            invalidateSelf();
        }
    }

    public final void a(int i) {
        this.b = this.c.getResources().getDrawable(i);
    }

    public final void b(Drawable drawable) {
        this.b = drawable;
    }

    public final String b() {
        return this.e;
    }

    public final void a(String str) {
        if (!b(str)) {
            c(str);
            if (!TextUtils.isEmpty(this.e)) {
                if (a.a(this.e, HttpHost.DEFAULT_SCHEME_NAME, "https")) {
                    a(new GlideUrl(this.e, new Builder().addHeader("Accept-Encoding", "gzip,deflate,sdch").build()));
                } else {
                    a(this.e);
                }
            }
        }
    }

    public final void a(n nVar) {
        if (TextUtils.isEmpty(nVar.a())) {
            a(nVar.b());
        } else if (!b(nVar.b())) {
            c(nVar.b());
            if (!TextUtils.isEmpty(this.e)) {
                if (this.b != null) {
                    Glide.with(this.c).load((Object) nVar).asBitmap().placeholder(this.b).error(this.b).into(this.n);
                } else if (!TextUtils.isEmpty(nVar.b()) || this.i == null) {
                    Glide.with(this.c).load((Object) nVar).asBitmap().into(this.n);
                } else {
                    this.i.b(this);
                    invalidateSelf();
                }
            }
        }
    }

    private boolean b(String str) {
        if (TextUtils.equals(str, this.e)) {
            if (TextUtils.isEmpty(str)) {
                this.j = this.b;
                return true;
            } else if (this.n.getRequest().isResourceSet()) {
                return true;
            }
        }
        return false;
    }

    private void c(String str) {
        Glide.clear(this.n);
        this.e = str;
        this.j = this.b;
        invalidateSelf();
    }

    private void a(Object obj) {
        if (this.b != null) {
            Glide.with(this.c).load(obj).asBitmap().placeholder(this.b).error(this.b).into(this.n);
        } else if (!TextUtils.isEmpty(obj.toString()) || this.i == null) {
            Glide.with(this.c).load(obj).asBitmap().into(this.n);
        } else {
            this.i.b(this);
            invalidateSelf();
        }
    }

    public final void a(PicStretch picStretch) {
        if (this.g != picStretch) {
            this.g = picStretch;
            invalidateSelf();
        }
    }

    public final void a(ColorMatrix colorMatrix) {
        if (colorMatrix != null && this.d == a) {
            this.d = new Paint(a);
        }
        if (this.h != colorMatrix) {
            this.h = colorMatrix;
            this.d.setColorFilter(new ColorMatrixColorFilter(this.h));
            invalidateSelf();
        }
    }

    public final void a(float f) {
        this.k = f;
    }

    public void setAlpha(int i) {
        if (i != 255 && this.d == a) {
            this.d = new Paint(a);
        }
        if (this.d.getAlpha() != i) {
            this.d.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public final float c() {
        return this.k;
    }

    public final boolean d() {
        return this.l;
    }

    public void a(Canvas canvas) {
        if (this.j != null) {
            this.j.setBounds(getBounds());
            this.j.draw(canvas);
            if (this.m) {
                this.l = false;
            }
        }
    }

    public void draw(Canvas canvas) {
        a(canvas);
    }

    public final void a(gz gzVar) {
        this.i = gzVar;
    }
}
