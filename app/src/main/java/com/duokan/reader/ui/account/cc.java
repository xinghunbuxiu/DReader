package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.OAuthCallback;
import com.duokan.reader.ui.general.be;

class cc implements OAuthCallback {
    /* renamed from: a */
    final /* synthetic */ bx f5918a;

    cc(bx bxVar) {
        this.f5918a = bxVar;
    }

    public void onOauthSuccess() {
        this.f5918a.f5902n = true;
        this.f5918a.m8965e();
    }

    public void onOauthFailed(String str) {
        CharSequence str2;
        Context activity = this.f5918a.getActivity();
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f5918a.getActivity().getString(C0258j.account_failed);
        }
        be.m10287a(activity, str2, 0).show();
    }

    public void onGetUserNameFailed() {
        be.m10287a(this.f5918a.getActivity(), this.f5918a.getActivity().getString(C0258j.account_get_name_failed), 0).show();
    }
}
