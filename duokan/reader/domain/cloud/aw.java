package com.duokan.reader.domain.cloud;

import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class aw implements ah, av {
    private static final ai a = new ai();
    private final Context b;
    private final i c;
    private final h d;
    private final LinkedList e = new LinkedList();
    private ab f;
    private int g = 0;

    private aw(Context context, i iVar) {
        this.b = context;
        this.c = iVar;
        this.d = new ax(this);
        this.f = new ab(this.c.c());
        this.g = PersonalPrefs.a().i();
        DkApp.get().runPreReady(new ay(this));
    }

    public static void a(Context context, i iVar) {
        a.a(new aw(context, iVar));
    }

    public static aw a() {
        return (aw) a.a();
    }

    public void a(bc bcVar) {
        this.e.add(bcVar);
    }

    public void b(bc bcVar) {
        this.e.remove(bcVar);
    }

    public int b() {
        return this.g;
    }

    public void a(a aVar) {
        a(false, false, 0, 0);
    }

    public void a(SharedKey sharedKey, Serializable serializable) {
        a(c.a);
    }

    public void a(SharedKey sharedKey) {
        a(c.a);
    }

    private void a(boolean z, boolean z2, int i, int i2) {
        if (z || !this.f.b()) {
            a(z, i, i2);
        }
    }

    private void a(boolean z, int i, int i2) {
        this.c.a(new az(this, i, i2, z));
    }

    private void c() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((bc) it.next()).c();
        }
    }
}
