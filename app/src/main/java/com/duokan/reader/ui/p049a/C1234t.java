package com.duokan.reader.ui.p049a;

import android.text.TextUtils;
import com.duokan.reader.domain.store.C1183i;
import com.duokan.reader.domain.store.DkStoreAbsBook;

/* renamed from: com.duokan.reader.ui.a.t */
class C1234t implements C1183i {
    /* renamed from: a */
    final /* synthetic */ String f5737a;
    /* renamed from: b */
    final /* synthetic */ C1228n f5738b;

    C1234t(C1228n c1228n, String str) {
        this.f5738b = c1228n;
        this.f5737a = str;
    }

    /* renamed from: a */
    public void mo1560a(DkStoreAbsBook[] dkStoreAbsBookArr, boolean z) {
        if (TextUtils.equals(this.f5737a, this.f5738b.f5727b.getText().toString())) {
            for (Object add : dkStoreAbsBookArr) {
                this.f5738b.f5728c.add(add);
            }
        }
        this.f5738b.f5726a.getAdapter().m8785a(z);
    }

    /* renamed from: a */
    public void mo1559a(String str) {
        this.f5738b.f5726a.getAdapter().m8790m();
    }
}
