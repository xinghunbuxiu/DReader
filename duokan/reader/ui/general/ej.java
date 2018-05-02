package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

final class ej extends Drawable {
    final /* synthetic */ Context a;
    final /* synthetic */ DkListView b;
    final /* synthetic */ int c;
    private Drawable d = this.a.getResources().getDrawable(e.general__shared__list_item_view__bg1);
    private Drawable e = this.a.getResources().getDrawable(e.general__shared__list_item_view__bg2);

    ej(Context context, DkListView dkListView, int i) {
        this.a = context;
        this.b = dkListView;
        this.c = i;
    }

    public void draw(Canvas canvas) {
        int i = 0;
        if (this.b.getNumColumns() != 0) {
            int i2 = 0;
            while (i < this.c) {
                int a = this.b.a(i) % this.b.getNumColumns();
                if (a == 0) {
                    a = this.b.a(i) / this.b.getNumColumns();
                } else {
                    a = ((this.b.a(i) - a) / this.b.getNumColumns()) + 1;
                }
                i2 += a + 1;
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
