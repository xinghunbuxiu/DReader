package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.OAuthCallback;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.ui.account.t */
class C1268t implements OAuthCallback {
    /* renamed from: a */
    final /* synthetic */ C1261m f5977a;

    C1268t(C1261m c1261m) {
        this.f5977a = c1261m;
    }

    public void onOauthSuccess() {
        this.f5977a.m9007b();
        be.m10287a(this.f5977a.getContext(), this.f5977a.getContext().getString(C0258j.account_success), 0).show();
    }

    public void onOauthFailed(String str) {
        CharSequence str2;
        Context context = this.f5977a.getContext();
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f5977a.getContext().getString(C0258j.account_failed);
        }
        be.m10287a(context, str2, 0).show();
    }

    public void onGetUserNameFailed() {
        be.m10287a(this.f5977a.getContext(), this.f5977a.getContext().getString(C0258j.account_get_name_failed), 1).show();
    }
}
