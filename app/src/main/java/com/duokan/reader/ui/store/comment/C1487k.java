package com.duokan.reader.ui.store.comment;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.ui.store.comment.k */
class C1487k implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ boolean f11426a;
    /* renamed from: b */
    final /* synthetic */ boolean f11427b;
    /* renamed from: c */
    final /* synthetic */ int f11428c;
    /* renamed from: d */
    final /* synthetic */ String f11429d;
    /* renamed from: e */
    final /* synthetic */ C1486j f11430e;

    C1487k(C1486j c1486j, boolean z, boolean z2, int i, String str) {
        this.f11430e = c1486j;
        this.f11426a = z;
        this.f11427b = z2;
        this.f11428c = i;
        this.f11429d = str;
    }

    public void onClick(View view) {
        if (this.f11426a && this.f11430e.f11422c.getScore() == 0.0f) {
            be.m10286a(this.f11430e.getActivity(), C0258j.store_comment__publish_comment_view__rating_null, 1).show();
        } else if (this.f11427b && TextUtils.isEmpty(this.f11430e.f11421b.getEditableText().toString().trim())) {
            be.m10286a(this.f11430e.getActivity(), C0258j.store_comment__publish_comment_view__content_null, 1).show();
        } else if (this.f11428c <= 0 || this.f11430e.f11421b.getEditableText().toString().length() <= this.f11428c) {
            this.f11430e.m15383b();
            this.f11430e.f11425f = true;
            if (this.f11430e.f11422c.getScore() > 3.0f) {
                ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
            }
            this.f11430e.f11424e.mo730a(this.f11430e.m15380a());
            this.f11430e.dismiss();
        } else {
            be.m10287a(this.f11430e.getActivity(), this.f11429d, 1).show();
        }
    }
}
