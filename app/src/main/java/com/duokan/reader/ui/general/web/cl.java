package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.general.ja;

class cl implements as {
    /* renamed from: a */
    final /* synthetic */ boolean f7676a;
    /* renamed from: b */
    final /* synthetic */ String f7677b;
    /* renamed from: c */
    final /* synthetic */ boolean f7678c;
    /* renamed from: d */
    final /* synthetic */ boolean f7679d;
    /* renamed from: e */
    final /* synthetic */ ck f7680e;

    cl(ck ckVar, boolean z, String str, boolean z2, boolean z3) {
        this.f7680e = ckVar;
        this.f7676a = z;
        this.f7677b = str;
        this.f7678c = z2;
        this.f7679d = z3;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7676a) {
            if (this.f7680e.f7675b.f7581b.mProgressDialog == null) {
                this.f7680e.f7675b.f7581b.mProgressDialog = new ja(this.f7680e.f7675b.f7581b.getContext());
            }
            this.f7680e.f7675b.f7581b.mProgressDialog.m10843a(this.f7677b);
            this.f7680e.f7675b.f7581b.mProgressDialog.m10844a(true);
            this.f7680e.f7675b.f7581b.mProgressDialog.setCancelOnBack(this.f7678c);
            this.f7680e.f7675b.f7581b.mProgressDialog.setCancelOnTouchOutside(this.f7678c);
            if (this.f7679d) {
                this.f7680e.f7675b.f7581b.mProgressDialog.m10842a(0);
            } else {
                this.f7680e.f7675b.f7581b.mProgressDialog.show();
            }
        } else if (this.f7680e.f7675b.f7581b.mProgressDialog != null) {
            this.f7680e.f7675b.f7581b.mProgressDialog.dismiss();
        }
    }
}
