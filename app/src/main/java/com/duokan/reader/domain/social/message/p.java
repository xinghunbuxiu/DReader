package com.duokan.reader.domain.social.message;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;

class p implements h {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public void a(a aVar) {
        this.a.f = new ab(this.a.b.b(PersonalAccount.class));
        this.a.g = ReaderEnv.get().getPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.a.f.c, "");
    }

    public void b(a aVar) {
        this.a.a(false, new q(this));
    }

    public void c(a aVar) {
        this.a.g = "";
        if (!(this.a.f == null || this.a.f.a())) {
            ReaderEnv.get().setPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.a.f.c, this.a.g);
        }
        this.a.f = new ab(null);
    }

    public void d(a aVar) {
    }
}
