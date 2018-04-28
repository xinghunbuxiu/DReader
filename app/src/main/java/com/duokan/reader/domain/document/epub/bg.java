package com.duokan.reader.domain.document.epub;

import android.graphics.Rect;
import java.util.Comparator;

class bg implements Comparator<Rect> {
    /* renamed from: a */
    final /* synthetic */ az f4554a;

    bg(az azVar) {
        this.f4554a = azVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6668a((Rect) obj, (Rect) obj2);
    }

    /* renamed from: a */
    public int m6668a(Rect rect, Rect rect2) {
        if (rect.left < rect2.left) {
            return 1;
        }
        if (rect.left > rect2.left) {
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
