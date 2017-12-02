package com.duokan.reader.ui.account;

import com.duokan.c.j;
import com.duokan.common.i;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.ui.general.be;

class v implements Runnable {
    final /* synthetic */ t a;
    final /* synthetic */ u b;

    v(u uVar, t tVar) {
        this.b = uVar;
        this.a = tVar;
    }

    public void run() {
        if (i.a(this.b.getContext())) {
            ThirdYinxiang thirdYinxiang;
            if (TokenStore.getInstance().isBindAccessToken(this.b.getContext(), "evernote")) {
                thirdYinxiang = (ThirdYinxiang) ThirdOAuth.produceThird(this.b.getActivity(), "evernote");
            } else {
                thirdYinxiang = (ThirdYinxiang) ThirdOAuth.produceThird(this.b.getActivity(), "yinxiang");
            }
            thirdYinxiang.queryAccount(new w(this, thirdYinxiang));
            return;
        }
        be.a(this.b.getContext(), this.b.getContext().getString(j.report_no_network_error), 0).show();
    }
}
