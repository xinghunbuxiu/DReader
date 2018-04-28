package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.general.be;

class bq implements bt {
    /* renamed from: a */
    final /* synthetic */ bp f5882a;

    bq(bp bpVar) {
        this.f5882a = bpVar;
    }

    /* renamed from: a */
    public void mo1573a(Bitmap bitmap, boolean z) {
        new ThirdWeiXin().share(!TextUtils.isEmpty(this.f5882a.f5809d) ? this.f5882a.f5809d : " ", !TextUtils.isEmpty(this.f5882a.f5810e) ? this.f5882a.f5810e : " ", !TextUtils.isEmpty(this.f5882a.f5808c) ? this.f5882a.f5808c : " ", bitmap, true, this.f5882a.f5807b.equals("weixin_timeline"));
        this.f5882a.mo1571a(this.f5882a.f5807b);
        this.f5882a.m8885e();
        if (bitmap != null && !bitmap.isRecycled() && z) {
            bitmap.recycle();
        }
    }

    /* renamed from: a */
    public void mo1572a() {
        this.f5882a.m8885e();
        CharSequence string = this.f5882a.getString(C0258j.gen_bitmap_fail);
        if (this.f5882a.f5813h != null) {
            this.f5882a.f5813h.mo1845b(string);
            this.f5882a.f5813h = null;
            return;
        }
        be.m10287a(this.f5882a.getContext(), string, 0).show();
    }
}
