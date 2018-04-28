package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.iq;
import java.util.ArrayList;
import java.util.List;

class hq implements iq {
    /* renamed from: a */
    final /* synthetic */ hp f6566a;

    hq(hp hpVar) {
        this.f6566a = hpVar;
    }

    /* renamed from: a */
    public boolean mo1688a(String str) {
        if (this.f6566a.f6565b.f6562b.f6555b.m9446g()) {
            List arrayList = new ArrayList();
            arrayList.add(this.f6566a.f6565b.f6562b.f6554a);
            this.f6566a.f6565b.f6562b.f6555b.m9439a(arrayList, ai.m3980a().m3932h(str));
            this.f6566a.f6565b.f6562b.f6555b.m9447h();
        }
        return true;
    }
}
