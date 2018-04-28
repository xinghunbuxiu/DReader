package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.eq;

public class gr extends Drawable {
    /* renamed from: a */
    private Paint f10264a = null;
    /* renamed from: b */
    private final su f10265b;
    /* renamed from: c */
    private final ColorDrawable f10266c;
    /* renamed from: d */
    private final Drawable f10267d;
    /* renamed from: e */
    private final eq f10268e;
    /* renamed from: f */
    private final String f10269f;
    /* renamed from: g */
    private final float f10270g;

    public gr(Context context) {
        this.f10265b = (su) AppContext.getAppContext(context).queryFeature(su.class);
        this.f10266c = new ColorDrawable();
        this.f10267d = context.getResources().getDrawable(C0243e.reading__shared__page_loading);
        this.f10268e = new eq(this.f10266c);
        this.f10268e.m10568a(this.f10267d);
        this.f10269f = context.getString(C0247i.reading__shared__page_loading);
        this.f10270g = context.getResources().getDimension(C0242d.general_font__shared__c);
        if (this.f10264a == null) {
            this.f10264a = new Paint();
            this.f10264a.setAntiAlias(true);
            this.f10264a.setSubpixelText(true);
            this.f10264a.setTextSize(this.f10270g);
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Rect rect = (Rect) dv.f1198g.addAnimation();
        int R = this.f10265b.mo2001R();
        if (this.f10266c.getColor() != R) {
            this.f10266c.setColor(R);
            this.f10268e.invalidateSelf();
        }
        if (this.f10264a.getColor() != R) {
            this.f10264a.setColor(R);
        }
        rect.set(bounds);
        rect.inset(0, Math.round((((float) (bounds.height() - this.f10267d.getIntrinsicHeight())) - (this.f10270g * 3.0f)) / 2.0f));
        dv.m1912a(canvas, this.f10268e, rect, this.f10267d.getIntrinsicWidth(), this.f10267d.getIntrinsicHeight(), 49);
        rect.top += this.f10267d.getIntrinsicHeight();
        dv.m1913a(canvas, this.f10269f, rect, 17, this.f10264a);
        dv.f1198g.clearAnimation(rect);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
