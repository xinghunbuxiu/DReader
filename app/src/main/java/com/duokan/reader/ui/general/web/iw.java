package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.general.jq;

import java.util.concurrent.Callable;

class iw implements Callable {
    final /* synthetic */ iv a;

    iw(iv ivVar) {
        this.a = ivVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public jq a() {
        jq jqVar = new jq(this.a.b.b.getContext());
        jqVar.show();
        return jqVar;
    }
}
