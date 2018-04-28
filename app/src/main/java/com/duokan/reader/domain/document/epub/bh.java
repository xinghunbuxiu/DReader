package com.duokan.reader.domain.document.epub;

import android.graphics.Rect;
import java.util.Comparator;

class bh implements Comparator<Rect> {
    /* renamed from: a */
    final /* synthetic */ az f4555a;

    bh(az azVar) {
        this.f4555a = azVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6669a((Rect) obj, (Rect) obj2);
    }

    /* renamed from: a */
    public int m6669a(Rect rect, Rect rect2) {
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
