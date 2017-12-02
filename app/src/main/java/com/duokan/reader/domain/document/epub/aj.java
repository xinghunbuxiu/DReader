package com.duokan.reader.domain.document.epub;

import com.duokan.reader.domain.document.x;

import java.util.Comparator;

final class aj implements Comparator {
    aj() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((x) obj, (x) obj2);
    }

    public int a(x xVar, x xVar2) {
        if (((ce) xVar.a()).a(xVar2.a())) {
            return -1;
        }
        if (((ce) xVar.a()).c(xVar2.a())) {
            return 1;
        }
        return 0;
    }
}
