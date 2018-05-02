package com.duokan.reader.common.webservices.duokan;

import java.util.Comparator;

class l implements Comparator {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkFeedbackThreadInfo) obj, (DkFeedbackThreadInfo) obj2);
    }

    public int a(DkFeedbackThreadInfo dkFeedbackThreadInfo, DkFeedbackThreadInfo dkFeedbackThreadInfo2) {
        if (dkFeedbackThreadInfo.mDateLine < dkFeedbackThreadInfo2.mDateLine) {
            return 1;
        }
        return -1;
    }
}
