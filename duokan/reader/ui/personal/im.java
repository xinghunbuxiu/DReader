package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;

class im implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ ih b;

    im(ih ihVar, String str) {
        this.b = ihVar;
        this.a = str;
    }

    public void onClick(View view) {
        new ThirdWeiXin().send2Friend(this.b.getString(j.personal__personal_redeem_info_view__send_title), this.a);
    }
}
