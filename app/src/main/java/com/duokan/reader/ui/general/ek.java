package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

import com.duokan.core.ui.HatGridView;

final class ek extends Drawable {
    final /* synthetic */ Context a;
    final /* synthetic */ HatGridView b;
    final /* synthetic */ int c;
    private Drawable d = this.a.getResources().getDrawable(e.general__shared__list_item_view__bg1);
    private Drawable e = this.a.getResources().getDrawable(e.general__shared__list_item_view__bg2);

    ek(Context context, HatGridView hatGridView, int i) {
        this.a = context;
        this.b = hatGridView;
        this.c = i;
    }

    public void draw(Canvas canvas) {
        int i = 0;
        if (this.b.getNumColumns() != 0) {
            int i2 = 0;
            while (i < this.c) {
                int f = this.b.f(i) % this.b.getNumColumns();
                if (f == 0) {
                    f = this.b.f(i) / this.b.getNumColumns();
                } else {
                    f = ((this.b.f(i) - f) / this.b.getNumColumns()) + 1;
                }
                i2 += f + 1;
                i++;
            }
            Drawable drawable = i2 % 2 == 0 ? this.e : this.d;
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
