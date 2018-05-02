package com.duokan.reader.ui.account;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.QueryAccountListener;

class ab implements QueryAccountListener {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public void onQueryAccountOk(String... strArr) {
        ReaderEnv.get().setSyncEvernoteEnabled(true);
        this.a.a.b();
        this.a.a.a();
    }

    public void onQueryAccountError() {
        this.a.a.a();
    }
}
