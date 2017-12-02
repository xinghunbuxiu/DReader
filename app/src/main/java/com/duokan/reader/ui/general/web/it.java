package com.duokan.reader.ui.general.web;

import com.duokan.core.app.x;
import com.duokan.core.ui.dv;
import com.duokan.reader.ui.s;

import java.util.concurrent.Callable;

class it implements Callable {
    final /* synthetic */ cg a;

    it(cg cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Integer a() {
        int round;
        s sVar = (s) x.a(this.a.b.getContext()).queryFeature(s.class);
        if (sVar != null) {
            round = Math.round(dv.b(this.a.b.getContext(), sVar.getTheme().getPageHeaderPaddingTop()));
        } else {
            round = 0;
        }
        return Integer.valueOf(round);
    }
}
