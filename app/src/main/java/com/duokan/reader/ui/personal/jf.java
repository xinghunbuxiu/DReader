package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import java.util.Comparator;

class jf implements Comparator<DkCloudRedeemFund> {
    /* renamed from: a */
    final /* synthetic */ je f8770a;

    jf(je jeVar) {
        this.f8770a = jeVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m12046a((DkCloudRedeemFund) obj, (DkCloudRedeemFund) obj2);
    }

    /* renamed from: a */
    public int m12046a(DkCloudRedeemFund dkCloudRedeemFund, DkCloudRedeemFund dkCloudRedeemFund2) {
        int status = dkCloudRedeemFund.getStatus() - dkCloudRedeemFund2.getStatus();
        if (status < 0) {
            return -1;
        }
        if (status > 0) {
            return 1;
        }
        return 0;
    }
}
