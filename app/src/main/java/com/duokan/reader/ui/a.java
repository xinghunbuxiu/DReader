package com.duokan.reader.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.sys.t;
import com.duokan.core.sys.z;
import com.duokan.core.ui.cv;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.SystemUiMode;

public class a extends FrameLayout {
    private static final int a = VERSION.SDK_INT;
    private final Activity b;
    private final View c;
    private final int d;
    private boolean e = true;
    private final View f;
    private int g = 0;
    private int h = -16777216;
    private SystemUiMode i = SystemUiMode.DOCK;
    private View j = null;

    @TargetApi(21)
    public a(Activity activity) {
        super(activity);
        this.b = activity;
        if (VERSION.SDK_INT >= 19) {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                this.d = getResources().getDimensionPixelSize(identifier);
            } else {
                this.d = dv.b(getContext(), 20.0f);
            }
        } else {
            this.d = 0;
        }
        this.c = new View(getContext());
        addView(this.c, new LayoutParams(-1, this.d, 48));
        this.f = new View(getContext());
        addView(this.f, new LayoutParams(-1, this.g, 80));
        if (a >= 23) {
            this.h = this.b.getWindow().getNavigationBarColor();
            this.f.setBackgroundColor(this.h);
            this.b.getWindow().getDecorView().setOnApplyWindowInsetsListener(new b(this));
        }
        f();
    }

    public void setContentView(View view) {
        if (this.j != null) {
            removeView(this.j);
            this.j = null;
        }
        if (view != null) {
            this.j = view;
            addView(this.j, 0, new LayoutParams(-1, -1));
            e();
        }
    }

    public int getStatusBarHeight() {
        return this.d;
    }

    public void setStatusBarStyle(boolean z) {
        if (this.e != z) {
            this.e = z;
            f();
        }
    }

    public void setNavigationBarMode(SystemUiMode systemUiMode) {
        if (systemUiMode == SystemUiMode.GONE) {
            b();
            a(this.b.getWindow());
        } else {
            a();
            a(this.b.getWindow(), systemUiMode == SystemUiMode.DOCK);
        }
        if (this.i != systemUiMode) {
            this.i = systemUiMode;
            e();
        }
    }

    public void setNavigationBarColor(int i) {
        if (this.h != i) {
            this.h = i;
            if (this.f.getVisibility() == 0) {
                t.a(new c(this, i), 200);
            }
        }
    }

    private void a() {
        if (this.c.getVisibility() != 0) {
            this.c.setVisibility(0);
            dv.d(this.c, null);
        }
    }

    private void b() {
        if (this.c.getVisibility() != 4) {
            this.c.setVisibility(4);
            dv.f(this.c, null);
        }
    }

    private void a(int i) {
        if (this.g != i) {
            this.g = i;
            e();
        }
    }

    private void c() {
        if (this.f.getVisibility() != 0) {
            this.f.setBackgroundColor(this.h);
            this.f.setVisibility(0);
            dv.e(this.f, null);
        }
    }

    private void d() {
        if (this.f.getVisibility() != 4) {
            this.f.setVisibility(4);
            dv.g(this.f, null);
        }
    }

    private void e() {
        if (this.j != null) {
            int i;
            LayoutParams layoutParams = (LayoutParams) this.j.getLayoutParams();
            switch (d.a[this.i.ordinal()]) {
                case 1:
                    i = 0;
                    break;
                case 2:
                    i = this.g;
                    break;
                default:
                    i = layoutParams.bottomMargin;
                    break;
            }
            if (layoutParams.bottomMargin != i) {
                layoutParams.bottomMargin = i;
                this.j.requestLayout();
            }
        }
        if (this.f.getLayoutParams().height != this.g) {
            this.f.getLayoutParams().height = this.g;
            this.f.requestLayout();
        }
    }

    private void f() {
        if (a >= 23) {
            this.c.setBackgroundColor(0);
            int systemUiVisibility = this.b.getWindow().getDecorView().getSystemUiVisibility();
            if (this.e) {
                this.b.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility | 8192);
            } else {
                this.b.getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility & -8193);
            }
            if (ReaderEnv.get().onMiui()) {
                z.a(this.b, this.e);
            }
        } else if (ReaderEnv.get().onMiui()) {
            this.c.setBackgroundColor(0);
            z.a(this.b, this.e);
        } else {
            this.c.setBackgroundColor(Color.argb(Math.round(25.5f), 0, 0, 0));
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        if ((i & 2) == 2) {
            d();
        } else {
            c();
        }
    }

    @TargetApi(20)
    private static void a(Window window, boolean z) {
        int i;
        int i2 = 0;
        if (a >= 23) {
            i = -2147481344;
        } else if (a >= 19) {
            i = 67111168;
        } else {
            i = 67840;
        }
        window.setFlags(i, -2080305408);
        if (Build.MODEL.equalsIgnoreCase("Kindle Fire")) {
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (a >= 23) {
            i2 = 768;
            i = z ? 4098 : 2;
        } else if (a >= 19) {
            i2 = j.e;
            i = z ? 4610 : 2;
        } else {
            i = a >= 14 ? -2 : 0;
        }
        window.getDecorView().setSystemUiVisibility((i ^ -1) & (i2 | systemUiVisibility));
        if (a >= 23) {
            window.getDecorView().requestApplyInsets();
        }
        cv.updateLayout();
    }

    @TargetApi(19)
    private static void a(Window window) {
        int i;
        if (a >= 23) {
            i = -2147482368;
        } else if (a >= 19) {
            i = 67110144;
        } else {
            i = 1280;
        }
        window.setFlags(i, -2080305408);
        if (Build.MODEL.equalsIgnoreCase("Kindle Fire")) {
            window.addFlags(j.g);
            window.getDecorView().setPadding(0, 0, 0, 20);
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (a >= 19) {
            i = 4866;
        } else if (a >= 14) {
            i = 1;
        } else {
            i = 0;
        }
        window.getDecorView().setSystemUiVisibility((i | systemUiVisibility) & -1);
        if (a >= 23) {
            window.getDecorView().requestApplyInsets();
        }
        cv.updateLayout();
    }
}
