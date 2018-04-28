package com.duokan.reader.ui.general;

import android.view.View;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.ao;
import com.duokan.reader.ui.general.DkWebListView.ListState;

class bl implements ao {
    /* renamed from: a */
    final /* synthetic */ DkWebListView f7001a;

    bl(DkWebListView dkWebListView) {
        this.f7001a = dkWebListView;
    }

    /* renamed from: a */
    public void mo1751a(HatGridView hatGridView, View view, int i) {
        if ((this.f7001a.getListState() != ListState.LOADING_MORE || i != this.f7001a.f6795d.mo506c() - 1) && this.f7001a.f6800i != null) {
            this.f7001a.f6800i.mo1751a(hatGridView, view, i);
        }
    }
}
