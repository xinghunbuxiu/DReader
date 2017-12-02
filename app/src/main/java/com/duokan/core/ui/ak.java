package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;

class ak extends GridItemsView {
    final /* synthetic */ HatGridView b;

    public ak(HatGridView hatGridView, Context context) {
        this.b = hatGridView;
        super(context);
    }

    public boolean c(Canvas canvas) {
        return super.d(canvas);
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.b.r) {
            int scrollY;
            if (this.b.q) {
                scrollY = (getScrollY() + this.b.d.getHeight()) - this.b.d.getScrollY();
            } else {
                scrollY = ((getScrollY() + this.b.d.getHeight()) - this.b.d.getScrollY()) - this.b.i.getHeight();
            }
            canvas.clipRect(0, scrollY, getWidth(), getHeight() + scrollY);
        }
        super.dispatchDraw(canvas);
    }

    protected boolean d(Canvas canvas) {
        return false;
    }

    protected bh b() {
        return new al(this);
    }
}
