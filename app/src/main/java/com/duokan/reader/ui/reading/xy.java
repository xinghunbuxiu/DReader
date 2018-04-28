package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.RectF;
import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.C1326b;

class xy extends C1326b {
    /* renamed from: a */
    final /* synthetic */ xx f11169a;

    public xy(xx xxVar, int i, int i2) {
        this.f11169a = xxVar;
        super(Config.ARGB_8888, dv.cathe);
    }

    public int getIntrinsicWidth() {
        return this.f11169a.f11165b.m6407b();
    }

    public int getIntrinsicHeight() {
        return this.f11169a.f11165b.m6411c();
    }

    /* renamed from: a */
    protected void mo2512a(Bitmap bitmap, RectF rectF, float f) {
        rectF.round(this.f11169a.f11167d);
        bitmap.eraseColor(0);
        this.f11169a.f11165b.m6406a(bitmap, this.f11169a.f11167d);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.f11169a.invalidate();
    }
}
