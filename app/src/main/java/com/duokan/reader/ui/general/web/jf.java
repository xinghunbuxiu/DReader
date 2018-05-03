package com.duokan.reader.ui.general.web;

import com.duokan.core.app.AppContext;
import com.duokan.core.ui.AnimUtils;
import com.duokan.reader.ui.C0435s;
import java.util.concurrent.Callable;

class jf implements Callable<Integer> {
    /* renamed from: a */
    final /* synthetic */ ci f8043a;

    jf(ci ciVar) {
        this.f8043a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11215a();
    }

    /* renamed from: a */
    public Integer m11215a() {
        int round;
        C0435s c0435s = (C0435s) AppContext.getAppContext(this.f8043a.f7581b.getContext()).queryFeature(C0435s.class);
        if (c0435s != null) {
            round = Math.round(AnimUtils.m1929b(this.f8043a.f7581b.getContext(), c0435s.getTheme().getPageHeaderHeight()));
        } else {
            round = 0;
        }
        return Integer.valueOf(round);
    }
}
