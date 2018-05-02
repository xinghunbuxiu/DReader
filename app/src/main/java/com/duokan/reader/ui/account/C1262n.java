package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.ThirdYinxiang;
import com.duokan.reader.domain.account.oauth.TokenStore;

/* renamed from: com.duokan.reader.ui.account.n */
class C1262n implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1261m f5969a;

    C1262n(C1261m c1261m) {
        this.f5969a = c1261m;
    }

    public void onClick(View view) {
        if (ReaderEnv.get().getSyncEvernoteEnabled()) {
            ReaderEnv.get().setSyncEvernoteEnabled(false);
            this.f5969a.m9003a();
        } else if (TokenStore.getInstance().hasLoginEvernote(this.f5969a.getContext())) {
            ReaderEnv.get().setSyncEvernoteEnabled(true);
            this.f5969a.m9003a();
        } else {
            ((ThirdYinxiang) ThirdOAuth.produceThird(this.f5969a.getActivity(), "evernote")).queryAccount(new C1263o(this));
        }
    }
}
