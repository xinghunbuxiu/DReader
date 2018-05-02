package com.duokan.reader.ui.store;

import android.content.Context;

import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.m;
import com.duokan.reader.domain.store.r;

class v extends r {
    final /* synthetic */ m a;
    final /* synthetic */ String b;
    final /* synthetic */ DkStoreCallback c;
    final /* synthetic */ o d;

    v(o oVar, Context context, m mVar, String str, DkStoreCallback dkStoreCallback) {
        this.d = oVar;
        this.a = mVar;
        this.b = str;
        this.c = dkStoreCallback;
        super(context);
    }

    public void a() {
        super.a();
        this.d.c(this.a, this.b, this.c);
    }

    public void onCancel() {
        super.onCancel();
        this.c.a(this.a, "");
    }
}
