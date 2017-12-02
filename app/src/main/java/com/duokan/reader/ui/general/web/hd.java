package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.general.ho;

class hd implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    hd(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        ho hoVar = (ho) this.b.b.getContext().queryFeature(ho.class);
        if (hoVar != null) {
            hoVar.a("", this.a, "");
        }
    }
}
