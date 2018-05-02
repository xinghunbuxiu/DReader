package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.duokan.reader.ui.general.web.t */
class C1374t implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ int f8175a;
    /* renamed from: b */
    final /* synthetic */ SearchController f8176b;

    C1374t(SearchController searchController, int i) {
        this.f8176b = searchController;
        this.f8175a = i;
    }

    public void onClick(View view) {
        this.f8176b.removeHistory(this.f8175a);
    }
}
