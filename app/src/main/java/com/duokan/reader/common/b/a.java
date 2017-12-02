package com.duokan.reader.common.b;

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

public class a {
    private static volatile a a;
    private final Context b;
    private MiAccountManager c = MiAccountManager.get(this.b);
    private XmsfPaymentManager d = XmsfPaymentManager.get(this.b);

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public synchronized boolean a() {
        return this.c.canUseSystem();
    }

    public synchronized boolean b() {
        return this.c.isUseSystem();
    }

    public synchronized void c() {
        this.c.setUseSystem();
        this.d.setUseSystem();
    }

    public synchronized void d() {
        this.c.setUseLocal();
        this.d.setUseLocal();
    }

    public synchronized void e() {
        this.c.setUseSystem();
        this.d.setUseLocal();
    }

    public synchronized void f() {
        this.c.setUseLocal();
    }

    public synchronized void g() {
        this.c.setUseSystem();
    }

    public synchronized boolean a(Account account, String str, Bundle bundle) {
        return this.c.addAccountExplicitly(account, str, bundle);
    }

    public synchronized boolean h() {
        return this.c.isUseLocal();
    }

    public static a a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private synchronized Account[] k() {
        return this.c.getAccounts();
    }

    private synchronized Account[] b(String str) {
        return this.c.getAccountsByType(str);
    }

    public synchronized void a(String str, Runnable runnable) {
        boolean b = b();
        if (b) {
            f();
        }
        a(new Account(str, "com.xiaomi"), new b(this, b, runnable));
    }

    public synchronized void a(Runnable runnable) {
        boolean b = b();
        if (b) {
            f();
        }
        Account[] a = a("com.xiaomi");
        if (a == null || a.length <= 0) {
            if (b) {
                g();
            }
            if (runnable != null) {
                runnable.run();
            }
        } else {
            Runnable cVar = new c(this, new AtomicInteger(a.length), b, runnable);
            for (Account a2 : a) {
                a(a2, cVar);
            }
        }
    }

    private synchronized AccountManagerFuture a(Account account, Runnable runnable) {
        return this.c.removeAccount(account, new d(this, runnable), null);
    }

    public synchronized void a(String str, String str2) {
        this.c.invalidateAuthToken(str, str2);
    }

    public String a(Account account, String str, boolean z) {
        return this.c.blockingGetAuthToken(account, str, z);
    }

    public synchronized AccountManagerFuture a(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback accountManagerCallback) {
        return this.c.getAuthToken(account, str, bundle, activity, accountManagerCallback, null);
    }

    public synchronized void a(Activity activity, String str, String str2, Bundle bundle, IXmsfPaymentListener iXmsfPaymentListener) {
        this.d.payForOrder(activity, str, str2, bundle, iXmsfPaymentListener);
    }

    public synchronized void a(Activity activity) {
        this.d.gotoMiliCenter(activity);
    }

    public synchronized Account i() {
        Account account;
        Account[] accountsByType = this.c.getAccountsByType("com.xiaomi");
        if (accountsByType.length > 0) {
            account = accountsByType[0];
        } else {
            account = null;
        }
        return account;
    }

    public synchronized void a(String str, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback accountManagerCallback) {
        for (Account account : k()) {
            if (TextUtils.equals(account.type, "com.xiaomi")) {
                break;
            }
        }
        this.c.addAccount("com.xiaomi", str, strArr, bundle, activity, accountManagerCallback, null);
    }

    public synchronized Account[] a(String str) {
        Account[] b;
        boolean b2 = b();
        if (b2) {
            f();
        }
        b = b(str);
        if (b2 && !b()) {
            g();
        }
        return b;
    }

    public synchronized Account j() {
        Account account = null;
        synchronized (this) {
            if (a()) {
                boolean h = h();
                if (h) {
                    g();
                }
                Account[] b = b("com.xiaomi");
                if (h && !h()) {
                    f();
                }
                if (b.length >= 1) {
                    account = b[0];
                }
            }
        }
        return account;
    }
}
