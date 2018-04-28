package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class er implements Comparator<DkCloudNoteBookInfo> {
    private er() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5506a((DkCloudNoteBookInfo) obj, (DkCloudNoteBookInfo) obj2);
    }

    /* renamed from: a */
    public int m5506a(DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudNoteBookInfo dkCloudNoteBookInfo2) {
        return dkCloudNoteBookInfo2.getLastDate().compareTo(dkCloudNoteBookInfo.getLastDate());
    }
}
