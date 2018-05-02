package com.duokan.reader.ui.account;

import com.duokan.core.ui.C0342j;
import com.duokan.core.ui.OnDismissListener;

/* renamed from: com.duokan.reader.ui.account.i */
class C1257i implements OnDismissListener {
    /* renamed from: a */
    final /* synthetic */ C1256h f5958a;

    C1257i(C1256h c1256h) {
        this.f5958a = c1256h;
    }

    public void onDismiss(C0342j c0342j) {
        this.f5958a.requestDetach();
    }
}
