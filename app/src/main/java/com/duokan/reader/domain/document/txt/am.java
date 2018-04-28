package com.duokan.reader.domain.document.txt;

import android.graphics.Rect;
import java.util.Comparator;

class am implements Comparator<Rect> {
    /* renamed from: a */
    final /* synthetic */ aj f4907a;

    am(aj ajVar) {
        this.f4907a = ajVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m7494a((Rect) obj, (Rect) obj2);
    }

    /* renamed from: a */
    public int m7494a(Rect rect, Rect rect2) {
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
