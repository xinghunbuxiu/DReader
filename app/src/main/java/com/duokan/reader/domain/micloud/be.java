package com.duokan.reader.domain.micloud;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.duokan.reader.common.async.work.C0521a;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.C0529q;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiGuestAccount;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import org.apache.http.HttpStatus;

public abstract class be<T extends bf> extends C0521a<T> implements af<T> {
    /* renamed from: a */
    private boolean f5231a;

    /* renamed from: a */
    protected abstract C0525e mo1491a(ExtendedAuthToken extendedAuthToken);

    public be(Context context, T t, C0529q<T> c0529q) {
        super(context, t, c0529q);
    }

    /* renamed from: a */
    protected final C0525e mo1488a(int i) {
        this.f5231a = false;
        if (!((bf) mo734b()).m2300o()) {
            return C0525e.m2310b(-2, true, true);
        }
        if (i > 0) {
            int i2;
            if (i <= 2) {
                i2 = i * 10;
            } else {
                i2 = HttpStatus.SC_MULTIPLE_CHOICES;
            }
            try {
                Thread.sleep((long) (i2 * 1000));
            } catch (InterruptedException e) {
            }
        }
        return m8137k();
    }

    /* renamed from: k */
    private C0525e m8137k() {
        if (!((bf) mo734b()).m2300o()) {
            return C0525e.m2310b(-2, true, true);
        }
        C0672a d = C0709k.m3476a().m3508d();
        if (d == null) {
            return C0525e.m2311c(-10005, true, true);
        }
        if (d.mo835e().equals(AccountType.XIAO_MI)) {
            C0538a a = C0542e.m2412a(m2258a(), true);
            Account i = a.m2409i();
            if (i == null) {
                return C0525e.m2311c(-10005, true, true);
            }
            if (!i.name.equals(((bf) mo734b()).m8140N())) {
                return C0525e.m2311c(-10006, true, true);
            }
            try {
                String a2 = a.m2392a(i, "micloud", false);
                if (!((bf) mo734b()).m2300o()) {
                    return C0525e.m2310b(-2, true, true);
                }
                if (TextUtils.isEmpty(a2)) {
                    return C0525e.m2311c(-10007, true, false);
                }
                C0525e a3 = mo1491a(ExtendedAuthToken.parse(a2));
                if (!((bf) mo734b()).m2300o() || a3.f1773a || a3.f1774b || a3.f1775c != -40003 || this.f5231a) {
                    return a3;
                }
                a.m2397a("com.xiaomi", a2);
                this.f5231a = true;
                return m8137k();
            } catch (Exception e) {
                return C0525e.m2311c(-10007, true, false);
            }
        } else if (!d.mo835e().equals(AccountType.XIAOMI_GUEST)) {
            return C0525e.m2311c(-10005, true, true);
        } else {
            if (!((bf) mo734b()).m2300o()) {
                return C0525e.m2310b(-2, true, true);
            }
            if (!d.mo833c().equals(((bf) mo734b()).m8140N())) {
                return C0525e.m2311c(-10006, true, true);
            }
            try {
                ((MiGuestAccount) d).mo848r();
                if (!((bf) mo734b()).m2300o()) {
                    return C0525e.m2310b(-2, true, true);
                }
                if (((MiGuestAccount) d).f2258e == null) {
                    return C0525e.m2311c(-10007, true, false);
                }
                C0525e a4 = mo1491a(((MiGuestAccount) d).f2258e);
                if (!((bf) mo734b()).m2300o() || a4.f1773a || a4.f1774b || a4.f1775c != -40003 || this.f5231a) {
                    return a4;
                }
                ((MiGuestAccount) d).mo848r();
                this.f5231a = true;
                return m8137k();
            } catch (Exception e2) {
                return C0525e.m2311c(-10007, true, false);
            }
        }
    }
}
