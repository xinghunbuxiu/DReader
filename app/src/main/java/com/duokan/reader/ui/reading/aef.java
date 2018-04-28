package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;

class aef implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aee f9576a;

    aef(aee aee) {
        this.f9576a = aee;
    }

    public void run() {
        if (!this.f9576a.f9575e) {
            C0328a.m757c().m752c(LogLevel.WARNING, "tts", "Task takes too long.");
        }
    }
}
