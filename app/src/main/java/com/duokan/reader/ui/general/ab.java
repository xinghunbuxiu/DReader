package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;

import com.duokan.b.e;
import com.duokan.core.sys.t;
import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.DkSimulationInterpolator.Mode;

final class ab extends Drawable {
    final /* synthetic */ z a;
    private final Drawable b;
    private final Rect c = new Rect(0, 0, 0, 0);
    private AlphaAnimation d = null;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private int h = 255;

    public ab(z zVar) {
        this.a = zVar;
        this.b = cn.a(zVar.c, e.general__shared__book_category_shadow);
    }

    public boolean a() {
        return this.g;
    }

    public void b() {
        this.g = true;
        a(this.c.width(), (this.c.width() + this.a.e.left) + this.a.e.right, this.c.height(), (this.c.height() + this.a.e.top) + this.a.e.bottom);
    }

    public void c() {
        a((this.c.width() + this.a.e.left) + this.a.e.right, this.c.width(), (this.c.height() + this.a.e.top) + this.a.e.bottom, this.c.height());
    }

    public boolean getPadding(Rect rect) {
        if (this.b != null) {
            return this.b.getPadding(rect);
        }
        return false;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.c.set(getBounds());
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            int i;
            int i2;
            if (this.e != 0) {
                i = this.e;
                i2 = this.f;
            } else {
                i = this.c.width();
                i2 = this.c.height();
            }
            canvas.save();
            int width = (this.c.width() - i) / 2;
            int height = (this.c.height() - i2) / 2;
            Rect rect = (Rect) dv.g.a();
            rect.set(width, height, i + width, i2 + height);
            this.b.setBounds(rect);
            this.b.draw(canvas);
            canvas.restore();
            dv.g.a(rect);
        }
    }

    public void setAlpha(int i) {
        if (this.h != i && this.b != null) {
            this.h = i;
            this.b.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    private void a(int i, int i2, int i3, int i4) {
        this.d = new AlphaAnimation(0.0f, 1.0f);
        this.d.setFillEnabled(true);
        this.d.setFillAfter(true);
        this.d.setDuration(250);
        this.d.setInterpolator(new DkSimulationInterpolator(Mode.ACCELERATE));
        Runnable acVar = new ac(this, i2, i, i4, i3);
        this.d.start();
        t.a(acVar);
    }

    private void d() {
        this.f = 0;
        this.e = 0;
    }
}
