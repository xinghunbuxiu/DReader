package com.duokan.core.sys;

import android.text.TextUtils;

import com.duokan.core.c.b;

class ad implements b {
    final /* synthetic */ aa a;
    private final ae b;

    public ad(aa aaVar, ae aeVar) {
        this.a = aaVar;
        this.b = aeVar;
    }

    public boolean a(ae aeVar) {
        if (this.b.c == aeVar.c) {
            return true;
        }
        if (TextUtils.isEmpty(this.b.a) || TextUtils.isEmpty(aeVar.a)) {
            return false;
        }
        return this.b.a.equals(aeVar.a);
    }
}
