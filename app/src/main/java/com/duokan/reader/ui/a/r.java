package com.duokan.reader.ui.a;

import android.view.View;

import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.store.DkStoreAbsBook;

class r implements an {
    final /* synthetic */ u a;
    final /* synthetic */ n b;

    r(n nVar, u uVar) {
        this.b = nVar;
        this.a = uVar;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        this.a.a((DkStoreAbsBook) hatGridView.getAdapter().d(i));
        UTools.hideSoftInputFromWindow(this.b.getContext());
        this.b.requestDetach();
    }
}
