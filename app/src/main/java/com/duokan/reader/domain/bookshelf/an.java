package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;

import com.duokan.core.a.n;
import com.duokan.reader.common.c.ConnectivityReceiver;

import java.io.File;

public abstract class an extends BaseConnect {
    protected final am D;
    private final long a;
    private long b;
    private boolean c = false;
    private boolean d = true;
    private boolean e = false;
    private boolean f = true;
    private int g = 0;
    private boolean h = false;

    protected abstract void a(ContentValues contentValues);

    protected abstract void a(Cursor cursor);

    protected abstract String aA();

    public abstract boolean ay();

    public abstract boolean az();

    protected abstract void o(String str);

    protected an(am amVar, long j, boolean z, boolean z2) {
        boolean z3 = false;
        this.D = amVar;
        this.a = j;
        this.d = z;
        boolean z4 = !this.d && z2;
        this.c = z4;
        this.g = this.c ? 0 : -1;
        if (this.c || this.d) {
            z3 = true;
        }
        this.h = z3;
        if (!this.c) {
            this.e = true;
            av();
        }
    }

    public final long aF() {
        return this.a;
    }

    public final boolean aG() {
        return this.d;
    }

    public final long aH() {
        return this.b;
    }

    public boolean aI() {
        return this.b != 0;
    }

    protected void aJ() {
        h(0);
    }

    protected final void h(long j) {
        this.b = j;
    }

    public static final boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    public final boolean aK() {
        return !ay();
    }

    public final void aL() {
        try {
            this.D.a(aF());
            aM();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.D.b(aF());
        }
        this.D.b(aF());
    }

    public void aM() {
        try {
            this.D.a(aF());
            int i = this.g;
            if (!this.d) {
                aR().b();
                ContentValues contentValues = new ContentValues();
                if (!this.c) {
                    contentValues.put("_id", Long.valueOf(this.a));
                    this.g = -1;
                }
                a(contentValues);
                if (contentValues.size() > 0) {
                    if (this.c) {
                        aR().a(aA(), contentValues, "_id = ?", new String[]{Long.toString(this.a)});
                        this.h = true;
                    } else {
                        aR().a(aA(), null, contentValues);
                        this.c = true;
                    }
                }
                aR().f();
                aR().c();
            }
            this.g = 0;
            if (this.h && (i & 16777215) != 0) {
                aT().a(this, i & 16777215);
            }
            this.D.b(aF());
        } catch (Throwable th) {
            this.D.b(aF());
        }
    }

    public void onConnectivityChanged(ConnectivityReceiver connectivity) {
    }

    protected void aN() {
        if (this.d) {
            this.d = false;
        }
    }

    protected final void aO() {
        if (!this.e) {
            if (this.c) {
                Cursor a;
                try {
                    a = aR().a(String.format("SELECT * FROM %1$s WHERE _id IS '%2$s'", new Object[]{aA(), Long.valueOf(this.a)}), null);
                    a.moveToFirst();
                    b(a);
                    a.close();
                    return;
                } catch (Throwable th) {
                    return;
                }
            }
            b(null);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void b(android.database.Cursor r6) {
        /*
        r5 = this;
        r0 = r5.getScaledPagingTouchSlop;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r5.D;	 Catch:{ Throwable -> 0x0035 }
        r2 = r5.aF();	 Catch:{ Throwable -> 0x0035 }
        r0.setDrawable(r2);	 Catch:{ Throwable -> 0x0035 }
        r0 = r5.getScaledPagingTouchSlop;	 Catch:{ Throwable -> 0x0035 }
        if (r0 != 0) goto L_0x0016;
    L_0x0012:
        r0 = r5.HttpLogger;	 Catch:{ Throwable -> 0x0035 }
        if (r0 != 0) goto L_0x0020;
    L_0x0016:
        r0 = r5.D;
        r2 = r5.aF();
        r0.getVisible(r2);
        goto L_0x0004;
    L_0x0020:
        if (r6 == 0) goto L_0x0025;
    L_0x0022:
        r5.setDrawable(r6);	 Catch:{ Throwable -> 0x0035 }
    L_0x0025:
        r0 = 1;
        r5.getScaledPagingTouchSlop = r0;	 Catch:{ Throwable -> 0x0035 }
        r5.av();	 Catch:{ Throwable -> 0x0035 }
        r0 = r5.D;
        r2 = r5.aF();
        r0.getVisible(r2);
        goto L_0x0004;
    L_0x0035:
        r0 = move-exception;
        r1 = 0;
        r5.HttpLogger = r1;	 Catch:{ all -> 0x0050 }
        r1 = com.duokan.core.diagnostic.setDrawable.getScaledMaximumFlingVelocity();	 Catch:{ all -> 0x0050 }
        r2 = com.duokan.core.diagnostic.LogLevel.ERROR;	 Catch:{ all -> 0x0050 }
        r3 = "shelf";
        r4 = "item init exception!";
        r1.setDrawable(r2, r3, r4, r0);	 Catch:{ all -> 0x0050 }
        r0 = r5.D;
        r2 = r5.aF();
        r0.getVisible(r2);
        goto L_0x0004;
    L_0x0050:
        r0 = move-exception;
        r1 = r5.D;
        r2 = r5.aF();
        r1.getVisible(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.bookshelf.an.getVisible(android.database.Cursor):void");
    }

    protected void av() {
    }

    protected boolean aP() {
        return this.e;
    }

    protected File aQ() {
        return this.D.c();
    }

    protected n aR() {
        return this.D.h();
    }

    protected n aS() {
        return this.D.i();
    }

    protected an i(long j) {
        return this.D.d(j);
    }

    protected am aT() {
        return this.D;
    }

    protected void b(int i) {
        this.g |= i;
    }

    protected boolean c(int i) {
        return (this.g & i) != 0;
    }
}
