package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.general.be;

class cj implements co {
    /* renamed from: a */
    final /* synthetic */ bx f5925a;

    cj(bx bxVar) {
        this.f5925a = bxVar;
    }

    /* renamed from: a */
    public void mo1586a(Bitmap bitmap, boolean z) {
        new ThirdWeiXin().share(this.f5925a.f5893e.f5803d.length > 0 ? this.f5925a.f5893e.f5803d[0] : " ", this.f5925a.f5893e.f5803d.length > 1 ? this.f5925a.f5893e.f5803d[1] : " ", this.f5925a.f5893e.f5800a, bitmap, this.f5925a.m8967f(), true);
        if (this.f5925a.f5900l.isShowing()) {
            this.f5925a.f5900l.dismiss();
        }
        this.f5925a.m8953a("weixin_timeline");
        this.f5925a.dismiss();
        if (bitmap != null && !bitmap.isRecycled() && z) {
            bitmap.recycle();
        }
    }

    /* renamed from: a */
    public void mo1587a(String str) {
        CharSequence str2;
        if (this.f5925a.f5900l.isShowing()) {
            this.f5925a.f5900l.dismiss();
        }
        Context activity = this.f5925a.getActivity();
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f5925a.getActivity().getString(C0258j.share_failed);
        }
        be.m10287a(activity, str2, 1).show();
        this.f5925a.dismiss();
    }
}
