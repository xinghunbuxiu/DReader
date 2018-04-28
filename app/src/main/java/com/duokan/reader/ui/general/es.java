package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.duokan.core.ui.dv;
import java.lang.ref.WeakReference;

public class es extends Drawable {
    /* renamed from: a */
    private View f7131a = null;
    /* renamed from: b */
    private boolean f7132b = false;
    /* renamed from: c */
    private boolean f7133c = true;
    /* renamed from: d */
    private int f7134d = -1;
    /* renamed from: e */
    private int f7135e = -1;
    /* renamed from: f */
    private boolean f7136f = false;

    /* renamed from: b */
    public void m10544b(View view) {
        if (this.f7131a != view) {
            this.f7131a = view;
            if (this.f7131a != null) {
                m10533a(new WeakReference(this), this.f7131a);
                invalidateSelf();
                return;
            }
            m10536b();
        }
    }

    /* renamed from: a */
    public void m10543a(boolean z) {
        if (this.f7136f != z) {
            this.f7136f = z;
            if (this.f7136f) {
                m10533a(new WeakReference(this), this.f7131a);
            }
        }
    }

    public void draw(Canvas canvas) {
        m10532a(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -3;
    }

    public int getIntrinsicWidth() {
        return this.f7134d;
    }

    public int getIntrinsicHeight() {
        return this.f7135e;
    }

    public void invalidateSelf() {
        this.f7132b = false;
        super.invalidateSelf();
    }

    /* renamed from: a */
    private void m10532a(Canvas canvas) {
        m10536b();
        if (!this.f7133c) {
            Rect bounds = getBounds();
            if (!bounds.isEmpty()) {
                float width = ((float) bounds.width()) / ((float) this.f7134d);
                float height = ((float) bounds.height()) / ((float) this.f7135e);
                canvas.save();
                canvas.translate((float) bounds.left, (float) bounds.top);
                canvas.scale(width, height);
                canvas.translate((float) (-bounds.left), (float) (-bounds.top));
                mo1770a(canvas, this.f7131a);
                canvas.restore();
            }
        }
    }

    /* renamed from: b */
    private void m10536b() {
        if (this.f7131a == null || this.f7134d <= 0 || this.f7135e <= 0) {
            if (!this.f7133c) {
                mo1769a();
                this.f7133c = true;
            }
        } else if (!this.f7132b) {
            mo1771a(this.f7131a);
            this.f7133c = false;
        }
        this.f7132b = true;
    }

    /* renamed from: a */
    protected void mo1770a(Canvas canvas, View view) {
        view.draw(canvas);
    }

    /* renamed from: a */
    protected void mo1771a(View view) {
    }

    /* renamed from: a */
    protected void mo1769a() {
    }

    /* renamed from: a */
    private static void m10533a(WeakReference<es> weakReference, View view) {
        if (weakReference != null && view != null) {
            dv.m1922a(view, new et(weakReference, view));
            view.invalidate();
        }
    }
}
