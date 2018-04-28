package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;

class ak extends GridItemsView {
    /* renamed from: b */
    final /* synthetic */ HatGridView f919b;

    public ak(HatGridView hatGridView, Context context) {
        this.f919b = hatGridView;
        super(context);
    }

    /* renamed from: c */
    public boolean m1411c(Canvas canvas) {
        return super.mo490d(canvas);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.f919b.f828r) {
            int scrollY;
            if (this.f919b.f827q) {
                scrollY = (getScrollY() + this.f919b.f814d.getHeight()) - this.f919b.f814d.getScrollY();
            } else {
                scrollY = ((getScrollY() + this.f919b.f814d.getHeight()) - this.f919b.f814d.getScrollY()) - this.f919b.f819i.getHeight();
            }
            canvas.clipRect(0, scrollY, getWidth(), getHeight() + scrollY);
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: d */
    protected boolean mo490d(Canvas canvas) {
        return false;
    }

    /* renamed from: b */
    protected bh mo489b() {
        return new al(this);
    }
}
