package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.OAuthCallback;
import com.duokan.reader.ui.general.be;

class cm implements OAuthCallback {
    final /* synthetic */ ch a;

    cm(ch chVar) {
        this.a = chVar;
    }

    public void onOauthSuccess() {
        this.a.n = true;
        this.a.e();
    }

    public void onOauthFailed(String str) {
        CharSequence string;
        Context activity = this.a.getActivity();
        if (TextUtils.isEmpty(str)) {
            string = this.a.getActivity().getString(j.account_failed);
        }
        be.a(activity, string, 0).show();
    }

    public void onGetUserNameFailed() {
        be.a(this.a.getActivity(), this.a.getActivity().getString(j.account_get_name_failed), 0).show();
    }
}
