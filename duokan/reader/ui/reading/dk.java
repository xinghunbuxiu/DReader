package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.duokan.core.ui.UTools;
import com.duokan.reader.common.webservices.duokan.af;

class dk extends SimpleTarget {
    final /* synthetic */ ImageView a;
    final /* synthetic */ af b;
    final /* synthetic */ de c;

    dk(de deVar, ImageView imageView, af afVar) {
        this.c = deVar;
        this.a = imageView;
        this.b = afVar;
    }

    public /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        a((Bitmap) obj, glideAnimation);
    }

    public void a(Bitmap bitmap, GlideAnimation glideAnimation) {
        float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, UTools.getWidthPixels(this.c.getContext()), (bitmap.getHeight() * UTools.getWidthPixels(this.c.getContext())) / bitmap.getWidth(), false);
        if (width < 2.7826087f) {
            if (((float) createScaledBitmap.getWidth()) / (((float) createScaledBitmap.getHeight()) * 0.75f) > 2.7826087f) {
                int height = (int) (((float) createScaledBitmap.getHeight()) - (((float) createScaledBitmap.getWidth()) / 2.7826087f));
                createScaledBitmap = Bitmap.createBitmap(createScaledBitmap, 0, height, createScaledBitmap.getWidth(), createScaledBitmap.getHeight() - height);
            } else {
                createScaledBitmap = Bitmap.createBitmap(createScaledBitmap, 0, (int) (((float) createScaledBitmap.getHeight()) * 0.25f), createScaledBitmap.getWidth(), (int) (((float) createScaledBitmap.getWidth()) / 2.7826087f));
            }
        }
        this.a.setImageBitmap(createScaledBitmap);
        this.c.v.put(this.a, this.b.d + "_banner");
        this.a.setOnClickListener(new dl(this));
    }

    public void onLoadFailed(Exception exception, Drawable drawable) {
        this.a.setVisibility(8);
    }
}
