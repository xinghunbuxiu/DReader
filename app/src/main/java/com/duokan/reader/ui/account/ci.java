package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.general.be;

class ci implements co {
    /* renamed from: a */
    final /* synthetic */ bx f5924a;

    ci(bx bxVar) {
        this.f5924a = bxVar;
    }

    /* renamed from: a */
    public void mo1586a(Bitmap bitmap, boolean z) {
        new ThirdWeiXin().share(this.f5924a.f5893e.f5803d.length > 0 ? this.f5924a.f5893e.f5803d[0] : " ", this.f5924a.f5893e.f5803d.length > 1 ? this.f5924a.f5893e.f5803d[1] : " ", this.f5924a.f5893e.f5800a, bitmap, this.f5924a.m8967f(), false);
        if (this.f5924a.f5900l.isShowing()) {
            this.f5924a.f5900l.dismiss();
        }
        this.f5924a.m8953a("weixin_friend");
        this.f5924a.dismiss();
        if (bitmap != null && !bitmap.isRecycled() && z) {
            bitmap.recycle();
        }
    }

    /* renamed from: a */
    public void mo1587a(String str) {
        CharSequence str2;
        if (this.f5924a.f5900l.isShowing()) {
            this.f5924a.f5900l.dismiss();
        }
        Context activity = this.f5924a.getActivity();
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f5924a.getActivity().getString(C0258j.share_failed);
        }
        be.m10287a(activity, str2, 1).show();
        this.f5924a.dismiss();
    }
}
