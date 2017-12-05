package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.ui.account.as;
import com.duokan.reader.ui.account.bv;
import com.duokan.reader.ui.account.ce;
import com.duokan.reader.ui.account.cf;

class hv implements as {
    final /* synthetic */ ce a;
    final /* synthetic */ ht b;

    hv(ht htVar, ce ceVar) {
        this.b = htVar;
        this.a = ceVar;
    }

    public void onChoiced(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.b.b;
            String str3 = this.b.c;
            String str4 = this.b.d;
            if (str.equals("wenxin_friends")) {
                str2 = this.b.e;
                str3 = this.b.f;
                str4 = this.b.g;
            }
            if (TextUtils.isEmpty(this.b.h)) {
                this.b.m.b.pageController.mShareController = new bv(this.b.m.b.pageController.getContext(), false, str, this.b.i, str2, str3, str4, this.b.j, this.b.k, this.a);
            } else {
                if (str.equals("sina")) {
                    str3 = this.b.l;
                    str4 = this.b.h;
                }
                this.b.m.b.pageController.mShareController = new cf(this.b.m.b.pageController.getContext(), str, this.b.i, str2, str3, str4, this.a);
            }
            this.b.m.b.pageController.addSubController(this.b.m.b.pageController.mShareController);
            this.b.m.b.pageController.activate(this.b.m.b.pageController.mShareController);
        }
    }
}
