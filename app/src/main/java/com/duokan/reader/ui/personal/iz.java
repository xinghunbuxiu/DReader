package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;

class iz implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ String f8755a;
    /* renamed from: b */
    final /* synthetic */ iu f8756b;

    iz(iu iuVar, String str) {
        this.f8756b = iuVar;
        this.f8755a = str;
    }

    public void onClick(View view) {
        new ThirdWeiXin().send2Friend(this.f8756b.getString(C0258j.personal__personal_redeem_info_view__send_title), this.f8755a);
    }
}
