package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

class s implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ SearchController b;

    s(SearchController searchController, int i) {
        this.b = searchController;
        this.a = i;
    }

    public void onClick(View view) {
        this.b.removeHistory(this.a);
    }
}
