package com.duokan.core.sys;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.diagnostic.C0327f;
import com.duokan.core.io.FileAlreadyExistsException;
import com.duokan.core.io.OutputException;
import com.duokan.core.p026a.C0285n;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

class av {
    /* renamed from: a */
    private final C0285n f656a;
    /* renamed from: b */
    private final ReentrantLock f657b;
    /* renamed from: c */
    private final String f658c;
    /* renamed from: d */
    private final String f659d;
    /* renamed from: e */
    private final String f660e;
    /* renamed from: f */
    private final C0327f f661f;
    /* renamed from: g */
    private boolean f662g = false;
    /* renamed from: h */
    private long f663h = -1;
    /* renamed from: i */
    private final HashMap<String, aw> f664i = new HashMap();
    /* renamed from: j */
    private final HashMap<String, ba> f665j = new HashMap();
    /* renamed from: k */
    private final ConcurrentHashMap<String, ax> f666k = new ConcurrentHashMap();

    public av(C0285n c0285n, ReentrantLock reentrantLock, String str, String str2, String str3, C0327f c0327f) {
        this.f656a = c0285n;
        this.f657b = reentrantLock;
        this.f658c = str;
        this.f659d = str2;
        this.f660e = str3;
        this.f661f = c0327f;
    }

    /* renamed from: a */
    public String m916a() {
        return this.f658c;
    }

    /* renamed from: b */
    public String m922b() {
        return this.f660e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean m918a(java.lang.String r8) {
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r2 = r7.f666k;
        r2 = r2.contains(r8);
        if (r2 == 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r2 = 0;
        r3 = r7.f656a;	 Catch:{ Throwable -> 0x0028, all -> 0x0031 }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x0028, all -> 0x0031 }
        r5 = 0;
        r6 = "attributes";
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0028, all -> 0x0031 }
        r2 = com.duokan.core.sys.au.m896b(r3, r8, r4);	 Catch:{ Throwable -> 0x0028, all -> 0x0031 }
        r3 = r2.getCount();	 Catch:{ Throwable -> 0x0038, all -> 0x0031 }
        if (r3 <= 0) goto L_0x0026;
    L_0x0020:
        if (r2 == 0) goto L_0x000a;
    L_0x0022:
        r2.close();
        goto L_0x000a;
    L_0x0026:
        r0 = r1;
        goto L_0x0020;
    L_0x0028:
        r0 = move-exception;
        r0 = r2;
    L_0x002a:
        if (r0 == 0) goto L_0x002f;
    L_0x002c:
        r0.close();
    L_0x002f:
        r0 = r1;
        goto L_0x000a;
    L_0x0031:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0037;
    L_0x0034:
        r2.close();
    L_0x0037:
        throw r0;
    L_0x0038:
        r0 = move-exception;
        r0 = r2;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.core.sys.av.a(java.lang.String):boolean");
    }

    /* renamed from: a */
    public boolean m919a(String str, String str2) {
        ReentrantLock reentrantLock = null;
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        this.f657b.lock();
        try {
            if (this.f662g) {
                return reentrantLock;
            }
            if (!m918a(str) || m918a(str2)) {
                this.f657b.unlock();
                return false;
            }
            try {
                ax c = m910c(str);
                this.f656a.m677b();
                m906a(c, str2);
                this.f656a.m681f();
                this.f656a.m678c();
                this.f657b.unlock();
                return true;
            } catch (Throwable th) {
                this.f657b.unlock();
                return false;
            }
        } finally {
            reentrantLock = this.f657b;
            reentrantLock.unlock();
        }
    }

    /* renamed from: a */
    public void m917a(String str, long j) {
        this.f657b.lock();
        try {
            if (this.f662g) {
                throw new OutputException(String.format(Locale.getDefault(), "the repository(%s) is already closed.", new Object[]{this.f658c}));
            } else if (m918a(str)) {
                throw new FileAlreadyExistsException(String.format(Locale.getDefault(), "fail to create a file(%s) with an expected size of %d bytes, cause it already exists.", new Object[]{str, Long.valueOf(j)}));
            } else {
                try {
                    this.f656a.m677b();
                    m911c(str, m904a(m907a(j)));
                    this.f656a.m681f();
                    this.f656a.m678c();
                } catch (IOException e) {
                    throw e;
                } catch (Throwable th) {
                    IOException iOException = new IOException(String.format(Locale.getDefault(), "fail to create a file(%s) with an expected size of %d bytes.", new Object[]{str, Long.valueOf(j)}), th);
                }
            }
        } finally {
            this.f657b.unlock();
        }
    }

