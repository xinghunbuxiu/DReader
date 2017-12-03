package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;

import com.duokan.core.sys.ag;
import com.duokan.core.ui.UTools;

import org.apache.http.HttpStatus;

class kx implements ag {
    final /* synthetic */ kq a;

    kx(kq kqVar) {
        this.a = kqVar;
    }

    public void a(Bitmap bitmap) {
        if (this.a.getWindowToken() == null) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        } else if (bitmap != null) {
            Bitmap i = this.a.h;
            this.a.h = bitmap;
            this.a.j = true;
            this.a.e.setImageBitmap(this.a.h);
            if (this.a.e.getVisibility() == 0) {
                if (i != null) {
                    this.a.f.setImageBitmap(i);
                    UTools.showAnimation(this.a.f, new ky(this, i));
                    return;
                }
                UTools.closeAnimation(this.a.e, null);
            } else if (this.a.b) {
                this.a.m = new AlphaAnimation(0.0f, 1.0f);
                this.a.m.setDuration(500);
                this.a.e.invalidate();
                this.a.e.setVisibility(0);
                UTools.addAnimation(this.a.e, 0.0f, 1.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, false, new kz(this));
            } else if (i != null) {
                i.recycle();
            }
        }
    }
}
