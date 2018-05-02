package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.general.jq;

class js implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ jr e;

    js(jr jrVar, boolean z, String str, boolean z2, boolean z3) {
        this.e = jrVar;
        this.a = z;
        this.b = str;
        this.c = z2;
        this.d = z3;
    }

    public void a() {
        if (this.a) {
            if (this.e.b.pageController.mProgressDialog == null) {
                this.e.b.pageController.mProgressDialog = new jq(this.e.b.pageController.getContext());
            }
            this.e.b.pageController.mProgressDialog.a(this.b);
            this.e.b.pageController.mProgressDialog.a(true);
            this.e.b.pageController.mProgressDialog.setCancelOnBack(this.c);
            this.e.b.pageController.mProgressDialog.setCancelOnTouchOutside(this.c);
            if (this.d) {
                this.e.b.pageController.mProgressDialog.a(0);
            } else {
                this.e.b.pageController.mProgressDialog.show();
            }
        } else if (this.e.b.pageController.mProgressDialog != null) {
            this.e.b.pageController.mProgressDialog.dismiss();
        }
    }
}
