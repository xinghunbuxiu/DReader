package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

import com.duokan.core.sys.z;
import com.umeng.analytics.pro.j;

class de extends dh {
    static final /* synthetic */ boolean a = (!cv.class.desiredAssertionStatus());
    private final Activity b;
    private final WindowManager c;
    private dg d = null;
    private dg e = null;

    public de(Activity activity) {
        super();
        this.b = activity;
        this.c = this.b.getWindowManager();
    }

    public void a() {
        dc dcVar = new dc();
        dcVar.a = true;
        int i = this.b.getWindow().getAttributes().flags;
        if ((i & 2048) == 2048) {
            dcVar.a = true;
        } else if ((i & 1024) == 1024) {
            dcVar.a = false;
        }
        if (this.e != null) {
            dcVar.a = this.e.a(dcVar.a);
        }
        if (this.d != null) {
            dcVar.a = this.d.a(dcVar.a);
        }
        if (VERSION.SDK_INT < 19) {
            dcVar.b = false;
        } else if ((i & 67108864) == 67108864) {
            dcVar.b = true;
        } else {
            dcVar.b = false;
        }
        if (VERSION.SDK_INT >= 23) {
            boolean z;
            if ((this.b.getWindow().getDecorView().getSystemUiVisibility() & 8192) == 8192) {
                z = true;
            } else {
                z = false;
            }
            dcVar.c = z;
        } else {
            dcVar.c = z.a(this.b);
        }
        if (this.e != null) {
            dcVar.c = this.e.b(dcVar.c);
        }
        if (this.d != null) {
            dcVar.c = this.d.b(dcVar.c);
        }
        if (this.e != null) {
            dcVar.d = this.e.a();
            dcVar.e = true;
            a(this.e.a, dcVar);
        }
        if (this.d != null) {
            dcVar.d = false;
            dcVar.e = false;
            a(this.d.a, dcVar);
        }
    }

    public int b() {
        int i = 0;
        int b = this.d == null ? 0 : this.d.b();
        if (this.e != null) {
            i = this.e.b();
        }
        return b + i;
    }

    public cv a(int i) {
        if (this.e != null && i < this.e.b()) {
            return this.e.a(i);
        }
        return this.d.a(i - (this.e == null ? 0 : this.e.b()));
    }

    public void a(cv cvVar) {
        if (this.e == null) {
            this.e = new dg(e());
        }
        if (this.d == null) {
            this.d = new dg(d());
        }
        if (cvVar.g) {
            this.d.a(cvVar);
        } else {
            this.e.a(cvVar);
        }
        a();
        if (this.e.a.getParent() == null) {
            a(this.e.a);
        }
        if (this.d.a.getParent() == null) {
            a(this.d.a);
        }
    }

    public void b(cv cvVar) {
        if (cvVar.g) {
            if (a || this.d != null) {
                this.d.b(cvVar);
            } else {
                throw new AssertionError();
            }
        } else if (a || this.e != null) {
            this.e.b(cvVar);
        } else {
            throw new AssertionError();
        }
        if (b() < 1) {
            if (this.d != null) {
                b(this.d.a);
                this.d = null;
            }
            if (this.e != null) {
                b(this.e.a);
                this.e = null;
                return;
            }
            return;
        }
        a();
    }

    public void c() {
        if (this.d != null) {
            this.d.c();
        }
        if (this.e != null) {
            this.e.c();
        }
    }

    private dd d() {
        LayoutParams f = f();
        f.flags |= 272;
        dd ddVar = new dd(this.b);
        ddVar.setVisibility(8);
        ddVar.setLayoutParams(f);
        return ddVar;
    }

    private dd e() {
        LayoutParams f = f();
        dd dfVar = new df(this, this.b);
        dfVar.setLayoutParams(f);
        dfVar.setVisibility(8);
        dfVar.setSystemUiVisibility(j.e);
        return dfVar;
    }

    private WindowManager.LayoutParams f() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2;
        layoutParams.token = null;
        layoutParams.format = -3;
        layoutParams.flags &= -8883993;
        layoutParams.flags = (this.b.getWindow().getAttributes().flags & 3072) | layoutParams.flags;
        if (VERSION.SDK_INT >= 21) {
            layoutParams.flags |= Integer.MIN_VALUE;
        }
        layoutParams.softInputMode = 48;
        return layoutParams;
    }

    @TargetApi(19)
    private void a(dd ddVar, dc dcVar) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) ddVar.getLayoutParams();
        layoutParams.flags &= -67243017;
        if (dcVar.a) {
            layoutParams.flags |= 2048;
        } else {
            layoutParams.flags |= 1024;
        }
        if (dcVar.b) {
            layoutParams.flags |= 67108864;
        }
        if (!dcVar.d) {
            layoutParams.flags |= 8;
            if (dcVar.e) {
                layoutParams.flags |= 131072;
            }
        } else if (!dcVar.e) {
            layoutParams.flags |= 131072;
        }
        if (VERSION.SDK_INT >= 23) {
            if (dcVar.c) {
                ddVar.setSystemUiVisibility(ddVar.getSystemUiVisibility() | 8192);
            } else {
                ddVar.setSystemUiVisibility(ddVar.getSystemUiVisibility() & -8193);
            }
        }
        z.a((View) ddVar, dcVar.c);
        if (ddVar.getParent() == null) {
            ddVar.setLayoutParams(layoutParams);
            return;
        }
        try {
            this.c.updateViewLayout(ddVar, layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(dd ddVar) {
        try {
            this.c.addView(ddVar, (WindowManager.LayoutParams) ddVar.getLayoutParams());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(dd ddVar) {
        try {
            this.c.removeViewImmediate(ddVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
