package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.OAuthCallback;
import com.duokan.reader.ui.general.be;

class br implements OAuthCallback {
    final /* synthetic */ bn a;

    br(bn bnVar) {
        this.a = bnVar;
    }

    public void onOauthSuccess() {
        this.a.f = true;
        this.a.c();
    }

    public void onOauthFailed(String str) {
        CharSequence string;
        Context context = this.a.getContext();
        if (TextUtils.isEmpty(str)) {
            string = this.a.getContext().getString(j.account_failed);
        }
        be.a(context, string, 0).show();
    }

    public void onGetUserNameFailed() {
        be.a(this.a.getContext(), j.account_get_name_failed, 0).show();
    }
}
