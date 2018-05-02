package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.ak;
import com.duokan.reader.ui.general.an;

class ek implements an {
    final /* synthetic */ ak a;
    final /* synthetic */ c b;
    final /* synthetic */ ej c;

    ek(ej ejVar, ak akVar, c cVar) {
        this.c = ejVar;
        this.a = akVar;
        this.b = cVar;
    }

    public void a(int i) {
        this.a.close();
        if (i == 0) {
            ai.a().a(this.b, true);
            if (this.c.a != null) {
                this.c.a.a();
            }
            if (this.a.isChecked(0)) {
                this.c.a();
            }
        }
    }
}
