package com.duokan.reader.ui.general;

import android.graphics.Rect;

import com.duokan.core.ui.dv;

public abstract class cu implements gi {
    final /* synthetic */ FixedPagesView a;

    public cu(FixedPagesView fixedPagesView) {
        this.a = fixedPagesView;
    }

    public Rect a() {
        Rect b = dv.b(new Rect(0, 0, d().getWidth(), d().getHeight()), d(), this.a);
        if (!b.intersect(0, 0, this.a.getWidth(), this.a.getHeight())) {
            return new Rect();
        }
        if (b.isEmpty()) {
            return new Rect();
        }
        return c(new Rect(dv.b(new Rect(b), this.a, d())));
    }

    public void b() {
    }

    public void a(Rect rect) {
        Rect c = this.a.getCellsView().c(new Rect(dv.b(new Rect(b(new Rect(rect))), d(), this.a)));
        this.a.getCellsView().scrollTo(c.left, c.top);
    }
}
