package com.duokan.reader.ui.general.web;

import android.view.View;

import com.duokan.core.ui.OnItemLongPressListener;
import com.duokan.core.ui.ay;

class ae implements OnItemLongPressListener {
    /* renamed from: a */
    final /* synthetic */ SearchController f7571a;

    ae(SearchController searchController) {
        this.f7571a = searchController;
    }

    /* renamed from: a */
    public void onItemLongPress(ay ayVar, View view, int i) {
        this.f7571a.mSearchPresenter.mo1720b(i, view);
    }
}
