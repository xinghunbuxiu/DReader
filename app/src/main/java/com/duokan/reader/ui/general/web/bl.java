package com.duokan.reader.ui.general.web;

import android.net.Uri;
import android.text.TextUtils;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.iq;

class bl implements iq {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7633a;

    bl(StorePageController storePageController) {
        this.f7633a = storePageController;
    }

    /* renamed from: a */
    public boolean mo1688a(String str) {
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(str)) {
            C0641o.m2934i().m2983k("");
        } else {
            CharSequence str2;
            if (str2.startsWith("http://")) {
                this.f7633a.loadUrl(str2);
            } else {
                str2 = "http://" + parse.getHost() + (parse.getPort() == -1 ? "" : ":" + parse.getPort());
                C0641o.m2934i().m2983k(str2);
            }
            be.m10287a(this.f7633a.getContext(), str2, 1).show();
        }
        return true;
    }
}
