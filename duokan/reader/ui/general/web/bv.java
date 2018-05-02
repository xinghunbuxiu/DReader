package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ui.general.ho;

class bv implements OnClickListener {
    final /* synthetic */ StorePageController a;

    bv(StorePageController storePageController) {
        this.a = storePageController;
    }

    public void onClick(View view) {
        ho hoVar = (ho) this.a.getContext().queryFeature(ho.class);
        if (hoVar != null) {
            hoVar.a("", "", "");
        }
    }
}
