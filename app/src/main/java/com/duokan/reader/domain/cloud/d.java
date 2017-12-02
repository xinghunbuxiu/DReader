package com.duokan.reader.domain.cloud;

import java.util.Comparator;

final class d implements Comparator {
    d() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudNoteBookInfo) obj, (DkCloudNoteBookInfo) obj2);
    }

    public int a(DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudNoteBookInfo dkCloudNoteBookInfo2) {
        return dkCloudNoteBookInfo2.getLastDate().compareTo(dkCloudNoteBookInfo.getLastDate());
    }
}
