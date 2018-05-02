package com.duokan.reader.domain.micloud;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;

import com.duokan.reader.common.async.work.a;
import com.duokan.reader.common.async.work.e;
import com.duokan.reader.common.async.work.q;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.MiGuestAccount;
import com.duokan.reader.domain.account.i;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;

import org.apache.http.HttpStatus;

import miuipub.date.Calendar;

public abstract class be extends a implements af {
    private boolean a;

    protected abstract e a(ExtendedAuthToken extendedAuthToken);

    public be(Context context, bf bfVar, q qVar) {
        super(context, bfVar, qVar);
    }

    protected final e a(int i) {
        this.a = false;
        if (!((bf) b()).o()) {
            return e.b(-2, true, true);
        }
        if (i > 0) {
            int i2;
            if (i <= 2) {
                i2 = i * 10;
            } else {
                i2 = HttpStatus.SC_MULTIPLE_CHOICES;
            }
            try {
                Thread.sleep((long) (i2 * Calendar.MILLISECOND_OF_SECOND));
            } catch (InterruptedException e) {
            }
        }
        return k();
    }

    private e k() {
        if (!((bf) b()).o()) {
            return e.b(-2, true, true);
        }
        com.duokan.reader.domain.account.a c = i.f().c();
        if (c == null) {
            return e.c(-10005, true, true);
        }
        if (c.e().equals(AccountType.XIAO_MI)) {
            com.duokan.reader.common.b.a a = com.duokan.reader.common.b.e.a(a(), true);
            Account i = a.i();
            if (i == null) {
                return e.c(-10005, true, true);
            }
            if (!i.name.equals(((bf) b()).N())) {
                return e.c(-10006, true, true);
            }
            try {
                String a2 = a.a(i, "micloud", false);
                if (!((bf) b()).o()) {
                    return e.b(-2, true, true);
                }
                if (TextUtils.isEmpty(a2)) {
                    return e.c(-10007, true, false);
                }
                e a3 = a(ExtendedAuthToken.parse(a2));
                if (!((bf) b()).o() || a3.a || a3.b || a3.c != -40003 || this.a) {
                    return a3;
                }
                a.a("com.xiaomi", a2);
                this.a = true;
                return k();
            } catch (Exception e) {
                return e.c(-10007, true, false);
            }
        } else if (!c.e().equals(AccountType.XIAOMI_GUEST)) {
            return e.c(-10005, true, true);
        } else {
            if (!((bf) b()).o()) {
                return e.b(-2, true, true);
            }
            if (!c.c().equals(((bf) b()).N())) {
                return e.c(-10006, true, true);
            }
            try {
                ((MiGuestAccount) c).o();
                if (!((bf) b()).o()) {
                    return e.b(-2, true, true);
                }
                if (((MiGuestAccount) c).e == null) {
                    return e.c(-10007, true, false);
                }
                e a4 = a(((MiGuestAccount) c).e);
                if (!((bf) b()).o() || a4.a || a4.b || a4.c != -40003 || this.a) {
                    return a4;
                }
                ((MiGuestAccount) c).o();
                this.a = true;
                return k();
            } catch (Exception e2) {
                return e.c(-10007, true, false);
            }
        }
    }
}
