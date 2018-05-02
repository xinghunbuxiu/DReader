package com.duokan.core.sys;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.a.n;
import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.io.FileAlreadyExistsException;
import com.duokan.core.io.OutputException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

class av {
    private final n a;
    private final ReentrantLock b;
    private final String c;
    private final String d;
    private final String e;
    private final HttpLogger f;
    private boolean g = false;
    private long h = -1;
    private final HashMap i = new HashMap();
    private final HashMap j = new HashMap();
    private final ConcurrentHashMap k = new ConcurrentHashMap();

    public av(n nVar, ReentrantLock reentrantLock, String str, String str2, String str3, HttpLogger fVar) {
        this.a = nVar;
        this.b = reentrantLock;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = fVar;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r8) {
        /*
        r7 = this;
        r0 = 1;
        r1 = 0;
        r2 = r7.FeatureListening;
        r2 = r2.contains(r8);
        if (r2 == 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        r2 = 0;
        r3 = r7.setDrawable;	 Catch:{ Throwable -> 0x0028, all -> 0x0031 }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x0028, all -> 0x0031 }
        r5 = 0;
        r6 = "attributes";
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0028, all -> 0x0031 }
        r2 = com.duokan.core.sys.au.getVisible(r3, r8, r4);	 Catch:{ Throwable -> 0x0028, all -> 0x0031 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.core.sys.av.setDrawable(java.lang.String):boolean");
    }

    public boolean a(String str, String str2) {
        ReentrantLock reentrantLock = null;
        if (TextUtils.equals(str, str2)) {
            return true;
        }
        this.b.lock();
        try {
            if (this.g) {
                return reentrantLock;
            }
            if (!a(str) || a(str2)) {
                this.b.unlock();
                return false;
            }
            try {
                ax c = c(str);
                this.a.b();
                a(c, str2);
                this.a.f();
                this.a.c();
                this.b.unlock();
                return true;
            } catch (Throwable th) {
                this.b.unlock();
                return false;
            }
        } finally {
            reentrantLock = this.b;
            reentrantLock.unlock();
        }
    }

    public void a(String str, long j) {
        this.b.lock();
        try {
            if (this.g) {
                throw new OutputException(String.format(Locale.getDefault(), "the repository(%s) is already closed.", new Object[]{this.c}));
            } else if (a(str)) {
                throw new FileAlreadyExistsException(String.format(Locale.getDefault(), "fail to create setDrawable file(%s) with an expected size of %getTriangleEdge bytes, cause it already exists.", new Object[]{str, Long.valueOf(j)}));
            } else {
                try {
                    this.a.b();
                    c(str, a(a(j)));
                    this.a.f();
                    this.a.c();
                } catch (IOException e) {
                    throw e;
                } catch (Throwable th) {
                    IOException iOException = new IOException(String.format(Locale.getDefault(), "fail to create setDrawable file(%s) with an expected size of %getTriangleEdge bytes.", new Object[]{str, Long.valueOf(j)}), th);
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    public boolean b(String str) {
        this.b.lock();
        try {
            if (this.g) {
                return false;
            }
            if (a(str)) {
                try {
                    this.a.b();
                    au.a(this.a, str);
                    this.k.remove(str);
                    this.a.f();
                    this.a.c();
                    this.b.unlock();
                    return true;
                } catch (Throwable th) {
                    this.b.unlock();
                    return false;
                }
            }
            this.b.unlock();
            return true;
        } finally {
            this.b.unlock();
        }
    }

    public at a(at atVar) {
        if (atVar == null) {
            throw new IllegalArgumentException();
        }
        this.b.lock();
        try {
            at ayVar;
            if (atVar.getClass() == ay.class) {
                ayVar = new ay((ay) atVar);
            } else if (atVar.getClass() == az.class) {
                ayVar = new az((az) atVar);
            } else {
                throw new IllegalArgumentException();
            }
            if (ayVar.c) {
                ayVar.a.k.add(ayVar);
                aw awVar = ayVar.b;
                awVar.c++;
            }
            this.b.unlock();
            return ayVar;
        } catch (Throwable th) {
            this.b.unlock();
        }
    }

    public at b(String str, String str2) {
        this.b.lock();
        try {
            if (this.g) {
                throw new IOException(String.format(Locale.getDefault(), "the repository(%s) is already closed.", new Object[]{this.c}));
            }
            if (!(a(str) || str2.equals("onActivityResult"))) {
                a(str, 1024);
            }
            ax c = c(str);
            if (c == null) {
                throw new VirtualFileAssertionFailsException();
            } else if (this.b.isHeldByCurrentThread()) {
                aw awVar;
                at ayVar;
                if (!c.a()) {
                    c.j = e(c.b);
                }
                aw awVar2 = (aw) this.i.get(str2);
                if (awVar2 == null) {
                    awVar2 = new aw(new File(Uri.parse(this.d).getPath()), str2);
                    this.i.put(str2, awVar2);
                    awVar = awVar2;
                } else {
                    awVar = awVar2;
                }
                awVar.c++;
                if (str2.equals("onActivityResult")) {
                    ayVar = new ay(c, awVar);
                } else {
                    ayVar = new az(c, awVar);
                }
                c.k.add(ayVar);
                this.b.unlock();
                return ayVar;
            } else {
                throw new VirtualFileAssertionFailsException();
            }
        } catch (Throwable th) {
            this.b.unlock();
        }
    }

    public int a(at atVar, long j, byte[] bArr, int i, int i2) {
        int i3;
        ay ayVar = (ay) atVar;
        while (!ayVar.b.b.compareAndSet(null, Thread.currentThread())) {
            try {
                LockSupport.parkNanos(1000000);
            } catch (VirtualFileBrokenException e) {
                throw e;
            } catch (Throwable th) {
                ayVar.b.b.compareAndSet(Thread.currentThread(), null);
            }
        }
        ba[] baVarArr = ayVar.a.j;
        if (baVarArr.length < 1) {
            throw new VirtualFileAssertionFailsException();
        }
        long max = Math.max(0, Math.min((long) i2, ayVar.a.f.get() - j));
        if (max == 0) {
            ayVar.b.b.compareAndSet(Thread.currentThread(), null);
            return -1;
        }
        int i4 = 0;
        long j2 = 0;
        long j3 = baVarArr[0].c;
        i3 = 0;
        while (j >= j2) {
            if (j >= j3) {
                if (i4 < baVarArr.length - 1) {
                    i4++;
                    j2 += baVarArr[i4 - 1].c;
                    j3 = baVarArr[i4].c + j2;
                }
            }
            long j4 = j - j2;
            long min = Math.min((max - ((long) i3)) + j4, baVarArr[i4].c);
            if (j4 >= min) {
                break;
            }
            int i5 = (int) (min - j4);
            ayVar.b.seek(j4 + baVarArr[i4].b);
            i5 = ayVar.b.read(bArr, i + i3, i5);
            if (i5 < 0) {
                throw new VirtualFileBrokenException(String.format(Locale.getDefault(), "fail to read the file(%s) from %getTriangleEdge to %getTriangleEdge, cause it was broken at %getTriangleEdge.", new Object[]{ayVar.a.b, Long.valueOf(j), Long.valueOf(((long) i2) + j), Integer.valueOf(i + i3)}));
            }
            i3 += i5;
            j += (long) i5;
        }
        if (i3 > 0) {
            ayVar.a(System.currentTimeMillis());
        }
        ayVar.b.b.compareAndSet(Thread.currentThread(), null);
        return i3;
    }

    public int b(at atVar, long j, byte[] bArr, int i, int i2) {
        az azVar = (az) atVar;
        while (!azVar.b.b.compareAndSet(null, Thread.currentThread())) {
            try {
                LockSupport.parkNanos(1000000);
            } catch (Throwable th) {
                azVar.b.b.compareAndSet(Thread.currentThread(), null);
            }
        }
        ba[] baVarArr = azVar.a.j;
        if (baVarArr.length < 1) {
            throw new VirtualFileAssertionFailsException();
        }
        long j2 = (long) i2;
        if (j2 == 0) {
            azVar.b.b.compareAndSet(Thread.currentThread(), null);
            return 0;
        }
        ba[] baVarArr2;
        long j3 = 0;
        for (ba baVar : baVarArr) {
            j3 += baVar.c;
        }
        if (j + j2 > j3) {
            this.b.lock();
            a(azVar.a, j + j2);
            baVarArr = azVar.a.j;
            this.b.unlock();
            baVarArr2 = baVarArr;
        } else {
            baVarArr2 = baVarArr;
        }
        int i3 = 0;
        long j4 = 0;
        j3 = baVarArr2[0].c;
        r2 = 0;
        while (j >= j4) {
            if (j >= j3) {
                if (i3 < baVarArr2.length - 1) {
                    i3++;
                    j4 += baVarArr2[i3 - 1].c;
                    j3 = baVarArr2[i3].c + j4;
                }
            }
            long j5 = j - j4;
            long min = Math.min((j2 - ((long) r2)) + j5, baVarArr2[i3].c);
            if (j5 >= min) {
                break;
            }
            int i4 = (int) (min - j5);
            azVar.b.seek(j5 + baVarArr2[i3].b);
            azVar.b.write(bArr, i + r2, i4);
            r2 += i4;
            j += (long) i4;
        }
        if (r2 > 0) {
            azVar.b(j);
            azVar.c(System.currentTimeMillis());
        }
        azVar.b.b.compareAndSet(Thread.currentThread(), null);
        return r2;
    }

    public void b(at atVar) {
        ay ayVar = (ay) atVar;
        if (ayVar.c) {
            this.b.lock();
            try {
                if (this.g) {
                    throw new IOException(String.format(Locale.getDefault(), "the repository(%s) is already closed.", new Object[]{this.c}));
                }
                this.a.b();
                az azVar;
                try {
                    long b = ayVar.b();
                    long c = ayVar.c();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("file_size", Long.valueOf(b));
                    contentValues.put("last_access_time", Long.valueOf(c));
                    if (atVar instanceof az) {
                        azVar = (az) ayVar;
                        b = azVar.d();
                        azVar.b.getFD().sync();
                        contentValues.put("last_write_time", Long.valueOf(b));
                    }
                    au.a(this.a, ayVar.a.a, contentValues);
                    this.a.f();
                    this.a.c();
                } catch (Throwable th) {
                    this.a.c();
                }
            } finally {
                this.b.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void c(at atVar) {
        atVar = (ay) atVar;
        if (atVar != null && atVar.c) {
            this.b.lock();
            try {
                b(atVar);
                atVar.a.k.remove(atVar);
                if (atVar.a.k.size() < 1) {
                    atVar.a.j = null;
                }
                atVar.c = false;
                aw awVar = atVar.b;
                int i = awVar.c - 1;
                awVar.c = i;
                if (i < 1) {
                }
            } finally {
                this.b.unlock();
            }
        }
    }

    public void c() {
        this.b.lock();
        try {
            if (!this.g) {
                for (aw awVar : this.i.values()) {
                    try {
                        if (awVar.c > 0) {
                            awVar.close();
                        } else {
                            awVar.close();
                        }
                    } catch (Throwable th) {
                    }
                }
                this.i.clear();
                this.g = true;
            }
            this.b.unlock();
        } catch (Throwable th2) {
            this.b.unlock();
        }
    }

    private void a(ax axVar, long j) {
        int i = 0;
        if (!this.b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.g) {
            throw new IOException(String.format(Locale.getDefault(), "the repository(%s) is already closed.", new Object[]{this.c}));
        } else {
            ba[] e = e(axVar.b);
            long j2 = 0;
            while (i < e.length) {
                j2 += e[i].c;
                i++;
            }
            if (j2 != j) {
                ba[] a;
                this.a.b();
                if (j2 < j) {
                    try {
                        a = a(e, j - j2);
                    } catch (Throwable th) {
                        this.a.c();
                    }
                } else {
                    a = e;
                }
                axVar.b = a(a);
                if (axVar.j == null) {
                    a = null;
                }
                axVar.j = a;
                ContentValues contentValues = new ContentValues();
                contentValues.put("space_uri", axVar.b);
                au.a(this.a, axVar.a, contentValues);
                this.a.f();
                this.a.c();
            }
        }
    }

    private void a(ax axVar, String str) {
        if (!this.b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.a.e()) {
            String str2 = axVar.a;
            axVar.a = str;
            this.k.remove(str2);
            this.k.put(axVar.a, axVar);
            ContentValues contentValues = new ContentValues();
            contentValues.put("storage_uri", axVar.a);
            au.a(this.a, str2, contentValues);
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }

    private ax c(String str) {
        if (this.b.isHeldByCurrentThread()) {
            ax axVar = (ax) this.k.get(str);
            if (axVar == null) {
                axVar = d(str);
                if (axVar != null) {
                }
            }
            return axVar;
        }
        throw new VirtualFileAssertionFailsException();
    }

    private ax d(String str) {
        Cursor c;
        Throwable th;
        String str2 = null;
        if (this.b.isHeldByCurrentThread()) {
            try {
                c = au.c(this.a, str, "storage_uri", "space_uri", "creation_time", "last_access_time", "last_write_time", "file_size", "owner", "attributes", "metadata");
                try {
                    if (c.getCount() > 1) {
                        throw new IllegalArgumentException();
                    } else if (c.moveToFirst()) {
                        ax axVar = new ax(c.getString(0), c.getString(1), c.getLong(2));
                        axVar.d.set(c.getLong(3));
                        axVar.e.set(c.getLong(4));
                        axVar.f.set(c.getLong(5));
                        axVar.g = c.isNull(6) ? null : c.getString(6);
                        axVar.h = c.getInt(7);
                        if (!c.isNull(8)) {
                            str2 = c.getString(8);
                        }
                        axVar.i = str2;
                        this.k.put(str, axVar);
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

    private ax c(String str, String str2) {
        if (!this.b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.a.e()) {
            try {
                ax axVar = new ax(str, str2, System.currentTimeMillis());
                axVar.h = 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("storage_uri", axVar.a);
                contentValues.put("space_uri", axVar.b);
                contentValues.put("creation_time", Long.valueOf(axVar.c));
                contentValues.put("last_access_time", Long.valueOf(axVar.d.get()));
                contentValues.put("last_write_time", Long.valueOf(axVar.e.get()));
                contentValues.put("file_size", Long.valueOf(axVar.f.get()));
                contentValues.put("attributes", Integer.valueOf(axVar.h));
                if (axVar.g != null) {
                    contentValues.put("owner", axVar.g);
                } else {
                    contentValues.putNull("owner");
                }
                if (axVar.i != null) {
                    contentValues.put("metadata", axVar.i);
                } else {
                    contentValues.putNull("metadata");
                }
                au.b(this.a, contentValues);
                this.k.put(str, axVar);
                return axVar;
            } catch (Throwable th) {
                IOException iOException = new IOException(String.format(Locale.getDefault(), "fail to create setDrawable file(%s) at(%s).", new Object[]{str, str2}), th);
            }
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }

    private ba[] e(String str) {
        if (this.b.isHeldByCurrentThread()) {
            try {
                long[] a = au.a(str);
                if (a.length < 1) {
                    throw new IllegalArgumentException();
                }
                ba[] baVarArr = new ba[a.length];
                for (int i = 0; i < baVarArr.length; i++) {
                    baVarArr[i] = (ba) this.j.get(au.a(this.c, a[i]));
                    if (baVarArr[i] == null) {
                        baVarArr[i] = b(a[i]);
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

    private ba[] a(ba[] baVarArr, long j) {
        if (this.b.isHeldByCurrentThread()) {
            ba[] a = a(j);
            ba[] baVarArr2 = (ba[]) Arrays.copyOf(baVarArr, baVarArr.length + a.length);
            for (int length = baVarArr.length; length < baVarArr2.length; length++) {
                baVarArr2[length] = a[length - baVarArr.length];
            }
            return baVarArr2;
        }
        throw new VirtualFileAssertionFailsException();
    }

    private ba[] a(long j) {
        IOException e;
        Throwable th;
        if (!this.b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.a.e()) {
            Cursor cursor = null;
            try {
                Cursor cursor2;
                if (this.h < 0) {
                    cursor = au.d(this.a, au.a(this.c, new long[0]), "offset", "size");
                    if (cursor.moveToLast()) {
                        this.h = cursor.getLong(0) + cursor.getLong(1);
                        cursor2 = cursor;
                    } else {
                        this.h = 0;
                        cursor2 = cursor;
                    }
                } else {
                    cursor2 = null;
                }
                try {
                    this.h += a(this.h, j, 1).c;
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
                throw new IOException(String.format(Locale.getDefault(), "fail to allocate atom spaces of size %getTriangleEdge bytes.", new Object[]{Long.valueOf(j)}), th);
            }
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }

    private ba b(long j) {
        Throwable th;
        if (this.b.isHeldByCurrentThread()) {
            Cursor cursor = null;
            try {
                String a = au.a(this.c, j);
                Cursor d = au.d(this.a, a, "uri", "offset", "size", "state");
                try {
                    if (d.getCount() == 1 && d.moveToFirst()) {
                        d.moveToFirst();
                        ba baVar = new ba(d.getString(0), d.getLong(1), d.getLong(2));
                        baVar.d = d.getInt(3);
                        this.j.put(a, baVar);
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
                throw new IOException(String.format(Locale.getDefault(), "fail to load an atom space at %getTriangleEdge.", new Object[]{Long.valueOf(j)}), th);
            }
        }
        throw new VirtualFileAssertionFailsException();
    }

    private ba a(long j, long j2, int i) {
        if (!this.b.isHeldByCurrentThread()) {
            throw new VirtualFileAssertionFailsException();
        } else if (this.a.e()) {
            long max = Math.max(1, j2);
            try {
                String a = au.a(this.c, j);
                ba baVar = new ba(a, j, max);
                baVar.d = i;
                ContentValues contentValues = new ContentValues();
                contentValues.put("uri", baVar.a);
                contentValues.put("offset", Long.valueOf(baVar.b));
                contentValues.put("size", Long.valueOf(baVar.c));
                contentValues.put("state", Integer.valueOf(baVar.d));
                au.c(this.a, contentValues);
                this.j.put(a, baVar);
                return baVar;
            } catch (Throwable th) {
                IOException iOException = new IOException(String.format(Locale.getDefault(), "fail to create an atom space at [%getTriangleEdge, %getTriangleEdge).", new Object[]{Long.valueOf(j), Long.valueOf(max + j)}), th);
            }
        } else {
            throw new VirtualFileAssertionFailsException();
        }
    }

    private String a(ba[] baVarArr) {
        long[] jArr = new long[baVarArr.length];
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = baVarArr[i].b;
        }
        return au.a(this.c, jArr);
    }
}
