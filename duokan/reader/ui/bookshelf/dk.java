package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.personal.ae;
import com.duokan.reader.ui.personal.kg;

class dk implements u {
    final /* synthetic */ dj a;

    dk(dj djVar) {
        this.a = djVar;
    }

    public void onQueryAccountOk(a aVar) {
        ActivatedController kgVar;
        if (i.f().c() == null || i.f().c().i()) {
            kgVar = new kg(this.a.a.a.getContext());
        } else {
            kgVar = new ae(this.a.a.a.getContext());
        }
        this.a.a.a.a.pushPageSmoothly(kgVar, null);
    }

    public void onQueryAccountError(a aVar, String str) {
    }
}
