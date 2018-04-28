package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.ak;
import java.util.Comparator;

class ft implements Comparator<ak> {
    /* renamed from: a */
    final /* synthetic */ fs f10185a;

    ft(fs fsVar) {
        this.f10185a = fsVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m14144a((ak) obj, (ak) obj2);
    }

    /* renamed from: a */
    public int m14144a(ak akVar, ak akVar2) {
        if (akVar.mo1188a((C0896a) akVar2)) {
            return -1;
        }
        if (akVar.mo1190c(akVar2)) {
            return 1;
        }
        return 0;
    }
}
