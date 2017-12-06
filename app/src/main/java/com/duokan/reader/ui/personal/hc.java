package com.duokan.reader.ui.personal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.duokan.core.ui.UTools;

class hc extends Drawable {
    final /* synthetic */ View a;
    final /* synthetic */ fl b;

    hc(fl flVar, View view) {
        this.b = flVar;
        this.a = view;
    }

    public void draw(Canvas canvas) {
        float width = (float) ((this.a.getWidth() / 2) - UTools.getMinimumHeight(this.b.getContext(), 3.0f));
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#cccccc"));
        paint.setAntiAlias(true);
        canvas.drawCircle((float) (this.a.getWidth() / 2), (float) (this.a.getHeight() / 2), width, paint);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
