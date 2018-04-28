package com.duokan.reader.domain.bookshelf;

import android.net.Uri;
import com.duokan.core.sys.af;
import com.duokan.reader.common.webservices.duokan.C0652z;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

class fa implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ ee f3153a;
    /* renamed from: b */
    final /* synthetic */ ac f3154b;

    fa(ee eeVar, ac acVar) {
        this.f3153a = eeVar;
        this.f3154b = acVar;
    }

    public /* synthetic */ Object call() {
        return m4445a();
    }

    /* renamed from: a */
    public Void m4445a() {
        try {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            this.f3153a.bj();
            this.f3153a.bk();
            String[] f = C0652z.m3050f(Uri.parse(this.f3154b.f2718b).getFragment());
            Semaphore semaphore = new Semaphore(0);
            af afVar = new af();
            this.f3153a.m4415b(Arrays.asList(f), true, new fb(this, afVar, semaphore));
            semaphore.acquire();
            if (((Map) afVar.m858a()).isEmpty()) {
                try {
                    this.f3153a.aV().mo1091a(this.f3153a.aH());
                    this.f3153a.aQ();
                    this.f3153a.m3744b(268435456);
                    if (!this.f3154b.m3777b(3)) {
                        this.f3153a.d = BookState.NORMAL;
                        this.f3154b.m3779d(1);
                        this.f3153a.m3744b(8);
                        this.f3154b.m3778c(240);
                        this.f3154b.m3779d(64);
                        this.f3153a.m3744b(64);
                    }
                    this.f3153a.aN();
                    return null;
                } catch (Throwable th) {
                    return null;
                } finally {
                    this.f3153a.aV().mo1097b(this.f3153a.aH());
                    this.f3153a.aV().mo1093a(this.f3153a);
                }
            } else {
                for (int i = 0; i < f.length; i++) {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    String str = f[i];
                    ex exVar = (ex) ((Map) afVar.m858a()).get(str);
                    Map hashMap = new HashMap();
                    hashMap.put("sha1", exVar.f3145d);
                    this.f3153a.mo1027a(this.f3153a.mo1040u(str), -1, exVar.f3144c, hashMap, null).get();
                    List w = this.f3153a.mo1042w(str);
                    for (int i2 = 0; i2 < w.size(); i2++) {
                        String str2 = (String) w.get(i2);
                        this.f3153a.mo1029a(Arrays.asList(new String[]{str2}), false, new fc(this, semaphore));
                        semaphore.acquire();
                        this.f3153a.t = Math.round(10000.0f * ((((float) i) / ((float) f.length)) + (((1.0f / ((float) f.length)) / ((float) w.size())) * ((float) i2))));
                    }
                    this.f3153a.t = Math.round(10000.0f * (((float) (i + 1)) / ((float) f.length)));
                    this.f3153a.aV().mo1093a(this.f3153a);
                }
                try {
                    this.f3153a.aV().mo1091a(this.f3153a.aH());
                    this.f3153a.aQ();
                    this.f3153a.m3744b(268435456);
                    if (!this.f3154b.m3777b(3)) {
                        this.f3153a.d = BookState.NORMAL;
                        this.f3154b.m3779d(1);
                        this.f3153a.m3744b(8);
                        this.f3154b.m3778c(240);
                        this.f3154b.m3779d(64);
                        this.f3153a.m3744b(64);
                    }
                    this.f3153a.aN();
                } catch (Throwable th2) {
                } finally {
                    this.f3153a.aV().mo1097b(this.f3153a.aH());
                    this.f3153a.aV().mo1093a(this.f3153a);
                }
                return null;
            }
        } catch (InterruptedException e) {
            try {
                this.f3153a.aV().mo1091a(this.f3153a.aH());
                this.f3153a.aQ();
                this.f3153a.m3744b(268435456);
                this.f3153a.aN();
            } catch (Throwable th3) {
            } finally {
                this.f3153a.aV().mo1097b(this.f3153a.aH());
                this.f3153a.aV().mo1093a(this.f3153a);
            }
        } catch (Throwable th4) {
            try {
                this.f3153a.aV().mo1091a(this.f3153a.aH());
                this.f3153a.aQ();
                this.f3153a.m3744b(268435456);
                if (!this.f3154b.m3777b(3)) {
                    this.f3153a.d = BookState.NORMAL;
                    this.f3154b.m3779d(1);
                    this.f3153a.m3744b(8);
                    this.f3154b.m3778c(240);
                    this.f3154b.m3779d(64);
                    this.f3153a.m3744b(64);
                }
                this.f3153a.aN();
            } catch (Throwable th5) {
            } finally {
                this.f3153a.aV().mo1097b(this.f3153a.aH());
                this.f3153a.aV().mo1093a(this.f3153a);
            }
        }
    }
}
