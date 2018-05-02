package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class u implements Comparator {
    final /* synthetic */ DkCloudStorage a;

    u(DkCloudStorage dkCloudStorage) {
        this.a = dkCloudStorage;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudAnnotation) obj, (DkCloudAnnotation) obj2);
    }

    public int a(DkCloudAnnotation dkCloudAnnotation, DkCloudAnnotation dkCloudAnnotation2) {
        if (dkCloudAnnotation.getStartPos().b(dkCloudAnnotation2.getStartPos())) {
            return -1;
        }
        if (dkCloudAnnotation.getStartPos().a(dkCloudAnnotation2.getStartPos())) {
            return 1;
        }
        return 0;
    }
}
