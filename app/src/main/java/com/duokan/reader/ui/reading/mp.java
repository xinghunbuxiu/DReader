package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import com.duokan.core.sys.ag;

class mp implements ag<Bitmap> {
    /* renamed from: a */
    final /* synthetic */ mo f10636a;

    mp(mo moVar) {
        this.f10636a = moVar;
    }

    public /* synthetic */ void run(Object obj) {
        m14673a((Bitmap) obj);
    }

    /* renamed from: a */
    public void m14673a(Bitmap bitmap) {
        if (this.f10636a.getWindowToken() != null) {
            this.f10636a.f10632b = bitmap;
            this.f10636a.invalidate();
        } else if (bitmap != null) {
            bitmap.recycle();
        }
    }
}
