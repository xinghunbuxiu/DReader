package com.duokan.reader.ui.store;

import android.view.View;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.expandable.StateExpandableAdapter.ExpandableAdapterState;

class bd implements an {
    /* renamed from: a */
    final /* synthetic */ bc f11360a;

    bd(bc bcVar) {
        this.f11360a = bcVar;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        int[] b = this.f11360a.f11357a.m1404b(i);
        ao aoVar = (ao) AppContext.getAppContext(this.f11360a.getContext()).queryFeature(ao.class);
        if (this.f11360a.f11357a.m10580c(b[0], b[1]) != ExpandableAdapterState.IGNORE) {
            UmengManager.get().onEvent("V2_STORE_FICTION_BUY_FROM", "FullOutline");
            aq.m15256a((AppContext) AppContext.getAppContext(this.f11360a.getContext()), (ReaderFeature) AppContext.getAppContext(this.f11360a.getContext()).queryFeature(ReaderFeature.class), this.f11360a.f11358b, (long) (b[1] + (b[0] * 100)), new be(this, aoVar));
            return;
        }
        aq.m15254a((ReaderFeature) AppContext.getAppContext(this.f11360a.getContext()).queryFeature(ReaderFeature.class), this.f11360a.f11358b, (long) ((b[0] * 100) + b[1]));
    }
}