    /* renamed from: b */
    public boolean m924b(String str) {
        this.f657b.lock();
        try {
            if (this.f662g) {
                return false;
            }
            if (m918a(str)) {
                try {
                    this.f656a.m677b();
                    au.m893a(this.f656a, str);
                    this.f666k.remove(str);
                    this.f656a.m681f();
                    this.f656a.m678c();
                    this.f657b.unlock();
                    return true;
                } catch (Throwable th) {
                    this.f657b.unlock();
                    return false;
                }
            }
            this.f657b.unlock();
            return true;
        } finally {
            this.f657b.unlock();
        }
    }

    /* renamed from: a */
    public at m915a(at atVar) {
        if (atVar == null) {
            throw new IllegalArgumentException();
        }
        this.f657b.lock();
        try {
            at ayVar;
            if (atVar.getClass() == ay.class) {
                ayVar = new ay((ay) atVar);
            } else if (atVar.getClass() == az.class) {
                ayVar = new az((az) atVar);
            } else {
                throw new IllegalArgumentException();
            }
            if (ayVar.f683c) {
                ayVar.f681a.f680k.add(ayVar);
                aw awVar = ayVar.f682b;
                awVar.f669c++;
            }
            this.f657b.unlock();
            return ayVar;
        } catch (Throwable th) {
            this.f657b.unlock();
        }
    }

    /* renamed from: b */
    public at m921b(String str, String str2) {
        this.f657b.lock();
        try {
            if (this.f662g) {
                throw new IOException(String.format(Locale.getDefault(), "the repository(%s) is already closed.", new Object[]{this.f658c}));
            }
            if (!(m918a(str) || str2.equals("r"))) {
                m917a(str, 1024);
            }
            ax c = m910c(str);
            if (c == null) {
                throw new VirtualFileAssertionFailsException();
            } else if (this.f657b.isHeldByCurrentThread()) {
                aw awVar;
                at ayVar;
                if (!c.m927a()) {
                    c.f679j = m913e(c.f671b);
                }
                aw awVar2 = (aw) this.f664i.get(str2);
                if (awVar2 == null) {
                    awVar2 = new aw(new File(Uri.parse(this.f659d).getPath()), str2);
                    this.f664i.put(str2, awVar2);
                    awVar = awVar2;
                } else {
                    awVar = awVar2;
                }
                awVar.f669c++;
                if (str2.equals("r")) {
                    ayVar = new ay(c, awVar);
                } else {
                    ayVar = new az(c, awVar);
                }
                c.f680k.add(ayVar);
                this.f657b.unlock();
                return ayVar;
            } else {
                throw new VirtualFileAssertionFailsException();
            }
        } catch (Throwable th) {
            this.f657b.unlock();
        }
    }

    /* renamed from: a */
    public int m914a(at atVar, long j, byte[] bArr, int i, int i2) {
        ay ayVar = (ay) atVar;
        while (!ayVar.f682b.f668b.compareAndSet(null, Thread.currentThread())) {
            try {
                LockSupport.parkNanos(1000000);
            } catch (VirtualFileBrokenException e) {
                throw e;
            } catch (Throwable th) {
                ayVar.f682b.f668b.compareAndSet(Thread.currentThread(), null);
            }
        }
        ba[] baVarArr = ayVar.f681a.f679j;
        if (baVarArr.length < 1) {
            throw new VirtualFileAssertionFailsException();
        }
        long max = Math.max(0, Math.min((long) i2, ayVar.f681a.f675f.get() - j));
        if (max == 0) {
            ayVar.f682b.f668b.compareAndSet(Thread.currentThread(), null);
            return -1;
        }
        int i3 = 0;
        long j2 = 0;
        long j3 = baVarArr[0].f687c;
        r2 = 0;
        while (j >= j2) {
            if (j >= j3) {
                if (i3 < baVarArr.length - 1) {
                    i3++;
                    j2 += baVarArr[i3 - 1].f687c;
                    j3 = baVarArr[i3].f687c + j2;
                }
            }
            long j4 = j - j2;
            long min = Math.min((max - ((long) r2)) + j4, baVarArr[i3].f687c);
            if (j4 >= min) {
                break;
            }
            int i4 = (int) (min - j4);
            ayVar.f682b.seek(j4 + baVarArr[i3].f686b);
            i4 = ayVar.f682b.read(bArr, i + r2, i4);
            if (i4 < 0) {
                throw new VirtualFileBrokenException(String.format(Locale.getDefault(), "fail to read the file(%s) from %d to %d, cause it was broken at %d.", new Object[]{ayVar.f681a.f671b, Long.valueOf(j), Long.valueOf(((long) i2) + j), Integer.valueOf(i + r2)}));
            }
            r2 += i4;
            j += (long) i4;
        }
        if (r2 > 0) {
            ayVar.m928a(System.currentTimeMillis());
        }
        ayVar.f682b.f668b.compareAndSet(Thread.currentThread(), null);
        return r2;
    }

