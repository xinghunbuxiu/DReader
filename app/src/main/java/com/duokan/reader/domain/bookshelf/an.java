package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import com.duokan.core.p026a.C0285n;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.p037c.C0559f;
import java.io.File;

public abstract class an extends ij {
    
    protected final am f2688D;
    
    private final long f2689a;
    
    private long f2690b;
    
    private boolean f2691c = false;
    
    private boolean f2692d = true;
    
    private boolean f2693e = false;
    
    private boolean f2694f = true;
    
    private int f2695g = 0;
    
    private boolean f2696h = false;

    
    protected abstract void mo950a(ContentValues contentValues);

    
    protected abstract void mo951a(Cursor cursor);

    public abstract boolean aA();

    public abstract boolean aB();

    protected abstract String aC();

    
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

    
    protected final void m3748h(long j) {
        this.f2690b = j;
    }

    
    public static final boolean m3740a(int i, int i2) {
        return (i & i2) != 0;
    }

    public final boolean aM() {
        return !aA();
    }

    public final void aN() {
        m3746c(true);
    }

    
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

    
    
    
    protected final void m3745b(android.database.Cursor r6) {
        
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

    
    protected an m3749i(long j) {
        return this.f2688D.mo1100d(j);
    }

    protected am aV() {
        return this.f2688D;
    }

    
    protected void m3744b(int i) {
        this.f2695g |= i;
    }

    
    protected boolean m3747c(int i) {
        return (this.f2695g & i) != 0;
    }
}
