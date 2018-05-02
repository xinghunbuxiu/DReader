package com.duokan.reader.domain.document.p045a;

import android.graphics.Rect;
import java.util.Comparator;

/* renamed from: com.duokan.reader.domain.document.a.ac */
class ac implements Comparator<Rect> {
    /* renamed from: a */
    final /* synthetic */ C0926w f4225a;

    ac(C0926w c0926w) {
        this.f4225a = c0926w;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5798a((Rect) obj, (Rect) obj2);
    }

    /* renamed from: a */
    public int m5798a(Rect rect, Rect rect2) {
        if (rect.top > rect2.top) {
            return 1;
        }
        if (rect.top < rect2.top) {
            return -1;
        }
        if (rect.left > rect2.left) {
            return 1;
        }
        if (rect.left < rect2.left) {
            return -1;
        }
        return 0;
    }
}
