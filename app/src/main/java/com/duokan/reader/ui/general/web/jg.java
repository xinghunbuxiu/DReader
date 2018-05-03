package com.duokan.reader.ui.general.web;

import com.duokan.core.app.AppContext;
import com.duokan.core.ui.AnimUtils;
import com.duokan.reader.ui.C0435s;
import java.util.concurrent.Callable;

class jg implements Callable<Integer> {
    /* renamed from: a */
    final /* synthetic */ ci f8044a;

    jg(ci ciVar) {
        this.f8044a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11216a();
    }

    /* renamed from: a */
    public Integer m11216a() {
        int round;
        C0435s c0435s = (C0435s) AppContext.getAppContext(this.f8044a.f7581b.getContext()).queryFeature(C0435s.class);
        if (c0435s != null) {
            round = Math.round(AnimUtils.m1929b(this.f8044a.f7581b.getContext(), c0435s.getTheme().getPageHeaderPaddingTop()));
        } else {
            round = 0;
        }
        return Integer.valueOf(round);
    }
}
