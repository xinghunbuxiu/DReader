package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import com.duokan.core.p026a.C0285n;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.p037c.C0559f;
import java.io.File;

public abstract class an extends ij {
    /* renamed from: D */
    protected final am f2688D;
    /* renamed from: a */
    private final long f2689a;
    /* renamed from: b */
    private long f2690b;
    /* renamed from: c */
    private boolean f2691c = false;
    /* renamed from: d */
    private boolean f2692d = true;
    /* renamed from: e */
    private boolean f2693e = false;
    /* renamed from: f */
    private boolean f2694f = true;
    /* renamed from: g */
    private int f2695g = 0;
    /* renamed from: h */
    private boolean f2696h = false;

    /* renamed from: a */
    protected abstract void mo950a(ContentValues contentValues);

    /* renamed from: a */
    protected abstract void mo951a(Cursor cursor);

    public abstract boolean aA();

    public abstract boolean aB();

    protected abstract String aC();

    /* renamed from: p */
    protected abstract void mo955p(String str);

    protected an(am amVar, long j, boolean z, boolean z2) {
        boolean z3 = false;
        this.f2688D = amVar;
        this.f2689a = j;
        this.f2692d = z;
        boolean z4 = !this.f2692d && z2;
        this.f2691c = z4;
        this.f2695g = this.f2691c ? 0 : -1;
        if (this.f2691c || this.f2692d) {
            z3 = true;
        }
        this.f2696h = z3;
        if (!this.f2691c) {
            this.f2693e = true;
            ax();
        }
    }

    public final long aH() {
        return this.f2689a;
    }

    public final boolean aI() {
        return this.f2692d;
    }

    public final long aJ() {
        return this.f2690b;
    }

    public boolean aK() {
        return this.f2690b != 0;
    }

    protected void aL() {
        m3748h(0);
    }

    /* renamed from: h */
    protected final void m3748h(long j) {
        this.f2690b = j;
    }

    /* renamed from: a */
    public static final boolean m3740a(int i, int i2) {
        return (i & i2) != 0;
    }

    public final boolean aM() {
        return !aA();
    }

    public final void aN() {
        m3746c(true);
    }

    /* renamed from: c */
    public final void m3746c(boolean z) {
        Runnable aoVar = new ao(this);
        if (z) {
            aoVar.run();
        } else {
            ah.m866a(aoVar, an.class.getName());
        }
    }

    public final void aO() {
        try {
            this.f2688D.mo1091a(aH());
            int i = this.f2695g;
            if (!this.f2692d) {
                aT().m677b();
                ContentValues contentValues = new ContentValues();
                if (!this.f2691c) {
                    contentValues.put("_id", Long.valueOf(this.f2689a));
                    this.f2695g = -1;
                }
                mo950a(contentValues);
                if (contentValues.size() > 0) {
                    if (this.f2691c) {
                        aT().m666a(aC(), contentValues, "_id = ?", new String[]{Long.toString(this.f2689a)});
                        this.f2696h = true;
                    } else {
                        aT().m668a(aC(), null, contentValues);
                        this.f2691c = true;
                    }
                }
                aT().m681f();
                aT().m678c();
            }
            this.f2695g = 0;
            if (this.f2696h && (i & 16777215) != 0) {
                aV().mo1092a(this, i & 16777215);
            }
            this.f2688D.mo1097b(aH());
        } catch (Throwable th) {
            this.f2688D.mo1097b(aH());
        }
    }

    /* renamed from: a */
    public void mo949a(C0559f c0559f) {
    }

    protected void aP() {
        if (this.f2692d) {
            this.f2692d = false;
        }
    }

    protected final void aQ() {
        if (!this.f2693e) {
            if (this.f2691c) {
                Cursor a;
                try {
                    a = aT().m670a(String.format("SELECT * FROM %1$s WHERE _id IS '%2$s'", new Object[]{aC(), Long.valueOf(this.f2689a)}), null);
                    a.moveToFirst();
                    m3745b(a);
                    a.close();
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            m3745b(null);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    protected final void m3745b(android.database.Cursor r6) {
        /*
        r5 = this;
        r0 = r5.f2693e;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r5.f2688D;	 Catch:{ Throwable -> 0x0035 }
        r2 = r5.aH();	 Catch:{ Throwable -> 0x0035 }
        r0.mo1091a(r2);	 Catch:{ Throwable -> 0x0035 }
        r0 = r5.f2693e;	 Catch:{ Throwable -> 0x0035 }
        if (r0 != 0) goto L_0x0016;
    L_0x0012:
        r0 = r5.f2694f;	 Catch:{ Throwable -> 0x0035 }
        if (r0 != 0) goto L_0x0020;
    L_0x0016:
        r0 = r5.f2688D;
        r2 = r5.aH();
        r0.mo1097b(r2);
        goto L_0x0004;
    L_0x0020:
        if (r6 == 0) goto L_0x0025;
    L_0x0022:
        r5.mo951a(r6);	 Catch:{ Throwable -> 0x0035 }
    L_0x0025:
        r0 = 1;
        r5.f2693e = r0;	 Catch:{ Throwable -> 0x0035 }
        r5.ax();	 Catch:{ Throwable -> 0x0035 }
        r0 = r5.f2688D;
        r2 = r5.aH();
        r0.mo1097b(r2);
        goto L_0x0004;
    L_0x0035:
        r0 = move-exception;
        r1 = 0;
        r5.f2694f = r1;	 Catch:{ all -> 0x0050 }
        r1 = com.duokan.core.diagnostic.C0328a.m757c();	 Catch:{ all -> 0x0050 }
        r2 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ all -> 0x0050 }
        r3 = "shelf";
        r4 = "item init exception!";
        r1.m748a(r2, r3, r4, r0);	 Catch:{ all -> 0x0050 }
        r0 = r5.f2688D;
        r2 = r5.aH();
        r0.mo1097b(r2);
        goto L_0x0004;
    L_0x0050:
        r0 = move-exception;
        r1 = r5.f2688D;
        r2 = r5.aH();
        r1.mo1097b(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.an.b(android.database.Cursor):void");
    }

    protected void ax() {
    }

    protected boolean aR() {
        return this.f2693e;
    }

    protected File aS() {
        return this.f2688D.mo1098c();
    }

    protected C0285n aT() {
        return this.f2688D.mo1105h();
    }

    protected C0285n aU() {
        return this.f2688D.mo1106i();
    }

    /* renamed from: i */
    protected an m3749i(long j) {
        return this.f2688D.mo1100d(j);
    }

    protected am aV() {
        return this.f2688D;
    }

    /* renamed from: b */
    protected void m3744b(int i) {
        this.f2695g |= i;
    }

    /* renamed from: c */
    protected boolean m3747c(int i) {
        return (this.f2695g & i) != 0;
    }
}
