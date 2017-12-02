package com.duokan.core.sys;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import java.lang.reflect.Method;

public abstract class z {
    public static final int a;
    private static final boolean b;
    private static final af c = new af();

    static {
        boolean z;
        int i;
        boolean z2 = false;
        try {
            z = Class.forName("miui.os.Build") != null ? true : z2;
        } catch (Throwable th) {
            z = z2;
        }
        b = z;
        try {
            Class cls = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            i = cls.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls);
        } catch (Throwable th2) {
        }
        a = i;
    }

    public static boolean a() {
        return b;
    }

    public static int a(LayoutParams layoutParams) {
        int i = 0;
        if (b) {
            try {
                i = layoutParams.getClass().getField("extraFlags").getInt(layoutParams);
            } catch (Throwable th) {
            }
        }
        return i;
    }

    public static void a(LayoutParams layoutParams, int i) {
        if (b) {
            try {
                layoutParams.getClass().getField("extraFlags").setInt(layoutParams, i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Window window, boolean z) {
        int i = 0;
        if (b && VERSION.SDK_INT >= 19 && window != null) {
            try {
                Method method = window.getClass().getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                Object[] objArr = new Object[2];
                if (z) {
                    i = a;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(a);
                method.invoke(window, objArr);
            } catch (Throwable th) {
            }
        }
    }

    public static void a(View view, boolean z) {
        if (b && VERSION.SDK_INT >= 19 && view != null) {
            View rootView = view.getRootView();
            if (rootView != null) {
                Activity a = b.a(view.getContext());
                if (a != null) {
                    try {
                        if (rootView == a.getWindow().getDecorView().getRootView()) {
                            a(a.getWindow(), z);
                            return;
                        }
                        LayoutParams layoutParams = (LayoutParams) rootView.getLayoutParams();
                        if (layoutParams != null) {
                            if (z) {
                                a(layoutParams, a(layoutParams) | a);
                            } else {
                                a(layoutParams, a(layoutParams) & (a ^ -1));
                            }
                            ((WindowManager) view.getContext().getSystemService("window")).updateViewLayout(rootView, layoutParams);
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    public static boolean a(Activity activity) {
        if (!b || VERSION.SDK_INT < 19 || activity == null) {
            return false;
        }
        try {
            if ((a(activity.getWindow().getAttributes()) & a) == a) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void a(Activity activity, boolean z) {
        if (b && VERSION.SDK_INT >= 19 && activity != null) {
            try {
                a(activity.getWindow(), z);
            } catch (Throwable th) {
            }
        }
    }
}
