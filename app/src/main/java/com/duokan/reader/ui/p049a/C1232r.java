package com.duokan.reader.ui.p049a;

import android.view.View;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.store.DkStoreAbsBook;

/* renamed from: com.duokan.reader.ui.a.r */
class C1232r implements an {
    /* renamed from: a */
    final /* synthetic */ C1221u f5734a;
    /* renamed from: b */
    final /* synthetic */ C1228n f5735b;

    C1232r(C1228n c1228n, C1221u c1221u) {
        this.f5735b = c1228n;
        this.f5734a = c1221u;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        this.f5734a.mo1552a((DkStoreAbsBook) hatGridView.getAdapter().mo509d(i));
        dv.m1909a(this.f5735b.getContext());
        this.f5735b.requestDetach();
    }
}
