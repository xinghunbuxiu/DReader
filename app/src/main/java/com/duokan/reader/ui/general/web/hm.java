package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.general.hd;

class hm implements as {
    /* renamed from: a */
    final /* synthetic */ String f7934a;
    /* renamed from: b */
    final /* synthetic */ ci f7935b;

    hm(ci ciVar, String str) {
        this.f7935b = ciVar;
        this.f7934a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        hd hdVar = (hd) this.f7935b.f7581b.getContext().queryFeature(hd.class);
        if (hdVar != null) {
            hdVar.mo2548a("", this.f7934a, "");
        }
    }
}
