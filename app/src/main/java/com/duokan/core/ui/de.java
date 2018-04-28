package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.duokan.core.sys.C0373z;
import com.umeng.analytics.pro.C2295j;

class de extends dh {
    /* renamed from: a */
    static final /* synthetic */ boolean f1135a = (!cv.class.desiredAssertionStatus());
    /* renamed from: b */
    private final Activity f1136b;
    /* renamed from: c */
    private final WindowManager f1137c;
    /* renamed from: d */
    private dg f1138d = null;
    /* renamed from: e */
    private dg f1139e = null;

    public de(Activity activity) {
        super();
        this.f1136b = activity;
        this.f1137c = this.f1136b.getWindowManager();
    }

    /* renamed from: a */
    public void m1802a() {
        dc dcVar = new dc();
        dcVar.f1129a = true;
        int i = this.f1136b.getWindow().getAttributes().flags;
        if ((i & 2048) == 2048) {
            dcVar.f1129a = true;
        } else if ((i & 1024) == 1024) {
            dcVar.f1129a = false;
        }
        if (this.f1139e != null) {
            dcVar.f1129a = this.f1139e.m1811a(dcVar.f1129a);
        }
        if (this.f1138d != null) {
            dcVar.f1129a = this.f1138d.m1811a(dcVar.f1129a);
        }
        if (VERSION.SDK_INT < 19) {
            dcVar.f1130b = false;
        } else if ((i & 67108864) == 67108864) {
            dcVar.f1130b = true;
        } else {
            dcVar.f1130b = false;
        }
        if (VERSION.SDK_INT >= 23) {
            boolean z;
            if ((this.f1136b.getWindow().getDecorView().getSystemUiVisibility() & 8192) == 8192) {
                z = true;
            } else {
                z = false;
            }
            dcVar.f1131c = z;
        } else {
            dcVar.f1131c = C0373z.m1053a(this.f1136b);
        }
        if (this.f1139e != null) {
            dcVar.f1131c = this.f1139e.m1814b(dcVar.f1131c);
        }
        if (this.f1138d != null) {
            dcVar.f1131c = this.f1138d.m1814b(dcVar.f1131c);
        }
        if (this.f1139e != null) {
            dcVar.f1132d = this.f1139e.m1810a();
            dcVar.f1133e = true;
            m1796a(this.f1139e.f1141a, dcVar);
        }
        if (this.f1138d != null) {
            dcVar.f1132d = false;
            dcVar.f1133e = false;
            m1796a(this.f1138d.f1141a, dcVar);
        }
    }

    /* renamed from: b */
    public int m1804b() {
        int i = 0;
        int b = this.f1138d == null ? 0 : this.f1138d.m1812b();
        if (this.f1139e != null) {
            i = this.f1139e.m1812b();
        }
        return b + i;
    }

    /* renamed from: a */
    public cv m1801a(int i) {
        if (this.f1139e != null && i < this.f1139e.m1812b()) {
            return this.f1139e.m1808a(i);
        }
        return this.f1138d.m1808a(i - (this.f1139e == null ? 0 : this.f1139e.m1812b()));
    }

    /* renamed from: a */
    public void m1803a(cv cvVar) {
        if (this.f1139e == null) {
            this.f1139e = new dg(m1799e());
        }
        if (this.f1138d == null) {
            this.f1138d = new dg(m1798d());
        }
        if (cvVar.f1099g) {
            this.f1138d.m1809a(cvVar);
        } else {
            this.f1139e.m1809a(cvVar);
        }
        m1802a();
        if (this.f1139e.f1141a.getParent() == null) {
            m1795a(this.f1139e.f1141a);
        }
        if (this.f1138d.f1141a.getParent() == null) {
            m1795a(this.f1138d.f1141a);
        }
    }

    /* renamed from: b */
    public void m1805b(cv cvVar) {
        if (cvVar.f1099g) {
            if (f1135a || this.f1138d != null) {
                this.f1138d.m1813b(cvVar);
            } else {
                throw new AssertionError();
            }
        } else if (f1135a || this.f1139e != null) {
            this.f1139e.m1813b(cvVar);
        } else {
            throw new AssertionError();
        }
        if (m1804b() < 1) {
            if (this.f1138d != null) {
                m1797b(this.f1138d.f1141a);
                this.f1138d = null;
            }
            if (this.f1139e != null) {
                m1797b(this.f1139e.f1141a);
                this.f1139e = null;
                return;
            }
            return;
        }
        m1802a();
    }

    /* renamed from: c */
    public void m1806c() {
        if (this.f1138d != null) {
            this.f1138d.m1815c();
        }
        if (this.f1139e != null) {
            this.f1139e.m1815c();
        }
    }

    /* renamed from: d */
    private dd m1798d() {
        LayoutParams f = m1800f();
        f.flags |= 272;
        dd ddVar = new dd(this.f1136b);
        ddVar.setVisibility(8);
        ddVar.setLayoutParams(f);
        return ddVar;
    }

    /* renamed from: e */
    private dd m1799e() {
        LayoutParams f = m1800f();
        dd dfVar = new df(this, this.f1136b);
        dfVar.setLayoutParams(f);
        dfVar.setVisibility(8);
        dfVar.setSystemUiVisibility(C2295j.f14325e);
        return dfVar;
    }

    /* renamed from: f */
    private WindowManager.LayoutParams m1800f() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2;
        layoutParams.token = null;
        layoutParams.format = -3;
        layoutParams.flags &= -8883993;
        layoutParams.flags = (this.f1136b.getWindow().getAttributes().flags & 3072) | layoutParams.flags;
        if (VERSION.SDK_INT >= 21) {
            layoutParams.flags |= Integer.MIN_VALUE;
        }
        layoutParams.softInputMode = 48;
        return layoutParams;
    }

    @TargetApi(19)
    /* renamed from: a */
    private void m1796a(dd ddVar, dc dcVar) {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) ddVar.getLayoutParams();
        layoutParams.flags &= -67243017;
        if (dcVar.f1129a) {
            layoutParams.flags |= 2048;
        } else {
            layoutParams.flags |= 1024;
        }
        if (dcVar.f1130b) {
            layoutParams.flags |= 67108864;
        }
        if (!dcVar.f1132d) {
            layoutParams.flags |= 8;
            if (dcVar.f1133e) {
                layoutParams.flags |= 131072;
            }
        } else if (!dcVar.f1133e) {
            layoutParams.flags |= 131072;
        }
        if (VERSION.SDK_INT >= 23) {
            if (dcVar.f1131c) {
                ddVar.setSystemUiVisibility(ddVar.getSystemUiVisibility() | 8192);
            } else {
                ddVar.setSystemUiVisibility(ddVar.getSystemUiVisibility() & -8193);
            }
        }
        C0373z.m1049a((View) ddVar, dcVar.f1131c);
        if (ddVar.getParent() == null) {
            ddVar.setLayoutParams(layoutParams);
            return;
        }
        try {
            this.f1137c.updateViewLayout(ddVar, layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m1795a(dd ddVar) {
        try {
            this.f1137c.addView(ddVar, (WindowManager.LayoutParams) ddVar.getLayoutParams());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m1797b(dd ddVar) {
        try {
            this.f1137c.removeViewImmediate(ddVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
