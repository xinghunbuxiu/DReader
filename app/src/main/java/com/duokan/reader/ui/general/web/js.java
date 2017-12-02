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
            if (this.e.b.b.mProgressDialog == null) {
                this.e.b.b.mProgressDialog = new jq(this.e.b.b.getContext());
            }
            this.e.b.b.mProgressDialog.a(this.b);
            this.e.b.b.mProgressDialog.a(true);
            this.e.b.b.mProgressDialog.setCancelOnBack(this.c);
            this.e.b.b.mProgressDialog.setCancelOnTouchOutside(this.c);
            if (this.d) {
                this.e.b.b.mProgressDialog.a(0);
            } else {
                this.e.b.b.mProgressDialog.show();
            }
        } else if (this.e.b.b.mProgressDialog != null) {
            this.e.b.b.mProgressDialog.dismiss();
        }
    }
}
