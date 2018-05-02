package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.UTools;

class gu extends View {
    final /* synthetic */ fl a;

    gu(fl flVar, Context context) {
        this.a = flVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = (Rect) UTools.g.getRect();
        rect.set(0, 0, getMeasuredWidth(), this.a.z);
        Paint paint = new Paint();
        paint.setColor(0);
        canvas.drawRect(rect, paint);
        paint.setColor(-1);
        rect.top = this.a.z;
        rect.bottom = getMeasuredHeight();
        canvas.drawRect(rect, paint);
        UTools.g.getRect(rect);
    }
}