    /* renamed from: b */
    public int m920b(at atVar, long j, byte[] bArr, int i, int i2) {
        az azVar = (az) atVar;
        while (!azVar.b.f668b.compareAndSet(null, Thread.currentThread())) {
            try {
                LockSupport.parkNanos(1000000);
            } catch (Throwable th) {
                azVar.b.f668b.compareAndSet(Thread.currentThread(), null);
            }
        }
        ba[] baVarArr = azVar.a.f679j;
        if (baVarArr.length < 1) {
            throw new VirtualFileAssertionFailsException();
        }
        long j2 = (long) i2;
        if (j2 == 0) {
            azVar.b.f668b.compareAndSet(Thread.currentThread(), null);
            return 0;
        }
        ba[] baVarArr2;
        long j3 = 0;
        for (ba baVar : baVarArr) {
            j3 += baVar.f687c;
        }
        if (j + j2 > j3) {
            this.f657b.lock();
            m905a(azVar.a, j + j2);
            baVarArr = azVar.a.f679j;
            this.f657b.unlock();
            baVarArr2 = baVarArr;
        } else {
            baVarArr2 = baVarArr;
        }
        int i3 = 0;
        long j4 = 0;
        j3 = baVarArr2[0].f687c;
        r2 = 0;
        while (j >= j4) {
            if (j >= j3) {
                if (i3 < baVarArr2.length - 1) {
                    i3++;
                    j4 += baVarArr2[i3 - 1].f687c;
                    j3 = baVarArr2[i3].f687c + j4;
                }
            }
            long j5 = j - j4;
            long min = Math.min((j2 - ((long) r2)) + j5, baVarArr2[i3].f687c);
            if (j5 >= min) {
                break;
            }
            int i4 = (int) (min - j5);
            azVar.b.seek(j5 + baVarArr2[i3].f686b);
            azVar.b.write(bArr, i + r2, i4);
            r2 += i4;
            j += (long) i4;
        }
        if (r2 > 0) {
            azVar.m932b(j);
            azVar.m933c(System.currentTimeMillis());
        }
        azVar.b.f668b.compareAndSet(Thread.currentThread(), null);
        return r2;
    }

