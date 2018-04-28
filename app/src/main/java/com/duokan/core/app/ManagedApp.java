package com.duokan.core.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;
import android.view.KeyEvent;
import com.duokan.core.sys.UThread;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManagedApp extends MultiDexApplication implements ISubController, IFeature {
    /* renamed from: a */
    static final /* synthetic */ boolean f494a = (!ManagedApp.class.desiredAssertionStatus());
    /* renamed from: b */
    private static ManagedApp f495b = null;
    /* renamed from: c */
    private final ConcurrentLinkedQueue<WeakReference<Activity>> f496c = new ConcurrentLinkedQueue();
    /* renamed from: d */
    private final CopyOnWriteArrayList<C0297a> f497d = new CopyOnWriteArrayList();
    /* renamed from: e */
    private final CopyOnWriteArrayList<C0286x> f498e = new CopyOnWriteArrayList();
    /* renamed from: f */
    private final FeatureManage f499f = new FeatureManage();
    /* renamed from: g */
    private RunningState f500g = RunningState.UNDERGROUND;
    /* renamed from: h */
    private long f501h = System.currentTimeMillis();
    /* renamed from: i */
    private Runnable f502i = null;

    public enum RunningState {
        UNDERGROUND,
        BACKGROUND,
        FOREGROUND
    }

    @TargetApi(14)
    protected ManagedApp() {
        f495b = this;
        registerActivityLifecycleCallbacks(new C0318v(this));
    }

    public final boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) == 2;
    }

    public final RunningState getRunningState() {
        return this.f500g;
    }

    public final long getRunningStateMillis() {
        return Math.max(0, System.currentTimeMillis() - this.f501h);
    }

    public final Activity getTopActivity() {
        Iterator it = this.f496c.iterator();
        Activity activity = null;
        while (it.hasNext()) {
            Activity activity2 = (Activity) ((WeakReference) it.next()).get();
            if (AppManage.isFinishing(activity2)) {
                activity = activity2;
            }
        }
        return activity;
    }

    public final boolean hasAliveActivity() {
        return getTopActivity() != null;
    }

    public final void addActivityLifecycleMonitor(C0297a c0297a) {
        if (f494a || c0297a != null) {
            this.f497d.addIfAbsent(c0297a);
            return;
        }
        throw new AssertionError();
    }

    public final void removeActivityLifecycleMonitor(C0297a c0297a) {
        if (f494a || c0297a != null) {
            this.f497d.remove(c0297a);
            return;
        }
        throw new AssertionError();
    }

    public final void addOnRunningStateChangedListener(C0286x c0286x) {
        if (f494a || c0286x != null) {
            this.f498e.addIfAbsent(c0286x);
            return;
        }
        throw new AssertionError();
    }

    public final void removeOnRunningStateChangedListener(C0286x c0286x) {
        this.f498e.remove(c0286x);
    }

    public static ManagedApp get() {
        return f495b;
    }

    public final void onActivityResult(BaseActivity mActivity, int i, int i2, Intent intent) {
        if (!f494a && mActivity == null) {
            throw new AssertionError();
        } else if (mActivity.getContentController() != null) {
            mActivity.getContentController().onActivityResult(mActivity, i, i2, intent);
        }
    }

    public final boolean isStub() {
        return true;
    }

    public final IFeature getContext() {
        return this;
    }

    public final ISubControllerParent getParent() {
        return null;
    }

    public boolean requestShowMenu(ActivatedController c0303e) {
        return c0303e.onActivityShowMenu();
    }

    public boolean requestHideMenu(ActivatedController c0303e) {
        return c0303e.onActivityHideMenu();
    }

    public boolean requestSoftInputMode(ActivatedController c0303e, int i) {
        c0303e.getActivity().getWindow().setSoftInputMode(i);
        return true;
    }

    public boolean requestDetach(ActivatedController controller) {
        return false;
    }

    public int getSoftInputMode(ActivatedController c0303e) {
        return c0303e.getActivity().getWindow().getAttributes().softInputMode;
    }

    public <T extends FeatureListening> T queryFeature(Class<T> cls) {
        return queryLocalFeature(cls);
    }

    public <T extends FeatureListening> T queryLocalFeature(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        return this.f499f.isContainsListener((Class) cls);
    }

    public boolean registerLocalFeature(FeatureListening featureListening) {
        return this.f499f.addFeatureListener(featureListening);
    }

    public boolean unregisterLocalFeature(FeatureListening featureListening) {
        return this.f499f.removeFeatureListener(featureListening);
    }

    public boolean registerGlobalFeature(FeatureListening featureListening) {
        return this.f499f.addFeatureListener(featureListening);
    }

    public boolean unregisterGlobalFeature(FeatureListening featureListening) {
        return this.f499f.removeFeatureListener(featureListening);
    }

    public final void onActivityConfigurationChanged(BaseActivity mActivity, Configuration configuration) {
        if (!f494a && mActivity == null) {
            throw new AssertionError();
        } else if (mActivity.getContentController() != null) {
            mActivity.getContentController().onActivityConfigurationChanged(mActivity, configuration);
        }
    }

    public final void onActivityWindowFocusChanged(BaseActivity mActivity, boolean z) {
        if (!f494a && mActivity == null) {
            throw new AssertionError();
        } else if (mActivity.getContentController() != null) {
            mActivity.getContentController().onActivityWindowFocusChanged(mActivity, z);
        }
    }

    public final boolean onActivityKeyDown(BaseActivity mActivity, int i, KeyEvent keyEvent) {
        if (!f494a && mActivity == null) {
            throw new AssertionError();
        } else if (mActivity.getContentController() != null) {
            return mActivity.getContentController().onActivityKeyDown(mActivity, i, keyEvent);
        } else {
            return false;
        }
    }

    public final boolean onActivityKeyUp(BaseActivity mActivity, int i, KeyEvent keyEvent) {
        if (mActivity.getContentController() != null) {
            return mActivity.getContentController().onActivityKeyUp(mActivity, i, keyEvent);
        }
        return false;
    }

    public final boolean onActivityBackPressed(BaseActivity mActivity) {
        if (mActivity.getContentController() != null) {
            return mActivity.getContentController().onActivityBackPressed(mActivity);
        }
        return false;
    }

    public void onTrimMemory(int i) {
        if (i == 20) {
            runningState(RunningState.BACKGROUND);
        }
        Iterator it = this.f496c.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (!(activity == null || activity.isFinishing())) {
                activity = managedActivity(activity);
                if (activity != null) {
                    ActivatedController contentController = activity.getContentController();
                    if (contentController != null) {
                        contentController.onActivityTrimMemory(activity, i);
                    }
                }
            }
        }
        super.onTrimMemory(i);
    }

    protected void onRunningStateChanged(RunningState runningState, RunningState runningState2) {
    }

    protected void onActivityCreated(Activity activity, Bundle bundle) {
        if (f494a || activity != null) {
            this.f496c.add(new WeakReference(activity));
            Iterator it = this.f497d.iterator();
            while (it.hasNext()) {
                ((C0297a) it.next()).onActivityCreated(activity, bundle);
            }
            if (this.f500g == RunningState.UNDERGROUND) {
                runningState(RunningState.BACKGROUND);
            }
            BaseActivity managedActivity = managedActivity(activity);
            if (managedActivity != null && managedActivity.getContentController() != null) {
                managedActivity.getContentController().onActivityCreated(activity, bundle);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected void onActivityPaused(Activity activity) {
        if (f494a || activity != null) {
            Iterator it = this.f497d.iterator();
            while (it.hasNext()) {
                ((C0297a) it.next()).onActivityPaused(activity);
            }
            runningState(RunningState.BACKGROUND, 5000);
            BaseActivity managedActivity = managedActivity(activity);
            if (managedActivity != null && managedActivity.getContentController() != null) {
                managedActivity.getContentController().onActivityPaused(activity);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected void onActivityResumed(Activity activity) {
        if (f494a || activity != null) {
            Iterator it = this.f496c.iterator();
            while (it.hasNext()) {
                Activity activity2 = (Activity) ((WeakReference) it.next()).get();
                if (activity2 == null || activity2 == activity) {
                    it.remove();
                }
            }
            this.f496c.add(new WeakReference(activity));
            it = this.f497d.iterator();
            while (it.hasNext()) {
                ((C0297a) it.next()).onActivityResumed(activity);
            }
            runningState(RunningState.FOREGROUND);
            BaseActivity managedActivity = managedActivity(activity);
            if (managedActivity != null && managedActivity.getContentController() != null) {
                managedActivity.getContentController().onActivityResumed(activity);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected void onActivityDestroyed(Activity activity) {
        if (f494a || activity != null) {
            Iterator it = this.f496c.iterator();
            while (it.hasNext()) {
                Activity activity2 = (Activity) ((WeakReference) it.next()).get();
                if (activity2 == null || activity2 == activity) {
                    it.remove();
                }
            }
            it = this.f497d.iterator();
            while (it.hasNext()) {
                ((C0297a) it.next()).onActivityDestroyed(activity);
            }
            if (this.f496c.isEmpty()) {
                runningState(RunningState.UNDERGROUND);
            }
            BaseActivity managedActivity = managedActivity(activity);
            if (managedActivity != null && managedActivity.getContentController() != null) {
                managedActivity.getContentController().onActivityDestroyed(activity);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private BaseActivity managedActivity(Activity activity) {
        if (activity instanceof BaseActivity) {
            return (BaseActivity) activity;
        }
        return null;
    }

    private void runningState(RunningState runningState, int i) {
        this.f502i = new C0319w(this, runningState);
        UThread.postDelayed(this.f502i, (long) i);
    }

    private void runningState(RunningState runningState) {
        if (this.f500g != runningState) {
            RunningState runningState2 = this.f500g;
            this.f500g = runningState;
            this.f501h = System.currentTimeMillis();
            onRunningStateChanged(runningState2, this.f500g);
            Iterator it = this.f498e.iterator();
            while (it.hasNext()) {
                ((C0286x) it.next()).onRunningStateChanged(this, runningState2, this.f500g);
            }
        }
        this.f502i = null;
    }
}
