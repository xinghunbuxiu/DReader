package com.duokan.reader.ui.general.web;

import com.duokan.common.tools;
import com.duokan.core.sys.as;

class eq implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    eq(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        tools.startActivity(this.b.b.getContext(), this.a);
    }
}
