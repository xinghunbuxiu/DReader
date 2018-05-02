package com.duokan.reader.ui.general;

import android.view.View;

import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.ao;
import com.duokan.reader.ui.general.DkWebListView.ListState;

class bl implements ao {
    final /* synthetic */ DkWebListView a;

    bl(DkWebListView dkWebListView) {
        this.a = dkWebListView;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        if ((this.a.getListState() != ListState.LOADING_MORE || i != this.a.d.c() - 1) && this.a.i != null) {
            this.a.i.a(hatGridView, view, i);
        }
    }
}
