package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.c.j;
import com.duokan.reader.common.c.f;
import com.duokan.reader.ui.general.be;

class p implements OnClickListener {
    final /* synthetic */ SearchController a;

    p(SearchController searchController) {
        this.a = searchController;
    }

    public void onClick(View view) {
        if (f.b().e()) {
            this.a.refresh();
        } else {
            be.a(this.a.getContext(), j.general__shared__network_error, 1).show();
        }
    }
}
