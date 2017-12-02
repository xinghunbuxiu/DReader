package com.duokan.reader.domain.social.message;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;

class u implements aa {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public void a(boolean z) {
        this.a.b.a.a(z, false);
        this.a.b.c.g = this.a.e;
        ReaderEnv.get().setPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.a.a.c, this.a.b.c.g);
    }
}
