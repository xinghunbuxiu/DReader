package com.duokan.reader.domain.payment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;

import com.duokan.core.a.n;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.m;
import com.duokan.reader.domain.store.u;

import java.util.LinkedList;
import java.util.List;

public class PaymentManager implements ah {
    static final /* synthetic */ boolean a = (!PaymentManager.class.desiredAssertionStatus());
    private static final ai b = new ai();
    private final i c;
    private final a d = new a();
    private final g e = new g();
    private final u f;
    private final q[] g = new q[]{this.e, this.d};
    private final Context h;
    private final n i;
    private final List j = new LinkedList();

    public enum DependenceOfOrder {
        Contain,
        Intersect,
        Isolated
    }

    public static void a(Context context, i iVar) {
        b.a(new PaymentManager(context, iVar));
    }

    public static PaymentManager a() {
        return (PaymentManager) b.a();
    }

    public PaymentManager(Context context, i iVar) {
        this.h = context;
        this.c = iVar;
        this.i = f.a();
        this.f = new u();
        d();
    }

    public q b() {
        return this.e;
    }

    public t c() {
        return this.f;
    }

    public void a(a aVar, String str, s sVar, String str2, DkStoreCallback dkStoreCallback) {
        if (a(aVar)) {
            a(aVar, new j(this, dkStoreCallback, sVar));
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = b().a();
        }
        a(str2).a(sVar, new k(this, aVar, str, dkStoreCallback));
    }

    public void a(a aVar, m mVar, String str, DkStoreCallback dkStoreCallback) {
        a(aVar, null, (s) mVar, str, dkStoreCallback);
    }

    private void a(a aVar, String str, s sVar, String str2, u uVar, ag agVar) {
        a(aVar, str, sVar, str2, (ag) new m(this, aVar, str, sVar, str2, uVar, agVar));
    }

    private void a(a aVar, String str, s sVar, String str2, ag agVar) {
        new o(this, aVar, str, sVar, str2, agVar).open(2);
    }

    private void a(a aVar, ag agVar) {
        List linkedList = new LinkedList();
        for (u uVar : this.j) {
            if (aVar.b().equals(uVar.b)) {
                uVar.f = false;
                linkedList.add(uVar);
            }
        }
        a(aVar, linkedList, agVar);
    }

    private void a(a aVar, List list, ag agVar) {
        if (list == null || list.size() == 0) {
            agVar.a(PaymentResult.VERIFIED_OK);
            return;
        }
        s sVar = null;
        for (s sVar2 : list) {
            if (!sVar2.f) {
                sVar = sVar2;
                break;
            }
        }
        if (sVar == null) {
            agVar.a(PaymentResult.VERIFIED_OK);
            return;
        }
        a(aVar, sVar.c, sVar, sVar.d, (ag) new p(this, sVar, agVar, aVar, list));
    }

    private u a(String str, s sVar, String str2, String str3) {
        u uVar = new u(str, sVar, str2, str3);
        a(uVar);
        return uVar;
    }

    private void a(u uVar) {
        if (a || uVar != null) {
            b(uVar);
            this.j.add(uVar);
            return;
        }
        throw new AssertionError();
    }

    private void a(long j) {
        for (u uVar : this.j) {
            if (j == uVar.a) {
                this.j.remove(uVar);
                d(uVar);
                return;
            }
        }
    }

    private boolean a(a aVar) {
        if (this.j.size() > 0) {
            for (u uVar : this.j) {
                if (aVar.b().equals(uVar.b)) {
                    return true;
                }
            }
        }
        return false;
    }

    private q a(String str) {
        if (this.d.a().equals(str)) {
            return this.d;
        }
        if (this.f.a().equalsIgnoreCase(str)) {
            return this.f;
        }
        return this.e;
    }

    private void d() {
        Cursor a;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        synchronized (this.i) {
            try {
                a = this.i.a(String.format("SELECT * FROM %1$s", new Object[]{"unverified_order"}), null);
                if (a != null) {
                    try {
                        if (a.moveToFirst()) {
                            do {
                                this.j.add(new u(a.getLong(0), a.getString(1), a.getString(2), a.getString(3)));
                            } while (a.moveToNext());
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = a;
                        try {
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            a = cursor;
                            if (a != null) {
                                a.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
                if (a != null) {
                    a.close();
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th4) {
                th = th4;
                a = null;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
    }

    private void b(u uVar) {
        if (a || uVar != null) {
            synchronized (this.i) {
                this.i.b();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(miui.payment.PaymentManager.KEY_ACCOUNT, uVar.b);
                    contentValues.put("book_order", uVar.e());
                    contentValues.put("receipt", uVar.d);
                    uVar.a = this.i.a("unverified_order", null, contentValues);
                    this.i.f();
                    this.i.c();
                } catch (Exception e) {
                    e.printStackTrace();
                    this.i.c();
                } catch (Throwable th) {
                    this.i.c();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    private void c(u uVar) {
        if (a || uVar != null) {
            this.i.b();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.valueOf(uVar.a));
                contentValues.put(miui.payment.PaymentManager.KEY_ACCOUNT, uVar.b);
                contentValues.put("book_order", uVar.e());
                contentValues.put("receipt", uVar.d);
                this.i.a("unverified_order", contentValues, "_id = ? ", new String[]{Long.toString(uVar.a)});
                this.i.f();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.i.c();
            }
            return;
        }
        throw new AssertionError();
    }

    private void d(u uVar) {
        synchronized (this.i) {
            this.i.b();
            try {
                this.i.a("unverified_order", "_id = ? ", new String[]{Long.toString(uVar.a)});
                this.i.f();
                this.i.c();
            } catch (Exception e) {
                e.printStackTrace();
                this.i.c();
            } catch (Throwable th) {
                this.i.c();
            }
        }
    }
}
