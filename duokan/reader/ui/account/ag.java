package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.OAuthCallback;
import com.duokan.reader.ui.general.be;

class ag implements OAuthCallback {
    final /* synthetic */ z a;

    ag(z zVar) {
        this.a = zVar;
    }

    public void onOauthSuccess() {
        this.a.b();
        be.a(this.a.getContext(), this.a.getContext().getString(j.account_success), 0).show();
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
        be.a(this.a.getContext(), this.a.getContext().getString(j.account_get_name_failed), 1).show();
    }
}
