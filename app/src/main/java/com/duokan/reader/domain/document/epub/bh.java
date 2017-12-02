package com.duokan.reader.domain.document.epub;

import android.graphics.Rect;

import java.util.Comparator;

class bh implements Comparator {
    final /* synthetic */ az a;

    bh(az azVar) {
        this.a = azVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Rect) obj, (Rect) obj2);
    }

    public int a(Rect rect, Rect rect2) {
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
