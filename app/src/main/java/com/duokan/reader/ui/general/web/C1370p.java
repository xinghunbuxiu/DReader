package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.ui.general.web.p */
class C1370p implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ SearchController f8170a;

    C1370p(SearchController searchController) {
        this.f8170a = searchController;
    }

    public void onClick(View view) {
        if (C0559f.m2476b().m2486e()) {
            this.f8170a.refresh();
        } else {
            be.m10286a(this.f8170a.getContext(), C0258j.general__shared__network_error, 1).show();
        }
    }
}
