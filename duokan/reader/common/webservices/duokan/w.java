package com.duokan.reader.common.webservices.duokan;

import java.util.Comparator;

final class w implements Comparator {
    w() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkStoreFictionCategoryInfo) obj, (DkStoreFictionCategoryInfo) obj2);
    }

    public int a(DkStoreFictionCategoryInfo dkStoreFictionCategoryInfo, DkStoreFictionCategoryInfo dkStoreFictionCategoryInfo2) {
        if (dkStoreFictionCategoryInfo.mLabel.length() < dkStoreFictionCategoryInfo2.mLabel.length()) {
            return -1;
        }
        if (dkStoreFictionCategoryInfo.mLabel.length() > dkStoreFictionCategoryInfo2.mLabel.length()) {
            return 1;
        }
        return 0;
    }
}
