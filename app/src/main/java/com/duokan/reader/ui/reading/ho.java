package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.epub.av;
import java.util.Arrays;
import java.util.Map;

class ho implements ag<Map<av, Integer>> {
    /* renamed from: a */
    final /* synthetic */ hl f10344a;

    ho(hl hlVar) {
        this.f10344a = hlVar;
    }

    public /* synthetic */ void run(Object obj) {
        m14365a((Map) obj);
    }

    /* renamed from: a */
    public void m14365a(Map<av, Integer> map) {
        if (this.f10344a.f10341a == this) {
            if (this.f10344a.q || this.f10344a.f10340S.isEmpty()) {
                this.f10344a.f10341a = null;
                return;
            }
            av avVar = (av) this.f10344a.f10340S.poll();
            this.f10344a.m14337b(Arrays.asList(new av[]{avVar}), this);
        }
    }
}
