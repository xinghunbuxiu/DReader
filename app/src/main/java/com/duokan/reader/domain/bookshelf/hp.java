package com.duokan.reader.domain.bookshelf;

import com.duokan.core.p026a.C0285n;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.store.C1176a;
import java.io.File;

class hp implements am {
    /* renamed from: a */
    static final /* synthetic */ boolean f3315a = (!hc.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ hc f3316b;

    hp(hc hcVar) {
        this.f3316b = hcVar;
    }

    /* renamed from: j */
    public BookOrderHelper mo1107j() {
        return this.f3316b.f2737H;
    }

    /* renamed from: c */
    public File mo1098c() {
        return this.f3316b.f2742f.getDownloadedCoverDirectory();
    }

    /* renamed from: e */
    public C1176a mo1102e() {
        return this.f3316b.f2739b;
    }

    /* renamed from: d */
    public File mo1101d() {
        return this.f3316b.f2742f.getCloudBookDirectory();
    }

    /* renamed from: f */
    public DkCloudStorage mo1103f() {
        return this.f3316b.f2748m;
    }

    /* renamed from: g */
    public C1016b mo1104g() {
        return this.f3316b.f2749n;
    }

    /* renamed from: d */
    public an mo1100d(long j) {
        if (!f3315a && j == 0) {
            throw new AssertionError();
        } else if (j < 0) {
            return this.f3316b.m3904b(j);
        } else {
            return this.f3316b.m3863a(j);
        }
    }

    /* renamed from: h */
    public C0285n mo1105h() {
        return this.f3316b.f2743g;
    }

    /* renamed from: i */
    public C0285n mo1106i() {
        return this.f3316b.f2750o;
    }

    /* renamed from: a */
    public void mo1094a(C0800c c0800c, long j) {
        if (j >= 1) {
            c0800c.m4229g(j);
            c0800c.aN();
            if (this.f3316b.f2759x) {
                ah.m866a(new hq(this, c0800c, j), hc.f2728c);
            } else {
                this.f3316b.m3820a(c0800c, j);
            }
        }
    }

    /* renamed from: a */
    public void mo1092a(an anVar, int i) {
        UThread.post(new hr(this, anVar, i));
    }

    /* renamed from: a */
    public void mo1093a(C0800c c0800c) {
        this.f3316b.m3855j(c0800c);
    }

    /* renamed from: a */
    public void mo1090a() {
        this.f3316b.f2733D.lock();
    }

    /* renamed from: b */
    public void mo1096b() {
        this.f3316b.f2733D.unlock();
    }

    /* renamed from: a */
    public void mo1091a(long j) {
        this.f3316b.f2733D.lock();
    }

    /* renamed from: b */
    public void mo1097b(long j) {
        this.f3316b.f2733D.unlock();
    }

    /* renamed from: c */
    public boolean mo1099c(long j) {
        return this.f3316b.f2733D.isHeldByCurrentThread();
    }

    /* renamed from: a */
    public void mo1095a(C0800c c0800c, im imVar) {
        C0800c b;
        if (c0800c.aq() != 3) {
            b = this.f3316b.m3906b(c0800c.m4156I());
        } else {
            b = this.f3316b.m3917c(c0800c.m4225f());
        }
        if (b == null) {
            this.f3316b.m3895a("", c0800c);
            this.f3316b.m3823a(c0800c, "");
            this.f3316b.m3949x();
            if (imVar != null) {
                imVar.mo1021a(c0800c);
            }
        } else if (imVar != null) {
            imVar.mo1021a(b);
        }
    }
}
