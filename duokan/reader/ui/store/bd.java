package com.duokan.reader.ui.store;

import android.view.View;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.expandable.StateExpandableAdapter.ExpandableAdapterState;

class bd implements an {
    final /* synthetic */ bc a;

    bd(bc bcVar) {
        this.a = bcVar;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        int[] b = this.a.a.b(i);
        ao aoVar = (ao) MyContextWrapper.getFeature(this.a.getContext()).queryFeature(ao.class);
        if (this.a.a.c(b[0], b[1]) != ExpandableAdapterState.IGNORE) {
            UmengManager.get().onEvent("V2_STORE_FICTION_BUY_FROM", "FullOutline");
            aq.a((MyContextWrapper) MyContextWrapper.getFeature(this.a.getContext()), (ReaderFeature) MyContextWrapper.getFeature(this.a.getContext()).queryFeature(ReaderFeature.class), this.a.b, (long) (b[1] + (b[0] * 100)), new be(this, aoVar));
            return;
        }
        aq.a((ReaderFeature) MyContextWrapper.getFeature(this.a.getContext()).queryFeature(ReaderFeature.class), this.a.b, (long) ((b[0] * 100) + b[1]));
    }
}
