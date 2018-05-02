package com.duokan.reader.domain.cloud;

import java.util.Comparator;

class fj implements Comparator {
    private fj() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudNoteBookInfo) obj, (DkCloudNoteBookInfo) obj2);
    }

    public int a(DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudNoteBookInfo dkCloudNoteBookInfo2) {
        return dkCloudNoteBookInfo2.getLastDate().compareTo(dkCloudNoteBookInfo.getLastDate());
    }
}
