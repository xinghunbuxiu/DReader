package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.general.be;

class ca implements cd {
    final /* synthetic */ bz a;

    ca(bz bzVar) {
        this.a = bzVar;
    }

    public void a(Bitmap bitmap, boolean z) {
        new ThirdWeiXin().share(!TextUtils.isEmpty(this.a.d) ? this.a.d : " ", !TextUtils.isEmpty(this.a.e) ? this.a.e : " ", !TextUtils.isEmpty(this.a.c) ? this.a.c : " ", bitmap, true, this.a.b.equals("wenxin_friends"));
        this.a.a(this.a.b);
        this.a.e();
        if (bitmap != null && !bitmap.isRecycled() && z) {
            bitmap.recycle();
        }
    }

    public void a() {
        this.a.e();
        CharSequence string = this.a.getString(j.gen_bitmap_fail);
        if (this.a.h != null) {
            this.a.h.b(string);
            this.a.h = null;
            return;
        }
        be.a(this.a.getContext(), string, 0).show();
    }
}
