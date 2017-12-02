package com.duokan.reader.ui.surfing;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.gf;
import com.duokan.reader.domain.cloud.gn;
import com.duokan.reader.ui.b.d;

class i implements Runnable {
    final /* synthetic */ f a;

    i(f fVar) {
        this.a = fVar;
    }

    public void run() {
        ai.a().b(this.a);
        d.c().b(this.a);
        gf.a().b(this.a);
        gn.a().b(this.a);
        PersonalPrefs.a().b(this.a);
        PersonalPrefs.a().b(this.a);
        PersonalPrefs.a().b(this.a);
        this.a.s.removePrimaryClipChangedListener(this.a);
    }
}
