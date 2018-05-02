package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;
import com.duokan.reader.domain.account.oauth.TokenStore;

class aa implements OnClickListener {
    final /* synthetic */ z a;

    aa(z zVar) {
        this.a = zVar;
    }

    public void onClick(View view) {
        if (ReaderEnv.get().getSyncEvernoteEnabled()) {
            ReaderEnv.get().setSyncEvernoteEnabled(false);
            this.a.a();
        } else if (TokenStore.getInstance().hasLoginEvernote(this.a.getContext())) {
            ReaderEnv.get().setSyncEvernoteEnabled(true);
            this.a.a();
        } else {
            ((ThirdYinxiang) ThirdOAuth.produceThird(this.a.getActivity(), "evernote")).queryAccount(new ab(this));
        }
    }
}
