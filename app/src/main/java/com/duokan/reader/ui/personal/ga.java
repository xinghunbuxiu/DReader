package com.duokan.reader.ui.personal;

import com.duokan.core.app.e;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.PersonalPrefs;

import java.util.concurrent.Callable;

class ga implements Callable {
    final /* synthetic */ fz a;

    ga(fz fzVar) {
        this.a = fzVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public e a() {
        PersonalPrefs.a().g(false);
        if (i.f().c() == null || i.f().c().i()) {
            return new kg(this.a.a.getContext());
        }
        return new ae(this.a.a.getContext());
    }
}
