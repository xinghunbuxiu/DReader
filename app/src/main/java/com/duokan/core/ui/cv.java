package com.duokan.core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
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
    
    private static final LinkedList<WeakReference<cv>> f1093a = new LinkedList();
    
    static final  boolean desiredAssertionStatus = (!cv.class.desiredAssertionStatus());
    
    private static final LinkedList<de> f1095c = new LinkedList();
    
    private static int white = Color.argb(255, 255, 255, 255);
    
    private final Context context;
    
    private final Activity mActivity;
    
    private final boolean foreground;
    
    private final db decorView;
    
    private final cy f1101i;
    
    private final af<Boolean> f1102j;
    
    private final af<Boolean> f1103k;
    
    private final ActivityLifecycleCallbacks lifecycleCallbacks;
    
    private View view;
    
    private boolean focusable;
    
    private int gravity;
    
    private float f1108p;
    
    private AlphaAnimation alphaAnimation;
    
    private Animation animation;
    
    private Animation animation1;
    
    private Runnable runnable;
    
    private boolean isShowing;
    
    private boolean f1114v;
    
    private boolean f1115w;
    
    private boolean f1116x;

    public cv(Context context) {
        this(context, false);
    }

    @TargetApi(14)
    public cv(Context context, boolean z) {
        boolean z2 = true;
        this.f1102j = new af();
        this.f1103k = new af();
        this.view = null;
        this.gravity = 17;
        this.f1108p = 0.0f;
        this.alphaAnimation = null;
        this.animation = null;
        this.animation1 = null;
        this.runnable = null;
        this.isShowing = false;
        this.f1114v = true;
        this.f1115w = false;
        this.f1116x = false;
        this.context = context;
        this.mActivity = AppManage.getCurrentActivity(this.context);
        this.foreground = z;
        if (this.foreground) {
            z2 = false;
        }
        this.focusable = z2;
        this.decorView = new db(this, getContext());
        this.f1101i = new cy(context);
        this.f1101i.setClipChildren(false);
        this.decorView.addView(this.f1101i, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        if (VERSION.SDK_INT >= 14) {
            this.lifecycleCallbacks = new ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                }

                @Override
                public void onActivityStarted(Activity activity) {

                }

                @Override
                public void onActivityResumed(Activity activity) {

                }

                @Override
                public void onActivityPaused(Activity activity) {

                }

                @Override
                public void onActivityStopped(Activity activity) {

                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                }

                @Override
                public void onActivityDestroyed(Activity activity) {
                    if (activity == mActivity) {
                        dismissNow();
                    }
                }
            };
        } else {
            this.lifecycleCallbacks = null;
        }
        f1093a.add(new WeakReference(this));
    }

    public final Context getContext() {
        return this.context;
    }

    public final Activity getmActivity() {
        return this.mActivity;
    }

    public final View getDecorView() {
        return this.decorView;
    }

    public final boolean isForeground() {
        return this.foreground;
    }

    public final boolean isFocusable() {
        return this.focusable;
    }

    public final void setFocusable(boolean focusable) {
        if (!this.foreground && this.focusable != focusable) {
            this.focusable = focusable;
            if (this.isShowing) {
                updateLayout();
            }
        }
    }

    public final boolean getResizeForSoftInput() {
        return this.decorView.getResizeLayoutForSoftInput();
    }

    public final void setResizeForSoftInput(boolean z) {
        this.decorView.setResizeLayoutForSoftInput(z);
    }

    public final af<Boolean> getShowStatusBar() {
        return this.f1102j;
    }

    public final void setShowStatusBar(af<Boolean> afVar) {
        this.f1102j.m859a((af) afVar);
        if (this.isShowing) {
            updateLayout();
        }
    }

    public final af<Boolean> getLightStatusBar() {
        return this.f1103k;
    }

    public final void setLightStatusBar(af<Boolean> afVar) {
        this.f1103k.m859a((af) afVar);
        if (this.isShowing) {
            updateLayout();
        }
    }

    public final View getContentView() {
        return this.view;
    }

    public final void setContentView(int i) {
        setContentView(LayoutInflater.from(this.context).inflate(i, this.decorView, false));
    }

    public final void setContentView(View view) {
        setContentView(view, view.getLayoutParams() != null ? view.getLayoutParams() : new FrameLayout.LayoutParams(-1, -1, this.gravity));
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        if (this.view != view) {
            if (this.view != null) {
                this.decorView.removeView(this.view);
                this.view = null;
            }
            if (view != null) {
                this.view = view;
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    layoutParams = (FrameLayout.LayoutParams) layoutParams;
                } else {
                    layoutParams = new FrameLayout.LayoutParams(layoutParams);
                }
                layoutParams.gravity = this.gravity;
                this.decorView.addView(this.view, 0, layoutParams);
            }
        }
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final void setGravity(int i) {
        if (this.gravity != i) {
            this.gravity = i;
            if (this.view != null) {
                ((FrameLayout.LayoutParams) this.view.getLayoutParams()).gravity = this.gravity;
                this.view.requestLayout();
            }
        }
    }

    public final float getDimAmount() {
        return this.f1108p;
    }

    public final void setDimAmount(float f) {
        this.f1108p = f;
        this.decorView.invalidate();
    }

    public final void setEnterAnimation(int i) {
        this.animation = AnimationUtils.loadAnimation(getContext(), i);
    }

    public final void setExitAnimation(int i) {
        this.animation1 = AnimationUtils.loadAnimation(getContext(), i);
        this.animation1.setFillAfter(true);
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
        return this.isShowing;
    }

    @TargetApi(14)
    public void show() {
        if (!this.isShowing) {
            dismissNow();
            de findShowingManager = findShowingManager();
            if (findShowingManager == null) {
                findShowingManager = new de(this.mActivity);
                f1095c.addFirst(findShowingManager);
            } else {
                f1095c.remove(findShowingManager);
                f1095c.addFirst(findShowingManager);
            }
            findShowingManager.m1803a(this);
            if (this.lifecycleCallbacks != null) {
                this.mActivity.getApplication().registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
            }
            if (Float.compare(this.f1108p, 0.0f) > 0) {
                this.alphaAnimation = new AlphaAnimation(0.0f, this.f1108p);
                this.alphaAnimation.setDuration(300);
                this.alphaAnimation.initialize(0, 0, 0, 0);
            }
            if (!(this.view == null || this.animation == null)) {
                this.view.startAnimation(this.animation);
            }
            this.isShowing = true;
            onShow();
        }
    }

    public void dismiss() {
        if (this.isShowing) {
            if (Float.compare(this.f1108p, 0.0f) > 0) {
                this.alphaAnimation = new AlphaAnimation(this.f1108p, 0.0f);
                this.alphaAnimation.setDuration(300);
                this.alphaAnimation.initialize(0, 0, 0, 0);
                this.decorView.invalidate();
            }
            if (!(this.view == null || this.animation1 == null)) {
                this.view.startAnimation(this.animation1);
            }
            tryDismiss();
        }
    }

    public void dismissNow() {
        if (this.runnable != null) {
            this.runnable.run();
        } else if (this.isShowing) {
            this.isShowing = false;
            doDismiss();
        }
    }

    public final View findViewById(int i) {
        return this.decorView.findViewById(i);
    }

    public final void showBalloon(C0374a c0374a, View view) {
        showBalloon(c0374a, view, c0374a.getLayoutParams());
    }

    public final void showBalloon(C0374a c0374a, View view, LayoutParams layoutParams) {
        LayoutParams a = layoutParams == null ? this.f1101i.getMarginLayoutParams() : this.f1101i.getMarginLayoutParams(layoutParams);
        this.f1101i.addView(c0374a, a);
        a.f1127b = new WeakReference(view);
    }

    public void showBalloon(C0374a c0374a, Rect rect) {
        showBalloon(c0374a, rect, c0374a.getLayoutParams());
    }

    public void showBalloon(C0374a c0374a, Rect rect, LayoutParams layoutParams) {
        LayoutParams a = layoutParams == null ? this.f1101i.getMarginLayoutParams() : this.f1101i.getMarginLayoutParams(layoutParams);
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
                    if (parent == cvVar.decorView) {
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
        white = Color.argb(255, Math.round(255.0f * f), Math.round(255.0f * f2), Math.round(255.0f * f3));
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
        this.isShowing = false;
        if (!hasRunningAnimation()) {
            doDismiss();
        } else if (this.runnable == null) {
            this.runnable = new cx(this);
        }
    }

    @TargetApi(14)
    private void doDismiss() {
        de findShowingManager = findShowingManager();
        if (desiredAssertionStatus || findShowingManager != null) {
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
            if (this.lifecycleCallbacks != null) {
                this.mActivity.getApplication().unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private boolean hasRunningAnimation() {
        if (this.alphaAnimation == null && (this.view == null || this.view.getAnimation() == null || this.view.getAnimation().hasEnded())) {
            return false;
        }
        return true;
    }

    private de findShowingManager() {
        Iterator<de> it = f1095c.iterator();
        while (it.hasNext()) {
            de deVar =it.next();
            if (deVar.activity == this.mActivity) {
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
        if (this.view == null) {
            return true;
        }
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        rect.set(this.view.getLeft(), this.view.getTop(), this.view.getRight(), this.view.getBottom());
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
