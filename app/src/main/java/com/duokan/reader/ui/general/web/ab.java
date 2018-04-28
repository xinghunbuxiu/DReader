package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

class ab implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ SearchController f7567a;

    ab(SearchController searchController) {
        this.f7567a = searchController;
    }

    public void onClick(View view) {
        this.f7567a.mLocalSearchLoadTime = this.f7567a.mLocalSearchLoadTime + 1;
        this.f7567a.refreshView();
    }
}
