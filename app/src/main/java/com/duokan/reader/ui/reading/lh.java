package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.dv;
import org.apache.http.HttpStatus;

class lh implements ag<Bitmap> {
    /* renamed from: a */
    final /* synthetic */ la f10568a;

    lh(la laVar) {
        this.f10568a = laVar;
    }

    public /* synthetic */ void run(Object obj) {
        m14612a((Bitmap) obj);
    }

    /* renamed from: a */
    public void m14612a(Bitmap bitmap) {
        if (this.f10568a.getWindowToken() == null) {
            if (bitmap != null) {
                bitmap.recycle();
            }
        } else if (bitmap != null) {
            Bitmap i = this.f10568a.f10553h;
            this.f10568a.f10553h = bitmap;
            this.f10568a.f10555j = true;
            this.f10568a.f10550e.setImageBitmap(this.f10568a.f10553h);
            if (this.f10568a.f10550e.getVisibility() == 0) {
                if (i != null) {
                    this.f10568a.f10551f.setImageBitmap(i);
                    dv.hideAnimation(this.f10568a.f10551f, new li(this, i));
                    return;
                }
                dv.showAnimation(this.f10568a.f10550e, null);
            } else if (this.f10568a.f10547b) {
                this.f10568a.f10558m = new AlphaAnimation(0.0f, 1.0f);
                this.f10568a.f10558m.setDuration(500);
                this.f10568a.f10550e.invalidate();
                this.f10568a.f10550e.setVisibility(0);
                dv.startAlphaAnimation(this.f10568a.f10550e, 0.0f, 1.0f, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR, false, new lj(this));
            } else if (i != null) {
                i.recycle();
            }
        }
    }
}
