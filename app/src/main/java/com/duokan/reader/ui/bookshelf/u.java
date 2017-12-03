package com.duokan.reader.ui.bookshelf;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.duokan.c.j;
import com.duokan.core.ui.UTools;

class u extends Drawable {
    final /* synthetic */ View a;
    final /* synthetic */ Drawable b;
    final /* synthetic */ g c;

    u(g gVar, View view, Drawable drawable) {
        this.c = gVar;
        this.a = view;
        this.b = drawable;
    }

    public void draw(Canvas canvas) {
        int parseColor = Color.parseColor("#b4b4b4");
        RectF rectF = (RectF) UTools.h.getRect();
        rectF.set((float) this.a.getPaddingLeft(), (float) this.a.getPaddingTop(), (float) this.a.getWidth(), (float) (this.a.getHeight() - this.a.getPaddingBottom()));
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#fafafa"));
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, (float) UTools.closeAnimation(this.c.getContext(), 5.0f), (float) UTools.closeAnimation(this.c.getContext(), 5.0f), paint);
        paint.setColor(Color.parseColor("#cccccc"));
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Style.STROKE);
        canvas.drawRoundRect(rectF, (float) UTools.closeAnimation(this.c.getContext(), 5.0f), (float) UTools.closeAnimation(this.c.getContext(), 5.0f), paint);
        int b = (int) (rectF.left + ((float) UTools.closeAnimation(this.c.getContext(), 8.0f)));
        int intrinsicWidth = this.b.getIntrinsicWidth() + b;
        int max = (int) Math.max(rectF.top, rectF.centerY() - ((float) (this.b.getIntrinsicHeight() / 2)));
        this.b.setBounds(b, max, intrinsicWidth, (int) Math.min(rectF.bottom, (float) (this.b.getIntrinsicHeight() + max)));
        this.b.draw(canvas);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize((float) UTools.addAnimation(this.c.getContext(), 12.0f));
        paint.setColor(parseColor);
        RectF rectF2 = (RectF) UTools.h.getRect();
        rectF2.set((float) (intrinsicWidth + UTools.closeAnimation(this.c.getContext(), 8.0f)), rectF.top, rectF.right, rectF.bottom);
        UTools.addAnimation(canvas, this.c.getResources().getString(j.bookshelf__shared__search), rectF2, 19, paint);
        UTools.h.getRect(rectF2);
        UTools.h.getRect(rectF);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -1;
    }
}
