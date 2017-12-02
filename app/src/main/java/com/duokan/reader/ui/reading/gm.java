package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.duokan.b.i;
import com.duokan.core.app.x;
import com.duokan.core.ui.dv;
import com.duokan.reader.ui.general.es;

public class gm extends Drawable {
    private Paint a = null;
    private final sh b;
    private final ColorDrawable c;
    private final Drawable d;
    private final es e;
    private final String f;
    private final float g;

    public gm(Context context) {
        this.b = (sh) x.a(context).queryFeature(sh.class);
        this.c = new ColorDrawable();
        this.d = context.getResources().getDrawable(e.reading__shared__page_loading);
        this.e = new es(this.c);
        this.e.a(this.d);
        this.f = context.getString(i.reading__shared__page_loading);
        this.g = context.getResources().getDimension(d.general_font__shared__c);
        if (this.a == null) {
            this.a = new Paint();
            this.a.setAntiAlias(true);
            this.a.setSubpixelText(true);
            this.a.setTextSize(this.g);
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Rect rect = (Rect) dv.g.a();
        int R = this.b.R();
        if (this.c.getColor() != R) {
            this.c.setColor(R);
            this.e.invalidateSelf();
        }
        if (this.a.getColor() != R) {
            this.a.setColor(R);
        }
        rect.set(bounds);
        rect.inset(0, Math.round((((float) (bounds.height() - this.d.getIntrinsicHeight())) - (this.g * 3.0f)) / 2.0f));
        dv.a(canvas, this.e, rect, this.d.getIntrinsicWidth(), this.d.getIntrinsicHeight(), 49);
        rect.top += this.d.getIntrinsicHeight();
        dv.a(canvas, this.f, rect, 17, this.a);
        dv.g.a(rect);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
