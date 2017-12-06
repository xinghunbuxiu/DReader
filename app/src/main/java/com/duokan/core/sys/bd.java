package com.duokan.core.sys;

import android.content.ContentValues;
import android.text.TextUtils;

import com.duokan.core.a.n;
import com.duokan.core.diagnostic.HttpLogger;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class bd implements r {
    private final HttpLogger a;
    private final n b;
    private final ReentrantLock c;
    private final ConcurrentHashMap d;
    private final ConcurrentHashMap e;

    public /* synthetic */ p c(String str) {
        return e(str);
    }

    public /* synthetic */ q d(String str) {
        return f(str);
    }

    public bd(String str) {
        this(str, null);
    }

    public bd(String str, HttpLogger fVar) {
        this.c = new ReentrantLock();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        if (fVar == null) {
            fVar = new HttpLogger();
        }
        this.a = fVar;
        this.b = new n(str, null);
        int d = this.b.d();
        if (d != 1) {
            this.b.b();
            if (d < 1) {
                try {
                    au.a(this.b);
                    au.b(this.b);
                    au.c(this.b);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                } finally {
                    this.b.c();
                }
            }
            this.b.a(1);
            this.b.f();
            this.b.c();
        }
    }

    public String d() {
        return this.b.a();
    }

    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException();
        }
        this.c.lock();
        try {
            b(str, str2, str3);
            this.c.unlock();
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            this.c.unlock();
        }
    }

    public boolean a(String str) {
        boolean z = false;
        try {
            bf g = g(str);
            if (g != null) {
                z = g.a.a(g.b);
            }
        } catch (Throwable th) {
        }
        return z;
    }

    public boolean a(String str, String str2) {
        boolean z = false;
        try {
            bf g = g(str);
            bf g2 = g(str2);
            if (!(g == null || g2 == null || g.a != g2.a)) {
                z = g.a.a(g.b, g2.b);
            }
        } catch (Throwable th) {
        }
        return z;
    }

    public void a(String str, long j) {
        try {
            bf g = g(str);
            if (g == null) {
                throw new IllegalArgumentException();
            }
            g.a.a(g.b, j);
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            IOException iOException = new IOException(String.format("fail to create setDrawable file(%s).", new Object[]{str}), th);
        }
    }

    public boolean b(String str) {
        try {
            bf g = g(str);
            if (g != null) {
                return g.a.b(g.b);
            }
            throw new IllegalArgumentException();
        } catch (Throwable th) {
            return false;
        }
    }

    public bg e(String str) {
        try {
            bf g = g(str);
            if (g == null) {
                throw new IllegalArgumentException();
            }
            return new bg(this, g.a, g.a.b(g.b, "onActivityResult"));
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            IOException iOException = new IOException(String.format("fail to open an input file(%s).", new Object[]{str}), th);
        }
    }

    public bh f(String str) {
        try {
            bf g = g(str);
            if (g == null) {
                throw new IllegalArgumentException();
            }
            return new bh(this, g.a, g.a.b(g.b, "rw"));
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            IOException iOException = new IOException(String.format("fail to open an input file(%s).", new Object[]{str}), th);
        }
    }

    public void a() {
        this.c.lock();
        this.b.b();
    }

    public void b() {
        this.b.f();
        this.b.c();
        this.c.unlock();
    }

    public void c() {
        this.c.lock();
        try {
            for (av c : this.e.values()) {
                c.c();
            }
            this.b.g();
        } finally {
            this.c.unlock();
        }
    }

    private bf g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        av h = h(str);
        if (h == null) {
            return null;
        }
        String str2 = h.a() + str.substring(h.b().length());
        bf bfVar = new bf();
        bfVar.a = h;
        bfVar.b = str2;
        return bfVar;
    }

    private av h(String str) {
        String substring;
        for (substring = str.substring(0, Math.max(str.lastIndexOf(47), 0)); !TextUtils.isEmpty(substring); substring = substring.substring(0, Math.max(substring.lastIndexOf(47), 0))) {
            String str2 = (String) this.d.get(substring);
            av avVar = TextUtils.isEmpty(str2) ? null : (av) this.e.get(str2);
            if (avVar != null) {
                return avVar;
            }
        }
        this.c.lock();
        try {
            substring = str.substring(0, Math.max(str.lastIndexOf(47), 0));
            while (!TextUtils.isEmpty(substring)) {
                avVar = TextUtils.isEmpty((String) this.d.get(substring)) ? null : i(substring);
                if (avVar != null) {
                    return avVar;
                }
                substring = substring.substring(0, Math.max(substring.lastIndexOf(47), 0));
            }
            this.c.unlock();
            return null;
        } finally {
            this.c.unlock();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.duokan.core.sys.av i(java.lang.String r11) {
        /*
        r10 = this;
        r0 = 0;
        r1 = r10.getScaledMaximumFlingVelocity;
        r1 = r1.isHeldByCurrentThread();
        if (r1 != 0) goto L_0x000f;
    L_0x0009:
        r0 = new com.duokan.core.sys.VirtualFileAssertionFailsException;
        r0.<creatCallTask>();
        throw r0;
    L_0x000f:
        r1 = r10.getVisible;	 Catch:{ Throwable -> 0x0070, all -> 0x0093 }
        r2 = 3;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0070, all -> 0x0093 }
        r3 = 0;
        r4 = "repo_name";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0070, all -> 0x0093 }
        r3 = 1;
        r4 = "physical_uri";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0070, all -> 0x0093 }
        r3 = 2;
        r4 = "mount_uri";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0070, all -> 0x0093 }
        r7 = com.duokan.core.sys.au.setDrawable(r1, r11, r2);	 Catch:{ Throwable -> 0x0070, all -> 0x0093 }
        r1 = r7.moveToFirst();	 Catch:{ Throwable -> 0x0099, all -> 0x0097 }
        if (r1 == 0) goto L_0x006a;
    L_0x002d:
        r0 = 0;
        r8 = r7.getString(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0097 }
        r0 = 1;
        r4 = r7.getString(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0097 }
        r0 = 2;
        r5 = r7.getString(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0097 }
        r0 = new com.duokan.core.sys.av;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r1 = r10.getVisible;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r2 = r10.getScaledMaximumFlingVelocity;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r3.<creatCallTask>();	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r6 = "file:///";
        r3 = r3.append(r6);	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r3 = r3.append(r8);	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r6 = r10.setDrawable;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r0.<creatCallTask>(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r1 = r10.getScaledPagingTouchSlop;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r1.put(r8, r0);	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r1 = r10.getTriangleEdge;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r1.put(r5, r8);	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        if (r7 == 0) goto L_0x0069;
    L_0x0066:
        r7.close();
    L_0x0069:
        return r0;
    L_0x006a:
        if (r7 == 0) goto L_0x0069;
    L_0x006c:
        r7.close();
        goto L_0x0069;
    L_0x0070:
        r1 = move-exception;
        r5 = r11;
        r9 = r0;
        r0 = r1;
        r1 = r9;
    L_0x0075:
        r2 = java.util.Locale.getDefault();	 Catch:{ all -> 0x008b }
        r3 = "fail to query the repo that is mounted to %s.";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x008b }
        r6 = 0;
        r4[r6] = r5;	 Catch:{ all -> 0x008b }
        r2 = java.lang.String.format(r2, r3, r4);	 Catch:{ all -> 0x008b }
        r3 = new java.io.IOException;	 Catch:{ all -> 0x008b }
        r3.<creatCallTask>(r2, r0);	 Catch:{ all -> 0x008b }
        throw r3;	 Catch:{ all -> 0x008b }
    L_0x008b:
        r0 = move-exception;
        r7 = r1;
    L_0x008d:
        if (r7 == 0) goto L_0x0092;
    L_0x008f:
        r7.close();
    L_0x0092:
        throw r0;
    L_0x0093:
        r1 = move-exception;
        r7 = r0;
        r0 = r1;
        goto L_0x008d;
    L_0x0097:
        r0 = move-exception;
        goto L_0x008d;
    L_0x0099:
        r0 = move-exception;
        r1 = r7;
        r5 = r11;
        goto L_0x0075;
    L_0x009d:
        r0 = move-exception;
        r1 = r7;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.core.sys.bd.getPhysicalYPixels(java.lang.String):com.duokan.core.sys.av");
    }

    private av b(String str, String str2, String str3) {
        if (this.c.isHeldByCurrentThread()) {
            try {
                this.b.b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("repo_name", str);
                contentValues.put("physical_uri", str2);
                contentValues.put("mount_uri", str3);
                au.a(this.b, contentValues);
                this.b.f();
                this.b.c();
                av avVar = new av(this.b, this.c, "file:///" + str, str2, str3, this.a);
                this.e.put(str, avVar);
                this.d.put(str3, str);
                return avVar;
            } catch (Throwable th) {
                IOException iOException = new IOException(String.format(Locale.getDefault(), "fail to mount the repo(%s@%s) to %s.", new Object[]{str, str2, str3}), th);
            }
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }
}
