package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ui.general.hd;

class bv implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7650a;

    bv(StorePageController storePageController) {
        this.f7650a = storePageController;
    }

    public void onClick(View view) {
        hd hdVar = (hd) this.f7650a.getContext().queryFeature(hd.class);
        if (hdVar != null) {
            hdVar.mo2548a("", "", "");
        }
    }
}
