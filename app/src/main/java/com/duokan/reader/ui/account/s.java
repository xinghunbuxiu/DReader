package com.duokan.reader.ui.account;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.domain.account.bb;

do;

class s implements bb {
    final /* synthetic */ do a;
    final /* synthetic */ q b;

    s(q qVar, do doVar) {
        this.b = qVar;
        this.a = doVar;
    }

    public void a() {
        this.a.a();
    }

    public void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            this.a.a(this.b.getContext().getResources().getString(j.personal__miaccount_change_signature_view__failed));
        } else {
            this.a.a(str);
        }
    }
}
