package com.duokan.reader.ui.surfing;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.gf;
import com.duokan.reader.domain.cloud.gn;
import com.duokan.reader.ui.b.d;

class h implements Runnable {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public void run() {
        ai.a().a(this.a);
        d.c().a(this.a);
        gf.a().a(this.a);
        gn.a().a(this.a);
        PersonalPrefs.a().a(this.a);
        PersonalPrefs.a().a(this.a);
        PersonalPrefs.a().a(this.a);
        this.a.s.addPrimaryClipChangedListener(this.a);
    }
}
