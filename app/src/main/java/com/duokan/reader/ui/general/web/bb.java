package com.duokan.reader.ui.general.web;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.domain.cloud.fj;
import com.duokan.reader.ui.personal.iu;

class bb implements fj {
    /* renamed from: a */
    final /* synthetic */ ba f7617a;

    bb(ba baVar) {
        this.f7617a = baVar;
    }

    /* renamed from: a */
    public void mo1160a(DkCloudRedeemFund dkCloudRedeemFund) {
        ((ReaderFeature) this.f7617a.f7616a.f7614b.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new iu(this.f7617a.f7616a.f7614b.getContext(), dkCloudRedeemFund), null);
    }

    /* renamed from: a */
    public void mo1161a(String str) {
    }
}
