package com.duokan.reader.ui.bookshelf;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0258j;
import org.apache.http.HttpStatus;

class ab extends Drawable {
    
    final  int f6080a;
    
    final  int f6081b;
    
    final  View f6082c;
    
    final  Drawable f6083d;
    
    final  View f6084e;
    
    final  C1290g f6085f;

    ab(C1290g c1290g, int i, int i2, View view, Drawable drawable, View view2) {
        this.f6085f = c1290g;
        this.f6080a = i;
        this.f6081b = i2;
        this.f6082c = view;
        this.f6083d = drawable;
        this.f6084e = view2;
    }

    public void draw(Canvas canvas) {
        float f;
        if (this.f6085f.f6489i.getVisibility() == 8) {
            f = 1.0f;
        } else {
            f = AnimUtils.getAlpha(((((float) this.f6085f.f6486f.getViewportBounds().top) - ((float) this.f6085f.f6489i.getHeight())) / ((float) this.f6085f.f6489i.getHeight())) + 1.0f);
        }
        int parseColor = Color.parseColor("#7a7a7a");
        RectF rectF = (RectF) AnimUtils.f1199h.addAnimation();
        int b = ((this.f6080a - this.f6081b) - AnimUtils.m1932b(this.f6085f.getContext(), 29.0f)) / 2;
        rectF.set((float) this.f6082c.getPaddingLeft(), (float) b, (float) this.f6082c.getWidth(), (float) ((this.f6080a - this.f6081b) - b));
        Paint paint = new Paint();
        paint.setColor(Color.rgb(this.f6085f.m9656a(255, 250, f), this.f6085f.m9656a(255, 250, f), this.f6085f.m9656a(255, 250, f)));
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, (float) AnimUtils.m1932b(this.f6085f.getContext(), 3.0f), (float) AnimUtils.m1932b(this.f6085f.getContext(), 3.0f), paint);
        paint.setColor(Color.argb((int) (255.0f * f), HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT));
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Style.STROKE);
        canvas.drawRoundRect(rectF, (float) AnimUtils.m1932b(this.f6085f.getContext(), 3.0f), (float) AnimUtils.m1932b(this.f6085f.getContext(), 3.0f), paint);
        int b2 = (int) (rectF.left + ((float) AnimUtils.m1932b(this.f6085f.getContext(), 8.0f)));
        b = this.f6083d.getIntrinsicWidth() + b2;
        int max = (int) Math.max(rectF.top, rectF.centerY() - ((float) (this.f6083d.getIntrinsicHeight() / 2)));
        this.f6083d.setBounds(b2, max, b, (int) Math.min(rectF.bottom, (float) (this.f6083d.getIntrinsicHeight() + max)));
        this.f6083d.draw(canvas);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTextSize((float) AnimUtils.getScaledDensity(this.f6085f.getContext(), 12.0f));
        paint2.setColor(parseColor);
        RectF rectF2 = (RectF) AnimUtils.f1199h.addAnimation();
        rectF2.set((float) (AnimUtils.m1932b(this.f6085f.getContext(), 8.0f) + b), rectF.top, rectF.right, rectF.bottom);
        AnimUtils.m1914a(canvas, this.f6085f.getResources().getString(C0258j.bookshelf__shared__search), rectF2, 19, paint2);
        AnimUtils.f1199h.clearAnimation(rectF2);
        AnimUtils.f1199h.clearAnimation(rectF);
        int rgb = Color.rgb(this.f6085f.m9656a(242, 255, f), this.f6085f.m9656a(243, 255, f), this.f6085f.m9656a(243, 255, f));
        this.f6084e.setBackgroundColor(rgb);
        this.f6085f.f6491k.setBackgroundColor(rgb);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }
}
