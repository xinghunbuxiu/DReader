package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0254f;
import com.duokan.reader.ui.general.C1283z;

/* renamed from: com.duokan.reader.ui.bookshelf.b */
class C1284b extends C1283z {
    /* renamed from: a */
    final /* synthetic */ C1282a f6151a;
    /* renamed from: h */
    private final Drawable f6152h;

    public C1284b(C1282a c1282a, Context context) {
        this.f6151a = c1282a;
        super(context, true);
        this.f6152h = c1282a.getResources().getDrawable(C0254f.bookshelf__add_book_view_bg);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int intrinsicWidth = this.f6152h.getIntrinsicWidth();
        int intrinsicHeight = this.f6152h.getIntrinsicHeight();
        Rect rect = (Rect) dv.f1198g.addAnimation();
        this.f6151a.mo1636a(rect);
        int width = (rect.width() - intrinsicWidth) / 2;
        int height = (rect.height() - intrinsicHeight) / 2;
        this.f6152h.setBounds(width, height, intrinsicWidth + width, intrinsicHeight + height);
        this.f6152h.draw(canvas);
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
