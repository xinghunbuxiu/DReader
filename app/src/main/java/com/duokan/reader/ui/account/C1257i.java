package com.duokan.reader.ui.account;

import com.duokan.core.ui.BaseDialog;
import com.duokan.core.ui.OnDismissListener;

/* renamed from: com.duokan.reader.ui.account.i */
class C1257i implements OnDismissListener {
    /* renamed from: a */
    final /* synthetic */ C1256h f5958a;

    C1257i(C1256h c1256h) {
        this.f5958a = c1256h;
    }

    public void onDismiss(BaseDialog dialog) {
        this.f5958a.requestDetach();
    }
}
