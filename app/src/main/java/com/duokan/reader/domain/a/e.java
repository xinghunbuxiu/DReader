package com.duokan.reader.domain.a;

import android.text.TextUtils;

import com.duokan.b.i;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;

class e implements b {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void a(a aVar) {
        this.a.c.f.a(this.a.c.a, this.a.c.b, this.a.c.c, this.a.c.d, this.a.c.e);
    }

    public void a(a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.a.c.f.c.getString(i.reading__comment_view__publish_comment_no_account);
        }
        this.a.c.e.a(str);
    }
}
