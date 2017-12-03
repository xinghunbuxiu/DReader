package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Rect;

import com.duokan.c.e;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.f;

class bg extends cz {
    final /* synthetic */ bb a;
    private f c;

    public bg(bb bbVar, Context context) {
        this.a = bbVar;
        super(context);
    }

    protected void a() {
        setShowOption(2);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 0) {
            size = getResources().getDimensionPixelSize(e.general__shared__cover_grid_width);
        }
        getCoverDrawable().setBounds(0, 0, size, Math.round((((float) size) * 349.0f) / 256.0f));
        size = getCoverDrawable().getBounds().width();
        mode = getCoverDrawable().getBounds().height();
        measureChildren(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
        setMeasuredDimension(size, mode);
    }

    protected void a(Rect rect) {
        rect.set(getCoverDrawable().getBounds());
        Rect rect2 = (Rect) UTools.g.getRect();
        getResources().getDrawable(com.duokan.c.f.bookshelf__recently_reading_cover_shadow).getPadding(rect2);
        rect.left += rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
        UTools.g.getRect(rect2);
    }

    protected f getBookCoverDrawable() {
        if (this.c == null) {
            this.c = new f(getContext(), com.duokan.c.f.bookshelf__recently_reading_cover_shadow);
            this.c.setCallback(this.b);
        }
        return this.c;
    }
}
