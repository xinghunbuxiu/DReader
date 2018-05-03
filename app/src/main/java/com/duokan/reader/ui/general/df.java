package com.duokan.reader.ui.general;

import android.graphics.Rect;
import com.duokan.core.ui.AnimUtils;

public abstract class df implements gc {
    /* renamed from: a */
    final /* synthetic */ FlowPagesView f7094a;

    public df(FlowPagesView flowPagesView) {
        this.f7094a = flowPagesView;
    }

    /* renamed from: a */
    public Rect mo1762a() {
        Rect b = AnimUtils.m1937b(new Rect(0, 0, mo2328d().getWidth(), mo2328d().getHeight()), mo2328d(), this.f7094a);
        if (b.intersect(0, 0, this.f7094a.getWidth(), this.f7094a.getHeight())) {
            return mo2326c(new Rect(AnimUtils.m1937b(new Rect(b), this.f7094a, mo2328d())));
        }
        return new Rect();
    }

    /* renamed from: b */
    public void mo1764b() {
        this.f7094a.f6859l = this;
    }

    /* renamed from: a */
    public void mo1763a(Rect rect) {
        Rect c = this.f7094a.getCellsView().m1130c(new Rect(AnimUtils.m1937b(new Rect(mo2325b(new Rect(rect))), mo2328d(), this.f7094a)));
        this.f7094a.getCellsView().scrollTo(c.left, c.top);
    }
}
