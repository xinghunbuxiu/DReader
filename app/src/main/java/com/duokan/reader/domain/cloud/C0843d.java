package com.duokan.reader.domain.cloud;

import java.util.Comparator;

/* renamed from: com.duokan.reader.domain.cloud.d */
final class C0843d implements Comparator<DkCloudNoteBookInfo> {
    C0843d() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5423a((DkCloudNoteBookInfo) obj, (DkCloudNoteBookInfo) obj2);
    }

    /* renamed from: a */
    public int m5423a(DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudNoteBookInfo dkCloudNoteBookInfo2) {
        return dkCloudNoteBookInfo2.getLastDate().compareTo(dkCloudNoteBookInfo.getLastDate());
    }
}
