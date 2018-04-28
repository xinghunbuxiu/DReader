package com.duokan.core.sys;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.Semaphore;

public class AsyncCache {
    /* renamed from: a */
    static final /* synthetic */ boolean f582a = (!AsyncCache.class.desiredAssertionStatus());
    /* renamed from: b */
    private final LinkedHashMap<Integer, RecordList> f583b;
    /* renamed from: c */
    private final Thread f584c;
    /* renamed from: d */
    private final Semaphore f585d;
    /* renamed from: e */
    private LinkedList<Runnable> f586e;
    /* renamed from: f */
    private boolean f587f;
    /* renamed from: g */
    private int f588g;
    /* renamed from: h */
    private int f589h;
    /* renamed from: i */
    private final String f590i;
    /* renamed from: j */
    private final SQLiteDatabase f591j;

    public enum DataState {
        NULL,
        UNFILLED,
        FILLED,
        EMPTY
    }

    public class RecordList extends LinkedList<C0359g> {
        protected RecordList() {
        }
    }

    public AsyncCache() {
        this(null);
    }

    public AsyncCache(String str) {
        this.f583b = new LinkedHashMap();
        this.f585d = new Semaphore(0);
        this.f586e = new LinkedList();
        this.f587f = false;
        this.f588g = 0;
        this.f589h = 3145728;
        this.f590i = str;
        if (TextUtils.isEmpty(this.f590i)) {
            this.f591j = null;
        } else {
            SQLiteDatabase openOrCreateDatabase;
            try {
                openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(new File(Uri.parse(str).getPath(), "index.db"), null);
                openOrCreateDatabase.beginTransaction();
                if (openOrCreateDatabase.getVersion() < 1) {
                    openOrCreateDatabase.execSQL(String.format("CREATE TABLE %1$s(2$s INTEGER PRIMARY KEY, 3$s INTEGER, 4$s BLOB)", new Object[]{"indices", "index_id", "hash_code", "key"}));
                }
                openOrCreateDatabase.setVersion(1);
                openOrCreateDatabase.setTransactionSuccessful();
                openOrCreateDatabase.endTransaction();
            } catch (Exception e) {
                e.printStackTrace();
                openOrCreateDatabase = null;
            } catch (Throwable th) {
                openOrCreateDatabase.endTransaction();
            }
            this.f591j = openOrCreateDatabase;
        }
        this.f584c = new Thread(new C0349a(this));
        this.f584c.start();
    }

    /* renamed from: a */
    public void m814a(int i) {
        this.f589h = i;
    }

    /* renamed from: a */
    public final C0357e m813a(C0358f c0358f, C0357e c0357e) {
        C0357e c0357e2;
        synchronized (m811c()) {
            C0359g c0359g = new C0359g(c0358f, c0357e);
            c0359g.f726b.m1003p();
            m808b(c0359g);
            this.f585d.release();
            c0357e2 = c0359g.f726b;
        }
        return c0357e2;
    }

    /* renamed from: a */
    public final C0357e m812a(C0358f c0358f, int i) {
        C0357e c0357e;
        synchronized (m811c()) {
            C0359g a = m799a(c0358f, i, new C0351b(this));
            if (a != null) {
                m803a(a);
                a.f726b.m1003p();
                c0357e = a.f726b;
            } else {
                c0357e = null;
            }
        }
        return c0357e;
    }

    /* renamed from: a */
    public final void m815a(C0357e c0357e) {
        synchronized (m811c()) {
            c0357e.m1004q();
        }
    }

    /* renamed from: b */
    public final void m818b(C0357e c0357e) {
        synchronized (m811c()) {
            c0357e.m1004q();
            c0357e.m1013f();
        }
    }

    /* renamed from: a */
    public final void m816a(boolean z) {
        Semaphore semaphore = new Semaphore(0);
        m817a(new C0355c(this, semaphore));
        if (z) {
            semaphore.acquireUninterruptibly();
        }
    }

