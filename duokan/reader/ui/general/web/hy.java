package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.ui.account.as;
import com.duokan.reader.ui.account.bv;

class hy implements as {
    final /* synthetic */ hx a;

    hy(hx hxVar) {
        this.a = hxVar;
    }

    public void onChoiced(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.g.b.pageController.mShareController = new bv(this.a.g.b.pageController.getContext(), false, str, this.a.a, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, null);
            this.a.g.b.pageController.addSubController(this.a.g.b.pageController.mShareController);
            this.a.g.b.pageController.activate(this.a.g.b.pageController.mShareController);
        }
    }
}
