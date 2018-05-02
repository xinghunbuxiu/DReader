package com.duokan.reader.domain.document.txt;

import android.graphics.Rect;

import java.util.Comparator;

class am implements Comparator {
    final /* synthetic */ aj a;

    am(aj ajVar) {
        this.a = ajVar;
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
