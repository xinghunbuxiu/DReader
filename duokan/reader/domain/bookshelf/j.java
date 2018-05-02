package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.cloud.DkCloudAnnotation;

import java.util.Comparator;

class j implements Comparator {
    final /* synthetic */ c a;

    j(c cVar) {
        this.a = cVar;
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
