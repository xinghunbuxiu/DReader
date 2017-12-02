package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

class gy extends SimpleTarget {
    final /* synthetic */ gw a;

    private gy(gw gwVar) {
        this.a = gwVar;
    }

    public /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        a((Bitmap) obj, glideAnimation);
    }

    public void a(Bitmap bitmap, GlideAnimation glideAnimation) {
        this.a.j = new BitmapDrawable(this.a.c.getResources(), bitmap);
        if (this.a.i != null) {
            this.a.i.a(bitmap);
        }
        this.a.m = true;
        this.a.invalidateSelf();
    }

    public void onLoadCleared(Drawable drawable) {
        this.a.j = drawable;
        this.a.invalidateSelf();
    }

    public void onLoadFailed(Exception exception, Drawable drawable) {
        this.a.j = drawable;
        if (this.a.i != null) {
            this.a.i.b(this.a);
        }
        this.a.invalidateSelf();
    }
}
