package com.duokan.reader.ui.store.comment;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.ui.store.comment.g */
class C1483g implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ boolean f11411a;
    /* renamed from: b */
    final /* synthetic */ boolean f11412b;
    /* renamed from: c */
    final /* synthetic */ int f11413c;
    /* renamed from: d */
    final /* synthetic */ String f11414d;
    /* renamed from: e */
    final /* synthetic */ boolean f11415e;
    /* renamed from: f */
    final /* synthetic */ C1482f f11416f;

    C1483g(C1482f c1482f, boolean z, boolean z2, int i, String str, boolean z3) {
        this.f11416f = c1482f;
        this.f11411a = z;
        this.f11412b = z2;
        this.f11413c = i;
        this.f11414d = str;
        this.f11415e = z3;
    }

    public void onClick(View view) {
        if (this.f11411a && this.f11416f.f11406c.getScore() == 0.0f) {
            be.m10286a(this.f11416f.getActivity(), C0258j.store_comment__publish_comment_view__rating_null, 1).show();
        } else if (this.f11412b && TextUtils.isEmpty(this.f11416f.f11405b.getEditableText().toString().trim())) {
            be.m10286a(this.f11416f.getActivity(), C0258j.store_comment__publish_comment_view__content_null, 1).show();
        } else if (this.f11413c <= 0 || this.f11416f.f11405b.getEditableText().toString().length() <= this.f11413c) {
            this.f11416f.m15374b();
            this.f11416f.f11410g = true;
            if (this.f11416f.f11406c.getScore() > 3.0f) {
                ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
            }
            this.f11416f.f11408e.run(this.f11416f.m15371a());
            if (this.f11415e) {
                this.f11416f.dismiss();
            }
        } else {
            be.m10287a(this.f11416f.getActivity(), this.f11414d, 1).show();
        }
    }
}
