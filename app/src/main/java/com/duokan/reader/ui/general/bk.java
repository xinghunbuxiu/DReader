package com.duokan.reader.ui.general;

import android.view.View;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.ui.general.DkWebListView.ListState;

class bk implements an {
    /* renamed from: a */
    final /* synthetic */ DkWebListView f7000a;

    bk(DkWebListView dkWebListView) {
        this.f7000a = dkWebListView;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        if ((this.f7000a.getListState() != ListState.LOADING_MORE || i != this.f7000a.f6795d.mo506c() - 1) && this.f7000a.f6799h != null) {
            this.f7000a.f6799h.mo1558a(hatGridView, view, i);
        }
    }
}
