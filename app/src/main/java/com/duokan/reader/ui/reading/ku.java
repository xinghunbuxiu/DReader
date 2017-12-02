package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;

import com.duokan.core.sys.ag;
import com.duokan.core.ui.dv;

class ku implements ag {
    final /* synthetic */ kq a;

    ku(kq kqVar) {
        this.a = kqVar;
    }

    public void a(Bitmap bitmap) {
        if (this.a.getWindowToken() == null) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        } else if (bitmap != null) {
            Bitmap f = this.a.g;
            this.a.g = bitmap;
            this.a.i = true;
            this.a.d.setImageBitmap(this.a.g);
            if (this.a.d.getVisibility() == 0) {
                if (f != null) {
                    this.a.f.setImageBitmap(f);
                    dv.c(this.a.f, new kv(this, f));
                    return;
                }
                dv.b(this.a.d, null);
            } else if (f != null) {
                f.recycle();
            }
        }
    }
}
