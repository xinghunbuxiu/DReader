package com.duokan.reader.ui.account;

import com.duokan.c.j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.UpdateHandler;
import com.duokan.reader.ui.general.be;

class x implements UpdateHandler {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public void onUpdateOk() {
        be.a(this.a.b.b.getContext(), j.account__oauth__ok, 1).show();
    }

    public void onUpdateError() {
        be.a(this.a.b.b.getContext(), j.account__oauth__error, 1).show();
    }

    public void onUpdateCancel() {
    }
}
