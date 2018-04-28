package com.duokan.reader.domain.account;

import android.widget.Toast;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.UmengManager;
import com.tencent.mm.opensdk.modelmsg.SendAuth$Resp;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ap implements C0420b {
    /* renamed from: a */
    private final C0706e f2367a;
    /* renamed from: b */
    private aq f2368b = null;
    /* renamed from: c */
    private final ConcurrentLinkedQueue<C0420b> f2369c = new ConcurrentLinkedQueue();

    public ap(C0706e c0706e) {
        this.f2367a = c0706e;
    }

    /* renamed from: a */
    public synchronized void m3374a(C0420b c0420b) {
        if (c0420b != null) {
            this.f2369c.add(c0420b);
        }
        if (this.f2368b != null) {
            m3372a();
        } else {
            this.f2368b = new ch().m3437a((MiAccount) this.f2367a.mo876a(MiAccount.class), this);
            this.f2368b.mo866a();
        }
    }

    /* renamed from: b */
    public synchronized void m3375b(C0420b c0420b) {
        if (c0420b != null) {
            this.f2369c.add(c0420b);
        }
        if (this.f2368b != null) {
            m3372a();
        } else {
            this.f2368b = new ak().m3363a((MiAccount) this.f2367a.mo876a(MiAccount.class), this);
            this.f2368b.mo866a();
        }
    }

    /* renamed from: c */
    public synchronized void m3376c(C0420b c0420b) {
        if (c0420b != null) {
            this.f2369c.add(c0420b);
        }
        if (this.f2368b != null) {
            m3372a();
        } else {
            this.f2368b = new ac().m3359a((MiAccount) this.f2367a.mo876a(MiAccount.class), this);
            this.f2368b.mo866a();
            UmengManager.get().onEvent("ACCOUNT_AUTOLOGIN_V1", "start");
        }
    }

    /* renamed from: d */
    public synchronized void m3377d(C0420b c0420b) {
        if (c0420b != null) {
            this.f2369c.add(c0420b);
        }
        if (this.f2368b != null) {
            m3372a();
        } else {
            this.f2368b = new bt().m3423a((MiGuestAccount) this.f2367a.mo876a(MiGuestAccount.class), this);
            this.f2368b.mo866a();
        }
    }

    /* renamed from: a */
    public synchronized void m3373a(MiGuestAccount miGuestAccount, SendAuth$Resp sendAuth$Resp) {
        if (this.f2368b instanceof br) {
            ((br) this.f2368b).m3422a(miGuestAccount, sendAuth$Resp);
        }
    }

    /* renamed from: a */
    private void m3372a() {
        Toast.makeText(DkApp.get(), C0247i.account__shared__duokan_logging_in, 0).show();
    }

    public void onLoginOk(C0672a c0672a) {
        ((PersonalAccount) this.f2367a.mo876a(PersonalAccount.class)).m3255a(c0672a);
        Iterator it = this.f2369c.iterator();
        while (it.hasNext()) {
            ((C0420b) it.next()).onLoginOk(c0672a);
        }
        this.f2369c.clear();
        this.f2368b = null;
    }

    public void onLoginError(C0672a c0672a, String str) {
        ((MiAccount) this.f2367a.mo876a(MiAccount.class)).mo851u();
        ((MiGuestAccount) this.f2367a.mo876a(MiGuestAccount.class)).mo851u();
        Iterator it = this.f2369c.iterator();
        while (it.hasNext()) {
            ((C0420b) it.next()).onLoginError(c0672a, str);
        }
        this.f2369c.clear();
        this.f2368b = null;
    }
}
