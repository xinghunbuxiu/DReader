package com.duokan.reader.ui.store.comment;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.be;

class k implements OnClickListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ j e;

    k(j jVar, boolean z, boolean z2, int i, String str) {
        this.e = jVar;
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = str;
    }

    public void onClick(View view) {
        if (this.a && this.e.c.getScore() == 0.0f) {
            be.a(this.e.getActivity(), j.store_comment__publish_comment_view__rating_null, 1).show();
        } else if (this.b && TextUtils.isEmpty(this.e.b.getEditableText().toString().trim())) {
            be.a(this.e.getActivity(), j.store_comment__publish_comment_view__content_null, 1).show();
        } else if (this.c <= 0 || this.e.b.getEditableText().toString().length() <= this.c) {
            this.e.b();
            this.e.f = true;
            if (this.e.c.getScore() > 3.0f) {
                ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
            }
            this.e.e.a(this.e.a());
            this.e.dismiss();
        } else {
            be.a(this.e.getActivity(), this.d, 1).show();
        }
    }
}
