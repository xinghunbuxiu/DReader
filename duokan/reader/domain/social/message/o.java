package com.duokan.reader.domain.social.message;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener;

public class o implements ah, MessageWakeupListener {
    private static final ai h = new ai();
    private long a = 0;
    private final i b;
    private final int[] c;
    private long d = 600000;
    private final x e = new x();
    private ab f;
    private String g = "";

    private o(Context context, i iVar, int[] iArr) {
        this.b = iVar;
        this.b.add(new p(this));
        this.c = iArr;
        this.f = new ab(this.b.b(PersonalAccount.class));
        if (!this.f.a()) {
            this.g = ReaderEnv.get().getPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.f.c, "");
        }
    }

    public static void a(Context context, i iVar, int[] iArr) {
        h.a(new o(context, iVar, iArr));
    }

    public static o a() {
        return (o) h.a();
    }

    public void a(z zVar) {
        this.e.a(zVar);
    }

    public void a(MessageSubType messageSubType, Object obj, boolean z) {
        if (MessageSubType.MESSAGE_LOOPER == messageSubType) {
            this.a = System.currentTimeMillis();
            c();
        }
    }

    public void b() {
        c();
        DkApp.get().runWhenAppReady(new r(this));
    }

    public void a(boolean z, ab abVar) {
        if (z || !this.f.a()) {
            this.b.a(PersonalAccount.class, new s(this, abVar, z));
        } else {
            abVar.a(false, false);
        }
    }

    private void c() {
        a(false, new w(this));
    }
}
