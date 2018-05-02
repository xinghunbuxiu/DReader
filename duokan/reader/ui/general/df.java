package com.duokan.reader.ui.general;

import android.graphics.Rect;

import com.duokan.core.ui.UTools;

public abstract class df implements gi {
    final /* synthetic */ FlowPagesView a;

    public df(FlowPagesView flowPagesView) {
        this.a = flowPagesView;
    }

    public Rect a() {
        Rect b = UTools.closeAnimation(new Rect(0, 0, d().getWidth(), d().getHeight()), d(), this.a);
        if (b.intersect(0, 0, this.a.getWidth(), this.a.getHeight())) {
            return c(new Rect(UTools.closeAnimation(new Rect(b), this.a, d())));
        }
        return new Rect();
    }

    public void b() {
        this.a.l = this;
    }

    public void a(Rect rect) {
        Rect c = this.a.getCellsView().c(new Rect(UTools.closeAnimation(new Rect(b(new Rect(rect))), d(), this.a)));
        this.a.getCellsView().scrollTo(c.left, c.top);
    }
}
