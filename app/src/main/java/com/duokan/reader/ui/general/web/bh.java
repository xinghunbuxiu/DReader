package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.ui.general.be;

class bh implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7627a;

    bh(StorePageController storePageController) {
        this.f7627a = storePageController;
    }

    public void onClick(View view) {
        if (C0559f.m2476b().m2486e()) {
            this.f7627a.refresh();
        } else {
            be.m10286a(this.f7627a.getContext(), C0258j.general__shared__network_error, 1).show();
        }
    }
}
