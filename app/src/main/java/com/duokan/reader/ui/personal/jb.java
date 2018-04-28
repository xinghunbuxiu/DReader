package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.domain.cloud.fk;
import com.duokan.reader.ui.general.C1329do;

class jb implements fk {
    /* renamed from: a */
    final /* synthetic */ String f8760a;
    /* renamed from: b */
    final /* synthetic */ C1329do f8761b;
    /* renamed from: c */
    final /* synthetic */ iu f8762c;

    jb(iu iuVar, String str, C1329do c1329do) {
        this.f8762c = iuVar;
        this.f8760a = str;
        this.f8761b = c1329do;
    }

    /* renamed from: a */
    public void mo1927a(DkCloudRedeemFund dkCloudRedeemFund) {
        this.f8762c.f8749b.setText(this.f8760a);
        this.f8761b.mo1780a();
    }

    /* renamed from: a */
    public void mo1928a(String str) {
        this.f8761b.mo1781a(str);
    }
}
