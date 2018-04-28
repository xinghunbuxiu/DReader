package com.duokan.reader.domain.bookshelf;

import android.net.Uri;
import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.document.epub.av;
import com.umeng.analytics.pro.C2295j;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

class gx implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ fp f3269a;
    /* renamed from: b */
    final /* synthetic */ ac f3270b;

    gx(fp fpVar, ac acVar) {
        this.f3269a = fpVar;
        this.f3270b = acVar;
    }

    public /* synthetic */ Object call() {
        return m4603a();
    }

    /* renamed from: a */
    public Void m4603a() {
        Throwable th;
        Object obj;
        this.f3269a.bw();
        C0352r e = this.f3269a.bv();
        try {
            int i = C0559f.m2476b().m2485d() ? 20 : 10;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            File file = new File(Uri.parse(this.f3270b.f2717a).getPath());
            if (!file.exists()) {
                ah.m871b(new gy(this, file, i)).get();
            }
            this.f3269a.t = 1000;
            this.f3269a.aV().mo1093a(this.f3269a);
            if (file.exists()) {
                gz gzVar;
                this.f3269a.aV().mo1091a(this.f3269a.aH());
                this.f3269a.aQ();
                this.f3269a.m4196a(this.f3269a.x.f2717a);
                this.f3269a.r = this.f3269a.x.f2719c;
                this.f3269a.m3744b(2);
                this.f3269a.aN();
                this.f3269a.aV().mo1097b(this.f3269a.aH());
                List<av> f = this.f3269a.m4492f(this.f3270b.m3777b(C2295j.f14327g));
                Semaphore semaphore = new Semaphore(20);
                int size = f.size();
                ArrayList arrayList = new ArrayList(size);
                e.mo415a();
                for (av avVar : f) {
                    gt gtVar = (gt) avVar;
                    gz gzVar2 = new gz(this);
                    gzVar2.f3274a = gtVar;
                    gzVar2.f3275b = gtVar.m4577a() + ".blk";
                    try {
                        e.mo416a(gzVar2.f3275b, (long) gzVar2.f3274a.mo1070e());
                    } catch (Throwable th2) {
                    }
                    try {
                        gzVar2.f3276c = e.mo424d(gzVar2.f3275b);
                        gzVar2.f3277d = e.mo422c(gzVar2.f3275b);
                    } catch (Throwable th3) {
                    }
                    try {
                        arrayList.add(gzVar2);
                        this.f3269a.t = (((arrayList.size() + 1) * 1000) / size) + 1000;
                    } catch (InterruptedException e2) {
                        try {
                            this.f3269a.aV().mo1091a(this.f3269a.aH());
                            this.f3269a.aQ();
                            this.f3269a.m3744b(268435456);
                            this.f3269a.aN();
                        } catch (Throwable th4) {
                            this.f3269a.bx();
                            return null;
                        } finally {
                            this.f3269a.aV().mo1097b(this.f3269a.aH());
                            this.f3269a.aV().mo1093a(this.f3269a);
                        }
                        this.f3269a.bx();
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                e.mo420b();
                this.f3269a.aV().mo1093a(this.f3269a);
                long currentTimeMillis = System.currentTimeMillis();
                int i2 = 0;
                while (i2 < size) {
                    long j;
                    gzVar = (gz) arrayList.get(i2);
                    if (gzVar.f3274a.mo1073i()) {
                        j = currentTimeMillis;
                    } else {
                        if (gzVar.f3276c != null) {
                            if (gzVar.f3277d == null) {
                                j = currentTimeMillis;
                            } else {
                                semaphore.acquire();
                                ah.m871b(new ha(this, gzVar, i, semaphore));
                                this.f3269a.t = (((i2 + 1) * 7000) / size) + 2000;
                                if (System.currentTimeMillis() - currentTimeMillis > 2000) {
                                    this.f3269a.aV().mo1093a(this.f3269a);
                                    j = System.currentTimeMillis();
                                }
                            }
                        }
                        j = currentTimeMillis;
                    }
                    i2++;
                    currentTimeMillis = j;
                }
                for (int i3 = 0; i3 < 20; i3++) {
                    semaphore.acquire();
                }
                e.mo415a();
                obj = 1;
                for (int i4 = 0; i4 < size; i4++) {
                    gzVar = (gz) arrayList.get(i4);
                    if (gzVar.f3276c != null) {
                        try {
                            gzVar.f3276c.close();
                        } catch (Throwable th6) {
                        }
                    }
                    if (gzVar.f3277d != null) {
                        try {
                            gzVar.f3277d.close();
                        } catch (Throwable th7) {
                        }
                    }
                    if (!gzVar.f3278e) {
                        obj = null;
                    } else if (!(e.mo419a(gzVar.f3275b, gzVar.f3274a.m4577a()) || gzVar.f3274a.mo1073i())) {
                        obj = null;
                    }
                    this.f3269a.t = (((i4 + 1) * 1000) / size) + 9000;
                }
                e.mo420b();
                this.f3269a.aV().mo1093a(this.f3269a);
            } else {
                obj = null;
            }
            try {
                this.f3269a.aV().mo1091a(this.f3269a.aH());
                this.f3269a.aQ();
                this.f3269a.m3744b(268435456);
                if (!this.f3269a.x.m3777b(3)) {
                    if (obj != null) {
                        this.f3269a.d = BookState.NORMAL;
                        this.f3269a.x.m3779d(1);
                        this.f3269a.m3744b(8);
                    } else {
                        this.f3269a.x.m3779d(2);
                    }
                    this.f3269a.x.m3778c(240);
                    this.f3269a.x.m3779d(64);
                    this.f3269a.m3744b(64);
                }
                this.f3269a.aN();
            } catch (Throwable th8) {
            } finally {
                this.f3269a.aV().mo1097b(this.f3269a.aH());
                this.f3269a.aV().mo1093a(this.f3269a);
            }
            this.f3269a.bx();
            return null;
        } catch (InterruptedException e22) {
            try {
                this.f3269a.aV().mo1091a(this.f3269a.aH());
                this.f3269a.aQ();
                this.f3269a.m3744b(268435456);
                this.f3269a.aN();
            } catch (Throwable th42) {
                this.f3269a.bx();
                return null;
            } finally {
                this.f3269a.aV().mo1097b(this.f3269a.aH());
                this.f3269a.aV().mo1093a(this.f3269a);
            }
            this.f3269a.bx();
        } catch (Throwable th9) {
            th = th9;
            obj = 1;
        }
        try {
            this.f3269a.aV().mo1091a(this.f3269a.aH());
            this.f3269a.aQ();
            this.f3269a.m3744b(268435456);
            if (!this.f3269a.x.m3777b(3)) {
                if (obj != null) {
                    this.f3269a.d = BookState.NORMAL;
                    this.f3269a.x.m3779d(1);
                    this.f3269a.m3744b(8);
                } else {
                    this.f3269a.x.m3779d(2);
                }
                this.f3269a.x.m3778c(240);
                this.f3269a.x.m3779d(64);
                this.f3269a.m3744b(64);
            }
            this.f3269a.aN();
        } catch (Throwable th10) {
            this.f3269a.bx();
            throw th;
        } finally {
            this.f3269a.aV().mo1097b(this.f3269a.aH());
            this.f3269a.aV().mo1093a(this.f3269a);
        }
        this.f3269a.bx();
        throw th;
    }
}
