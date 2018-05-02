package com.duokan.reader.domain.document.a;

import android.graphics.Rect;

import java.util.Comparator;

class ac implements Comparator {
    final /* synthetic */ w a;

    ac(w wVar) {
        this.a = wVar;
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
