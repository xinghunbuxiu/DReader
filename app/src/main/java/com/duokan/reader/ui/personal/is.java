package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudRedeemFund;

import java.util.Comparator;

class is implements Comparator {
    final /* synthetic */ ir a;

    is(ir irVar) {
        this.a = irVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DkCloudRedeemFund) obj, (DkCloudRedeemFund) obj2);
    }

    public int a(DkCloudRedeemFund dkCloudRedeemFund, DkCloudRedeemFund dkCloudRedeemFund2) {
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
