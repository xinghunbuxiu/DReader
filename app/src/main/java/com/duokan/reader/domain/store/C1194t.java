package com.duokan.reader.domain.store;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.duokan.reader.domain.store.t */
class C1194t implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1192r f5685a;

    C1194t(C1192r c1192r) {
        this.f5685a = c1192r;
    }

    public void onClick(View view) {
        this.f5685a.dismiss();
        this.f5685a.onCancel();
    }
}
