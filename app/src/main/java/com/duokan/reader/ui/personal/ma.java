package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudComment;

import java.util.Comparator;

class ma implements Comparator {
    final /* synthetic */ lv a;

    ma(lv lvVar) {
        this.a = lvVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudComment) obj, (DkCloudComment) obj2);
    }

    public int a(DkCloudComment dkCloudComment, DkCloudComment dkCloudComment2) {
        if (dkCloudComment.getStartPos().b(dkCloudComment2.getStartPos())) {
            return -1;
        }
        if (dkCloudComment.getStartPos().a(dkCloudComment2.getStartPos())) {
            return 1;
        }
        return 0;
    }
}
