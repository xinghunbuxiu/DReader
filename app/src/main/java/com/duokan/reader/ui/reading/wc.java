package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class wc extends Drawable {
    /* renamed from: a */
    final /* synthetic */ ReadingPrefs f11100a;
    /* renamed from: b */
    private final Bitmap[] f11101b;

    public wc(ReadingPrefs readingPrefs, int... iArr) {
        this.f11100a = readingPrefs;
        this.f11101b = new Bitmap[iArr.length];
        for (int i = 0; i < this.f11101b.length; i++) {
            this.f11101b[i] = BitmapFactory.decodeResource(readingPrefs.f9142p.getResources(), iArr[i]);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }

    public void draw(Canvas canvas) {
        int i = 0;
        int height = this.f11101b[0].getHeight();
        int width = this.f11101b[0].getWidth();
        Rect bounds = getBounds();
        int i2 = bounds.top;
        while (i2 < bounds.bottom) {
            int i3 = i;
            i = bounds.left;
            while (i < bounds.right) {
                Bitmap bitmap = this.f11101b[i3 % this.f11101b.length];
                if (canvas.getDensity() > 0) {
                    bitmap.setDensity(canvas.getDensity());
                }
                canvas.drawBitmap(bitmap, (float) i, (float) i2, null);
                i += width;
                i3++;
            }
            i2 += height;
            i = i3 + 1;
        }
    }
}
