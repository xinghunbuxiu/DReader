package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

import com.duokan.b.e;

final class ei extends Drawable {
    final /* synthetic */ Context a;
    private Drawable b = this.a.getResources().getDrawable(e.general__shared__list_item_view__bg1);
    private Drawable c = this.a.getResources().getDrawable(e.general__shared__list_item_view__bg2);

    ei(Context context) {
        this.a = context;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = getLevel() % 2 == 0 ? this.b : this.c;
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
