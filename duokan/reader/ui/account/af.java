package com.duokan.reader.ui.account;

import com.duokan.reader.domain.account.oauth.TokenStore.OnAccessTokenUnbindListener;
import com.duokan.reader.ui.general.jq;

class af implements OnAccessTokenUnbindListener {
    final /* synthetic */ jq a;
    final /* synthetic */ ae b;

    af(ae aeVar, jq jqVar) {
        this.b = aeVar;
        this.a = jqVar;
    }

    public void onOk() {
        if (this.a != null && this.a.isShowing()) {
            this.a.dismiss();
        }
        this.b.b.b();
    }
}
