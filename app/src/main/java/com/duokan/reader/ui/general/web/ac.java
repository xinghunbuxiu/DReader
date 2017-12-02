package com.duokan.reader.ui.general.web;

import android.view.View;

import com.duokan.core.ui.ay;
import com.duokan.core.ui.bf;

class ac implements bf {
    final /* synthetic */ SearchController a;

    ac(SearchController searchController) {
        this.a = searchController;
    }

    public void a(ay ayVar, View view, int i) {
        this.a.mSearchPresenter.a(i, view);
    }
}
