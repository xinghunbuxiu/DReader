package com.duokan.reader.domain.bookshelf;

import android.net.Uri;

import com.duokan.core.sys.ah;
import com.duokan.core.sys.r;
import com.duokan.reader.common.classc;
import com.duokan.reader.domain.document.epub.av;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

import miuipub.date.Calendar;

class hd implements Callable {
    final /* synthetic */ fv a;
    final /* synthetic */ ac b;

    hd(fv fvVar, ac acVar) {
        this.a = fvVar;
        this.b = acVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Void a() {
        Throwable th;
        Object obj;
        this.a.bu();
        r e = this.a.bt();
        try {
            int i = classc.ConnectivityReceiver.b().d() ? 20 : 10;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            File file = new File(Uri.parse(this.b.a).getPath());
            if (!file.exists()) {
                ah.b(new he(this, file, i)).get();
            }
            this.a.t = Calendar.MILLISECOND_OF_SECOND;
            this.a.aT().a(this.a);
            if (file.exists()) {
                hf hfVar;
                this.a.aT().a(this.a.aF());
                this.a.aO();
                this.a.a(this.a.x.a);
                this.a.r = this.a.x.c;
                this.a.b(2);
                this.a.aL();
                this.a.aT().b(this.a.aF());
                List<av> e2 = this.a.e(this.b.b(j.g));
                Semaphore semaphore = new Semaphore(20);
                int size = e2.size();
                ArrayList arrayList = new ArrayList(size);
                e.a();
                for (av avVar : e2) {
                    gz gzVar = (gz) avVar;
                    hf hfVar2 = new hf(this);
                    hfVar2.a = gzVar;
                    hfVar2.b = gzVar.a() + ".blk";
                    try {
                        e.a(hfVar2.b, (long) hfVar2.a.e());
                    } catch (Throwable th2) {
                    }
                    try {
                        hfVar2.c = e.d(hfVar2.b);
                        hfVar2.d = e.c(hfVar2.b);
                    } catch (Throwable th3) {
                    }
                    try {
                        arrayList.add(hfVar2);
                        this.a.t = (((arrayList.size() + 1) * Calendar.MILLISECOND_OF_SECOND) / size) + Calendar.MILLISECOND_OF_SECOND;
                    } catch (InterruptedException e3) {
                        try {
                            this.a.aT().a(this.a.aF());
                            this.a.aO();
                            this.a.b(268435456);
                            this.a.aL();
                        } catch (Throwable th4) {
                            this.a.bv();
                            return null;
                        } finally {
                            this.a.aT().b(this.a.aF());
                            this.a.aT().a(this.a);
                        }
                        this.a.bv();
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                e.b();
                this.a.aT().a(this.a);
                long currentTimeMillis = System.currentTimeMillis();
                int i2 = 0;
                while (i2 < size) {
                    long j;
                    hfVar = (hf) arrayList.get(i2);
                    if (hfVar.a.i()) {
                        j = currentTimeMillis;
                    } else {
                        if (hfVar.c != null) {
                            if (hfVar.d == null) {
                                j = currentTimeMillis;
                            } else {
                                semaphore.acquire();
                                ah.b(new hg(this, hfVar, i, semaphore));
                                this.a.t = (((i2 + 1) * 7000) / size) + 2000;
                                if (System.currentTimeMillis() - currentTimeMillis > 2000) {
                                    this.a.aT().a(this.a);
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
                e.a();
                obj = 1;
                for (int i4 = 0; i4 < size; i4++) {
                    hfVar = (hf) arrayList.get(i4);
                    if (hfVar.c != null) {
                        try {
                            hfVar.c.close();
                        } catch (Throwable th6) {
                        }
                    }
                    if (hfVar.d != null) {
                        try {
                            hfVar.d.close();
                        } catch (Throwable th7) {
                        }
                    }
                    if (!hfVar.e) {
                        obj = null;
                    } else if (!(e.a(hfVar.b, hfVar.a.a()) || hfVar.a.i())) {
                        obj = null;
                    }
                    this.a.t = (((i4 + 1) * Calendar.MILLISECOND_OF_SECOND) / size) + 9000;
                }
                e.b();
                this.a.aT().a(this.a);
            } else {
                obj = null;
            }
            try {
                this.a.aT().a(this.a.aF());
                this.a.aO();
                this.a.b(268435456);
                if (!this.a.x.b(3)) {
                    if (obj != null) {
                        this.a.bookState = BookState.NORMAL;
                        this.a.x.d(1);
                        this.a.b(8);
                    } else {
                        this.a.x.d(2);
                    }
                    this.a.x.c(240);
                    this.a.x.d(64);
                    this.a.b(64);
                }
                this.a.aL();
            } catch (Throwable th8) {
            } finally {
                this.a.aT().b(this.a.aF());
                this.a.aT().a(this.a);
            }
            this.a.bv();
            return null;
        } catch (InterruptedException e32) {
            try {
                this.a.aT().a(this.a.aF());
                this.a.aO();
                this.a.b(268435456);
                this.a.aL();
            } catch (Throwable th42) {
                this.a.bv();
                return null;
            } finally {
                this.a.aT().b(this.a.aF());
                this.a.aT().a(this.a);
            }
            this.a.bv();
        } catch (Throwable th9) {
            th = th9;
            obj = 1;
        }
        try {
            this.a.aT().a(this.a.aF());
            this.a.aO();
            this.a.b(268435456);
            if (!this.a.x.b(3)) {
                if (obj != null) {
                    this.a.bookState = BookState.NORMAL;
                    this.a.x.d(1);
                    this.a.b(8);
                } else {
                    this.a.x.d(2);
                }
                this.a.x.c(240);
                this.a.x.d(64);
                this.a.b(64);
            }
            this.a.aL();
        } catch (Throwable th10) {
            this.a.bv();
            throw th;
        } finally {
            this.a.aT().b(this.a.aF());
            this.a.aT().a(this.a);
        }
        this.a.bv();
        throw th;
    }
}
