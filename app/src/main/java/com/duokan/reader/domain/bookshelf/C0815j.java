package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import java.util.Comparator;

/* renamed from: com.duokan.reader.domain.bookshelf.j */
class C0815j implements Comparator<DkCloudAnnotation> {
    /* renamed from: a */
    final /* synthetic */ C0800c f3378a;

    C0815j(C0800c c0800c) {
        this.f3378a = c0800c;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m4736a((DkCloudAnnotation) obj, (DkCloudAnnotation) obj2);
    }

    /* renamed from: a */
    public int m4736a(DkCloudAnnotation dkCloudAnnotation, DkCloudAnnotation dkCloudAnnotation2) {
        if (dkCloudAnnotation.getStartPos().m5592b(dkCloudAnnotation2.getStartPos())) {
            return -1;
        }
        if (dkCloudAnnotation.getStartPos().m5590a(dkCloudAnnotation2.getStartPos())) {
            return 1;
        }
        return 0;
    }
}
