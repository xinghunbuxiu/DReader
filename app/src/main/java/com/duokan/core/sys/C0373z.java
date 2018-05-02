package com.duokan.core.sys;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.duokan.core.app.AppManage;
import java.lang.reflect.Method;

/* renamed from: com.duokan.core.sys.z */
public abstract class C0373z {
    /* renamed from: a */
    public static final int f741a;
    /* renamed from: b */
    private static final boolean f742b;
    /* renamed from: c */
    private static final af<Boolean> f743c = new af();

    static {
        boolean z;
        int i;
        boolean i2 = false;
        try {
            z = Class.forName("miui.os.Build") != null ? true : i2;
        } catch (Throwable th) {
            z = i2;
        }
        f742b = z;
        try {
            Class cls = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            i2 = cls.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls);
        } catch (Throwable th2) {
        }
        f741a = i2;
    }

    /* renamed from: a */
    public static boolean m1052a() {
        return f742b;
    }

    /* renamed from: a */
    public static int m1047a(LayoutParams layoutParams) {
        int i = 0;
        if (f742b) {
            try {
                i = layoutParams.getClass().getField("extraFlags").getInt(layoutParams);
            } catch (Throwable th) {
            }
        }
        return i;
    }

    /* renamed from: a */
    public static void m1051a(LayoutParams layoutParams, int i) {
        if (f742b) {
            try {
                layoutParams.getClass().getField("extraFlags").setInt(layoutParams, i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m1050a(Window window, boolean z) {
        int i = 0;
        if (f742b && VERSION.SDK_INT >= 19 && window != null) {
            try {
                Method method = window.getClass().getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                Object[] objArr = new Object[2];
                if (z) {
                    i = f741a;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(f741a);
                method.invoke(window, objArr);
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public static void m1049a(View view, boolean z) {
        if (f742b && VERSION.SDK_INT >= 19 && view != null) {
            View rootView = view.getRootView();
            if (rootView != null) {
                Activity a = AppManage.getCurrentActivity(view.getContext());
                if (a != null) {
                    try {
                        if (rootView == a.getWindow().getDecorView().getRootView()) {
                            C0373z.m1050a(a.getWindow(), z);
                            return;
                        }
                        LayoutParams layoutParams = (LayoutParams) rootView.getLayoutParams();
                        if (layoutParams != null) {
                            if (z) {
                                C0373z.m1051a(layoutParams, C0373z.m1047a(layoutParams) | f741a);
                            } else {
                                C0373z.m1051a(layoutParams, C0373z.m1047a(layoutParams) & (f741a ^ -1));
                            }
                            ((WindowManager) view.getContext().getSystemService("window")).updateViewLayout(rootView, layoutParams);
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m1053a(Activity activity) {
        if (!f742b || VERSION.SDK_INT < 19 || activity == null) {
            return false;
        }
        try {
            if ((C0373z.m1047a(activity.getWindow().getAttributes()) & f741a) == f741a) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m1048a(Activity activity, boolean z) {
        if (f742b && VERSION.SDK_INT >= 19 && activity != null) {
            try {
                C0373z.m1050a(activity.getWindow(), z);
            } catch (Throwable th) {
            }
        }
    }
}
