package com.duokan.reader.common.webservices.duokan;

import java.util.Comparator;

/* renamed from: com.duokan.reader.common.webservices.duokan.l */
class C0638l implements Comparator<DkFeedbackThreadInfo> {
    /* renamed from: a */
    final /* synthetic */ C0637k f2143a;

    C0638l(C0637k c0637k) {
        this.f2143a = c0637k;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m2894a((DkFeedbackThreadInfo) obj, (DkFeedbackThreadInfo) obj2);
    }

    /* renamed from: a */
    public int m2894a(DkFeedbackThreadInfo dkFeedbackThreadInfo, DkFeedbackThreadInfo dkFeedbackThreadInfo2) {
        if (dkFeedbackThreadInfo.mDateLine < dkFeedbackThreadInfo2.mDateLine) {
            return 1;
        }
        return -1;
    }
}
