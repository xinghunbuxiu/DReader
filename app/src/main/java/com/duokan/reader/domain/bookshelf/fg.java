package com.duokan.reader.domain.bookshelf;

import android.net.Uri;

import com.duokan.core.sys.af;
import com.duokan.reader.common.webservices.duokan.aa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

class fg implements Callable {
    final /* synthetic */ ej a;
    final /* synthetic */ ac b;

    fg(ej ejVar, ac acVar) {
        this.a = ejVar;
        this.b = acVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Void a() {
        try {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            this.a.bh();
            this.a.bi();
            String[] f = aa.f(Uri.parse(this.b.b).getFragment());
            Semaphore semaphore = new Semaphore(0);
            af afVar = new af();
            this.a.b(Arrays.asList(f), true, new fh(this, afVar, semaphore));
            semaphore.acquire();
            if (((Map) afVar.a()).isEmpty()) {
                try {
                    this.a.aT().a(this.a.aF());
                    this.a.aO();
                    this.a.b(268435456);
                    if (!this.b.b(3)) {
                        this.a.bookState = BookState.NORMAL;
                        this.b.d(1);
                        this.a.b(8);
                        this.b.c(240);
                        this.b.d(64);
                        this.a.b(64);
                    }
                    this.a.aL();
                    return null;
                } catch (Throwable th) {
                    return null;
                } finally {
                    this.a.aT().b(this.a.aF());
                    this.a.aT().a(this.a);
                }
            } else {
                for (int i = 0; i < f.length; i++) {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    String str = f[i];
                    fd fdVar = (fd) ((Map) afVar.a()).get(str);
                    Map hashMap = new HashMap();
                    hashMap.put("sha1", fdVar.d);
                    this.a.a(this.a.t(str), -1, fdVar.c, hashMap, null).get();
                    List v = this.a.v(str);
                    for (int i2 = 0; i2 < v.size(); i2++) {
                        String str2 = (String) v.get(i2);
                        this.a.a(Arrays.asList(new String[]{str2}), false, new fi(this, semaphore));
                        semaphore.acquire();
                        this.a.t = Math.round(10000.0f * ((((float) i) / ((float) f.length)) + (((1.0f / ((float) f.length)) / ((float) v.size())) * ((float) i2))));
                    }
                    this.a.t = Math.round(10000.0f * (((float) (i + 1)) / ((float) f.length)));
                    this.a.aT().a(this.a);
                }
                try {
                    this.a.aT().a(this.a.aF());
                    this.a.aO();
                    this.a.b(268435456);
                    if (!this.b.b(3)) {
                        this.a.bookState = BookState.NORMAL;
                        this.b.d(1);
                        this.a.b(8);
                        this.b.c(240);
                        this.b.d(64);
                        this.a.b(64);
                    }
                    this.a.aL();
                } catch (Throwable th2) {
                } finally {
                    this.a.aT().b(this.a.aF());
                    this.a.aT().a(this.a);
                }
                return null;
            }
        } catch (InterruptedException e) {
            try {
                this.a.aT().a(this.a.aF());
                this.a.aO();
                this.a.b(268435456);
                this.a.aL();
            } catch (Throwable th3) {
            } finally {
                this.a.aT().b(this.a.aF());
                this.a.aT().a(this.a);
            }
        } catch (Throwable th4) {
            try {
                this.a.aT().a(this.a.aF());
                this.a.aO();
                this.a.b(268435456);
                if (!this.b.b(3)) {
                    this.a.bookState = BookState.NORMAL;
                    this.b.d(1);
                    this.a.b(8);
                    this.b.c(240);
                    this.b.d(64);
                    this.a.b(64);
                }
                this.a.aL();
            } catch (Throwable th5) {
            } finally {
                this.a.aT().b(this.a.aF());
                this.a.aT().a(this.a);
            }
        }
    }
}
