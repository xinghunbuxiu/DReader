package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.ui.account.ae;
import com.duokan.reader.ui.account.bl;
import com.duokan.reader.ui.account.bu;
import com.duokan.reader.ui.account.bv;

class id implements ae {
    /* renamed from: a */
    final /* synthetic */ bu f7979a;
    /* renamed from: b */
    final /* synthetic */ ib f7980b;

    id(ib ibVar, bu buVar) {
        this.f7980b = ibVar;
        this.f7979a = buVar;
    }

    public void onChoiced(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f7980b.f7966b;
            String str3 = this.f7980b.f7967c;
            String str4 = this.f7980b.f7968d;
            if (str.equals("weixin_timeline")) {
                str2 = this.f7980b.f7969e;
                str3 = this.f7980b.f7970f;
                str4 = this.f7980b.f7971g;
            }
            if (TextUtils.isEmpty(this.f7980b.f7972h)) {
                this.f7980b.f7977m.f7964b.f7581b.mShareController = new bl(this.f7980b.f7977m.f7964b.f7581b.getContext(), false, str, this.f7980b.f7973i, str2, str3, str4, this.f7980b.f7974j, this.f7980b.f7975k, this.f7979a);
            } else {
                if (str.equals("weibo")) {
                    str3 = this.f7980b.f7976l;
                    str4 = this.f7980b.f7972h;
                }
                this.f7980b.f7977m.f7964b.f7581b.mShareController = new bv(this.f7980b.f7977m.f7964b.f7581b.getContext(), str, this.f7980b.f7973i, str2, str3, str4, this.f7979a);
            }
            this.f7980b.f7977m.f7964b.f7581b.addSubController(this.f7980b.f7977m.f7964b.f7581b.mShareController);
            this.f7980b.f7977m.f7964b.f7581b.activate(this.f7980b.f7977m.f7964b.f7581b.mShareController);
        }
    }
}
