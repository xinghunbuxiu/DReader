package com.duokan.reader.common.d;

import android.os.Handler;
import android.os.Looper;

import com.duokan.core.app.IActivityRunStatusChanged;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.c.g;
import com.duokan.reader.common.m;
import com.duokan.reader.common.n;
import com.duokan.reader.domain.account.h;

public class a implements IActivityRunStatusChanged, g, n, h {
    private final Handler a = new Handler(Looper.getMainLooper());
    private final c b;
    private final int c;
    private long d;
    private long e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private Runnable j = null;

    public a(c cVar, int i) {
        this.b = cVar;
        this.c = i;
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (c()) {
            if (runningState2 == RunningState.FOREGROUND) {
                b(false, true);
            } else if (runningState2 == RunningState.BACKGROUND) {
                a(false, true);
            } else if (runningState2 == RunningState.UNDERGROUND) {
                a(false, true);
            }
        } else if (!b()) {
        } else {
            if (runningState2 == RunningState.BACKGROUND && runningState == RunningState.UNDERGROUND) {
                b(false, true);
            } else if (runningState2 == RunningState.UNDERGROUND) {
                a(false, true);
            }
        }
    }

    public synchronized void a() {
        if (e()) {
            if (m.a().b()) {
                b(false, true);
            } else {
                a(false, true);
            }
        }
    }

    public void onConnectivityChanged(f fVar) {
        if (!d()) {
            return;
        }
        if (fVar.e()) {
            b(false, true);
        } else {
            a(false, true);
        }
    }

    public void a(com.duokan.reader.domain.account.a aVar) {
    }

    public void b(com.duokan.reader.domain.account.a aVar) {
        if (f()) {
            b(true, true);
        }
    }

    public void c(com.duokan.reader.domain.account.a aVar) {
        if (f()) {
            a(true, true);
        }
    }

    public void d(com.duokan.reader.domain.account.a aVar) {
    }

    public synchronized void a(int i) {
        if (!this.f) {
            if (e()) {
                m.a().a((n) this);
            }
            if (f()) {
                i.f().a((h) this);
            }
            if (d()) {
                f.b().a((g) this);
            }
            if (b() || c()) {
                DkApp.get().addOnRunningStateChangedListener(this);
            }
            this.d = System.currentTimeMillis();
            this.e = (long) i;
            this.f = true;
            if (g()) {
                a(false);
            } else {
                this.g = true;
                this.h = true;
            }
        }
    }

    public synchronized void a(long j) {
        this.i = false;
        this.d = System.currentTimeMillis();
        this.e = j;
        if (this.f && !this.g) {
            a(false);
        }
    }

    private boolean b() {
        return (this.c & 1) == 1;
    }

    private boolean c() {
        return (this.c & 2) == 2;
    }

    private boolean d() {
        return (this.c & 4) == 4;
    }

    private boolean e() {
        return (this.c & 8) == 8;
    }

    private boolean f() {
        return (this.c & 16) == 16;
    }

    private void a(boolean z, boolean z2) {
        if (!this.f) {
            return;
        }
        if (!this.g) {
            this.g = true;
            this.h = z2;
            b(z);
        } else if (this.h && !z2) {
            this.h = z2;
        }
    }

    private void b(boolean z, boolean z2) {
        if (this.f && this.g) {
            if (!(this.h || z2)) {
                this.h = true;
            }
            if (!g()) {
                return;
            }
            if (!z2 || this.h) {
                this.g = false;
                this.h = false;
                c(z);
            }
        }
    }

    private void a(boolean z) {
        if (!this.i && this.j == null) {
            long currentTimeMillis = (this.d + this.e) - System.currentTimeMillis();
            if (currentTimeMillis < 0 || z) {
                currentTimeMillis = 0;
            }
            this.j = new b(this);
            this.a.postDelayed(this.j, currentTimeMillis);
        }
    }

    private void b(boolean z) {
        if (z) {
            this.a.removeCallbacksAndMessages(null);
            this.j = null;
        }
    }

    private void c(boolean z) {
        a(z);
    }

    private boolean g() {
        if (b() && ManagedApp.get().getOldRunningState() == RunningState.UNDERGROUND) {
            return false;
        }
        if (c() && ManagedApp.get().getOldRunningState() != RunningState.FOREGROUND) {
            return false;
        }
        if (d() && !f.b().e()) {
            return false;
        }
        if (e() && !m.a().b()) {
            return false;
        }
        if (f() && i.f().c().i()) {
            return false;
        }
        return true;
    }
}
