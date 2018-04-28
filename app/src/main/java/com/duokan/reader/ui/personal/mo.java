package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudComment;
import java.util.Comparator;

class mo implements Comparator<DkCloudComment> {
    /* renamed from: a */
    final /* synthetic */ mj f8956a;

    mo(mj mjVar) {
        this.f8956a = mjVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m12307a((DkCloudComment) obj, (DkCloudComment) obj2);
    }

    /* renamed from: a */
    public int m12307a(DkCloudComment dkCloudComment, DkCloudComment dkCloudComment2) {
        if (dkCloudComment.getStartPos().m5592b(dkCloudComment2.getStartPos())) {
            return -1;
        }
        if (dkCloudComment.getStartPos().m5590a(dkCloudComment2.getStartPos())) {
            return 1;
        }
        return 0;
    }
}
