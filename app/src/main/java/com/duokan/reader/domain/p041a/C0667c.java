package com.duokan.reader.domain.p041a;

import android.text.TextUtils;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.a.c */
class C0667c implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f2228a;
    /* renamed from: b */
    final /* synthetic */ int f2229b;
    /* renamed from: c */
    final /* synthetic */ String f2230c;
    /* renamed from: d */
    final /* synthetic */ String f2231d;
    /* renamed from: e */
    final /* synthetic */ C0669e f2232e;
    /* renamed from: f */
    final /* synthetic */ C0664a f2233f;

    C0667c(C0664a c0664a, String str, int i, String str2, String str3, C0669e c0669e) {
        this.f2233f = c0664a;
        this.f2228a = str;
        this.f2229b = i;
        this.f2230c = str2;
        this.f2231d = str3;
        this.f2232e = c0669e;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        if (this.f2233f.f2222e != null) {
            this.f2233f.f2222e.close();
        }
        this.f2233f.f2222e = new C0668d(this, c0672a.mo832b(), C0643q.f2173a, c0672a);
        this.f2233f.f2222e.open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f2233f.f2220c.getString(C0247i.reading__comment_view__publish_comment_no_account);
        }
        this.f2232e.mo2310a(str);
    }
}
