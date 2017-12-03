package com.duokan.reader.ui.general;

import com.duokan.core.ui.UTools;

import java.util.concurrent.Callable;

class gv implements Callable {
    final /* synthetic */ gu a;

    gv(gu guVar) {
        this.a = guVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        if (this.a.b.a.d.getMeasuredHeight() != this.a.b.f) {
            this.a.b.a.h.setLevel(Math.round(((1.0f * ((float) this.a.b.a.d.getMeasuredHeight())) / ((float) this.a.b.a.b.getMeasuredHeight())) * 10000.0f));
            this.a.b.f = this.a.b.a.d.getMeasuredHeight();
        }
        UTools.addAnimation(this.a.b.a.d, (Callable) this);
        return Boolean.valueOf(true);
    }
}
