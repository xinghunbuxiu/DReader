package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.general.be;

class cs implements cy {
    final /* synthetic */ ch a;

    cs(ch chVar) {
        this.a = chVar;
    }

    public void a(Bitmap bitmap, boolean z) {
        new ThirdWeiXin().share(this.a.e.d.length > 0 ? this.a.e.d[0] : " ", this.a.e.d.length > 1 ? this.a.e.d[1] : " ", this.a.e.a, bitmap, this.a.f(), false);
        if (this.a.l.isShowing()) {
            this.a.l.dismiss();
        }
        this.a.a("wenxin_friend");
        this.a.dismiss();
        if (bitmap != null && !bitmap.isRecycled() && z) {
            bitmap.recycle();
        }
    }

    public void a(String str) {
        CharSequence string;
        if (this.a.l.isShowing()) {
            this.a.l.dismiss();
        }
        Context activity = this.a.getActivity();
        if (TextUtils.isEmpty(str)) {
            string = this.a.getActivity().getString(j.share_failed);
        }
        be.a(activity, string, 1).show();
        this.a.dismiss();
    }
}
