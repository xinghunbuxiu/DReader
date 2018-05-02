package com.duokan.reader.common.p036b;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.util.concurrent.atomic.AtomicInteger;
import miuipub.payment.IXmsfPaymentListener;
import miuipub.payment.XmsfPaymentManager;

/* renamed from: com.duokan.reader.common.b.a */
public class C0538a {
    /* renamed from: a */
    private static volatile C0538a f1795a;
    /* renamed from: b */
    private final Context f1796b;
    /* renamed from: c */
    private MiAccountManager f1797c = MiAccountManager.get(this.f1796b);
    /* renamed from: d */
    private XmsfPaymentManager f1798d = XmsfPaymentManager.get(this.f1796b);

    private C0538a(Context context) {
        this.f1796b = context.getApplicationContext();
    }

    /* renamed from: a */
    public synchronized boolean m2399a() {
        return this.f1797c.canUseSystem();
    }

    /* renamed from: b */
    public synchronized boolean m2402b() {
        return this.f1797c.isUseSystem();
    }

    /* renamed from: c */
    public synchronized void m2403c() {
        this.f1797c.setUseSystem();
        this.f1798d.setUseSystem();
    }

    /* renamed from: d */
    public synchronized void m2404d() {
        this.f1797c.setUseLocal();
        this.f1798d.setUseLocal();
    }

    /* renamed from: e */
    public synchronized void m2405e() {
        this.f1797c.setUseSystem();
        this.f1798d.setUseLocal();
    }

    /* renamed from: f */
    public synchronized void m2406f() {
        this.f1797c.setUseLocal();
    }

    /* renamed from: g */
    public synchronized void m2407g() {
        this.f1797c.setUseSystem();
    }

    /* renamed from: a */
    public synchronized boolean m2400a(Account account, String str, Bundle bundle) {
        return this.f1797c.addAccountExplicitly(account, str, bundle);
    }

    /* renamed from: h */
    public synchronized boolean m2408h() {
        return this.f1797c.isUseLocal();
    }

    /* renamed from: a */
    public static C0538a m2388a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        if (f1795a == null) {
            synchronized (C0538a.class) {
                if (f1795a == null) {
                    f1795a = new C0538a(context);
                }
            }
        }
        return f1795a;
    }

    /* renamed from: k */
    private synchronized Account[] m2390k() {
        return this.f1797c.getAccounts();
    }

    /* renamed from: b */
    private synchronized Account[] m2389b(String str) {
        return this.f1797c.getAccountsByType(str);
    }

    /* renamed from: a */
    public synchronized void m2396a(String str, Runnable runnable) {
        boolean b = m2402b();
        if (b) {
            m2406f();
        }
        m2387a(new Account(str, "com.xiaomi"), new C0539b(this, b, runnable));
    }

    /* renamed from: a */
    public synchronized void m2395a(Runnable runnable) {
        boolean b = m2402b();
        if (b) {
            m2406f();
        }
        Account[] a = m2401a("com.xiaomi");
        if (a == null || a.length <= 0) {
            if (b) {
                m2407g();
            }
            if (runnable != null) {
                runnable.run();
            }
        } else {
            Runnable c0540c = new C0540c(this, new AtomicInteger(a.length), b, runnable);
            for (Account a2 : a) {
                m2387a(a2, c0540c);
            }
        }
    }

    /* renamed from: a */
    private synchronized AccountManagerFuture<Boolean> m2387a(Account account, Runnable runnable) {
        return this.f1797c.removeAccount(account, new C0541d(this, runnable), null);
    }

    /* renamed from: a */
    public synchronized void m2397a(String str, String str2) {
        this.f1797c.invalidateAuthToken(str, str2);
    }

    /* renamed from: a */
    public String m2392a(Account account, String str, boolean z) {
        return this.f1797c.blockingGetAuthToken(account, str, z);
    }

    /* renamed from: a */
    public synchronized AccountManagerFuture<Bundle> m2391a(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback) {
        return this.f1797c.getAuthToken(account, str, bundle, activity, (AccountManagerCallback) accountManagerCallback, null);
    }

    /* renamed from: a */
    public synchronized void m2394a(Activity activity, String str, String str2, Bundle bundle, IXmsfPaymentListener iXmsfPaymentListener) {
        this.f1798d.payForOrder(activity, str, str2, bundle, iXmsfPaymentListener);
    }

    /* renamed from: a */
    public synchronized void m2393a(Activity activity) {
        this.f1798d.gotoMiliCenter(activity);
    }

    /* renamed from: i */
    public synchronized Account m2409i() {
        Account account;
        Account[] accountsByType = this.f1797c.getAccountsByType("com.xiaomi");
        if (accountsByType.length > 0) {
            account = accountsByType[0];
        } else {
            account = null;
        }
        return account;
    }

    /* renamed from: a */
    public synchronized void m2398a(String str, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback) {
        for (Account account : m2390k()) {
            if (TextUtils.equals(account.type, "com.xiaomi")) {
                break;
            }
        }
        this.f1797c.addAccount("com.xiaomi", str, strArr, bundle, activity, accountManagerCallback, null);
    }

    /* renamed from: a */
    public synchronized Account[] m2401a(String str) {
        Account[] b;
        boolean b2 = m2402b();
        if (b2) {
            m2406f();
        }
        b = m2389b(str);
        if (b2 && !m2402b()) {
            m2407g();
        }
        return b;
    }

    /* renamed from: j */
    public synchronized Account m2410j() {
        Account account = null;
        synchronized (this) {
            if (m2399a()) {
                boolean h = m2408h();
                if (h) {
                    m2407g();
                }
                Account[] b = m2389b("com.xiaomi");
                if (h && !m2408h()) {
                    m2406f();
                }
                if (b.length >= 1) {
                    account = b[0];
                }
            }
        }
        return account;
    }
}
