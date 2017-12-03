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

import com.duokan.core.sys.af;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class cv {
    private static final LinkedList a = new LinkedList();
    static final /* synthetic */ boolean b = (!cv.class.desiredAssertionStatus());
    private static final LinkedList c = new LinkedList();
    private static int d = Color.argb(255, 255, 255, 255);
    private final Context e;
    private final Activity f;
    private final boolean g;
    private final db h;
    private final cy i;
    private final af j;
    private final af k;
    private final ActivityLifecycleCallbacks l;
    private View m;
    private boolean n;
    private int o;
    private float p;
    private AlphaAnimation q;
    private Animation r;
    private Animation s;
    private Runnable t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;

    public cv(Context context) {
        this(context, false);
    }

    @TargetApi(14)
    public cv(Context context, boolean z) {
        boolean z2 = true;
        this.j = new af();
        this.k = new af();
        this.m = null;
        this.o = 17;
        this.p = 0.0f;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = false;
        this.e = context;
        this.f = b.a(this.e);
        this.g = z;
        if (this.g) {
            z2 = false;
        }
        this.n = z2;
        this.h = new db(this, getContext());
        this.i = new cy(context);
        this.i.setClipChildren(false);
        this.h.addView(this.i, new LayoutParams(-1, -1));
        if (VERSION.SDK_INT >= 14) {
            this.l = new cw(this);
        } else {
            this.l = null;
        }
        a.add(new WeakReference(this));
    }

    public final Context getContext() {
        return this.e;
    }

    public final Activity getActivity() {
        return this.f;
    }

    public final View getDecorView() {
        return this.h;
    }

    public final boolean isForeground() {
        return this.g;
    }

    public final boolean isFocusable() {
        return this.n;
    }

    public final void setFocusable(boolean z) {
        if (!this.g && this.n != z) {
            this.n = z;
            if (this.u) {
                updateLayout();
            }
        }
    }

    public final boolean getResizeForSoftInput() {
        return this.h.getResizeLayoutForSoftInput();
    }

    public final void setResizeForSoftInput(boolean z) {
        this.h.setResizeLayoutForSoftInput(z);
    }

    public final af getShowStatusBar() {
        return this.j;
    }

    public final void setShowStatusBar(af afVar) {
        this.j.a(afVar);
        if (this.u) {
            updateLayout();
        }
    }

    public final af getLightStatusBar() {
        return this.k;
    }

    public final void setLightStatusBar(af afVar) {
        this.k.a(afVar);
        if (this.u) {
            updateLayout();
        }
    }

    public final View getContentView() {
        return this.m;
    }

    public final void setContentView(int i) {
        setContentView(LayoutInflater.from(this.e).inflate(i, this.h, false));
    }

    public final void setContentView(View view) {
        setContentView(view, view.getLayoutParams() != null ? view.getLayoutParams() : new FrameLayout.LayoutParams(-1, -1, this.o));
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        if (this.m != view) {
            if (this.m != null) {
                this.h.removeView(this.m);
                this.m = null;
            }
            if (view != null) {
                this.m = view;
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams;
                } else {
                    layoutParams = new FrameLayout.LayoutParams(layoutParams);
                }
                layoutParams.gravity = this.o;
                this.h.addView(this.m, 0, layoutParams);
            }
        }
    }

    public final int getGravity() {
        return this.o;
    }

    public final void setGravity(int i) {
        if (this.o != i) {
            this.o = i;
            if (this.m != null) {
                ((FrameLayout.LayoutParams) this.m.getLayoutParams()).gravity = this.o;
                this.m.requestLayout();
            }
        }
    }

    public final float getDimAmount() {
        return this.p;
    }

    public final void setDimAmount(float f) {
        this.p = f;
        this.h.invalidate();
    }

    public final void setEnterAnimation(int i) {
        this.r = AnimationUtils.loadAnimation(getContext(), i);
    }

    public final void setExitAnimation(int i) {
        this.s = AnimationUtils.loadAnimation(getContext(), i);
        this.s.setFillAfter(true);
    }

    public final boolean getConsumeKeyEvents() {
        return this.v;
    }

    public final void setConsumeKeyEvents(boolean z) {
        this.v = z;
    }

    public final boolean getConsumeTouchEvents() {
        return this.w;
    }

    public final void setConsumeTouchEvents(boolean z) {
        this.w = z;
    }

    public final int getBalloonCount() {
        return this.i.getChildCount();
    }

    public final boolean isShowing() {
        return this.u;
    }

    @TargetApi(14)
    public void show() {
        if (!this.u) {
            dismissNow();
            de findShowingManager = findShowingManager();
            if (findShowingManager == null) {
                findShowingManager = new de(this.f);
                c.addFirst(findShowingManager);
            } else {
                c.remove(findShowingManager);
                c.addFirst(findShowingManager);
            }
            findShowingManager.a(this);
            if (this.l != null) {
                this.f.getApplication().registerActivityLifecycleCallbacks(this.l);
            }
            if (Float.compare(this.p, 0.0f) > 0) {
                this.q = new AlphaAnimation(0.0f, this.p);
                this.q.setDuration(300);
                this.q.initialize(0, 0, 0, 0);
            }
            if (!(this.m == null || this.r == null)) {
                this.m.startAnimation(this.r);
            }
            this.u = true;
            onShow();
        }
    }

    public void dismiss() {
        if (this.u) {
            if (Float.compare(this.p, 0.0f) > 0) {
                this.q = new AlphaAnimation(this.p, 0.0f);
                this.q.setDuration(300);
                this.q.initialize(0, 0, 0, 0);
                this.h.invalidate();
            }
            if (!(this.m == null || this.s == null)) {
                this.m.startAnimation(this.s);
            }
            tryDismiss();
        }
    }

    public void dismissNow() {
        if (this.t != null) {
            this.t.run();
        } else if (this.u) {
            this.u = false;
            doDismiss();
        }
    }

    public final View findViewById(int i) {
        return this.h.findViewById(i);
    }

    public final void showBalloon(a aVar, View view) {
        showBalloon(aVar, view, aVar.getLayoutParams());
    }

    public final void showBalloon(a aVar, View view, LayoutParams layoutParams) {
        LayoutParams a = layoutParams == null ? this.i.a() : this.i.a(layoutParams);
        this.i.addView(aVar, a);
        a.b = new WeakReference(view);
    }

    public void showBalloon(a aVar, Rect rect) {
        showBalloon(aVar, rect, aVar.getLayoutParams());
    }

    public void showBalloon(a aVar, Rect rect, LayoutParams layoutParams) {
        LayoutParams a = layoutParams == null ? this.i.a() : this.i.a(layoutParams);
        this.i.addView(aVar, a);
        a.a.set(rect);
    }

    public final a getBalloon(int i) {
        return (a) this.i.getChildAt(i);
    }

    public final void removeBalloon(a aVar) {
        this.i.removeView(aVar);
    }

    public final void setBalloonPadding(int i, int i2, int i3, int i4) {
        this.i.setPadding(i, i2, i3, i4);
    }

    public static final cv of(View view) {
        if (view == null) {
            return null;
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            cv cvVar = (cv) ((WeakReference) it.next()).get();
            if (cvVar != null) {
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent == cvVar.h) {
                        return cvVar;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static final List listShowingWindows() {
        List linkedList = new LinkedList();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            de deVar = (de) it.next();
            for (int b = deVar.b() - 1; b >= 0; b--) {
                linkedList.addFirst(deVar.a(b));
            }
        }
        return linkedList;
    }

    public static final void setRgbDensity(float f, float f2, float f3) {
        d = Color.argb(255, Math.round(255.0f * f), Math.round(255.0f * f2), Math.round(255.0f * f3));
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((de) it.next()).c();
        }
    }

    public static final void updateLayout() {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((de) it.next()).a();
        }
    }

    private void tryDismiss() {
        this.u = false;
        if (!hasRunningAnimation()) {
            doDismiss();
        } else if (this.t == null) {
            this.t = new cx(this);
        }
    }

    @TargetApi(14)
    private void doDismiss() {
        de findShowingManager = findShowingManager();
        if (b || findShowingManager != null) {
            if (findShowingManager != null) {
                onDismiss();
                findShowingManager.b(this);
                if (findShowingManager.b() < 1) {
                    c.remove(findShowingManager);
                }
                ListIterator listIterator = a.listIterator();
                while (listIterator.hasNext()) {
                    if (((WeakReference) listIterator.next()).get() == null) {
                        listIterator.remove();
                    }
                }
            }
            if (this.l != null) {
                this.f.getApplication().unregisterActivityLifecycleCallbacks(this.l);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private boolean hasRunningAnimation() {
        if (this.q == null && (this.m == null || this.m.getAnimation() == null || this.m.getAnimation().hasEnded())) {
            return false;
        }
        return true;
    }

    private de findShowingManager() {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            de deVar = (de) it.next();
            if (deVar.b == this.f) {
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
        if (this.m == null) {
            return true;
        }
        Rect rect = (Rect) UTools.g.getRect();
        rect.set(this.m.getLeft(), this.m.getTop(), this.m.getRight(), this.m.getBottom());
        try {
            if (rect.contains(i, i2)) {
                return rect;
            }
            UTools.g.getRect(rect);
            return true;
        } finally {
            UTools.g.getRect(rect);
        }
    }
}
