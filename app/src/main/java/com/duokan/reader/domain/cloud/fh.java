package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;

class fh implements u {
    final /* synthetic */ fm a;
    final /* synthetic */ boolean b;
    final /* synthetic */ DkUserReadingNotesManager c;

    fh(DkUserReadingNotesManager dkUserReadingNotesManager, fm fmVar, boolean z) {
        this.c = dkUserReadingNotesManager;
        this.a = fmVar;
        this.b = z;
    }

    public void onQueryAccountOk(a aVar) {
        this.c.d = new ab(aVar);
        new fi(this, this.c.d).open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.a.a(str);
    }
}
