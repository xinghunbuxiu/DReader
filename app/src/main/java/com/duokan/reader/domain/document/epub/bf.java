package com.duokan.reader.domain.document.epub;

import android.graphics.Rect;
import java.util.Comparator;

class bf implements Comparator<Rect> {
    /* renamed from: a */
    final /* synthetic */ az f4553a;

    bf(az azVar) {
        this.f4553a = azVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6667a((Rect) obj, (Rect) obj2);
    }

    /* renamed from: a */
    public int m6667a(Rect rect, Rect rect2) {
        if (rect.left > rect2.left) {
            return 1;
        }
        if (rect.left < rect2.left) {
            return -1;
        }
        if (rect.top > rect2.top) {
            return 1;
        }
        if (rect.top < rect2.top) {
            return -1;
        }
        return 0;
    }
}
