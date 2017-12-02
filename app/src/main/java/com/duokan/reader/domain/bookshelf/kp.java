package com.duokan.reader.domain.bookshelf;

import android.content.Context;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.c.g;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreAdInfo;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.eo;

import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public class kp implements ah, g, h {
    private static final ai a = new ai();
    private Context b;
    private final f c;
    private final i d;
    private final PersonalPrefs e;
    private final CopyOnWriteArrayList f = new CopyOnWriteArrayList();
    private ab g;
    private r h;
    private r i;
    private eo j = null;

    public static void a(Context context, i iVar, f fVar, PersonalPrefs personalPrefs) {
        a.a(new kp(context, iVar, fVar, personalPrefs));
    }

    public static kp a() {
        return (kp) a.a();
    }

    private kp(Context context, i iVar, f fVar, PersonalPrefs personalPrefs) {
        this.b = context;
        this.d = iVar;
        this.c = fVar;
        this.e = personalPrefs;
        this.d.a((h) this);
        this.c.a((g) this);
    }

    public void a(la laVar) {
        this.f.addIfAbsent(laVar);
    }

    public void b(la laVar) {
        this.f.remove(laVar);
    }

    public CopyOnWriteArrayList b() {
        return this.f;
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((la) it.next()).a(z, z2);
        }
    }

    public void b(boolean z) {
        if (this.d.a(PersonalAccount.class) && this.c.e()) {
            new kq(this, z).open();
        } else {
            a(z);
        }
    }

    public void c() {
        d();
        this.d.a(PersonalAccount.class, new kr(this));
    }

    public void a(DkSignInInfo dkSignInInfo) {
        dkSignInInfo.mLottery = b(dkSignInInfo.mSignStatus, dkSignInInfo.mToday, dkSignInInfo.mLottery);
        a(dkSignInInfo.mSignStatus, dkSignInInfo.mToday, dkSignInInfo.mLottery);
        a(true);
    }

    private void j() {
        if (!(this.h == null || this.h.getIsClosed() || this.h.isCancelling())) {
            this.h.close();
        }
        if (this.i != null && !this.i.getIsClosed() && !this.i.isCancelling()) {
            this.i.close();
        }
    }

    public void a(ab abVar) {
        this.g = abVar;
    }

    public void a(List list) {
        d();
        a.c().c(LogLevel.EVENT, "resign_event", "receive_succeed");
        if (this.e.a(this.g)) {
            new ku(this, list).open();
            return;
        }
        e();
        be.a(this.b, com.duokan.b.i.general__shared__account_change, 0).show();
    }

    public synchronized void d() {
        if (this.j == null) {
            if (DkApp.get().getTopActivity() != null) {
                this.j = new kv(this, DkApp.get().getTopActivity());
            }
        }
        if (!this.j.isShowing()) {
            this.j.show();
        }
    }

    public void e() {
        if (this.j != null) {
            this.j.dismiss();
        }
    }

    public void f() {
        d();
        this.d.a(PersonalAccount.class, new kw(this));
    }

    private void a(boolean[] zArr, int i, boolean z) {
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
            this.e.b(str.substring(1));
        }
        this.e.c(i);
        this.e.b(z);
        this.e.d((int) ((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000));
    }

    private void a(boolean[] zArr, int i, List list, boolean z, boolean z2, boolean z3, boolean z4, int i2, DkStoreAdInfo[] dkStoreAdInfoArr) {
        if (list == null || list.size() == 0) {
            e();
            g();
            return;
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((la) it.next()).a(zArr, i, list, z, z2, z3, z4, i2, dkStoreAdInfoArr);
        }
    }

    public void g() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((la) it.next()).d();
        }
    }

    public void h() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((la) it.next()).c();
        }
    }

    public void i() {
        d();
        new kz(this).open();
    }

    public int a(boolean[] zArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i - 1; i3++) {
            if (!zArr[i3]) {
                i2++;
            }
        }
        return i2;
    }

    private boolean b(boolean[] zArr, int i, boolean z) {
        return a(zArr, i) == 0 && i == 7 && zArr[i - 1] && z;
    }

    public void a(com.duokan.reader.domain.account.a aVar) {
    }

    public void b(com.duokan.reader.domain.account.a aVar) {
        if (!this.e.j()) {
            a(false);
        }
        b(true);
    }

    public void c(com.duokan.reader.domain.account.a aVar) {
        if (!this.e.j()) {
            a(false);
        }
        b(true);
    }

    public void d(com.duokan.reader.domain.account.a aVar) {
    }

    public void onConnectivityChanged(f fVar) {
        if ((!this.c.e() || ManagedApp.get().getRunningState() != RunningState.FOREGROUND) && !this.c.d()) {
            return;
        }
        if (this.e.m()) {
            b(true);
        } else {
            a(true);
        }
    }
}
