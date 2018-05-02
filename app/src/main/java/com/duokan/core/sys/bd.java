package com.duokan.core.sys;

import android.content.ContentValues;
import android.text.TextUtils;
import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.p026a.C0285n;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class bd implements C0352r {
    /* renamed from: a */
    private final HttpLogger f692a;
    /* renamed from: b */
    private final C0285n f693b;
    /* renamed from: c */
    private final ReentrantLock f694c;
    /* renamed from: d */
    private final ConcurrentHashMap<String, String> f695d;
    /* renamed from: e */
    private final ConcurrentHashMap<String, av> f696e;

    /* renamed from: c */
    public /* synthetic */ C0353p mo422c(String str) {
        return m973e(str);
    }

    /* renamed from: d */
    public /* synthetic */ C0354q mo424d(String str) {
        return m974f(str);
    }

    public bd(String str) {
        this(str, null);
    }

    public bd(String str, HttpLogger httpLogger) {
        this.f694c = new ReentrantLock();
        this.f695d = new ConcurrentHashMap();
        this.f696e = new ConcurrentHashMap();
        if (httpLogger == null) {
            httpLogger = new HttpLogger();
        }
        this.f692a = httpLogger;
        this.f693b = new C0285n(str, null);
        int d = this.f693b.m679d();
        if (d != 1) {
            this.f693b.m677b();
            if (d < 1) {
                try {
                    au.m891a(this.f693b);
                    au.m897b(this.f693b);
                    au.m900c(this.f693b);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                } finally {
                    this.f693b.m678c();
                }
            }
            this.f693b.m672a(1);
            this.f693b.m681f();
            this.f693b.m678c();
        }
    }

    /* renamed from: d */
    public String m972d() {
        return this.f693b.m671a();
    }

    /* renamed from: a */
    public void mo417a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException();
        }
        this.f694c.lock();
        try {
            m958b(str, str2, str3);
            this.f694c.unlock();
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            this.f694c.unlock();
        }
    }

    /* renamed from: a */
    public boolean mo418a(String str) {
        boolean z = false;
        try {
            bf g = m959g(str);
            if (g != null) {
                z = g.f698a.m918a(g.f699b);
            }
        } catch (Throwable th) {
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo419a(String str, String str2) {
        boolean z = false;
        try {
            bf g = m959g(str);
            bf g2 = m959g(str2);
            if (!(g == null || g2 == null || g.f698a != g2.f698a)) {
                z = g.f698a.m919a(g.f699b, g2.f699b);
            }
        } catch (Throwable th) {
        }
        return z;
    }

    /* renamed from: a */
    public void mo416a(String str, long j) {
        try {
            bf g = m959g(str);
            if (g == null) {
                throw new IllegalArgumentException();
            }
            g.f698a.m917a(g.f699b, j);
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            IOException iOException = new IOException(String.format("fail to create a file(%s).", new Object[]{str}), th);
        }
    }

    /* renamed from: b */
    public boolean mo421b(String str) {
        try {
            bf g = m959g(str);
            if (g != null) {
                return g.f698a.m924b(g.f699b);
            }
            throw new IllegalArgumentException();
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: e */
    public bg m973e(String str) {
        try {
            bf g = m959g(str);
            if (g == null) {
                throw new IllegalArgumentException();
            }
            return new bg(this, g.f698a, g.f698a.m921b(g.f699b, "r"));
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            IOException iOException = new IOException(String.format("fail to open an input file(%s).", new Object[]{str}), th);
        }
    }

    /* renamed from: f */
    public bh m974f(String str) {
        try {
            bf g = m959g(str);
            if (g == null) {
                throw new IllegalArgumentException();
            }
            return new bh(this, g.f698a, g.f698a.m921b(g.f699b, "rw"));
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            IOException iOException = new IOException(String.format("fail to open an input file(%s).", new Object[]{str}), th);
        }
    }

    /* renamed from: a */
    public void mo415a() {
        this.f694c.lock();
        this.f693b.m677b();
    }

    /* renamed from: b */
    public void mo420b() {
        this.f693b.m681f();
        this.f693b.m678c();
        this.f694c.unlock();
    }

    /* renamed from: c */
    public void mo423c() {
        this.f694c.lock();
        try {
            for (av c : this.f696e.values()) {
                c.m925c();
            }
            this.f693b.m682g();
        } finally {
            this.f694c.unlock();
        }
    }

    /* renamed from: g */
    private bf m959g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        av h = m960h(str);
        if (h == null) {
            return null;
        }
        String str2 = h.m916a() + str.substring(h.m922b().length());
        bf bfVar = new bf();
        bfVar.f698a = h;
        bfVar.f699b = str2;
        return bfVar;
    }

    /* renamed from: h */
    private av m960h(String str) {
        String substring;
        for (substring = str.substring(0, Math.max(str.lastIndexOf(47), 0)); !TextUtils.isEmpty(substring); substring = substring.substring(0, Math.max(substring.lastIndexOf(47), 0))) {
            String str2 = (String) this.f695d.get(substring);
            av avVar = TextUtils.isEmpty(str2) ? null : (av) this.f696e.get(str2);
            if (avVar != null) {
                return avVar;
            }
        }
        this.f694c.lock();
        try {
            substring = str.substring(0, Math.max(str.lastIndexOf(47), 0));
            while (!TextUtils.isEmpty(substring)) {
                avVar = TextUtils.isEmpty((String) this.f695d.get(substring)) ? null : m961i(substring);
                if (avVar != null) {
                    return avVar;
                }
                substring = substring.substring(0, Math.max(substring.lastIndexOf(47), 0));
            }
            this.f694c.unlock();
            return null;
        } finally {
            this.f694c.unlock();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    private com.duokan.core.sys.av m961i(java.lang.String r11) {
        /*
        r10 = this;
        r0 = 0;
        r1 = r10.f694c;
        r1 = r1.isHeldByCurrentThread();
        if (r1 != 0) goto L_0x000f;
    L_0x0009:
        r0 = new com.duokan.core.sys.VirtualFileAssertionFailsException;
        r0.<init>();
        throw r0;
    L_0x000f:
        r1 = r10.f693b;	 Catch:{ Throwable -> 0x0070, all -> 0x0093 }
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
        r7 = com.duokan.core.sys.au.m888a(r1, r11, r2);	 Catch:{ Throwable -> 0x0070, all -> 0x0093 }
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
        r1 = r10.f693b;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r2 = r10.f694c;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r3.<init>();	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r6 = "file:///";
        r3 = r3.append(r6);	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r3 = r3.append(r8);	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r6 = r10.f692a;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r1 = r10.f696e;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r1.put(r8, r0);	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
        r1 = r10.f695d;	 Catch:{ Throwable -> 0x009d, all -> 0x0097 }
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
        r3.<init>(r2, r0);	 Catch:{ all -> 0x008b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.core.sys.bd.i(java.lang.String):com.duokan.core.sys.av");
    }

    /* renamed from: b */
    private av m958b(String str, String str2, String str3) {
        if (this.f694c.isHeldByCurrentThread()) {
            try {
                this.f693b.m677b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("repo_name", str);
                contentValues.put("physical_uri", str2);
                contentValues.put("mount_uri", str3);
                au.m892a(this.f693b, contentValues);
                this.f693b.m681f();
                this.f693b.m678c();
                av avVar = new av(this.f693b, this.f694c, "file:///" + str, str2, str3, this.f692a);
                this.f696e.put(str, avVar);
                this.f695d.put(str3, str);
                return avVar;
            } catch (Throwable th) {
                IOException iOException = new IOException(String.format(Locale.getDefault(), "fail to mount the repo(%s@%s) to %s.", new Object[]{str, str2, str3}), th);
            }
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }
}
