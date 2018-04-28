package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

class gn extends SimpleTarget<Bitmap> {
    /* renamed from: a */
    final /* synthetic */ gl f7299a;

    private gn(gl glVar) {
        this.f7299a = glVar;
    }

    public /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        m10725a((Bitmap) obj, glideAnimation);
    }

    /* renamed from: a */
    public void m10725a(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.f7299a.f7294j = new BitmapDrawable(this.f7299a.f7287c.getResources(), bitmap);
        if (this.f7299a.f7293i != null) {
            this.f7299a.f7293i.mo1789a(bitmap);
        }
        this.f7299a.f7297m = true;
        this.f7299a.invalidateSelf();
    }

    public void onLoadCleared(Drawable drawable) {
        this.f7299a.f7294j = drawable;
        this.f7299a.invalidateSelf();
    }

    public void onLoadFailed(Exception exception, Drawable drawable) {
        this.f7299a.f7294j = drawable;
        if (this.f7299a.f7293i != null) {
            this.f7299a.f7293i.mo1790b(this.f7299a);
        }
        this.f7299a.invalidateSelf();
    }
}
