package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Rect;

import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0254f;
import com.duokan.reader.ui.general.C1332f;

class bm extends de {
    /* renamed from: a */
    final /* synthetic */ bh f6181a;
    /* renamed from: c */
    private C1332f f6182c;

    public bm(bh bhVar, Context context) {
        this.f6181a = bhVar;
        super(context);
    }

    /* renamed from: a */
    protected void mo1635a() {
        setShowOption(2);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 0) {
            size = getResources().getDimensionPixelSize(C0253e.general__shared__cover_grid_width);
        }
        getCoverDrawable().setBounds(0, 0, size, Math.round((((float) size) * 349.0f) / 256.0f));
        size = getCoverDrawable().getBounds().width();
        mode = getCoverDrawable().getBounds().height();
        measureChildren(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
        setMeasuredDimension(size, mode);
    }

    /* renamed from: a */
    protected void mo1636a(Rect rect) {
        rect.set(getCoverDrawable().getBounds());
        Rect rect2 = (Rect) AnimUtils.f1198g.addAnimation();
        getResources().getDrawable(C0254f.bookshelf__recently_reading_cover_shadow).getPadding(rect2);
        rect.left += rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
        AnimUtils.f1198g.clearAnimation(rect2);
    }

    protected C1332f getBookCoverDrawable() {
        if (this.f6182c == null) {
            this.f6182c = new C1332f(getContext(), C0254f.bookshelf__recently_reading_cover_shadow);
            this.f6182c.setCallback(this.b);
        }
        return this.f6182c;
    }
}
