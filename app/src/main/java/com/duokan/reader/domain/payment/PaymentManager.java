package com.duokan.reader.domain.payment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.p026a.C0285n;
import com.duokan.core.sys.ag;
import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0707f;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.store.C1187m;
import com.duokan.reader.domain.store.C1195u;
import com.duokan.reader.domain.store.DkStoreCallback;
import java.util.LinkedList;
import java.util.List;

public class PaymentManager implements ai {
    /* renamed from: a */
    static final /* synthetic */ boolean f5316a = (!PaymentManager.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final aj<PaymentManager> f5317b = new aj();
    /* renamed from: c */
    private final C0709k f5318c;
    /* renamed from: d */
    private final C1086a f5319d = new C1086a();
    /* renamed from: e */
    private final C1093g f5320e = new C1093g();
    /* renamed from: f */
    private final C1105u f5321f;
    /* renamed from: g */
    private final C1085q[] f5322g = new C1085q[]{this.f5320e, this.f5319d};
    /* renamed from: h */
    private final Context f5323h;
    /* renamed from: i */
    private final C0285n f5324i;
    /* renamed from: j */
    private final List<C1195u> f5325j = new LinkedList();

    public enum DependenceOfOrder {
        Contain,
        Intersect,
        Isolated
    }

    /* renamed from: a */
    public static void m8336a(Context context, C0709k c0709k) {
        f5317b.m709a(new PaymentManager(context, c0709k));
    }

    /* renamed from: a */
    public static PaymentManager m8331a() {
        return (PaymentManager) f5317b.m707a();
    }

    public PaymentManager(Context context, C0709k c0709k) {
        this.f5323h = context;
        this.f5318c = c0709k;
        this.f5324i = C0707f.m3460a();
        this.f5321f = new C1105u();
        m8349d();
    }

    /* renamed from: b */
    public C1085q m8353b() {
        return this.f5320e;
    }

    /* renamed from: c */
    public C1104t m8354c() {
        return this.f5321f;
    }

    /* renamed from: a */
    public void m8352a(C0672a c0672a, String str, C1089s c1089s, String str2, DkStoreCallback dkStoreCallback) {
        if (m8346a(c0672a)) {
            m8337a(c0672a, new C1096j(this, dkStoreCallback, c1089s));
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = m8353b().mo1499a();
        }
        m8332a(str2).mo1500a(c1089s, new C1098k(this, c0672a, str, dkStoreCallback));
    }

    /* renamed from: a */
    public void m8351a(C0672a c0672a, C1187m c1187m, String str, DkStoreCallback dkStoreCallback) {
        m8352a(c0672a, null, (C1089s) c1187m, str, dkStoreCallback);
    }

    /* renamed from: a */
    private void m8339a(C0672a c0672a, String str, C1089s c1089s, String str2, C1195u c1195u, ag<PaymentResult> agVar) {
        m8338a(c0672a, str, c1089s, str2, (ag) new C1100m(this, c0672a, str, c1089s, str2, c1195u, agVar));
    }

    /* renamed from: a */
    private void m8338a(C0672a c0672a, String str, C1089s c1089s, String str2, ag<PaymentResult> agVar) {
        new C1102o(this, C0629b.f2117a, c0672a, str, c1089s, str2, agVar).open(2);
    }

    /* renamed from: a */
    private void m8337a(C0672a c0672a, ag<PaymentResult> agVar) {
        List linkedList = new LinkedList();
        for (C1195u c1195u : this.f5325j) {
            if (c0672a.mo832b().equals(c1195u.f5687b)) {
                c1195u.f5691f = false;
                linkedList.add(c1195u);
            }
        }
        m8340a(c0672a, linkedList, agVar);
    }

    /* renamed from: a */
    private void m8340a(C0672a c0672a, List<C1195u> list, ag<PaymentResult> agVar) {
        if (list == null || list.size() == 0) {
            agVar.run(PaymentResult.VERIFIED_OK);
            return;
        }
        C1089s c1089s = null;
        for (C1089s c1089s2 : list) {
            if (!c1089s2.f5691f) {
                c1089s = c1089s2;
                break;
            }
        }
        if (c1089s == null) {
            agVar.run(PaymentResult.VERIFIED_OK);
            return;
        }
        m8338a(c0672a, c1089s.f5688c, c1089s, c1089s.f5689d, (ag) new C1103p(this, c1089s, agVar, c0672a, list));
    }

    /* renamed from: a */
    private C1195u m8334a(String str, C1089s c1089s, String str2, String str3) {
        C1195u c1195u = new C1195u(str, c1089s, str2, str3);
        m8345a(c1195u);
        return c1195u;
    }

    /* renamed from: a */
    private void m8345a(C1195u c1195u) {
        if (f5316a || c1195u != null) {
            m8347b(c1195u);
            this.f5325j.add(c1195u);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private void m8335a(long j) {
        for (C1195u c1195u : this.f5325j) {
            if (j == c1195u.f5686a) {
                this.f5325j.remove(c1195u);
                m8350d(c1195u);
                return;
            }
        }
    }

    /* renamed from: a */
    private boolean m8346a(C0672a c0672a) {
        if (this.f5325j.size() > 0) {
            for (C1195u c1195u : this.f5325j) {
                if (c0672a.mo832b().equals(c1195u.f5687b)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private C1085q m8332a(String str) {
        if (this.f5319d.mo1499a().equals(str)) {
            return this.f5319d;
        }
        if (this.f5321f.mo1499a().equalsIgnoreCase(str)) {
            return this.f5321f;
        }
        return this.f5320e;
    }

    /* renamed from: d */
    private void m8349d() {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        synchronized (this.f5324i) {
            Cursor a;
            try {
                a = this.f5324i.m670a(String.format("SELECT * FROM %1$s", new Object[]{"unverified_order"}), null);
                if (a != null) {
                    try {
                        if (a.moveToFirst()) {
                            do {
                                this.f5325j.add(new C1195u(a.getLong(0), a.getString(1), a.getString(2), a.getString(3)));
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

    /* renamed from: b */
    private void m8347b(C1195u c1195u) {
        if (f5316a || c1195u != null) {
            synchronized (this.f5324i) {
                this.f5324i.m677b();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(miui.payment.PaymentManager.KEY_ACCOUNT, c1195u.f5687b);
                    contentValues.put("book_order", c1195u.m8747e());
                    contentValues.put("receipt", c1195u.f5689d);
                    c1195u.f5686a = this.f5324i.m668a("unverified_order", null, contentValues);
                    this.f5324i.m681f();
                    this.f5324i.m678c();
                } catch (Exception e) {
                    e.printStackTrace();
                    this.f5324i.m678c();
                } catch (Throwable th) {
                    this.f5324i.m678c();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    private void m8348c(C1195u c1195u) {
        if (f5316a || c1195u != null) {
            this.f5324i.m677b();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.valueOf(c1195u.f5686a));
                contentValues.put(miui.payment.PaymentManager.KEY_ACCOUNT, c1195u.f5687b);
                contentValues.put("book_order", c1195u.m8747e());
                contentValues.put("receipt", c1195u.f5689d);
                this.f5324i.m666a("unverified_order", contentValues, "_id = ? ", new String[]{Long.toString(c1195u.f5686a)});
                this.f5324i.m681f();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.f5324i.m678c();
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    private void m8350d(C1195u c1195u) {
        synchronized (this.f5324i) {
            this.f5324i.m677b();
            try {
                this.f5324i.m667a("unverified_order", "_id = ? ", new String[]{Long.toString(c1195u.f5686a)});
                this.f5324i.m681f();
                this.f5324i.m678c();
            } catch (Exception e) {
                e.printStackTrace();
                this.f5324i.m678c();
            } catch (Throwable th) {
                this.f5324i.m678c();
            }
        }
    }
}
