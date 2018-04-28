package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.epub.av;
import java.util.Map;

class lb implements ag<Map<av, Integer>> {
    /* renamed from: a */
    final /* synthetic */ av f10560a;
    /* renamed from: b */
    final /* synthetic */ la f10561b;

    lb(la laVar, av avVar) {
        this.f10561b = laVar;
        this.f10560a = avVar;
    }

    public /* synthetic */ void run(Object obj) {
        m14610a((Map) obj);
    }

    /* renamed from: a */
    public void m14610a(Map<av, Integer> map) {
        this.f10561b.f10554i = false;
        this.f10561b.f10555j = false;
        if (this.f10561b.f10559n == this.f10560a) {
            this.f10561b.f10559n = null;
        }
        if (this.f10561b.f10547b) {
            this.f10561b.m14598c();
        } else {
            this.f10561b.m14595b();
        }
    }
}
