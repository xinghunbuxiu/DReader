package com.duokan.core.ui;

import android.graphics.Rect;
import com.duokan.core.sys.BaseAnimation;

final class em extends BaseAnimation<Rect> {
    em() {
    }

    /* renamed from: b */
    protected /* synthetic */ Object createAnimation() {
        return m2016c();
    }

    /* renamed from: b */
    protected /* synthetic */ void mo516b(Object obj) {
        m2013a((Rect) obj);
    }

    /* renamed from: c */
    protected Rect m2016c() {
        return new Rect();
    }

    /* renamed from: a */
    protected void m2013a(Rect rect) {
        rect.setEmpty();
    }
}
