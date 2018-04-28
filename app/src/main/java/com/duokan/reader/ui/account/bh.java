package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.OAuthCallback;
import com.duokan.reader.ui.general.be;

class bh implements OAuthCallback {
    /* renamed from: a */
    final /* synthetic */ bd f5869a;

    bh(bd bdVar) {
        this.f5869a = bdVar;
    }

    public void onOauthSuccess() {
        this.f5869a.f5821b = true;
        this.f5869a.m8909c();
    }

    public void onOauthFailed(String str) {
        CharSequence str2;
        Context context = this.f5869a.getContext();
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f5869a.getContext().getString(C0258j.account_failed);
        }
        be.m10287a(context, str2, 0).show();
    }

    public void onGetUserNameFailed() {
        be.m10286a(this.f5869a.getContext(), C0258j.account_get_name_failed, 0).show();
    }
}
