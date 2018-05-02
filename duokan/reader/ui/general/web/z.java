package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

class z implements OnClickListener {
    final /* synthetic */ SearchController a;

    z(SearchController searchController) {
        this.a = searchController;
    }

    public void onClick(View view) {
        this.a.mEditText.getText().clear();
    }
}
