package com.duokan.reader.ui.general.web;

import android.view.View;
import com.duokan.core.ui.ay;
import com.duokan.core.ui.OnItemClickListener;

class ad implements OnItemClickListener {
    /* renamed from: a */
    final /* synthetic */ SearchController f7570a;

    ad(SearchController searchController) {
        this.f7570a = searchController;
    }

    /* renamed from: a */
    public void onItemClick(ay ayVar, View view, int i) {
        this.f7570a.mSearchPresenter.mo1718a(i, view);
    }
}