    /* renamed from: a */
    public final boolean m817a(Runnable runnable) {
        if (this.f587f || runnable == null) {
            return false;
        }
        synchronized (m811c()) {
            this.f586e.push(runnable);
        }
        this.f585d.release();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m801a() {
        /*
        r11 = this;
        r10 = 1;
    L_0x0001:
        r0 = r11.f587f;
        if (r0 != 0) goto L_0x0279;
    L_0x0005:
        r0 = r11.f585d;
        r0 = r0.availablePermits();
        if (r0 >= r10) goto L_0x003a;
    L_0x000d:
        r0 = r11.f586e;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x003a;
    L_0x0015:
        r1 = r11.m811c();
        monitor-enter(r1);
        r2 = r11.f586e;	 Catch:{ all -> 0x0037 }
        r0 = new java.util.LinkedList;	 Catch:{ all -> 0x0037 }
        r0.<init>();	 Catch:{ all -> 0x0037 }
        r11.f586e = r0;	 Catch:{ all -> 0x0037 }
        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
    L_0x0024:
        r0 = r2.isEmpty();
        if (r0 != 0) goto L_0x003a;
    L_0x002a:
        r0 = r2.getFirst();
        r0 = (java.lang.Runnable) r0;
        r0.run();
        r2.removeFirst();
        goto L_0x0024;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
        throw r0;
    L_0x003a:
        r0 = r11.f585d;
        r0.acquireUninterruptibly();
        r1 = 0;
        r2 = r11.m811c();
        monitor-enter(r2);
        r0 = 1;
        r3 = r11.m807b(r0);	 Catch:{ all -> 0x0062 }
    L_0x004a:
        r0 = r3.hasPrevious();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x006d;
    L_0x0050:
        r0 = r3.previous();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.C0359g) r0;	 Catch:{ all -> 0x0062 }
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1010c();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x0065;
    L_0x005e:
        r3.remove();	 Catch:{ all -> 0x0062 }
        goto L_0x004a;
    L_0x0062:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0062 }
        throw r0;
    L_0x0065:
        if (r1 != 0) goto L_0x02cb;
    L_0x0067:
        r4 = r0.f727c;	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x02cb;
    L_0x006b:
        r1 = r0;
        goto L_0x004a;
    L_0x006d:
        if (r1 != 0) goto L_0x0071;
    L_0x006f:
        monitor-exit(r2);	 Catch:{ all -> 0x0062 }
        goto L_0x0001;
    L_0x0071:
        r0 = f582a;	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x007f;
    L_0x0075:
        r0 = r1.f727c;	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x007f;
    L_0x0079:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x007f:
        r0 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1007a();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x01b7;
    L_0x0087:
        r0 = 0;
        r3 = r11.m807b(r0);	 Catch:{ all -> 0x0062 }
    L_0x008c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x00f6;
    L_0x0092:
        r0 = r3.next();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.C0359g) r0;	 Catch:{ all -> 0x0062 }
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1007a();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x008c;
    L_0x00a0:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1012e();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x008c;
    L_0x00a8:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.mo771i();	 Catch:{ all -> 0x0062 }
        r5 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r5 = r5.mo770h();	 Catch:{ all -> 0x0062 }
        if (r4 < r5) goto L_0x008c;
    L_0x00b6:
        r4 = f582a;	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x00c8;
    L_0x00ba:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1011d();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x00c8;
    L_0x00c2:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x00c8:
        r4 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r5 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1000h(r5);	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x008c;
    L_0x00d2:
        r3 = f582a;	 Catch:{ all -> 0x0062 }
        if (r3 != 0) goto L_0x00e4;
    L_0x00d6:
        r0 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1010c();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x00e4;
    L_0x00de:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x00e4:
        r0 = f582a;	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x00f6;
    L_0x00e8:
        r0 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1009b();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x00f6;
    L_0x00f0:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x00f6:
        r0 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1009b();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0168;
    L_0x00fe:
        r0 = r11.f588g;	 Catch:{ all -> 0x0062 }
        r3 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r3 = r3.mo770h();	 Catch:{ all -> 0x0062 }
        r0 = r0 + r3;
        r3 = r11.f589h;	 Catch:{ all -> 0x0062 }
        if (r0 <= r3) goto L_0x0168;
    L_0x010b:
        r0 = 0;
        r3 = r11.m807b(r0);	 Catch:{ all -> 0x0062 }
    L_0x0110:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0168;
    L_0x0116:
        r0 = r3.next();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.C0359g) r0;	 Catch:{ all -> 0x0062 }
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1011d();	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x0110;
    L_0x0124:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1012e();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x0110;
    L_0x012c:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.mo771i();	 Catch:{ all -> 0x0062 }
        r5 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r5 = r5.mo770h();	 Catch:{ all -> 0x0062 }
        if (r4 < r5) goto L_0x0110;
    L_0x013a:
        r4 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r5 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1000h(r5);	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x0110;
    L_0x0144:
        r3 = f582a;	 Catch:{ all -> 0x0062 }
        if (r3 != 0) goto L_0x0156;
    L_0x0148:
        r0 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1010c();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x0156;
    L_0x0150:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x0156:
        r0 = f582a;	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x0168;
    L_0x015a:
        r0 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1009b();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0168;
    L_0x0162:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x0168:
        r0 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1009b();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0191;
    L_0x0170:
        r0 = 0;
        r3 = r11.m807b(r0);	 Catch:{ all -> 0x0062 }
    L_0x0175:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0191;
    L_0x017b:
        r0 = r3.next();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.C0359g) r0;	 Catch:{ all -> 0x0062 }
        r4 = r11.f588g;	 Catch:{ all -> 0x0062 }
        r4 = (double) r4;	 Catch:{ all -> 0x0062 }
        r6 = r11.f589h;	 Catch:{ all -> 0x0062 }
        r6 = (double) r6;	 Catch:{ all -> 0x0062 }
        r8 = 4603579539098121011; // 0x3fe3333333333333 float:4.172325E-8 double:0.6;
        r6 = r6 * r8;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 > 0) goto L_0x01ec;
    L_0x0191:
        r0 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1009b();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x01b7;
    L_0x0199:
        r0 = 0;
        r3 = r11.m807b(r0);	 Catch:{ all -> 0x0062 }
    L_0x019e:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x01b7;
    L_0x01a4:
        r0 = r3.next();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.C0359g) r0;	 Catch:{ all -> 0x0062 }
        r4 = r11.f588g;	 Catch:{ all -> 0x0062 }
        r5 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r5 = r5.mo770h();	 Catch:{ all -> 0x0062 }
        r4 = r4 + r5;
        r5 = r11.f589h;	 Catch:{ all -> 0x0062 }
        if (r4 > r5) goto L_0x0230;
    L_0x01b7:
        r0 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1009b();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x01df;
    L_0x01bf:
        r0 = r11.f588g;	 Catch:{ all -> 0x0062 }
        r3 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r3 = r3.mo770h();	 Catch:{ all -> 0x0062 }
        r0 = r0 + r3;
        r3 = r11.f589h;	 Catch:{ all -> 0x0062 }
        if (r0 > r3) goto L_0x01df;
    L_0x01cc:
        r0 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1001n();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x01df;
    L_0x01d4:
        r0 = r11.f588g;	 Catch:{ all -> 0x0062 }
        r3 = r1.f726b;	 Catch:{ all -> 0x0062 }
        r3 = r3.mo771i();	 Catch:{ all -> 0x0062 }
        r0 = r0 + r3;
        r11.f588g = r0;	 Catch:{ all -> 0x0062 }
    L_0x01df:
        monitor-exit(r2);	 Catch:{ all -> 0x0062 }
        r0 = f582a;
        if (r0 != 0) goto L_0x0262;
    L_0x01e4:
        if (r1 != 0) goto L_0x0262;
    L_0x01e6:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x01ec:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1007a();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x0175;
    L_0x01f4:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1012e();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x0175;
    L_0x01fc:
        r4 = f582a;	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x020e;
    L_0x0200:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1011d();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x020e;
    L_0x0208:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x020e:
        r4 = r11.f588g;	 Catch:{ all -> 0x0062 }
        r5 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r5 = r5.mo771i();	 Catch:{ all -> 0x0062 }
        r4 = r4 - r5;
        r11.f588g = r4;	 Catch:{ all -> 0x0062 }
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4.m1002o();	 Catch:{ all -> 0x0062 }
        r4 = f582a;	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x0175;
    L_0x0222:
        r0 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1010c();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x0175;
    L_0x022a:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x0230:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1011d();	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x019e;
    L_0x0238:
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4 = r4.m1012e();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x019e;
    L_0x0240:
        r4 = r11.f588g;	 Catch:{ all -> 0x0062 }
        r5 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r5 = r5.mo771i();	 Catch:{ all -> 0x0062 }
        r4 = r4 - r5;
        r11.f588g = r4;	 Catch:{ all -> 0x0062 }
        r4 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r4.m1002o();	 Catch:{ all -> 0x0062 }
        r4 = f582a;	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x019e;
    L_0x0254:
        r0 = r0.f726b;	 Catch:{ all -> 0x0062 }
        r0 = r0.m1010c();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x019e;
    L_0x025c:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<init>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x0262:
        r0 = r1.f726b;
        r0 = r0.m1009b();
        if (r0 != 0) goto L_0x0273;
    L_0x026a:
        r0 = r1.f726b;
        r0.m1005r();
    L_0x026f:
        r1.f727c = r10;
        goto L_0x0001;
    L_0x0273:
        r0 = r1.f726b;
        r0.m1006s();
        goto L_0x026f;
    L_0x0279:
        r1 = r11.m811c();
        monitor-enter(r1);
        r0 = 0;
        r2 = r11.m807b(r0);	 Catch:{ all -> 0x02a1 }
    L_0x0283:
        r0 = r2.hasNext();	 Catch:{ all -> 0x02a1 }
        if (r0 == 0) goto L_0x02c9;
    L_0x0289:
        r0 = r2.next();	 Catch:{ all -> 0x02a1 }
        r0 = (com.duokan.core.sys.C0359g) r0;	 Catch:{ all -> 0x02a1 }
        r3 = f582a;	 Catch:{ all -> 0x02a1 }
        if (r3 != 0) goto L_0x02a4;
    L_0x0293:
        r3 = r0.f726b;	 Catch:{ all -> 0x02a1 }
        r3 = r3.m1011d();	 Catch:{ all -> 0x02a1 }
        if (r3 == 0) goto L_0x02a4;
    L_0x029b:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x02a1 }
        r0.<init>();	 Catch:{ all -> 0x02a1 }
        throw r0;	 Catch:{ all -> 0x02a1 }
    L_0x02a1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x02a1 }
        throw r0;
    L_0x02a4:
        r3 = r0.f727c;	 Catch:{ all -> 0x02a1 }
        if (r3 != 0) goto L_0x02ad;
    L_0x02a8:
        r3 = r0.f726b;	 Catch:{ all -> 0x02a1 }
        r3.m1006s();	 Catch:{ all -> 0x02a1 }
    L_0x02ad:
        r3 = r0.f726b;	 Catch:{ all -> 0x02a1 }
        r3 = r3.m1010c();	 Catch:{ all -> 0x02a1 }
        if (r3 != 0) goto L_0x02c5;
    L_0x02b5:
        r3 = r11.f588g;	 Catch:{ all -> 0x02a1 }
        r4 = r0.f726b;	 Catch:{ all -> 0x02a1 }
        r4 = r4.mo771i();	 Catch:{ all -> 0x02a1 }
        r3 = r3 - r4;
        r11.f588g = r3;	 Catch:{ all -> 0x02a1 }
        r0 = r0.f726b;	 Catch:{ all -> 0x02a1 }
        r0.m1002o();	 Catch:{ all -> 0x02a1 }
    L_0x02c5:
        r2.remove();	 Catch:{ all -> 0x02a1 }
        goto L_0x0283;
    L_0x02c9:
        monitor-exit(r1);	 Catch:{ all -> 0x02a1 }
        return;
    L_0x02cb:
        r0 = r1;
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.core.sys.AsyncCache.a():void");
    }

    /* renamed from: b */
    private ListIterator<C0359g> m807b(boolean z) {
        int b = m804b();
        ArrayList arrayList = new ArrayList(this.f583b.size());
        for (RecordList recordList : this.f583b.values()) {
            if (recordList != null) {
                arrayList.add(recordList.listIterator(z ? recordList.size() : 0));
            }
        }
        return new C0356d(this, b, z, arrayList);
    }

    /* renamed from: b */
    private int m804b() {
        int i = 0;
        for (RecordList size : this.f583b.values()) {
            i = size.size() + i;
        }
        return i;
    }

    /* renamed from: a */
    private C0359g m799a(C0358f c0358f, int i, C0350h c0350h) {
        if (f582a || Thread.holdsLock(this)) {
            ListIterator b = m807b(true);
            C0359g c0359g = null;
            int i2 = 0;
            while (b.hasPrevious()) {
                C0359g c0359g2 = (C0359g) b.previous();
                int a = c0359g2.f725a.mo775a(c0358f);
                if (a >= i && (c0350h == null || c0350h.mo414a(c0359g2))) {
                    C0359g c0359g3;
                    int i3;
                    if (c0359g == null || i2 < a) {
                        c0359g3 = c0359g2;
                        i3 = a;
                    } else {
                        i3 = i2;
                        c0359g3 = c0359g;
                    }
                    if (i3 == Integer.MAX_VALUE) {
                        return c0359g3;
                    }
                    c0359g = c0359g3;
                    i2 = i3;
                }
            }
            return c0359g;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m803a(C0359g c0359g) {
        if (f582a || Thread.holdsLock(this)) {
            RecordList c = m810c(c0359g.hashCode());
            c.remove(c0359g);
            c.addLast(c0359g);
            this.f583b.remove(c);
            this.f583b.put(Integer.valueOf(c0359g.hashCode()), c);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private void m808b(C0359g c0359g) {
        RecordList b = m805b(c0359g.hashCode());
        if (f582a || b != null) {
            b.add(c0359g);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private RecordList m805b(int i) {
        RecordList c = m810c(i);
        if (c != null) {
            return c;
        }
        c = new RecordList();
        this.f583b.put(Integer.valueOf(i), c);
        return c;
    }

    /* renamed from: c */
    private RecordList m810c(int i) {
        return (RecordList) this.f583b.get(Integer.valueOf(i));
    }

    /* renamed from: c */
    private Object m811c() {
        return this;
    }
}
