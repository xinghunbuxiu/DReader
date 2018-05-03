package com.duokan.reader.ui.general;

import android.graphics.Rect;
import com.duokan.core.ui.AnimUtils;

public abstract class cu implements gc {
    /* renamed from: a */
    final /* synthetic */ FixedPagesView f7048a;

    public cu(FixedPagesView fixedPagesView) {
        this.f7048a = fixedPagesView;
    }

    /* renamed from: a */
    public Rect mo1762a() {
        Rect b = AnimUtils.m1937b(new Rect(0, 0, mo2328d().getWidth(), mo2328d().getHeight()), mo2328d(), this.f7048a);
        if (!b.intersect(0, 0, this.f7048a.getWidth(), this.f7048a.getHeight())) {
            return new Rect();
        }
        if (b.isEmpty()) {
            return new Rect();
        }
        return mo2326c(new Rect(AnimUtils.m1937b(new Rect(b), this.f7048a, mo2328d())));
    }

    /* renamed from: b */
    public void mo1764b() {
    }

    /* renamed from: a */
    public void mo1763a(Rect rect) {
        Rect c = this.f7048a.getCellsView().m1130c(new Rect(AnimUtils.m1937b(new Rect(mo2325b(new Rect(rect))), mo2328d(), this.f7048a)));
        this.f7048a.getCellsView().scrollTo(c.left, c.top);
    }
}
