package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.domain.cloud.fi;
import java.util.Arrays;
import java.util.List;

class je implements fi {
    /* renamed from: a */
    final /* synthetic */ int f8767a;
    /* renamed from: b */
    final /* synthetic */ List f8768b;
    /* renamed from: c */
    final /* synthetic */ jc f8769c;

    je(jc jcVar, int i, List list) {
        this.f8769c = jcVar;
        this.f8767a = i;
        this.f8768b = list;
    }

    /* renamed from: a */
    public void mo1931a(DkCloudRedeemFund[] dkCloudRedeemFundArr, boolean z) {
        if (this.f8767a == 0) {
            this.f8768b.clear();
        }
        Arrays.sort(dkCloudRedeemFundArr, new jf(this));
        this.f8768b.addAll(Arrays.asList(dkCloudRedeemFundArr));
        this.f8769c.f8765c.m8785a(z);
    }

    /* renamed from: a */
    public void mo1930a(String str) {
        this.f8769c.f8765c.m8790m();
    }
}
