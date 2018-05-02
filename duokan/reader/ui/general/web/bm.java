package com.duokan.reader.ui.general.web;

import android.net.Uri;
import android.text.TextUtils;

import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jg;

class bm implements jg {
    final /* synthetic */ StorePageController a;

    bm(StorePageController storePageController) {
        this.a = storePageController;
    }

    public boolean a(String str) {
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(str)) {
            p.i().k("");
        } else {
            CharSequence charSequence;
            if (str.startsWith("http://")) {
                this.a.loadUrl(str);
            } else {
                charSequence = "http://" + parse.getHost() + (parse.getPort() == -1 ? "" : ":" + parse.getPort());
                p.i().k(charSequence);
            }
            be.a(this.a.getContext(), charSequence, 1).show();
        }
        return true;
    }
}
