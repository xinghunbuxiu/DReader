package com.duokan.reader.ui.general.web;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.domain.cloud.gd;
import com.duokan.reader.ui.personal.ih;

class bc implements gd {
    final /* synthetic */ bb a;

    bc(bb bbVar) {
        this.a = bbVar;
    }

    public void a(DkCloudRedeemFund dkCloudRedeemFund) {
        ((ReaderFeature) this.a.a.b.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new ih(this.a.a.b.getContext(), dkCloudRedeemFund), null);
    }

    public void a(String str) {
    }
}
