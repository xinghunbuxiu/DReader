package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.duokan.core.ui.UTools;

import java.lang.ref.WeakReference;

public class eu extends Drawable {
    private View a = null;
    private boolean b = false;
    private boolean c = true;
    private int d = -1;
    private int e = -1;
    private boolean f = false;

    public void b(View view) {
        if (this.a != view) {
            this.a = view;
            if (this.a != null) {
                a(new WeakReference(this), this.a);
                invalidateSelf();
                return;
            }
            b();
        }
    }

    public void a(boolean z) {
        if (this.f != z) {
            this.f = z;
            if (this.f) {
                a(new WeakReference(this), this.a);
            }
        }
    }

    public void draw(Canvas canvas) {
        a(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -3;
    }

    public int getIntrinsicWidth() {
        return this.d;
    }

    public int getIntrinsicHeight() {
        return this.e;
    }

    public void invalidateSelf() {
        this.b = false;
        super.invalidateSelf();
    }

    private void a(Canvas canvas) {
        b();
        if (!this.c) {
            Rect bounds = getBounds();
            if (!bounds.isEmpty()) {
                float width = ((float) bounds.width()) / ((float) this.d);
                float height = ((float) bounds.height()) / ((float) this.e);
                canvas.save();
                canvas.translate((float) bounds.left, (float) bounds.top);
                canvas.scale(width, height);
                canvas.translate((float) (-bounds.left), (float) (-bounds.top));
                a(canvas, this.a);
                canvas.restore();
            }
        }
    }

    private void b() {
        if (this.a == null || this.d <= 0 || this.e <= 0) {
            if (!this.c) {
                a();
                this.c = true;
            }
        } else if (!this.b) {
            a(this.a);
            this.c = false;
        }
        this.b = true;
    }

    protected void a(Canvas canvas, View view) {
        view.draw(canvas);
    }

    protected void a(View view) {
    }

    protected void a() {
    }

    private static void a(WeakReference weakReference, View view) {
        if (weakReference != null && view != null) {
            UTools.creatCallTask(view, new ev(weakReference, view));
            view.invalidate();
        }
    }
}
