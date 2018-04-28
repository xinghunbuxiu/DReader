package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.ui.dv;

class hi extends View {
    /* renamed from: a */
    final /* synthetic */ fz f8652a;

    hi(fz fzVar, Context context) {
        this.f8652a = fzVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = (Rect) dv.f1198g.addAnimation();
        rect.set(0, 0, getMeasuredWidth(), this.f8652a.f8599z);
        Paint paint = new Paint();
        paint.setColor(0);
        canvas.drawRect(rect, paint);
        paint.setColor(-1);
        rect.top = this.f8652a.f8599z;
        rect.bottom = getMeasuredHeight();
        canvas.drawRect(rect, paint);
        dv.f1198g.clearAnimation(rect);
    }
}
