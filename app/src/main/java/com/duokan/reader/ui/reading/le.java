package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.dv;

class le implements ag<Bitmap> {
    /* renamed from: a */
    final /* synthetic */ la f10564a;

    le(la laVar) {
        this.f10564a = laVar;
    }

    public /* synthetic */ void run(Object obj) {
        m14611a((Bitmap) obj);
    }

    /* renamed from: a */
    public void m14611a(Bitmap bitmap) {
        if (this.f10564a.getWindowToken() == null) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        } else if (bitmap != null) {
            Bitmap f = this.f10564a.f10552g;
            this.f10564a.f10552g = bitmap;
            this.f10564a.f10554i = true;
            this.f10564a.f10549d.setImageBitmap(this.f10564a.f10552g);
            if (this.f10564a.f10549d.getVisibility() == 0) {
                if (f != null) {
                    this.f10564a.f10551f.setImageBitmap(f);
                    dv.hideAnimation(this.f10564a.f10551f, new lf(this, f));
                    return;
                }
                dv.showAnimation(this.f10564a.f10549d, null);
            } else if (f != null) {
                f.recycle();
            }
        }
    }
}
