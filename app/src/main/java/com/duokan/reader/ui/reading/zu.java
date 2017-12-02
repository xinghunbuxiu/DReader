package com.duokan.reader.ui.reading;

import com.duokan.core.sys.t;
import com.duokan.reader.common.c.f;

import java.util.Collections;
import java.util.List;

class zu implements Runnable {
    final /* synthetic */ zt a;

    zu(zt ztVar) {
        this.a = ztVar;
    }

    public void run() {
        for (String str : (List) t.a(new zv(this))) {
            if (this.a.b.u(str) || !((Boolean) t.a(new zw(this, str))).booleanValue()) {
                for (String str2 : f.b().d() ? this.a.b.v(str2) : Collections.emptyList()) {
                    if (!this.a.b.w(str2) && ((Boolean) t.a(new zy(this, str2))).booleanValue()) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        this.a.c.b = false;
    }
}
