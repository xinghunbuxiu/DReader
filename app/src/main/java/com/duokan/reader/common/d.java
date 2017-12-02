package com.duokan.reader.common;

import android.content.Intent;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.sys.t;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;
import com.duokan.reader.domain.cloud.push.b;

import java.util.LinkedList;

public class d implements ah, h, MessageWakeupListener {
    private static final ai a = new ai();
    private final DkApp b;
    private final boolean c;
    private final ReaderEnv d;
    private final i e;
    private final LinkedList f = new LinkedList();
    private final Intent g;
    private int h = 0;
    private long i = 0;

    private d(DkApp dkApp, boolean z, ReaderEnv readerEnv, b bVar, i iVar) {
        this.b = dkApp;
        this.c = z;
        this.d = readerEnv;
        this.e = iVar;
        this.g = new Intent(this.b, DkApp.get().getReaderActivityClass());
        this.g.setAction("com.duokan.reader.actions.SHOW_FEEDBACK");
        this.g.addFlags(268468224);
        bVar.a(MessageSubType.BBS_FEEDBACK, (MessageWakeupListener) this);
        this.b.runPreReady(new e(this));
    }

    public static void a(DkApp dkApp, boolean z, ReaderEnv readerEnv, b bVar, i iVar) {
        a.a(new d(dkApp, z, readerEnv, bVar, iVar));
    }

    public static d a() {
        return (d) a.a();
    }

    public int b() {
        return this.h;
    }

    public void c() {
        a(0);
    }

    public void a(h hVar) {
        this.f.add(hVar);
    }

    public void b(h hVar) {
        this.f.remove(hVar);
    }

    public void a(MessageSubType messageSubType, Object obj, boolean z) {
        if (z) {
            this.b.startActivity(this.g);
            return;
        }
        this.i = System.currentTimeMillis();
        d();
    }

    public void a(a aVar) {
    }

    public void b(a aVar) {
        d();
    }

    public void c(a aVar) {
        a(0);
    }

    public void d(a aVar) {
    }

    private void d() {
        if (i.f().a(MiAccount.class)) {
            a((MiAccount) this.e.b(MiAccount.class));
        }
    }

    private void a(int i) {
        if (this.h != i) {
            this.h = i;
            this.d.setPrefInt(PrivatePref.PERSONAL, "feedback_count", this.h);
            this.d.commitPrefs();
            e();
        }
    }

    private void e() {
        t.a(new f(this));
    }

    private void a(MiAccount miAccount) {
        new g(this, miAccount).open();
    }
}
