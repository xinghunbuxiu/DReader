package com.duokan.reader.ui.general.web;

import android.view.View;

import com.duokan.core.ui.ay;
import com.duokan.core.ui.bg;

class ad implements bg {
    final /* synthetic */ SearchController a;

    ad(SearchController searchController) {
        this.a = searchController;
    }

    public void a(ay ayVar, View view, int i) {
        this.a.mSearchPresenter.b(i, view);
    }
}
