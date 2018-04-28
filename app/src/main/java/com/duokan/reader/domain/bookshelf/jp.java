package com.duokan.reader.domain.bookshelf;

import android.content.Context;
import com.duokan.reader.common.async.work.C0521a;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.C0537r;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.domain.micloud.C0812t;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.domain.micloud.C1074o;
import com.duokan.reader.domain.micloud.ba;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.micloud.bl;
import java.util.Collection;
import java.util.Iterator;

class jp implements IAsyncWorkProgressListener<bl>, C0812t {
    /* renamed from: a */
    public final String f3404a;
    /* renamed from: b */
    public final ba f3405b;
    /* renamed from: c */
    public final jn f3406c = new jn();
    /* renamed from: d */
    public boolean f3407d = false;
    /* renamed from: e */
    final /* synthetic */ it f3408e;
    /* renamed from: f */
    private final C0537r f3409f = new jq(this);
    /* renamed from: g */
    private final IAsyncWorkProgressListener<C1068i> f3410g = new jr(this);

    public jp(it itVar, Context context, String str) {
        this.f3408e = itVar;
        this.f3404a = str;
        this.f3405b = ba.m8105a(context, this.f3404a, "duokan");
        this.f3405b.m8115c().m8261a((C0812t) this);
        this.f3405b.m8115c().m2357a((IAsyncWorkProgressListener) this);
        this.f3405b.m8112a().m2361a(this.f3409f);
        this.f3405b.m8112a().m2357a(this.f3410g);
        it.m4700b(new js(this, itVar));
    }

    /* renamed from: a */
    public void m4746a() {
        this.f3405b.m8116d();
        this.f3405b.m8115c().m8264b((C0812t) this);
        this.f3405b.m8115c().m2364b((IAsyncWorkProgressListener) this);
        this.f3405b.m8112a().m2366b(this.f3409f);
        this.f3405b.m8112a().m2364b(this.f3410g);
    }

    /* renamed from: b */
    public void mo1111b(C1074o c1074o, bi biVar) {
        try {
            it.m4700b(new jt(this, biVar)).get();
        } catch (Throwable th) {
        }
        Iterator it = this.f3408e.f3359c.iterator();
        while (it.hasNext()) {
            ((C0812t) it.next()).mo1111b(c1074o, biVar);
        }
    }

    /* renamed from: a */
    public void mo1109a(C1074o c1074o, bi biVar) {
        try {
            it.m4700b(new ju(this, biVar)).get();
        } catch (Throwable th) {
        }
        Iterator it = this.f3408e.f3359c.iterator();
        while (it.hasNext()) {
            ((C0812t) it.next()).mo1109a(c1074o, biVar);
        }
    }

    /* renamed from: a */
    public void mo1108a(C1074o c1074o) {
        try {
            it.m4700b(new jv(this)).get();
        } catch (Throwable th) {
        }
        Iterator it = this.f3408e.f3359c.iterator();
        while (it.hasNext()) {
            ((C0812t) it.next()).mo1108a(c1074o);
        }
    }

    /* renamed from: b */
    public void mo1110b(C1074o c1074o) {
        try {
            it.m4700b(new jw(this)).get();
        } catch (Throwable th) {
        }
        Iterator it = this.f3408e.f3359c.iterator();
        while (it.hasNext()) {
            ((C0812t) it.next()).mo1110b(c1074o);
        }
    }

    /* renamed from: a */
    public void m4748a(bl blVar) {
        Iterator it = this.f3408e.f3360d.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo745a(blVar);
        }
    }

    /* renamed from: b */
    public void m4752b(bl blVar) {
        Iterator it = this.f3408e.f3360d.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo746b(blVar);
        }
    }

    /* renamed from: c */
    public void m4756c(bl blVar) {
        Iterator it = this.f3408e.f3360d.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo747c(blVar);
        }
    }

    /* renamed from: d */
    public void m4758d(bl blVar) {
        Iterator it = this.f3408e.f3360d.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo748d(blVar);
        }
    }

    /* renamed from: e */
    public void m4760e(bl blVar) {
        Iterator it = this.f3408e.f3360d.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo749e(blVar);
        }
    }

    /* renamed from: f */
    public void m4762f(bl blVar) {
        Iterator it = this.f3408e.f3360d.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo750f(blVar);
        }
    }

    /* renamed from: a */
    public CheckErrorResult m4745a(bl blVar, C0525e c0525e) {
        CheckErrorResult checkErrorResult = CheckErrorResult.Ignored;
        Iterator it = this.f3408e.f3360d.iterator();
        CheckErrorResult checkErrorResult2 = checkErrorResult;
        while (it.hasNext()) {
            checkErrorResult2 = C0521a.m2253a(checkErrorResult2, ((IAsyncWorkProgressListener) it.next()).mo744a(blVar, c0525e));
        }
        return checkErrorResult2;
    }

    /* renamed from: g */
    public void m4764g(bl blVar) {
        Iterator it = this.f3408e.f3360d.iterator();
        while (it.hasNext()) {
            ((IAsyncWorkProgressListener) it.next()).mo751g(blVar);
        }
    }

    /* renamed from: a */
    private void m4742a(Collection<bi> collection, Collection<bi> collection2) {
        this.f3406c.f3402a = this.f3405b.m8115c().m8267h();
        m4743b();
        if (collection != null) {
            for (bi isVar : collection) {
                this.f3406c.m4737a(new is(isVar));
            }
        }
        if (collection2 != null) {
            for (bi isVar2 : collection2) {
                this.f3406c.m4738a(new is(isVar2).m4686f());
            }
        }
    }

    /* renamed from: b */
    private void m4743b() {
        if (!this.f3407d) {
            this.f3406c.m4739a(this.f3405b.m8115c().m8262b("/Books"));
            this.f3407d = true;
        }
    }
}
