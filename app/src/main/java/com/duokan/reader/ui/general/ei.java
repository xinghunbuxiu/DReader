package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.HatGridView;
import com.duokan.p023b.C0243e;

final class ei extends Drawable {
    /* renamed from: a */
    final /* synthetic */ Context f7147a;
    /* renamed from: b */
    final /* synthetic */ HatGridView f7148b;
    /* renamed from: c */
    final /* synthetic */ int f7149c;
    /* renamed from: d */
    private Drawable f7150d = this.f7147a.getResources().getDrawable(C0243e.general__shared__list_item_view__bg1);
    /* renamed from: e */
    private Drawable f7151e = this.f7147a.getResources().getDrawable(C0243e.general__shared__list_item_view__bg2);

    ei(Context context, HatGridView hatGridView, int i) {
        this.f7147a = context;
        this.f7148b = hatGridView;
        this.f7149c = i;
    }

    public void draw(Canvas canvas) {
        int i = 0;
        if (this.f7148b.getNumColumns() != 0) {
            int i2 = 0;
            while (i < this.f7149c) {
                int f = this.f7148b.m1262f(i) % this.f7148b.getNumColumns();
                if (f == 0) {
                    f = this.f7148b.m1262f(i) / this.f7148b.getNumColumns();
                } else {
                    f = ((this.f7148b.m1262f(i) - f) / this.f7148b.getNumColumns()) + 1;
                }
                i2 += f + 1;
                i++;
            }
            Drawable drawable = i2 % 2 == 0 ? this.f7151e : this.f7150d;
            drawable.setState(getState());
            drawable.setBounds(getBounds());
            drawable.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
