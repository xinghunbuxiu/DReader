package com.duokan.reader.ui.store.comment;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.be;

class g implements OnClickListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ boolean e;
    final /* synthetic */ f f;

    g(f fVar, boolean z, boolean z2, int i, String str, boolean z3) {
        this.f = fVar;
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = str;
        this.e = z3;
    }

    public void onClick(View view) {
        if (this.a && this.f.c.getScore() == 0.0f) {
            be.a(this.f.getActivity(), j.store_comment__publish_comment_view__rating_null, 1).show();
        } else if (this.b && TextUtils.isEmpty(this.f.b.getEditableText().toString().trim())) {
            be.a(this.f.getActivity(), j.store_comment__publish_comment_view__content_null, 1).show();
        } else if (this.c <= 0 || this.f.b.getEditableText().toString().length() <= this.c) {
            this.f.b();
            this.f.g = true;
            if (this.f.c.getScore() > 3.0f) {
                ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
            }
            this.f.e.a(this.f.a());
            if (this.e) {
                this.f.dismiss();
            }
        } else {
            be.a(this.f.getActivity(), this.d, 1).show();
        }
    }
}
