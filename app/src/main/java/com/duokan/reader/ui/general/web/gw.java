package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class gw implements as {
    final /* synthetic */ gv a;

    gw(gv gvVar) {
        this.a = gvVar;
    }

    public void a() {
        if (PersonalPrefs.a().k()[PersonalPrefs.a().l() - 1]) {
            kp.a().h();
        }
    }
}
