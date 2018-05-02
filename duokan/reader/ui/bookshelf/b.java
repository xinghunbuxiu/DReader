package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.z;

class b extends z {
    final /* synthetic */ a a;
    private final Drawable h;

    public b(a aVar, Context context) {
        this.a = aVar;
        super(context, true);
        this.h = aVar.getResources().getDrawable(f.bookshelf__add_book_view_bg);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int intrinsicWidth = this.h.getIntrinsicWidth();
        int intrinsicHeight = this.h.getIntrinsicHeight();
        Rect rect = (Rect) UTools.g.getRect();
        this.a.a(rect);
        int width = (rect.width() - intrinsicWidth) / 2;
        int height = (rect.height() - intrinsicHeight) / 2;
        this.h.setBounds(width, height, intrinsicWidth + width, intrinsicHeight + height);
        this.h.draw(canvas);
        UTools.g.getRect(rect);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
