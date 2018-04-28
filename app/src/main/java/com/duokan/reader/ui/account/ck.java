package com.duokan.reader.ui.account;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.be;

class ck implements co {
    /* renamed from: a */
    final /* synthetic */ String f5926a;
    /* renamed from: b */
    final /* synthetic */ bx f5927b;

    ck(bx bxVar, String str) {
        this.f5927b = bxVar;
        this.f5926a = str;
    }

    /* renamed from: a */
    public void mo1586a(Bitmap bitmap, boolean z) {
        this.f5927b.f5895g.update(this.f5926a, bitmap, this.f5927b.f5893e.f5801b, new cl(this, bitmap, z));
    }

    /* renamed from: a */
    public void mo1587a(String str) {
        CharSequence str2;
        this.f5927b.f5900l.dismiss();
        Context activity = this.f5927b.getActivity();
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f5927b.getActivity().getString(C0258j.sina_send_failed);
        }
        be.m10287a(activity, str2, 1).show();
        this.f5927b.f5897i.setEnabled(true);
    }
}
