package com.duokan.reader.ui.account;

import com.duokan.common.C0260b;
import com.duokan.common.C0267i;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hq;

/* renamed from: com.duokan.reader.ui.account.j */
class C1258j implements hq {
    /* renamed from: a */
    final /* synthetic */ C1256h f5959a;

    private C1258j(C1256h c1256h) {
        this.f5959a = c1256h;
    }

    /* renamed from: a */
    public void mo1590a(int i) {
        switch (i) {
            case 0:
                if (C0267i.m604a(this.f5959a.getContext())) {
                    ThirdYinxiang thirdYinxiang;
                    if (TokenStore.getInstance().isBindAccessToken(this.f5959a.getContext(), "evernote")) {
                        thirdYinxiang = (ThirdYinxiang) ThirdOAuth.produceThird(this.f5959a.getActivity(), "evernote");
                    } else {
                        thirdYinxiang = (ThirdYinxiang) ThirdOAuth.produceThird(this.f5959a.getActivity(), "yinxiang");
                    }
                    thirdYinxiang.queryAccount(new C1259k(this, thirdYinxiang));
                    return;
                }
                be.m10287a(this.f5959a.getContext(), this.f5959a.getContext().getString(C0258j.report_no_network_error), 0).show();
                return;
            case 1:
                if (this.f5959a.f5955f != null) {
                    C0260b.m569a(this.f5959a.getContext(), this.f5959a.f5955f, this.f5959a.f5956g, this.f5959a.f5957h);
                    return;
                } else {
                    C0260b.m570a(this.f5959a.getContext(), this.f5959a.f5954e, this.f5959a.f5952c, this.f5959a.f5953d);
                    return;
                }
            default:
                return;
        }
    }
}
