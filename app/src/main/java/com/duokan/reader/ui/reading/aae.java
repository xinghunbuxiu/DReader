package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ag;
import java.util.Map;

class aae implements ag<Map<String, Integer>> {
    /* renamed from: a */
    final /* synthetic */ aad f9324a;

    aae(aad aad) {
        this.f9324a = aad;
    }

    public /* synthetic */ void run(Object obj) {
        m12901a((Map) obj);
    }

    /* renamed from: a */
    public void m12901a(Map<String, Integer> map) {
        UThread.post(this.f9324a.f9323a.f9315c);
    }
}
