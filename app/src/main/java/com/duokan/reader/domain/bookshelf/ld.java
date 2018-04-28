package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.ui.general.be;

class ld implements C0666x {
    /* renamed from: a */
    final /* synthetic */ lb f3536a;

    ld(lb lbVar) {
        this.f3536a = lbVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        al alVar = new al(c0672a);
        this.f3536a.f3528h = new le(this, alVar.f2360a, C0643q.f2173a, alVar);
        this.f3536a.f3528h.open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3536a.m4926f();
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f3536a.f3522b, (CharSequence) str, 0).show();
        }
    }
}
