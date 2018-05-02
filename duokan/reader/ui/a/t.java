package com.duokan.reader.ui.a;

import android.text.TextUtils;

import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.domain.store.i;

class t implements i {
    final /* synthetic */ String a;
    final /* synthetic */ n b;

    t(n nVar, String str) {
        this.b = nVar;
        this.a = str;
    }

    public void a(DkStoreAbsBook[] dkStoreAbsBookArr, boolean z) {
        if (TextUtils.equals(this.a, this.b.b.getText().toString())) {
            for (Object add : dkStoreAbsBookArr) {
                this.b.c.add(add);
            }
        }
        this.b.a.getAdapter().a(z);
    }

    public void a(String str) {
        this.b.a.getAdapter().m();
    }
}
