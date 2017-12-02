package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.duokan.reader.ReaderEnv;

import org.apache.http.HttpStatus;

class eb extends Drawable {
    final /* synthetic */ ds a;

    eb(ds dsVar) {
        this.a = dsVar;
    }

    public void draw(Canvas canvas) {
        if (ReaderEnv.get().forHd()) {
            this.a.a(canvas, this.a.k);
            return;
        }
        int min = Math.min(((this.a.k.getMeasuredWidth() / 4) * 3) + (this.a.q.getIntrinsicWidth() / 2), this.a.k.getRight());
        int max = Math.max(0, min - this.a.q.getIntrinsicWidth());
        int max2 = Math.max(0, ((this.a.d - this.a.c) - (this.a.getTabTextHeight() / 2)) - (this.a.q.getIntrinsicHeight() / 2));
        int min2 = Math.min(this.a.k.getMeasuredHeight(), this.a.q.getIntrinsicHeight() + max2);
        float c = this.a.c();
        es esVar = new es(new ColorDrawable(Color.rgb(this.a.a(255, (int) HttpStatus.SC_PROCESSING, c), this.a.a(255, (int) HttpStatus.SC_PROCESSING, c), this.a.a(255, (int) HttpStatus.SC_PROCESSING, c))));
        esVar.a(this.a.q);
        esVar.setBounds(max, max2, min, min2);
        esVar.draw(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
