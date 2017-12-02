package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

class aa implements OnClickListener {
    final /* synthetic */ SearchController a;

    aa(SearchController searchController) {
        this.a = searchController;
    }

    public void onClick(View view) {
        this.a.mLocalSearchLoadTime = this.a.mLocalSearchLoadTime + 1;
        this.a.refreshView();
    }
}
