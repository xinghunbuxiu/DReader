package com.duokan.reader.ui.reading;

import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.common.classc;

import java.util.Collections;
import java.util.List;

class zu implements Runnable {
    final /* synthetic */ zt a;

    zu(zt ztVar) {
        this.a = ztVar;
    }

    public void run() {
        for (String str : (List) TaskHandler.getTaskHandler(new zv(this))) {
            if (this.a.b.u(str) || !((Boolean) TaskHandler.getTaskHandler(new zw(this, str))).booleanValue()) {
                for (String str2 : classc.ConnectivityReceiver.b().d() ? this.a.b.v(str2) : Collections.emptyList()) {
                    if (!this.a.b.w(str2) && ((Boolean) TaskHandler.getTaskHandler(new zy(this, str2))).booleanValue()) {
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
