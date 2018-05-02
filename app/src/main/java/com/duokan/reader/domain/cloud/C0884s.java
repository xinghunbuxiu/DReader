package com.duokan.reader.domain.cloud;

import java.util.Comparator;

/* renamed from: com.duokan.reader.domain.cloud.s */
class C0884s implements Comparator<DkCloudAnnotation> {
    /* renamed from: a */
    final /* synthetic */ DkCloudStorage f4185a;

    C0884s(DkCloudStorage dkCloudStorage) {
        this.f4185a = dkCloudStorage;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5761a((DkCloudAnnotation) obj, (DkCloudAnnotation) obj2);
    }

    /* renamed from: a */
    public int m5761a(DkCloudAnnotation dkCloudAnnotation, DkCloudAnnotation dkCloudAnnotation2) {
        if (dkCloudAnnotation.getStartPos().m5592b(dkCloudAnnotation2.getStartPos())) {
            return -1;
        }
        if (dkCloudAnnotation.getStartPos().m5590a(dkCloudAnnotation2.getStartPos())) {
            return 1;
        }
        return 0;
    }
}
