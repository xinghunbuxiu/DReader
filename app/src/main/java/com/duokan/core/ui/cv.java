package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.duokan.core.app.AppManage;
import com.duokan.core.sys.af;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class cv {
    /* renamed from: a */
    private static final LinkedList<WeakReference<cv>> f1093a = new LinkedList();
    /* renamed from: b */
    static final /* synthetic */ boolean f1094b = (!cv.class.desiredAssertionStatus());
    /* renamed from: c */
    private static final LinkedList<de> f1095c = new LinkedList();
    /* renamed from: d */
    private static int f1096d = Color.argb(255, 255, 255, 255);
    /* renamed from: e */
    private final Context f1097e;
    /* renamed from: f */
    private final Activity f1098f;
    /* renamed from: g */
    private final boolean f1099g;
    /* renamed from: h */
    private final db f1100h;
    /* renamed from: i */
    private final cy f1101i;
    /* renamed from: j */
    private final af<Boolean> f1102j;
    /* renamed from: k */
    private final af<Boolean> f1103k;
    /* renamed from: l */
    private final ActivityLifecycleCallbacks f1104l;
    /* renamed from: m */
    private View f1105m;
    /* renamed from: n */
    private boolean f1106n;
    /* renamed from: o */
    private int f1107o;
    /* renamed from: p */
    private float f1108p;
    /* renamed from: q */
    private AlphaAnimation f1109q;
    /* renamed from: r */
    private Animation f1110r;
    /* renamed from: s */
    private Animation f1111s;
    /* renamed from: t */
    private Runnable f1112t;
    /* renamed from: u */
    private boolean f1113u;
    /* renamed from: v */
    private boolean f1114v;
    /* renamed from: w */
    private boolean f1115w;
    /* renamed from: x */
    private boolean f1116x;

    public cv(Context context) {
        this(context, false);
    }

    @TargetApi(14)
    public cv(Context context, boolean z) {
        boolean z2 = true;
        this.f1102j = new af();
        this.f1103k = new af();
        this.f1105m = null;
        this.f1107o = 17;
        this.f1108p = 0.0f;
        this.f1109q = null;
        this.f1110r = null;
        this.f1111s = null;
        this.f1112t = null;
        this.f1113u = false;
        this.f1114v = true;
        this.f1115w = false;
        this.f1116x = false;
        this.f1097e = context;
        this.f1098f = AppManage.getCurrentActivity(this.f1097e);
        this.f1099g = z;
        if (this.f1099g) {
            z2 = false;
        }
        this.f1106n = z2;
        this.f1100h = new db(this, getContext());
        this.f1101i = new cy(context);
        this.f1101i.setClipChildren(false);
        this.f1100h.addView(this.f1101i, new LayoutParams(-1, -1));
        if (VERSION.SDK_INT >= 14) {
            this.f1104l = new cw(this);
        } else {
            this.f1104l = null;
        }
        f1093a.add(new WeakReference(this));
    }

    public final Context getContext() {
        return this.f1097e;
    }

    public final Activity getActivity() {
        return this.f1098f;
    }

    public final View getDecorView() {
        return this.f1100h;
    }

    public final boolean isForeground() {
        return this.f1099g;
    }

    public final boolean isFocusable() {
        return this.f1106n;
    }

    public final void setFocusable(boolean z) {
        if (!this.f1099g && this.f1106n != z) {
            this.f1106n = z;
            if (this.f1113u) {
                updateLayout();
            }
        }
    }

    public final boolean getResizeForSoftInput() {
        return this.f1100h.getResizeLayoutForSoftInput();
    }

    public final void setResizeForSoftInput(boolean z) {
        this.f1100h.setResizeLayoutForSoftInput(z);
    }

    public final af<Boolean> getShowStatusBar() {
        return this.f1102j;
    }

    public final void setShowStatusBar(af<Boolean> afVar) {
        this.f1102j.m859a((af) afVar);
        if (this.f1113u) {
            updateLayout();
        }
    }

    public final af<Boolean> getLightStatusBar() {
        return this.f1103k;
    }

    public final void setLightStatusBar(af<Boolean> afVar) {
        this.f1103k.m859a((af) afVar);
        if (this.f1113u) {
            updateLayout();
        }
    }

    public final View getContentView() {
        return this.f1105m;
    }

    public final void setContentView(int i) {
        setContentView(LayoutInflater.from(this.f1097e).inflate(i, this.f1100h, false));
    }

    public final void setContentView(View view) {
        setContentView(view, view.getLayoutParams() != null ? view.getLayoutParams() : new FrameLayout.LayoutParams(-1, -1, this.f1107o));
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        if (this.f1105m != view) {
            if (this.f1105m != null) {
                this.f1100h.removeView(this.f1105m);
                this.f1105m = null;
            }
            if (view != null) {
                this.f1105m = view;
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams;
                } else {
                    layoutParams = new FrameLayout.LayoutParams(layoutParams);
                }
                layoutParams.gravity = this.f1107o;
                this.f1100h.addView(this.f1105m, 0, layoutParams);
            }
        }
    }

    public final int getGravity() {
        return this.f1107o;
    }

    public final void setGravity(int i) {
        if (this.f1107o != i) {
            this.f1107o = i;
            if (this.f1105m != null) {
                ((FrameLayout.LayoutParams) this.f1105m.getLayoutParams()).gravity = this.f1107o;
                this.f1105m.requestLayout();
            }
        }
    }

    public final float getDimAmount() {
        return this.f1108p;
    }

    public final void setDimAmount(float f) {
        this.f1108p = f;
        this.f1100h.invalidate();
    }

    public final void setEnterAnimation(int i) {
        this.f1110r = AnimationUtils.loadAnimation(getContext(), i);
    }

    public final void setExitAnimation(int i) {
        this.f1111s = AnimationUtils.loadAnimation(getContext(), i);
        this.f1111s.setFillAfter(true);
    }

    public final boolean getConsumeKeyEvents() {
        return this.f1114v;
    }

    public final void setConsumeKeyEvents(boolean z) {
        this.f1114v = z;
    }

    public final boolean getConsumeTouchEvents() {
        return this.f1115w;
    }

    public final void setConsumeTouchEvents(boolean z) {
        this.f1115w = z;
    }

    public final int getBalloonCount() {
        return this.f1101i.getChildCount();
    }

    public final boolean isShowing() {
        return this.f1113u;
    }

    @TargetApi(14)
    public void show() {
        if (!this.f1113u) {
            dismissNow();
            de findShowingManager = findShowingManager();
            if (findShowingManager == null) {
                findShowingManager = new de(this.f1098f);
                f1095c.addFirst(findShowingManager);
            } else {
                f1095c.remove(findShowingManager);
                f1095c.addFirst(findShowingManager);
            }
            findShowingManager.m1803a(this);
            if (this.f1104l != null) {
                this.f1098f.getApplication().registerActivityLifecycleCallbacks(this.f1104l);
            }
            if (Float.compare(this.f1108p, 0.0f) > 0) {
                this.f1109q = new AlphaAnimation(0.0f, this.f1108p);
                this.f1109q.setDuration(300);
                this.f1109q.initialize(0, 0, 0, 0);
            }
            if (!(this.f1105m == null || this.f1110r == null)) {
                this.f1105m.startAnimation(this.f1110r);
            }
            this.f1113u = true;
            onShow();
        }
    }

    public void dismiss() {
        if (this.f1113u) {
            if (Float.compare(this.f1108p, 0.0f) > 0) {
                this.f1109q = new AlphaAnimation(this.f1108p, 0.0f);
                this.f1109q.setDuration(300);
                this.f1109q.initialize(0, 0, 0, 0);
                this.f1100h.invalidate();
            }
            if (!(this.f1105m == null || this.f1111s == null)) {
                this.f1105m.startAnimation(this.f1111s);
            }
            tryDismiss();
        }
    }

    public void dismissNow() {
        if (this.f1112t != null) {
            this.f1112t.run();
        } else if (this.f1113u) {
            this.f1113u = false;
            doDismiss();
        }
    }

    public final View findViewById(int i) {
        return this.f1100h.findViewById(i);
    }

    public final void showBalloon(C0374a c0374a, View view) {
        showBalloon(c0374a, view, c0374a.getLayoutParams());
    }

    public final void showBalloon(C0374a c0374a, View view, LayoutParams layoutParams) {
        LayoutParams a = layoutParams == null ? this.f1101i.m1791a() : this.f1101i.m1793a(layoutParams);
        this.f1101i.addView(c0374a, a);
        a.f1127b = new WeakReference(view);
    }

    public void showBalloon(C0374a c0374a, Rect rect) {
        showBalloon(c0374a, rect, c0374a.getLayoutParams());
    }

    public void showBalloon(C0374a c0374a, Rect rect, LayoutParams layoutParams) {
        LayoutParams a = layoutParams == null ? this.f1101i.m1791a() : this.f1101i.m1793a(layoutParams);
        this.f1101i.addView(c0374a, a);
        a.f1126a.set(rect);
    }

    public final C0374a getBalloon(int i) {
        return (C0374a) this.f1101i.getChildAt(i);
    }

    public final void removeBalloon(C0374a c0374a) {
        this.f1101i.removeView(c0374a);
    }

    public final void setBalloonPadding(int i, int i2, int i3, int i4) {
        this.f1101i.setPadding(i, i2, i3, i4);
    }

    public static final cv of(View view) {
        if (view == null) {
            return null;
        }
        Iterator it = f1093a.iterator();
        while (it.hasNext()) {
            cv cvVar = (cv) ((WeakReference) it.next()).get();
            if (cvVar != null) {
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent == cvVar.f1100h) {
                        return cvVar;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static final List<cv> listShowingWindows() {
        List linkedList = new LinkedList();
        Iterator it = f1095c.iterator();
        while (it.hasNext()) {
            de deVar = (de) it.next();
            for (int b = deVar.m1804b() - 1; b >= 0; b--) {
                linkedList.addFirst(deVar.m1801a(b));
            }
        }
        return linkedList;
    }

    public static final void setRgbDensity(float f, float f2, float f3) {
        f1096d = Color.argb(255, Math.round(255.0f * f), Math.round(255.0f * f2), Math.round(255.0f * f3));
        Iterator it = f1095c.iterator();
        while (it.hasNext()) {
            ((de) it.next()).m1806c();
        }
    }

    public static final void updateLayout() {
        Iterator it = f1095c.iterator();
        while (it.hasNext()) {
            ((de) it.next()).m1802a();
        }
    }

    private void tryDismiss() {
        this.f1113u = false;
        if (!hasRunningAnimation()) {
            doDismiss();
        } else if (this.f1112t == null) {
            this.f1112t = new cx(this);
        }
    }

    @TargetApi(14)
    private void doDismiss() {
        de findShowingManager = findShowingManager();
        if (f1094b || findShowingManager != null) {
            if (findShowingManager != null) {
                onDismiss();
                findShowingManager.m1805b(this);
                if (findShowingManager.m1804b() < 1) {
                    f1095c.remove(findShowingManager);
                }
                ListIterator listIterator = f1093a.listIterator();
                while (listIterator.hasNext()) {
                    if (((WeakReference) listIterator.next()).get() == null) {
                        listIterator.remove();
                    }
                }
            }
            if (this.f1104l != null) {
                this.f1098f.getApplication().unregisterActivityLifecycleCallbacks(this.f1104l);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private boolean hasRunningAnimation() {
        if (this.f1109q == null && (this.f1105m == null || this.f1105m.getAnimation() == null || this.f1105m.getAnimation().hasEnded())) {
            return false;
        }
        return true;
    }

    private de findShowingManager() {
        Iterator it = f1095c.iterator();
        while (it.hasNext()) {
            de deVar = (de) it.next();
            if (deVar.f1136b == this.f1098f) {
                return deVar;
            }
        }
        return null;
    }

    protected void onShow() {
    }

    protected void onDismiss() {
    }

    protected boolean onTouchOutside() {
        return false;
    }

    protected boolean onBack() {
        return false;
    }

    protected boolean checkTouchOutside(int i, int i2) {
        if (this.f1105m == null) {
            return true;
        }
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        rect.set(this.f1105m.getLeft(), this.f1105m.getTop(), this.f1105m.getRight(), this.f1105m.getBottom());
        try {
            if (rect.contains(i, i2)) {
                return rect;
            }
            AnimUtils.f1198g.clearAnimation(rect);
            return true;
        } finally {
            AnimUtils.f1198g.clearAnimation(rect);
        }
    }
}
