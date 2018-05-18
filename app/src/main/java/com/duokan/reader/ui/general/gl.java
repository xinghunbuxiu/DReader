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
import com.duokan.core.p027b.UrlTools;
import org.apache.http.HttpHost;

public class gl extends Drawable {
    /* renamed from: a */
    public static final Paint f7285a = new Paint();
    /* renamed from: b */
    private Drawable f7286b;
    /* renamed from: c */
    private final Context f7287c;
    /* renamed from: d */
    private Paint f7288d = null;
    /* renamed from: e */
    private String f7289e = null;
    /* renamed from: f */
    private Drawable f7290f = null;
    /* renamed from: g */
    private PicStretch f7291g = PicStretch.SCALE_INSIDE;
    /* renamed from: h */
    private ColorMatrix f7292h;
    /* renamed from: i */
    private go f7293i = null;
    /* renamed from: j */
    private Drawable f7294j = null;
    /* renamed from: k */
    private float f7295k = 0.0f;
    /* renamed from: l */
    private boolean f7296l = true;
    /* renamed from: m */
    private boolean f7297m = false;
    /* renamed from: n */
    private gn f7298n;

    static {
        f7285a.setFilterBitmap(true);
        f7285a.setAntiAlias(true);
    }

    public gl(Context context) {
        this.f7287c = context.getApplicationContext();
        this.f7288d = f7285a;
        this.f7298n = new gn();
    }

    /* renamed from: a */
    public final Drawable m10711a() {
        return this.f7290f;
    }

    /* renamed from: a */
    public final void m10716a(Drawable drawable) {
        if (this.f7290f != drawable) {
            this.f7290f = drawable;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public final void m10713a(int i) {
        this.f7286b = this.f7287c.getResources().getDrawable(i);
    }

    /* renamed from: b */
    public final void m10722b(Drawable drawable) {
        this.f7286b = drawable;
    }

    /* renamed from: b */
    public final String m10721b() {
        return this.f7289e;
    }

    /* renamed from: a */
    public final void m10720a(String str) {
        if (!m10709b(str)) {
            m10710c(str);
            if (!TextUtils.isEmpty(this.f7289e)) {
                if (UrlTools.equalsIgnoreCase(this.f7289e, HttpHost.DEFAULT_SCHEME_NAME, "https")) {
                    m10706a(new GlideUrl(this.f7289e, new Builder().addHeader("Accept-Encoding", "gzip,deflate,sdch").build()));
                } else {
                    m10706a(this.f7289e);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m10719a(CustomGlideUrl c1342n) {
        if (TextUtils.isEmpty(c1342n.getId())) {
            m10720a(c1342n.getSafeUrl());
        } else if (!m10709b(c1342n.getSafeUrl())) {
            m10710c(c1342n.getSafeUrl());
            if (!TextUtils.isEmpty(this.f7289e)) {
                if (this.f7286b != null) {
                    Glide.with(this.f7287c).load((Object) c1342n).asBitmap().placeholder(this.f7286b).error(this.f7286b).into(this.f7298n);
                } else if (!TextUtils.isEmpty(c1342n.getSafeUrl()) || this.f7293i == null) {
                    Glide.with(this.f7287c).load((Object) c1342n).asBitmap().into(this.f7298n);
                } else {
                    this.f7293i.mo1790b(this);
                    invalidateSelf();
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m10709b(String str) {
        if (TextUtils.equals(str, this.f7289e)) {
            if (TextUtils.isEmpty(str)) {
                this.f7294j = this.f7286b;
                return true;
            } else if (this.f7298n.getRequest().isResourceSet()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private void m10710c(String str) {
        Glide.clear(this.f7298n);
        this.f7289e = str;
        this.f7294j = this.f7286b;
        invalidateSelf();
    }

    /* renamed from: a */
    private void m10706a(Object obj) {
        if (this.f7286b != null) {
            Glide.with(this.f7287c).load(obj).asBitmap().placeholder(this.f7286b).error(this.f7286b).into(this.f7298n);
        } else if (!TextUtils.isEmpty(obj.toString()) || this.f7293i == null) {
            Glide.with(this.f7287c).load(obj).asBitmap().into(this.f7298n);
        } else {
            this.f7293i.mo1790b(this);
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public final void m10717a(PicStretch picStretch) {
        if (this.f7291g != picStretch) {
            this.f7291g = picStretch;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public final void m10715a(ColorMatrix colorMatrix) {
        if (colorMatrix != null && this.f7288d == f7285a) {
            this.f7288d = new Paint(f7285a);
        }
        if (this.f7292h != colorMatrix) {
            this.f7292h = colorMatrix;
            this.f7288d.setColorFilter(new ColorMatrixColorFilter(this.f7292h));
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public final void m10712a(float f) {
        this.f7295k = f;
    }

    public void setAlpha(int i) {
        if (i != 255 && this.f7288d == f7285a) {
            this.f7288d = new Paint(f7285a);
        }
        if (this.f7288d.getAlpha() != i) {
            this.f7288d.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    /* renamed from: c */
    public final float m10723c() {
        return this.f7295k;
    }

    /* renamed from: d */
    public final boolean m10724d() {
        return this.f7296l;
    }

    /* renamed from: a */
    public void m10714a(Canvas canvas) {
        if (this.f7294j != null) {
            this.f7294j.setBounds(getBounds());
            this.f7294j.draw(canvas);
            if (this.f7297m) {
                this.f7296l = false;
            }
        }
    }

    public void draw(Canvas canvas) {
        m10714a(canvas);
    }

    /* renamed from: a */
    public final void m10718a(go goVar) {
        this.f7293i = goVar;
    }
}