    /* renamed from: b */
    public void m923b(at atVar) {
        ay ayVar = (ay) atVar;
        if (ayVar.f683c) {
            this.f657b.lock();
            try {
                if (this.f662g) {
                    throw new IOException(String.format(Locale.getDefault(), "the repository(%s) is already closed.", new Object[]{this.f658c}));
                }
                this.f656a.m677b();
                az azVar;
                try {
                    long b = ayVar.mo413b();
                    long c = ayVar.m931c();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("file_size", Long.valueOf(b));
                    contentValues.put("last_access_time", Long.valueOf(c));
                    if (atVar instanceof az) {
                        azVar = (az) ayVar;
                        b = azVar.m934d();
                        azVar.b.getFD().sync();
                        contentValues.put("last_write_time", Long.valueOf(b));
                    }
                    au.m894a(this.f656a, ayVar.f681a.f670a, contentValues);
                    this.f656a.m681f();
                    this.f656a.m678c();
                } catch (Throwable th) {
                    this.f656a.m678c();
                }
            } finally {
                this.f657b.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public void m926c(at atVar) {
        atVar = (ay) atVar;
        if (atVar != null && atVar.f683c) {
            this.f657b.lock();
            try {
                m923b(atVar);
                atVar.f681a.f680k.remove(atVar);
                if (atVar.f681a.f680k.size() < 1) {
                    atVar.f681a.f679j = null;
                }
                atVar.f683c = false;
                aw awVar = atVar.f682b;
                int i = awVar.f669c - 1;
                awVar.f669c = i;
                if (i < 1) {
                }
            } finally {
                this.f657b.unlock();
            }
        }
    }

    /* renamed from: c */
    public void m925c() {
        this.f657b.lock();
        try {
            if (!this.f662g) {
                for (aw awVar : this.f664i.values()) {
                    try {
                        if (awVar.f669c > 0) {
                            awVar.close();
                        } else {
                            awVar.close();
                        }
                    } catch (Throwable th) {
                    }
                }
                this.f664i.clear();
                this.f662g = true;
            }
            this.f657b.unlock();
        } catch (Throwable th2) {
            this.f657b.unlock();
        }
    }

    /* renamed from: a */
    private void m905a(ax axVar, long j) {
        int i = 0;
        if (!this.f657b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.f662g) {
            throw new IOException(String.format(Locale.getDefault(), "the repository(%s) is already closed.", new Object[]{this.f658c}));
        } else {
            ba[] e = m913e(axVar.f671b);
            long j2 = 0;
            while (i < e.length) {
                j2 += e[i].f687c;
                i++;
            }
            if (j2 != j) {
                ba[] a;
                this.f656a.m677b();
                if (j2 < j) {
                    try {
                        a = m908a(e, j - j2);
                    } catch (Throwable th) {
                        this.f656a.m678c();
                    }
                } else {
                    a = e;
                }
                axVar.f671b = m904a(a);
                if (axVar.f679j == null) {
                    a = null;
                }
                axVar.f679j = a;
                ContentValues contentValues = new ContentValues();
                contentValues.put("space_uri", axVar.f671b);
                au.m894a(this.f656a, axVar.f670a, contentValues);
                this.f656a.m681f();
                this.f656a.m678c();
            }
        }
    }

    /* renamed from: a */
    private void m906a(ax axVar, String str) {
        if (!this.f657b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.f656a.m680e()) {
            String str2 = axVar.f670a;
            axVar.f670a = str;
            this.f666k.remove(str2);
            this.f666k.put(axVar.f670a, axVar);
            ContentValues contentValues = new ContentValues();
            contentValues.put("storage_uri", axVar.f670a);
            au.m894a(this.f656a, str2, contentValues);
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }

    /* renamed from: c */
    private ax m910c(String str) {
        if (this.f657b.isHeldByCurrentThread()) {
            ax axVar = (ax) this.f666k.get(str);
            if (axVar == null) {
                axVar = m912d(str);
                if (axVar != null) {
                }
            }
            return axVar;
        }
        throw new VirtualFileAssertionFailsException();
    }

    /* renamed from: d */
    private ax m912d(String str) {
        Throwable th;
        String str2 = null;
        if (this.f657b.isHeldByCurrentThread()) {
            Cursor c;
            try {
                c = au.m899c(this.f656a, str, "storage_uri", "space_uri", "creation_time", "last_access_time", "last_write_time", "file_size", "owner", "attributes", "metadata");
                try {
                    if (c.getCount() > 1) {
                        throw new IllegalArgumentException();
                    } else if (c.moveToFirst()) {
                        ax axVar = new ax(c.getString(0), c.getString(1), c.getLong(2));
                        axVar.f673d.set(c.getLong(3));
                        axVar.f674e.set(c.getLong(4));
                        axVar.f675f.set(c.getLong(5));
                        axVar.f676g = c.isNull(6) ? null : c.getString(6);
                        axVar.f677h = c.getInt(7);
                        if (!c.isNull(8)) {
                            str2 = c.getString(8);
                        }
                        axVar.f678i = str2;
                        this.f666k.put(str, axVar);
                        if (c != null) {
                            c.close();
                        }
                        return axVar;
                    } else if (c == null) {
                        return null;
                    } else {
                        c.close();
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c != null) {
                        c.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                c = null;
                th = th3;
                if (c != null) {
                    c.close();
                }
                throw th;
            }
        }
        throw new VirtualFileAssertionFailsException();
    }

    /* renamed from: c */
    private ax m911c(String str, String str2) {
        if (!this.f657b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.f656a.m680e()) {
            try {
                ax axVar = new ax(str, str2, System.currentTimeMillis());
                axVar.f677h = 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("storage_uri", axVar.f670a);
                contentValues.put("space_uri", axVar.f671b);
                contentValues.put("creation_time", Long.valueOf(axVar.f672c));
                contentValues.put("last_access_time", Long.valueOf(axVar.f673d.get()));
                contentValues.put("last_write_time", Long.valueOf(axVar.f674e.get()));
                contentValues.put("file_size", Long.valueOf(axVar.f675f.get()));
                contentValues.put("attributes", Integer.valueOf(axVar.f677h));
                if (axVar.f676g != null) {
                    contentValues.put("owner", axVar.f676g);
                } else {
                    contentValues.putNull("owner");
                }
                if (axVar.f678i != null) {
                    contentValues.put("metadata", axVar.f678i);
                } else {
                    contentValues.putNull("metadata");
                }
                au.m898b(this.f656a, contentValues);
                this.f666k.put(str, axVar);
                return axVar;
            } catch (Throwable th) {
                IOException iOException = new IOException(String.format(Locale.getDefault(), "fail to create a file(%s) at(%s).", new Object[]{str, str2}), th);
            }
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }

    /* renamed from: e */
    private ba[] m913e(String str) {
        if (this.f657b.isHeldByCurrentThread()) {
            try {
                long[] a = au.m895a(str);
                if (a.length < 1) {
                    throw new IllegalArgumentException();
                }
                ba[] baVarArr = new ba[a.length];
                for (int i = 0; i < baVarArr.length; i++) {
                    baVarArr[i] = (ba) this.f665j.get(au.m889a(this.f658c, a[i]));
                    if (baVarArr[i] == null) {
                        baVarArr[i] = m909b(a[i]);
                    }
                }
                return baVarArr;
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                IOException iOException = new IOException(String.format(Locale.getDefault(), "fail to load an atom space(%s).", new Object[]{str}), th);
            }
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }

    /* renamed from: a */
    private ba[] m908a(ba[] baVarArr, long j) {
        if (this.f657b.isHeldByCurrentThread()) {
            ba[] a = m907a(j);
            ba[] baVarArr2 = (ba[]) Arrays.copyOf(baVarArr, baVarArr.length + a.length);
            for (int length = baVarArr.length; length < baVarArr2.length; length++) {
                baVarArr2[length] = a[length - baVarArr.length];
            }
            return baVarArr2;
        }
        throw new VirtualFileAssertionFailsException();
    }

    /* renamed from: a */
    private ba[] m907a(long j) {
        IOException e;
        Throwable th;
        if (!this.f657b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.f656a.m680e()) {
            Cursor cursor = null;
            try {
                Cursor cursor2;
                if (this.f663h < 0) {
                    cursor = au.m902d(this.f656a, au.m889a(this.f658c, new long[0]), "offset", "size");
                    if (cursor.moveToLast()) {
                        this.f663h = cursor.getLong(0) + cursor.getLong(1);
                        cursor2 = cursor;
                    } else {
                        this.f663h = 0;
                        cursor2 = cursor;
                    }
                } else {
                    cursor2 = null;
                }
                try {
                    this.f663h += m903a(this.f663h, j, 1).f687c;
                    ba[] baVarArr = new ba[]{r0};
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return baVarArr;
                } catch (IOException e2) {
                    e = e2;
                    cursor = cursor2;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                throw new IOException(String.format(Locale.getDefault(), "fail to allocate atom spaces of size %d bytes.", new Object[]{Long.valueOf(j)}), th);
            }
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }

    /* renamed from: b */
    private ba m909b(long j) {
        Throwable th;
        if (this.f657b.isHeldByCurrentThread()) {
            Cursor cursor = null;
            try {
                String a = au.m889a(this.f658c, j);
                Cursor d = au.m902d(this.f656a, a, "uri", "offset", "size", "state");
                try {
                    if (d.getCount() == 1 && d.moveToFirst()) {
                        d.moveToFirst();
                        ba baVar = new ba(d.getString(0), d.getLong(1), d.getLong(2));
                        baVar.f688d = d.getInt(3);
                        this.f665j.put(a, baVar);
                        if (d != null) {
                            d.close();
                        }
                        return baVar;
                    }
                    throw new IllegalArgumentException();
                } catch (Throwable th2) {
                    th = th2;
                    cursor = d;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw new IOException(String.format(Locale.getDefault(), "fail to load an atom space at %d.", new Object[]{Long.valueOf(j)}), th);
            }
        }
        throw new VirtualFileAssertionFailsException();
    }

    /* renamed from: a */
    private ba m903a(long j, long j2, int i) {
        if (!this.f657b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.f656a.m680e()) {
            long max = Math.max(1, j2);
            try {
                String a = au.m889a(this.f658c, j);
                ba baVar = new ba(a, j, max);
                baVar.f688d = i;
                ContentValues contentValues = new ContentValues();
                contentValues.put("uri", baVar.f685a);
                contentValues.put("offset", Long.valueOf(baVar.f686b));
                contentValues.put("size", Long.valueOf(baVar.f687c));
                contentValues.put("state", Integer.valueOf(baVar.f688d));
                au.m901c(this.f656a, contentValues);
                this.f665j.put(a, baVar);
                return baVar;
            } catch (Throwable th) {
                IOException iOException = new IOException(String.format(Locale.getDefault(), "fail to create an atom space at [%d, %d).", new Object[]{Long.valueOf(j), Long.valueOf(max + j)}), th);
            }
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }

    /* renamed from: a */
    private String m904a(ba[] baVarArr) {
        long[] jArr = new long[baVarArr.length];
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = baVarArr[i].f686b;
        }
        return au.m889a(this.f658c, jArr);
    }
}
