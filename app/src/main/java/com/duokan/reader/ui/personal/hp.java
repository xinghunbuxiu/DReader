package com.duokan.reader.ui.personal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.duokan.core.ui.AnimUtils;

class hp extends Drawable {
    /* renamed from: a */
    final /* synthetic */ View f8667a;
    /* renamed from: b */
    final /* synthetic */ fz f8668b;

    hp(fz fzVar, View view) {
        this.f8668b = fzVar;
        this.f8667a = view;
    }

    public void draw(Canvas canvas) {
        float width = (float) ((this.f8667a.getWidth() / 2) - AnimUtils.m1932b(this.f8668b.getContext(), 3.0f));
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#cccccc"));
        paint.setAntiAlias(true);
        canvas.drawCircle((float) (this.f8667a.getWidth() / 2), (float) (this.f8667a.getHeight() / 2), width, paint);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
