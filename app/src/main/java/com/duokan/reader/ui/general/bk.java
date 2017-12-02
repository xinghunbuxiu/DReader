package com.duokan.reader.ui.general;

import android.view.View;

import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.ui.general.DkWebListView.ListState;

class bk implements an {
    final /* synthetic */ DkWebListView a;

    bk(DkWebListView dkWebListView) {
        this.a = dkWebListView;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        if ((this.a.getListState() != ListState.LOADING_MORE || i != this.a.d.c() - 1) && this.a.h != null) {
            this.a.h.a(hatGridView, view, i);
        }
    }
}
