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
    static final /* synthetic */ boolean a = (!AsyncCache.class.desiredAssertionStatus());
    private final LinkedHashMap b;
    private final Thread c;
    private final Semaphore d;
    private LinkedList e;
    private boolean f;
    private int g;
    private int h;
    private final String i;
    private final SQLiteDatabase j;

    public enum DataState {
        NULL,
        UNFILLED,
        FILLED,
        EMPTY
    }

    public class RecordList extends LinkedList {
        protected RecordList() {
        }
    }

    public AsyncCache() {
        this(null);
    }

    public AsyncCache(String str) {
        this.b = new LinkedHashMap();
        this.d = new Semaphore(0);
        this.e = new LinkedList();
        this.f = false;
        this.g = 0;
        this.h = 3145728;
        this.i = str;
        if (TextUtils.isEmpty(this.i)) {
            this.j = null;
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
            this.j = openOrCreateDatabase;
        }
        this.c = new Thread(new asyncCacheRun(this));
        this.c.start();
    }

    public void a(int i) {
        this.h = i;
    }

    public final e a(f fVar, e eVar) {
        e eVar2;
        synchronized (c()) {
            g gVar = new g(fVar, eVar);
            gVar.b.p();
            b(gVar);
            this.d.release();
            eVar2 = gVar.b;
        }
        return eVar2;
    }

    public final e a(f fVar, int i) {
        e eVar;
        synchronized (c()) {
            g a = a(fVar, i, new b(this));
            if (a != null) {
                a(a);
                a.b.p();
                eVar = a.b;
            } else {
                eVar = null;
            }
        }
        return eVar;
    }

    public final void a(e eVar) {
        synchronized (c()) {
            eVar.q();
        }
    }

    public final void b(e eVar) {
        synchronized (c()) {
            eVar.q();
            eVar.f();
        }
    }

    public final void a(boolean z) {
        Semaphore semaphore = new Semaphore(0);
        a(new c(this, semaphore));
        if (z) {
            semaphore.acquireUninterruptibly();
        }
    }

    public final boolean a(Runnable runnable) {
        if (this.f || runnable == null) {
            return false;
        }
        synchronized (c()) {
            this.e.push(runnable);
        }
        this.d.release();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
        r11 = this;
        r10 = 1;
    L_0x0001:
        r0 = r11.HttpLogger;
        if (r0 != 0) goto L_0x0279;
    L_0x0005:
        r0 = r11.getTriangleEdge;
        r0 = r0.availablePermits();
        if (r0 >= r10) goto L_0x003a;
    L_0x000d:
        r0 = r11.getScaledPagingTouchSlop;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x003a;
    L_0x0015:
        r1 = r11.getScaledMaximumFlingVelocity();
        monitor-enter(r1);
        r2 = r11.getScaledPagingTouchSlop;	 Catch:{ all -> 0x0037 }
        r0 = new java.util.LinkedList;	 Catch:{ all -> 0x0037 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0037 }
        r11.getScaledPagingTouchSlop = r0;	 Catch:{ all -> 0x0037 }
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
        r0 = r11.getTriangleEdge;
        r0.acquireUninterruptibly();
        r1 = 0;
        r2 = r11.getScaledMaximumFlingVelocity();
        monitor-enter(r2);
        r0 = 1;
        r3 = r11.getVisible(r0);	 Catch:{ all -> 0x0062 }
    L_0x004a:
        r0 = r3.hasPrevious();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x006d;
    L_0x0050:
        r0 = r3.previous();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.SessionTask) r0;	 Catch:{ all -> 0x0062 }
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getScaledMaximumFlingVelocity();	 Catch:{ all -> 0x0062 }
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
        r4 = r0.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x0062 }
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
        r0 = setDrawable;	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x007f;
    L_0x0075:
        r0 = r1.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x007f;
    L_0x0079:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x007f:
        r0 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.setDrawable();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x01b7;
    L_0x0087:
        r0 = 0;
        r3 = r11.getVisible(r0);	 Catch:{ all -> 0x0062 }
    L_0x008c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x00f6;
    L_0x0092:
        r0 = r3.next();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.SessionTask) r0;	 Catch:{ all -> 0x0062 }
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.setDrawable();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x008c;
    L_0x00a0:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getScaledPagingTouchSlop();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x008c;
    L_0x00a8:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getPhysicalYPixels();	 Catch:{ all -> 0x0062 }
        r5 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r5 = r5.getPhysicalXPixels();	 Catch:{ all -> 0x0062 }
        if (r4 < r5) goto L_0x008c;
    L_0x00b6:
        r4 = setDrawable;	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x00c8;
    L_0x00ba:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getTriangleEdge();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x00c8;
    L_0x00c2:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x00c8:
        r4 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r5 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getPhysicalXPixels(r5);	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x008c;
    L_0x00d2:
        r3 = setDrawable;	 Catch:{ all -> 0x0062 }
        if (r3 != 0) goto L_0x00e4;
    L_0x00d6:
        r0 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getScaledMaximumFlingVelocity();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x00e4;
    L_0x00de:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x00e4:
        r0 = setDrawable;	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x00f6;
    L_0x00e8:
        r0 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getVisible();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x00f6;
    L_0x00f0:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x00f6:
        r0 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getVisible();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0168;
    L_0x00fe:
        r0 = r11.SessionTask;	 Catch:{ all -> 0x0062 }
        r3 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r3 = r3.getPhysicalXPixels();	 Catch:{ all -> 0x0062 }
        r0 = r0 + r3;
        r3 = r11.getPhysicalXPixels;	 Catch:{ all -> 0x0062 }
        if (r0 <= r3) goto L_0x0168;
    L_0x010b:
        r0 = 0;
        r3 = r11.getVisible(r0);	 Catch:{ all -> 0x0062 }
    L_0x0110:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0168;
    L_0x0116:
        r0 = r3.next();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.SessionTask) r0;	 Catch:{ all -> 0x0062 }
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getTriangleEdge();	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x0110;
    L_0x0124:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getScaledPagingTouchSlop();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x0110;
    L_0x012c:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getPhysicalYPixels();	 Catch:{ all -> 0x0062 }
        r5 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r5 = r5.getPhysicalXPixels();	 Catch:{ all -> 0x0062 }
        if (r4 < r5) goto L_0x0110;
    L_0x013a:
        r4 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r5 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getPhysicalXPixels(r5);	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x0110;
    L_0x0144:
        r3 = setDrawable;	 Catch:{ all -> 0x0062 }
        if (r3 != 0) goto L_0x0156;
    L_0x0148:
        r0 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getScaledMaximumFlingVelocity();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x0156;
    L_0x0150:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x0156:
        r0 = setDrawable;	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x0168;
    L_0x015a:
        r0 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getVisible();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0168;
    L_0x0162:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x0168:
        r0 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getVisible();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0191;
    L_0x0170:
        r0 = 0;
        r3 = r11.getVisible(r0);	 Catch:{ all -> 0x0062 }
    L_0x0175:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x0191;
    L_0x017b:
        r0 = r3.next();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.SessionTask) r0;	 Catch:{ all -> 0x0062 }
        r4 = r11.SessionTask;	 Catch:{ all -> 0x0062 }
        r4 = (double) r4;	 Catch:{ all -> 0x0062 }
        r6 = r11.getPhysicalXPixels;	 Catch:{ all -> 0x0062 }
        r6 = (double) r6;	 Catch:{ all -> 0x0062 }
        r8 = 4603579539098121011; // 0x3fe3333333333333 float:4.172325E-8 double:0.6;
        r6 = r6 * r8;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 > 0) goto L_0x01ec;
    L_0x0191:
        r0 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getVisible();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x01b7;
    L_0x0199:
        r0 = 0;
        r3 = r11.getVisible(r0);	 Catch:{ all -> 0x0062 }
    L_0x019e:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x01b7;
    L_0x01a4:
        r0 = r3.next();	 Catch:{ all -> 0x0062 }
        r0 = (com.duokan.core.sys.SessionTask) r0;	 Catch:{ all -> 0x0062 }
        r4 = r11.SessionTask;	 Catch:{ all -> 0x0062 }
        r5 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r5 = r5.getPhysicalXPixels();	 Catch:{ all -> 0x0062 }
        r4 = r4 + r5;
        r5 = r11.getPhysicalXPixels;	 Catch:{ all -> 0x0062 }
        if (r4 > r5) goto L_0x0230;
    L_0x01b7:
        r0 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getVisible();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x01df;
    L_0x01bf:
        r0 = r11.SessionTask;	 Catch:{ all -> 0x0062 }
        r3 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r3 = r3.getPhysicalXPixels();	 Catch:{ all -> 0x0062 }
        r0 = r0 + r3;
        r3 = r11.getPhysicalXPixels;	 Catch:{ all -> 0x0062 }
        if (r0 > r3) goto L_0x01df;
    L_0x01cc:
        r0 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.n();	 Catch:{ all -> 0x0062 }
        if (r0 == 0) goto L_0x01df;
    L_0x01d4:
        r0 = r11.SessionTask;	 Catch:{ all -> 0x0062 }
        r3 = r1.getVisible;	 Catch:{ all -> 0x0062 }
        r3 = r3.getPhysicalYPixels();	 Catch:{ all -> 0x0062 }
        r0 = r0 + r3;
        r11.SessionTask = r0;	 Catch:{ all -> 0x0062 }
    L_0x01df:
        monitor-exit(r2);	 Catch:{ all -> 0x0062 }
        r0 = setDrawable;
        if (r0 != 0) goto L_0x0262;
    L_0x01e4:
        if (r1 != 0) goto L_0x0262;
    L_0x01e6:
        r0 = new java.lang.AssertionError;
        r0.<creatCallTask>();
        throw r0;
    L_0x01ec:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.setDrawable();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x0175;
    L_0x01f4:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getScaledPagingTouchSlop();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x0175;
    L_0x01fc:
        r4 = setDrawable;	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x020e;
    L_0x0200:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getTriangleEdge();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x020e;
    L_0x0208:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x020e:
        r4 = r11.SessionTask;	 Catch:{ all -> 0x0062 }
        r5 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r5 = r5.getPhysicalYPixels();	 Catch:{ all -> 0x0062 }
        r4 = r4 - r5;
        r11.SessionTask = r4;	 Catch:{ all -> 0x0062 }
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4.o();	 Catch:{ all -> 0x0062 }
        r4 = setDrawable;	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x0175;
    L_0x0222:
        r0 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getScaledMaximumFlingVelocity();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x0175;
    L_0x022a:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x0230:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getTriangleEdge();	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x019e;
    L_0x0238:
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4 = r4.getScaledPagingTouchSlop();	 Catch:{ all -> 0x0062 }
        if (r4 == 0) goto L_0x019e;
    L_0x0240:
        r4 = r11.SessionTask;	 Catch:{ all -> 0x0062 }
        r5 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r5 = r5.getPhysicalYPixels();	 Catch:{ all -> 0x0062 }
        r4 = r4 - r5;
        r11.SessionTask = r4;	 Catch:{ all -> 0x0062 }
        r4 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r4.o();	 Catch:{ all -> 0x0062 }
        r4 = setDrawable;	 Catch:{ all -> 0x0062 }
        if (r4 != 0) goto L_0x019e;
    L_0x0254:
        r0 = r0.getVisible;	 Catch:{ all -> 0x0062 }
        r0 = r0.getScaledMaximumFlingVelocity();	 Catch:{ all -> 0x0062 }
        if (r0 != 0) goto L_0x019e;
    L_0x025c:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x0062 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x0062 }
        throw r0;	 Catch:{ all -> 0x0062 }
    L_0x0262:
        r0 = r1.getVisible;
        r0 = r0.getVisible();
        if (r0 != 0) goto L_0x0273;
    L_0x026a:
        r0 = r1.getVisible;
        r0.onActivityResult();
    L_0x026f:
        r1.getScaledMaximumFlingVelocity = r10;
        goto L_0x0001;
    L_0x0273:
        r0 = r1.getVisible;
        r0.s();
        goto L_0x026f;
    L_0x0279:
        r1 = r11.getScaledMaximumFlingVelocity();
        monitor-enter(r1);
        r0 = 0;
        r2 = r11.getVisible(r0);	 Catch:{ all -> 0x02a1 }
    L_0x0283:
        r0 = r2.hasNext();	 Catch:{ all -> 0x02a1 }
        if (r0 == 0) goto L_0x02c9;
    L_0x0289:
        r0 = r2.next();	 Catch:{ all -> 0x02a1 }
        r0 = (com.duokan.core.sys.SessionTask) r0;	 Catch:{ all -> 0x02a1 }
        r3 = setDrawable;	 Catch:{ all -> 0x02a1 }
        if (r3 != 0) goto L_0x02a4;
    L_0x0293:
        r3 = r0.getVisible;	 Catch:{ all -> 0x02a1 }
        r3 = r3.getTriangleEdge();	 Catch:{ all -> 0x02a1 }
        if (r3 == 0) goto L_0x02a4;
    L_0x029b:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x02a1 }
        r0.<creatCallTask>();	 Catch:{ all -> 0x02a1 }
        throw r0;	 Catch:{ all -> 0x02a1 }
    L_0x02a1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x02a1 }
        throw r0;
    L_0x02a4:
        r3 = r0.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x02a1 }
        if (r3 != 0) goto L_0x02ad;
    L_0x02a8:
        r3 = r0.getVisible;	 Catch:{ all -> 0x02a1 }
        r3.s();	 Catch:{ all -> 0x02a1 }
    L_0x02ad:
        r3 = r0.getVisible;	 Catch:{ all -> 0x02a1 }
        r3 = r3.getScaledMaximumFlingVelocity();	 Catch:{ all -> 0x02a1 }
        if (r3 != 0) goto L_0x02c5;
    L_0x02b5:
        r3 = r11.SessionTask;	 Catch:{ all -> 0x02a1 }
        r4 = r0.getVisible;	 Catch:{ all -> 0x02a1 }
        r4 = r4.getPhysicalYPixels();	 Catch:{ all -> 0x02a1 }
        r3 = r3 - r4;
        r11.SessionTask = r3;	 Catch:{ all -> 0x02a1 }
        r0 = r0.getVisible;	 Catch:{ all -> 0x02a1 }
        r0.o();	 Catch:{ all -> 0x02a1 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.core.sys.AsyncCache.setDrawable():void");
    }

    private ListIterator b(boolean z) {
        int b = b();
        ArrayList arrayList = new ArrayList(this.b.size());
        for (RecordList recordList : this.b.values()) {
            if (recordList != null) {
                arrayList.add(recordList.listIterator(z ? recordList.size() : 0));
            }
        }
        return new d(this, b, z, arrayList);
    }

    private int b() {
        int i = 0;
        for (RecordList size : this.b.values()) {
            i = size.size() + i;
        }
        return i;
    }

    private g a(f fVar, int i, h hVar) {
        if (a || Thread.holdsLock(this)) {
            ListIterator b = b(true);
            g gVar = null;
            int i2 = 0;
            while (b.hasPrevious()) {
                g gVar2 = (g) b.previous();
                int a = gVar2.a.a(fVar);
                if (a >= i && (hVar == null || hVar.a(gVar2))) {
                    g gVar3;
                    int i3;
                    if (gVar == null || i2 < a) {
                        gVar3 = gVar2;
                        i3 = a;
                    } else {
                        i3 = i2;
                        gVar3 = gVar;
                    }
                    if (i3 == Integer.MAX_VALUE) {
                        return gVar3;
                    }
                    gVar = gVar3;
                    i2 = i3;
                }
            }
            return gVar;
        }
        throw new AssertionError();
    }

    private void a(g gVar) {
        if (a || Thread.holdsLock(this)) {
            RecordList c = c(gVar.hashCode());
            c.remove(gVar);
            c.addLast(gVar);
            this.b.remove(c);
            this.b.put(Integer.valueOf(gVar.hashCode()), c);
            return;
        }
        throw new AssertionError();
    }

    private void b(g gVar) {
        RecordList b = b(gVar.hashCode());
        if (a || b != null) {
            b.add(gVar);
            return;
        }
        throw new AssertionError();
    }

    private RecordList b(int i) {
        RecordList c = c(i);
        if (c != null) {
            return c;
        }
        c = new RecordList();
        this.b.put(Integer.valueOf(i), c);
        return c;
    }

    private RecordList c(int i) {
        return (RecordList) this.b.get(Integer.valueOf(i));
    }

    private Object c() {
        return this;
    }
}
