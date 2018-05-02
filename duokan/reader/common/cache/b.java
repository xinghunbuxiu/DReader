package com.duokan.reader.common.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.duokan.core.sys.e;
import com.duokan.reader.common.bitmap.a;

public abstract class b extends e {
    static final /* synthetic */ boolean b = (!a.class.desiredAssertionStatus());
    private final int c;
    private final int d;
    private final Config e;
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private Bitmap h = null;

    protected abstract void a(Bitmap bitmap);

    public b(int i, int i2, Config config) {
        this.c = i;
        this.d = i2;
        this.e = config;
    }

    public final boolean a(Canvas canvas, int i, int i2, float f, Paint paint) {
        if (!b && !g()) {
            throw new AssertionError();
        } else if (!g() || !e()) {
            return false;
        } else {
            if (Float.compare(f, 1.0f) == 0) {
                canvas.drawBitmap(this.h, (float) i, (float) i2, paint);
            } else {
                canvas.save();
                canvas.translate((float) i, (float) i2);
                canvas.scale(f, f);
                canvas.translate((float) (-i), (float) (-i2));
                canvas.drawBitmap(this.h, (float) i, (float) i2, paint);
                canvas.restore();
            }
            return true;
        }
    }

    public final int h() {
        return a.a(this.c, this.d, this.e);
    }

    public final int i() {
        return a.a(this.h);
    }

    protected final boolean j() {
        this.h = a.c(this.c, this.d, this.e);
        return true;
    }

    protected final boolean a(e eVar) {
        if (!eVar.getClass().equals(getClass())) {
            return false;
        }
        b bVar = (b) eVar;
        if (bVar.h == null || this.e != bVar.h.getConfig() || this.c > bVar.h.getWidth() || this.d > bVar.h.getHeight()) {
            return false;
        }
        this.h = bVar.h;
        bVar.h = null;
        return true;
    }

    protected final void k() {
        if (this.h != null && !this.h.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
    }

    protected final void l() {
        a(this.h);
    }
}
