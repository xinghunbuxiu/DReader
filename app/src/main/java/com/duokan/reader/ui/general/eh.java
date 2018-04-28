package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.duokan.p023b.C0243e;

final class eh extends Drawable {
    /* renamed from: a */
    final /* synthetic */ Context f7144a;
    /* renamed from: b */
    private Drawable f7145b = this.f7144a.getResources().getDrawable(C0243e.general__shared__list_item_view__bg1);
    /* renamed from: c */
    private Drawable f7146c = this.f7144a.getResources().getDrawable(C0243e.general__shared__list_item_view__bg2);

    eh(Context context) {
        this.f7144a = context;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = getLevel() % 2 == 0 ? this.f7145b : this.f7146c;
        drawable.setState(getState());
        drawable.setBounds(getBounds());
        drawable.draw(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
