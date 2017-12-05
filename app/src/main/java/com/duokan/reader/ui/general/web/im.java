package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.general.jq;

import java.util.concurrent.Callable;

class im implements Callable {
    final /* synthetic */ il a;

    im(il ilVar) {
        this.a = ilVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public jq a() {
        jq jqVar = new jq(this.a.b.pageController.getContext());
        jqVar.show();
        return jqVar;
    }
}
