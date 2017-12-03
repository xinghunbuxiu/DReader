package com.duokan.reader.ui.b;

import android.content.Context;

import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.h;
import com.duokan.reader.domain.cloud.push.a;
import com.duokan.reader.domain.cloud.push.b;
import com.duokan.reader.domain.social.message.az;

import java.util.Iterator;
import java.util.LinkedList;

public class d implements ah, IActivityRunStatusChanged, h, a, az {
    static final /* synthetic */ boolean a = (!d.class.desiredAssertionStatus());
    private static final ai b = new ai();
    private final Context c;
    private final b d;
    private final com.duokan.reader.domain.social.message.h e;
    private final com.duokan.reader.common.d f;
    private final LinkedList g = new LinkedList();
    private int h = 0;

    private d(Context context, b bVar, com.duokan.reader.domain.social.message.h hVar, com.duokan.reader.common.d dVar) {
        this.c = context;
        this.d = bVar;
        this.e = hVar;
        this.f = dVar;
        DkApp.get().runPreReady(new e(this));
    }

    public void a() {
        if (DkApp.get().isReady()) {
            h();
        }
    }

    public void b() {
        if (DkApp.get().isReady()) {
            h();
        }
    }

    public void a(int i) {
        if (DkApp.get().isReady()) {
            h();
        }
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
    }

    public static void a(Context context, b bVar, com.duokan.reader.domain.social.message.h hVar, com.duokan.reader.common.d dVar) {
        b.a(new d(context, bVar, hVar, dVar));
    }

    public static d c() {
        return (d) b.a();
    }

    public void a(f fVar) {
        if (a || fVar != null) {
            fVar.b(this.h);
            this.g.add(fVar);
            return;
        }
        throw new AssertionError();
    }

    public void b(f fVar) {
        if (a || fVar != null) {
            this.g.remove(fVar);
            return;
        }
        throw new AssertionError();
    }

    public int d() {
        return this.h;
    }

    public int e() {
        return this.d.c() + this.e.b();
    }

    private void f() {
        this.h = g();
        b(this.h);
    }

    private int g() {
        return (this.d.c() + this.e.b()) + this.f.b();
    }

    private void h() {
        f();
    }

    private void b(int i) {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((f) it.next()).b(i);
        }
    }
}
