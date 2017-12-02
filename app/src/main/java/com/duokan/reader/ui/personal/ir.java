package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.domain.cloud.gc;

import java.util.Arrays;
import java.util.List;

class ir implements gc {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ ip c;

    ir(ip ipVar, int i, List list) {
        this.c = ipVar;
        this.a = i;
        this.b = list;
    }

    public void a(DkCloudRedeemFund[] dkCloudRedeemFundArr, boolean z) {
        if (this.a == 0) {
            this.b.clear();
        }
        Arrays.sort(dkCloudRedeemFundArr, new is(this));
        this.b.addAll(Arrays.asList(dkCloudRedeemFundArr));
        this.c.c.a(z);
    }

    public void a(String str) {
        this.c.c.m();
    }
}
