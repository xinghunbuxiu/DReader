package com.duokan.reader.domain.bookshelf;

import com.duokan.core.a.n;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ah;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.downloadcenter.b;
import com.duokan.reader.domain.store.a;

import java.io.File;

class hv implements am {
    static final /* synthetic */ boolean a = (!hi.class.desiredAssertionStatus());
    final /* synthetic */ hi b;

    hv(hi hiVar) {
        this.b = hiVar;
    }

    public BookOrderHelper j() {
        return this.b.H;
    }

    public File c() {
        return this.b.f.getDownloadedCoverDirectory();
    }

    public a e() {
        return this.b.b;
    }

    public File d() {
        return this.b.f.getCloudBookDirectory();
    }

    public DkCloudStorage f() {
        return this.b.m;
    }

    public b g() {
        return this.b.n;
    }

    public an d(long j) {
        if (!a && j == 0) {
            throw new AssertionError();
        } else if (j < 0) {
            return this.b.b(j);
        } else {
            return this.b.a(j);
        }
    }

    public n h() {
        return this.b.g;
    }

    public n i() {
        return this.b.o;
    }

    public void a(c cVar, long j) {
        if (j >= 1) {
            cVar.g(j);
            cVar.aL();
            if (this.b.x) {
                ah.a(new hw(this, cVar, j), hi.c);
            } else {
                this.b.a(cVar, j);
            }
        }
    }

    public void a(an anVar, int i) {
        TaskHandler.PostTask(new hx(this, anVar, i));
    }

    public void a(c cVar) {
        this.b.j(cVar);
    }

    public void a() {
        this.b.D.lock();
    }

    public void b() {
        this.b.D.unlock();
    }

    public void a(long j) {
        this.b.D.lock();
    }

    public void b(long j) {
        this.b.D.unlock();
    }

    public boolean c(long j) {
        return this.b.D.isHeldByCurrentThread();
    }

    public void a(c cVar, is isVar) {
        c b;
        if (cVar.ao() != 3) {
            b = this.b.b(cVar.H());
        } else {
            b = this.b.c(cVar.f());
        }
        if (b == null) {
            this.b.a("", cVar);
            this.b.a(cVar, "");
            this.b.x();
            if (isVar != null) {
                isVar.a(cVar);
            }
        } else if (isVar != null) {
            isVar.a(b);
        }
    }
}
