package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

class aa implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ SearchController f7566a;

    aa(SearchController searchController) {
        this.f7566a = searchController;
    }

    public void onClick(View view) {
        this.f7566a.mEditText.getText().clear();
    }
}
