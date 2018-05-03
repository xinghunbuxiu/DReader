package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.AnimUtils;
import com.duokan.kernel.DkUtils;
import com.duokan.reader.common.bitmap.C0544a;

/* renamed from: com.duokan.reader.ui.general.e */
public class C1330e extends es {
    /* renamed from: a */
    private final Paint f7137a = new Paint();
    /* renamed from: b */
    private int f7138b = 0;
    /* renamed from: c */
    private Bitmap f7139c = null;

    public C1330e() {
        this.f7137a.setAntiAlias(true);
        this.f7137a.setFilterBitmap(true);
        this.f7138b = 60;
    }

    /* renamed from: a */
    protected void mo1770a(Canvas canvas, View view) {
        if (this.f7138b <= 0 || this.f7139c == null) {
            super.mo1770a(canvas, view);
            return;
        }
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        rect.set(0, 0, this.f7139c.getWidth(), this.f7139c.getHeight());
        canvas.drawBitmap(this.f7139c, rect, getBounds(), this.f7137a);
        AnimUtils.f1198g.clearAnimation(rect);
    }

    /* renamed from: a */
    protected void mo1771a(View view) {
        int intrinsicWidth = getIntrinsicWidth() / 5;
        int intrinsicHeight = getIntrinsicHeight() / 5;
        if (this.f7138b > 0 && intrinsicWidth > 0 && intrinsicHeight > 0) {
            if (this.f7139c == null) {
                this.f7139c = C0544a.m2444b(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            } else if (!(this.f7139c.getWidth() == intrinsicWidth && this.f7139c.getHeight() == intrinsicHeight)) {
                this.f7139c.recycle();
                this.f7139c = C0544a.m2444b(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(this.f7139c);
            float width = ((float) intrinsicWidth) / ((float) view.getWidth());
            float height = ((float) intrinsicHeight) / ((float) view.getHeight());
            canvas.save();
            canvas.scale(width, height);
            view.draw(canvas);
            canvas.restore();
            DkUtils.blurBitmap(this.f7139c, this.f7138b);
        } else if (this.f7139c != null) {
            this.f7139c.recycle();
            this.f7139c = null;
        }
    }

    /* renamed from: a */
    protected void mo1769a() {
        if (this.f7139c != null) {
            this.f7139c.recycle();
            this.f7139c = null;
        }
    }
}
