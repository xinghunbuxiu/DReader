package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.C1011x;
import java.util.Comparator;

final class aj implements Comparator<C1011x<ce>> {
    aj() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6518a((C1011x) obj, (C1011x) obj2);
    }

    /* renamed from: a */
    public int m6518a(C1011x<ce> c1011x, C1011x<ce> c1011x2) {
        if (((ce) c1011x.m7779a()).mo1188a(c1011x2.m7779a())) {
            return -1;
        }
        if (((ce) c1011x.m7779a()).mo1190c(c1011x2.m7779a())) {
            return 1;
        }
        return 0;
    }
}
