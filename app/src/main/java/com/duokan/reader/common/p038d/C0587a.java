package com.duokan.reader.common.p038d;

import android.os.Handler;
import android.os.Looper;
import com.duokan.core.app.ApplicationsStateCallbacks;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.C0585n;
import com.duokan.reader.common.C0615m;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;

/* renamed from: com.duokan.reader.common.d.a */
public class C0587a implements ApplicationsStateCallbacks, C0563j, C0585n, C0586j {
    /* renamed from: a */
    private final Handler f1911a = new Handler(Looper.getMainLooper());
    /* renamed from: b */
    private final C0589c f1912b;
    /* renamed from: c */
    private final int f1913c;
    /* renamed from: d */
    private long f1914d;
    /* renamed from: e */
    private long f1915e;
    /* renamed from: f */
    private boolean f1916f = false;
    /* renamed from: g */
    private boolean f1917g = false;
    /* renamed from: h */
    private boolean f1918h = false;
    /* renamed from: i */
    private boolean f1919i = false;
    /* renamed from: j */
    private Runnable f1920j = null;

    public C0587a(C0589c c0589c, int i) {
        this.f1912b = c0589c;
        this.f1913c = i;
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (m2631c()) {
            if (runningState2 == RunningState.FOREGROUND) {
                m2628b(false, true);
            } else if (runningState2 == RunningState.BACKGROUND) {
                m2623a(false, true);
            } else if (runningState2 == RunningState.UNDERGROUND) {
                m2623a(false, true);
            }
        } else if (!m2629b()) {
        } else {
            if (runningState2 == RunningState.BACKGROUND && runningState == RunningState.UNDERGROUND) {
                m2628b(false, true);
            } else if (runningState2 == RunningState.UNDERGROUND) {
                m2623a(false, true);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo779a() {
        if (m2633e()) {
            if (C0615m.m2799a().m2803b()) {
                m2628b(false, true);
            } else {
                m2623a(false, true);
            }
        }
    }

    public void onConnectivityChanged(C0559f c0559f) {
        if (!m2632d()) {
            return;
        }
        if (c0559f.m2486e()) {
            m2628b(false, true);
        } else {
            m2623a(false, true);
        }
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        if (m2634f()) {
            m2628b(true, true);
        }
    }

    public void onAccountLogoff(C0672a c0672a) {
        if (m2634f()) {
            m2623a(true, true);
        }
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: a */
    public synchronized void m2637a(int i) {
        if (!this.f1916f) {
            if (m2633e()) {
                C0615m.m2799a().m2802a((C0585n) this);
            }
            if (m2634f()) {
                C0709k.m3476a().m3494a((C0586j) this);
            }
            if (m2632d()) {
                C0559f.m2476b().m2481a((C0563j) this);
            }
            if (m2629b() || m2631c()) {
                DkApp.get().addOnRunningStateChangedListener(this);
            }
            this.f1914d = System.currentTimeMillis();
            this.f1915e = (long) i;
            this.f1916f = true;
            if (m2635g()) {
                m2622a(false);
            } else {
                this.f1917g = true;
                this.f1918h = true;
            }
        }
    }

    /* renamed from: a */
    public synchronized void m2638a(long j) {
        this.f1919i = false;
        this.f1914d = System.currentTimeMillis();
        this.f1915e = j;
        if (this.f1916f && !this.f1917g) {
            m2622a(false);
        }
    }

    /* renamed from: b */
    private boolean m2629b() {
        return (this.f1913c & 1) == 1;
    }

    /* renamed from: c */
    private boolean m2631c() {
        return (this.f1913c & 2) == 2;
    }

    /* renamed from: d */
    private boolean m2632d() {
        return (this.f1913c & 4) == 4;
    }

    /* renamed from: e */
    private boolean m2633e() {
        return (this.f1913c & 8) == 8;
    }

    /* renamed from: f */
    private boolean m2634f() {
        return (this.f1913c & 16) == 16;
    }

    /* renamed from: a */
    private void m2623a(boolean z, boolean z2) {
        if (!this.f1916f) {
            return;
        }
        if (!this.f1917g) {
            this.f1917g = true;
            this.f1918h = z2;
            m2627b(z);
        } else if (this.f1918h && !z2) {
            this.f1918h = z2;
        }
    }

    /* renamed from: b */
    private void m2628b(boolean z, boolean z2) {
        if (this.f1916f && this.f1917g) {
            if (!(this.f1918h || z2)) {
                this.f1918h = true;
            }
            if (!m2635g()) {
                return;
            }
            if (!z2 || this.f1918h) {
                this.f1917g = false;
                this.f1918h = false;
                m2630c(z);
            }
        }
    }

    /* renamed from: a */
    private void m2622a(boolean z) {
        if (!this.f1919i && this.f1920j == null) {
            long currentTimeMillis = (this.f1914d + this.f1915e) - System.currentTimeMillis();
            if (currentTimeMillis < 0 || z) {
                currentTimeMillis = 0;
            }
            this.f1920j = new C0588b(this);
            this.f1911a.postDelayed(this.f1920j, currentTimeMillis);
        }
    }

    /* renamed from: b */
    private void m2627b(boolean z) {
        if (z) {
            this.f1911a.removeCallbacksAndMessages(null);
            this.f1920j = null;
        }
    }

    /* renamed from: c */
    private void m2630c(boolean z) {
        m2622a(z);
    }

    /* renamed from: g */
    private boolean m2635g() {
        if (m2629b() && ManagedApp.get().getRunningState() == RunningState.UNDERGROUND) {
            return false;
        }
        if (m2631c() && ManagedApp.get().getRunningState() != RunningState.FOREGROUND) {
            return false;
        }
        if (m2632d() && !C0559f.m2476b().m2486e()) {
            return false;
        }
        if (m2633e() && !C0615m.m2799a().m2803b()) {
            return false;
        }
        if (m2634f() && C0709k.m3476a().m3508d().mo839i()) {
            return false;
        }
        return true;
    }
}
