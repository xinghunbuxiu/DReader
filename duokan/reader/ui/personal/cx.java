package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.push.q;
import com.duokan.reader.domain.cloud.push.r;
import com.duokan.reader.ui.general.expandable.ViewMode;

class cx implements r {
    final /* synthetic */ int a;
    final /* synthetic */ long b;
    final /* synthetic */ ct c;

    cx(ct ctVar, int i, long j) {
        this.c = ctVar;
        this.a = i;
        this.b = j;
    }

    public void a(q[] qVarArr, boolean z) {
        if (this.a == 0 && this.b == 0) {
            this.c.a.b.clear();
        }
        for (Object add : qVarArr) {
            this.c.a.b.add(add);
        }
        if (this.c.getViewMode() == ViewMode.Edit && this.c.j != null) {
            this.c.j.c();
        }
        this.c.getAdapter().a(z);
    }
}
