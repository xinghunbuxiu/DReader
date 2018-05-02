package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.RectF;

import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.b;

class xl extends b {
    final /* synthetic */ xk a;

    public xl(xk xkVar, int i, int i2) {
        this.a = xkVar;
        super(Config.ARGB_8888, UTools.async);
    }

    public int getIntrinsicWidth() {
        return this.a.b.b();
    }

    public int getIntrinsicHeight() {
        return this.a.b.c();
    }

    protected void a(Bitmap bitmap, RectF rectF, float f) {
        rectF.round(this.a.d);
        bitmap.eraseColor(0);
        this.a.b.a(bitmap, this.a.d);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.a.invalidate();
    }
}
