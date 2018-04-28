package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

class hh extends View {
    /* renamed from: a */
    final /* synthetic */ fz f8651a;

    hh(fz fzVar, Context context) {
        this.f8651a = fzVar;
        super(context);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(-1);
        this.f8651a.f8593t.draw(canvas);
    }
}
