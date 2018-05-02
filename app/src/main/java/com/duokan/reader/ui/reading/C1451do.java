package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.duokan.core.ui.dv;
import com.duokan.reader.common.webservices.duokan.af;

/* renamed from: com.duokan.reader.ui.reading.do */
class C1451do extends SimpleTarget<Bitmap> {
    /* renamed from: a */
    final /* synthetic */ ImageView f10033a;
    /* renamed from: b */
    final /* synthetic */ af f10034b;
    /* renamed from: c */
    final /* synthetic */ dg f10035c;

    C1451do(dg dgVar, ImageView imageView, af afVar) {
        this.f10035c = dgVar;
        this.f10033a = imageView;
        this.f10034b = afVar;
    }

    public /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        m13994a((Bitmap) obj, glideAnimation);
    }

    /* renamed from: a */
    public void m13994a(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, dv.getWidthPixels(this.f10035c.getContext()), (bitmap.getHeight() * dv.getWidthPixels(this.f10035c.getContext())) / bitmap.getWidth(), false);
        if (width < 2.7826087f) {
            if (((float) createScaledBitmap.getWidth()) / (((float) createScaledBitmap.getHeight()) * 0.75f) > 2.7826087f) {
                int height = (int) (((float) createScaledBitmap.getHeight()) - (((float) createScaledBitmap.getWidth()) / 2.7826087f));
                createScaledBitmap = Bitmap.createBitmap(createScaledBitmap, 0, height, createScaledBitmap.getWidth(), createScaledBitmap.getHeight() - height);
            } else {
                createScaledBitmap = Bitmap.createBitmap(createScaledBitmap, 0, (int) (((float) createScaledBitmap.getHeight()) * 0.25f), createScaledBitmap.getWidth(), (int) (((float) createScaledBitmap.getWidth()) / 2.7826087f));
            }
        }
        this.f10033a.setImageBitmap(createScaledBitmap);
        this.f10035c.f10022w.put(this.f10033a, this.f10034b.f2105d + "_banner");
        this.f10033a.setOnClickListener(new dp(this));
    }

    public void onLoadFailed(Exception exception, Drawable drawable) {
        this.f10033a.setVisibility(8);
    }
}
