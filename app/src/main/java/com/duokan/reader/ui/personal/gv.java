package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

class gv extends View {
    final /* synthetic */ fl a;

    gv(fl flVar, Context context) {
        this.a = flVar;
        super(context);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(-1);
        this.a.u.draw(canvas);
    }
}
