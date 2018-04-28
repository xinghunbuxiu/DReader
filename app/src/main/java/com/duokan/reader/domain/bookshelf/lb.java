package com.duokan.reader.domain.bookshelf;

import android.content.Context;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.em;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public class lb implements ai, C0563j, C0586j {
    /* renamed from: a */
    private static final aj<lb> f3521a = new aj();
    /* renamed from: b */
    private Context f3522b;
    /* renamed from: c */
    private final C0559f f3523c;
    /* renamed from: d */
    private final C0709k f3524d;
    /* renamed from: e */
    private final PersonalPrefs f3525e;
    /* renamed from: f */
    private final CopyOnWriteArrayList<ln> f3526f = new CopyOnWriteArrayList();
    /* renamed from: g */
    private al f3527g;
    /* renamed from: h */
    private WebSession f3528h;
    /* renamed from: i */
    private WebSession f3529i;
    /* renamed from: j */
    private WebSession f3530j;
    /* renamed from: k */
    private em f3531k = null;

    /* renamed from: a */
    public static void m4897a(Context context, C0709k c0709k, C0559f c0559f, PersonalPrefs personalPrefs) {
        f3521a.m709a(new lb(context, c0709k, c0559f, personalPrefs));
    }

    /* renamed from: a */
    public static lb m4896a() {
        return (lb) f3521a.m707a();
    }

    private lb(Context context, C0709k c0709k, C0559f c0559f, PersonalPrefs personalPrefs) {
        this.f3522b = context;
        this.f3524d = c0709k;
        this.f3523c = c0559f;
        this.f3525e = personalPrefs;
        this.f3524d.m3494a((C0586j) this);
        this.f3523c.m2481a((C0563j) this);
    }

    /* renamed from: a */
    public void m4917a(ln lnVar) {
        this.f3526f.addIfAbsent(lnVar);
    }

    /* renamed from: b */
    public void m4921b(ln lnVar) {
        this.f3526f.remove(lnVar);
    }

    /* renamed from: b */
    public CopyOnWriteArrayList<ln> m4920b() {
        return this.f3526f;
    }

    /* renamed from: a */
    public void m4919a(boolean z) {
        Iterator it = this.f3526f.iterator();
        while (it.hasNext()) {
            ((ln) it.next()).mo1703a(z);
        }
    }

    /* renamed from: b */
    public void m4922b(boolean z) {
        if (this.f3524d.m3500a(PersonalAccount.class) && this.f3523c.m2486e()) {
            new lc(this, C0643q.f2173a, z).open();
        } else {
            m4919a(z);
        }
    }

    /* renamed from: c */
    public void m4923c() {
        m4925e();
        this.f3524d.m3497a(PersonalAccount.class, new ld(this));
    }

    /* renamed from: d */
    public void m4924d() {
        m4925e();
        this.f3524d.m3497a(PersonalAccount.class, new lf(this));
    }

    /* renamed from: a */
    public void m4915a(DkSignInInfo dkSignInInfo) {
        if (dkSignInInfo == null) {
            m4925e();
            C0328a.m757c().m752c(LogLevel.EVENT, "sign_in_event", "receive_sign_in_succeed");
            if (this.f3525e.m5209a(this.f3527g)) {
                new lh(this, C0643q.f2173a).open();
                return;
            }
            m4926f();
            be.m10286a(this.f3522b, C0247i.general__shared__account_change, 0).show();
            return;
        }
        dkSignInInfo.mLottery = m4905b(dkSignInInfo.mSignStatus, dkSignInInfo.mToday, dkSignInInfo.mLottery);
        m4900a(dkSignInInfo.mSignStatus, dkSignInInfo.mToday, dkSignInInfo.mLottery);
        m4899a(dkSignInInfo.mSignStatus, dkSignInInfo.mToday, dkSignInInfo.mReward, dkSignInInfo.mLottery, false, false);
    }

    /* renamed from: i */
    private void m4913i() {
        if (!(this.f3528h == null || this.f3528h.getIsClosed() || this.f3528h.isCancelling())) {
            this.f3528h.close();
        }
        if (!(this.f3530j == null || this.f3530j.getIsClosed() || this.f3530j.isCancelling())) {
            this.f3530j.close();
        }
        if (this.f3529i != null && !this.f3529i.getIsClosed() && !this.f3529i.isCancelling()) {
            this.f3529i.close();
        }
    }

    /* renamed from: a */
    public void m4916a(al alVar) {
        this.f3527g = alVar;
    }

    /* renamed from: a */
    public void m4918a(List<DkSignInReward> list) {
        m4925e();
        C0328a.m757c().m752c(LogLevel.EVENT, "resign_event", "receive_succeed");
        if (this.f3525e.m5209a(this.f3527g)) {
            new li(this, C0643q.f2173a, list).open();
            return;
        }
        m4926f();
        be.m10286a(this.f3522b, C0247i.general__shared__account_change, 0).show();
    }

    /* renamed from: e */
    public synchronized void m4925e() {
        if (this.f3531k == null) {
            if (DkApp.get().getTopActivity() != null) {
                this.f3531k = new lj(this, DkApp.get().getTopActivity());
            }
        }
        if (!this.f3531k.isShowing()) {
            this.f3531k.show();
        }
    }

    /* renamed from: f */
    public void m4926f() {
        if (this.f3531k != null) {
            this.f3531k.dismiss();
            this.f3531k = null;
        }
    }

    /* renamed from: g */
    public void m4927g() {
        m4925e();
        this.f3524d.m3497a(PersonalAccount.class, new lk(this));
    }

    /* renamed from: a */
    private void m4900a(boolean[] zArr, int i, boolean z) {
        String str = "";
        int length = zArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3;
            boolean z2 = zArr[i2];
            StringBuilder append = new StringBuilder().append(str).append(",");
            if (z2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            i2++;
            str = append.append(i3).toString();
        }
        if (str.length() > 0) {
            this.f3525e.m5217b(str.substring(1));
        }
        this.f3525e.m5220c(i);
        this.f3525e.m5218b(z);
        this.f3525e.m5223d((int) ((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000));
    }

    /* renamed from: a */
    private void m4899a(boolean[] zArr, int i, List<DkSignInReward> list, boolean z, boolean z2, boolean z3) {
        m4926f();
        Iterator it = this.f3526f.iterator();
        while (it.hasNext()) {
            ((ln) it.next()).mo1704a(zArr, i, list, z, z2, z3);
        }
    }

    /* renamed from: h */
    public void m4928h() {
        m4925e();
        new lm(this, C0643q.f2173a).open();
    }

    /* renamed from: a */
    public int m4914a(boolean[] zArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i - 1; i3++) {
            if (!zArr[i3]) {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: b */
    private boolean m4905b(boolean[] zArr, int i, boolean z) {
        return m4914a(zArr, i) == 0 && i == 7 && zArr[i - 1] && z;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        if (!this.f3525e.m5234j()) {
            m4919a(false);
        }
        m4922b(true);
    }

    public void onAccountLogoff(C0672a c0672a) {
        if (!this.f3525e.m5234j()) {
            m4919a(false);
        }
        m4922b(true);
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    public void onConnectivityChanged(C0559f c0559f) {
        if ((!this.f3523c.m2486e() || ManagedApp.get().getRunningState() != RunningState.FOREGROUND) && !this.f3523c.m2485d()) {
            return;
        }
        if (this.f3525e.m5237m()) {
            m4922b(true);
        } else {
            m4919a(true);
        }
    }
}
