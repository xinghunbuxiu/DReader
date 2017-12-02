package com.duokan.reader.domain.a;

import android.text.TextUtils;

import com.duokan.b.i;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class c implements u {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ f e;
    final /* synthetic */ a f;

    c(a aVar, String str, int i, String str2, String str3, f fVar) {
        this.f = aVar;
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = fVar;
    }

    public void onQueryAccountOk(a aVar) {
        if (this.f.e != null) {
            this.f.e.close();
        }
        this.f.e = new d(this, aVar, aVar.b());
        this.f.e.open(2000);
    }

    public void onQueryAccountError(a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.f.c.getString(i.reading__comment_view__publish_comment_no_account);
        }
        this.e.a(str);
    }
}
