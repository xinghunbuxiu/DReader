package com.duokan.reader.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.C0373z;
import com.duokan.core.ui.cv;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.SystemUiMode;
import com.umeng.analytics.pro.C2295j;

/* renamed from: com.duokan.reader.ui.a */
public class C1235a extends FrameLayout {
    /* renamed from: a */
    private static final int f5739a = VERSION.SDK_INT;
    /* renamed from: b */
    private final Activity f5740b;
    /* renamed from: c */
    private final View f5741c;
    /* renamed from: d */
    private final int f5742d;
    /* renamed from: e */
    private boolean f5743e = true;
    /* renamed from: f */
    private final View f5744f;
    /* renamed from: g */
    private int f5745g = 0;
    /* renamed from: h */
    private int f5746h = -16777216;
    /* renamed from: i */
    private SystemUiMode f5747i = SystemUiMode.DOCK;
    /* renamed from: j */
    private View f5748j = null;

    @TargetApi(21)
    public C1235a(Activity activity) {
        super(activity);
        this.f5740b = activity;
        if (VERSION.SDK_INT >= 19) {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                this.f5742d = getResources().getDimensionPixelSize(identifier);
            } else {
                this.f5742d = dv.m1932b(getContext(), 20.0f);
            }
        } else {
            this.f5742d = 0;
        }
        this.f5741c = new View(getContext());
        addView(this.f5741c, new LayoutParams(-1, this.f5742d, 48));
        this.f5744f = new View(getContext());
        addView(this.f5744f, new LayoutParams(-1, this.f5745g, 80));
        if (f5739a >= 23) {
            this.f5746h = this.f5740b.getWindow().getNavigationBarColor();
            this.f5744f.setBackgroundColor(this.f5746h);
            this.f5740b.getWindow().getDecorView().setOnApplyWindowInsetsListener(new C1281b(this));
        }
        m8814f();
    }

    public void setContentView(View view) {
        if (this.f5748j != null) {
            removeView(this.f5748j);
            this.f5748j = null;
        }
        if (view != null) {
            this.f5748j = view;
            addView(this.f5748j, 0, new LayoutParams(-1, -1));
            m8813e();
        }
    }

    public int getStatusBarHeight() {
        return this.f5742d;
    }

    public void setStatusBarStyle(boolean z) {
        if (this.f5743e != z) {
            this.f5743e = z;
            m8814f();
        }
    }

    public void setNavigationBarMode(SystemUiMode systemUiMode) {
        if (systemUiMode == SystemUiMode.GONE) {
            m8810b();
            C1235a.m8806a(this.f5740b.getWindow());
        } else {
            m8804a();
            C1235a.m8807a(this.f5740b.getWindow(), systemUiMode == SystemUiMode.DOCK);
        }
        if (this.f5747i != systemUiMode) {
            this.f5747i = systemUiMode;
            m8813e();
        }
    }

    public void setNavigationBarColor(int i) {
        if (this.f5746h != i) {
            this.f5746h = i;
            if (this.f5744f.getVisibility() == 0) {
                UThread.postDelayed(new C1313c(this, i), 200);
            }
        }
    }

    /* renamed from: a */
    private void m8804a() {
        if (this.f5741c.getVisibility() != 0) {
            this.f5741c.setVisibility(0);
            dv.m1954d(this.f5741c, null);
        }
    }

    /* renamed from: b */
    private void m8810b() {
        if (this.f5741c.getVisibility() != 4) {
            this.f5741c.setVisibility(4);
            dv.m1961f(this.f5741c, null);
        }
    }

    /* renamed from: a */
    private void m8805a(int i) {
        if (this.f5745g != i) {
            this.f5745g = i;
            m8813e();
        }
    }

    /* renamed from: c */
    private void m8811c() {
        if (this.f5744f.getVisibility() != 0) {
            this.f5744f.setBackgroundColor(this.f5746h);
            this.f5744f.setVisibility(0);
            dv.m1958e(this.f5744f, null);
        }
    }

    /* renamed from: d */
    private void m8812d() {
        if (this.f5744f.getVisibility() != 4) {
            this.f5744f.setVisibility(4);
            dv.loadSuccess(this.f5744f, null);
        }
    }

    /* renamed from: e */
    private void m8813e() {
        if (this.f5748j != null) {
            int i;
            LayoutParams layoutParams = (LayoutParams) this.f5748j.getLayoutParams();
            switch (C1314d.f6753a[this.f5747i.ordinal()]) {
                case 1:
                    i = 0;
                    break;
                case 2:
                    i = this.f5745g;
                    break;
                default:
                    i = layoutParams.bottomMargin;
                    break;
            }
            if (layoutParams.bottomMargin != i) {
                layoutParams.bottomMargin = i;
                this.f5748j.requestLayout();
            }
        }
        if (this.f5744f.getLayoutParams().height != this.f5745g) {
            this.f5744f.getLayoutParams().height = this.f5745g;
            this.f5744f.requestLayout();
        }
    }

    /* renamed from: f */
    private void m8814f() {
        if (f5739a >= 23) {
            this.f5741c.setBackgroundColor(0);
            int systemUiVisibility = this.f5740b.getWindow().getDecorView().getSystemUiVisibility();
            if (this.f5743e) {
                this.f5740b.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility | 8192);
            } else {
                this.f5740b.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility & -8193);
            }
            if (ReaderEnv.get().onMiui()) {
                C0373z.m1048a(this.f5740b, this.f5743e);
            }
        } else if (ReaderEnv.get().onMiui()) {
            this.f5741c.setBackgroundColor(0);
            C0373z.m1048a(this.f5740b, this.f5743e);
        } else {
            this.f5741c.setBackgroundColor(Color.argb(Math.round(25.5f), 0, 0, 0));
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if ((i & 2) == 2) {
            m8812d();
        } else {
            m8811c();
        }
    }

    @TargetApi(20)
    /* renamed from: a */
    private static void m8807a(Window window, boolean z) {
        int i;
        int i2 = 0;
        if (f5739a >= 23) {
            i = -2147481344;
        } else if (f5739a >= 19) {
            i = 67111168;
        } else {
            i = 67840;
        }
        window.setFlags(i, -2080305408);
        if (Build.MODEL.equalsIgnoreCase("Kindle Fire")) {
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (f5739a >= 23) {
            i2 = 768;
            i = z ? 4098 : 2;
        } else if (f5739a >= 19) {
            i2 = C2295j.f14325e;
            i = z ? 4610 : 2;
        } else {
            i = f5739a >= 14 ? -2 : 0;
        }
        window.getDecorView().setSystemUiVisibility((i ^ -1) & (i2 | systemUiVisibility));
        if (f5739a >= 23) {
            window.getDecorView().requestApplyInsets();
        }
        cv.updateLayout();
    }

    @TargetApi(19)
    /* renamed from: a */
    private static void m8806a(Window window) {
        int i;
        if (f5739a >= 23) {
            i = -2147482368;
        } else if (f5739a >= 19) {
            i = 67110144;
        } else {
            i = 1280;
        }
        window.setFlags(i, -2080305408);
        if (Build.MODEL.equalsIgnoreCase("Kindle Fire")) {
            window.addFlags(C2295j.f14327g);
            window.getDecorView().setPadding(0, 0, 0, 20);
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (f5739a >= 19) {
            i = 4866;
        } else if (f5739a >= 14) {
            i = 1;
        } else {
            i = 0;
        }
        window.getDecorView().setSystemUiVisibility((i | systemUiVisibility) & -1);
        if (f5739a >= 23) {
            window.getDecorView().requestApplyInsets();
        }
        cv.updateLayout();
    }
}
