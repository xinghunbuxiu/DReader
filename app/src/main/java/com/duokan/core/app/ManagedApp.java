package com.duokan.core.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;
import android.view.KeyEvent;

import com.duokan.core.sys.t;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManagedApp extends MultiDexApplication implements i, y {
    static final /* synthetic */ boolean a = (!ManagedApp.class.desiredAssertionStatus());
    private static ManagedApp b = null;
    private final ConcurrentLinkedQueue c = new ConcurrentLinkedQueue();
    private final CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();
    private final l f = new l();
    private RunningState g = RunningState.UNDERGROUND;
    private long h = System.currentTimeMillis();
    private Runnable i = null;

    public enum RunningState {
        UNDERGROUND,
        BACKGROUND,
        FOREGROUND
    }

    @TargetApi(14)
    protected ManagedApp() {
        b = this;
        registerActivityLifecycleCallbacks(new u(this));
    }

    public final boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) == 2;
    }

    public final RunningState getRunningState() {
        return this.g;
    }

    public final long getRunningStateMillis() {
        return Math.max(0, System.currentTimeMillis() - this.h);
    }

    public final Activity getTopActivity() {
        Iterator it = this.c.iterator();
        Activity activity = null;
        while (it.hasNext()) {
            Activity activity2 = (Activity) ((WeakReference) it.next()).get();
            if (!(activity2 == null || activity2.isFinishing())) {
                activity = activity2;
            }
        }
        return activity;
    }

    public final boolean hasAliveActivity() {
        return getTopActivity() != null;
    }

    public final void addActivityLifecycleMonitor(a aVar) {
        if (a || aVar != null) {
            this.d.addIfAbsent(aVar);
            return;
        }
        throw new AssertionError();
    }

    public final void removeActivityLifecycleMonitor(a aVar) {
        if (a || aVar != null) {
            this.d.remove(aVar);
            return;
        }
        throw new AssertionError();
    }

    public final void addOnRunningStateChangedListener(w wVar) {
        if (a || wVar != null) {
            this.e.addIfAbsent(wVar);
            return;
        }
        throw new AssertionError();
    }

    public final void removeOnRunningStateChangedListener(w wVar) {
        this.e.remove(wVar);
    }

    public static ManagedApp get() {
        return b;
    }

    public final void onActivityResult(m mVar, int i, int i2, Intent intent) {
        if (!a && mVar == null) {
            throw new AssertionError();
        } else if (mVar.getContentController() != null) {
            mVar.getContentController().onActivityResult(mVar, i, i2, intent);
        }
    }

    public final boolean isStub() {
        return true;
    }

    public final y getContext() {
        return this;
    }

    public final h getParent() {
        return null;
    }

    public boolean requestShowMenu(e eVar) {
        return eVar.onActivityShowMenu();
    }

    public boolean requestHideMenu(e eVar) {
        return eVar.onActivityHideMenu();
    }

    public boolean requestSoftInputMode(e eVar, int i) {
        eVar.getActivity().getWindow().setSoftInputMode(i);
        return true;
    }

    public boolean requestDetach(e eVar) {
        return false;
    }

    public int getSoftInputMode(e eVar) {
        return eVar.getActivity().getWindow().getAttributes().softInputMode;
    }

    public k queryFeature(Class cls) {
        return queryLocalFeature(cls);
    }

    public k queryLocalFeature(Class cls) {
        if (cls == null) {
            return null;
        }
        return this.f.a(cls);
    }

    public boolean registerLocalFeature(k kVar) {
        return this.f.a(kVar);
    }

    public boolean unregisterLocalFeature(k kVar) {
        return this.f.b(kVar);
    }

    public boolean registerGlobalFeature(k kVar) {
        return this.f.a(kVar);
    }

    public boolean unregisterGlobalFeature(k kVar) {
        return this.f.b(kVar);
    }

    public final void onActivityConfigurationChanged(m mVar, Configuration configuration) {
        if (!a && mVar == null) {
            throw new AssertionError();
        } else if (mVar.getContentController() != null) {
            mVar.getContentController().onActivityConfigurationChanged(mVar, configuration);
        }
    }

    public final void onActivityWindowFocusChanged(m mVar, boolean z) {
        if (!a && mVar == null) {
            throw new AssertionError();
        } else if (mVar.getContentController() != null) {
            mVar.getContentController().onActivityWindowFocusChanged(mVar, z);
        }
    }

    public final boolean onActivityKeyDown(m mVar, int i, KeyEvent keyEvent) {
        if (!a && mVar == null) {
            throw new AssertionError();
        } else if (mVar.getContentController() != null) {
            return mVar.getContentController().onActivityKeyDown(mVar, i, keyEvent);
        } else {
            return false;
        }
    }

    public final boolean onActivityKeyUp(m mVar, int i, KeyEvent keyEvent) {
        if (mVar.getContentController() != null) {
            return mVar.getContentController().onActivityKeyUp(mVar, i, keyEvent);
        }
        return false;
    }

    public final boolean onActivityBackPressed(m mVar) {
        if (mVar.getContentController() != null) {
            return mVar.getContentController().onActivityBackPressed(mVar);
        }
        return false;
    }

    public void onTrimMemory(int i) {
        if (i == 20) {
            runningState(RunningState.BACKGROUND);
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (!(activity == null || activity.isFinishing())) {
                activity = managedActivity(activity);
                if (activity != null) {
                    e contentController = activity.getContentController();
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
        if (a || activity != null) {
            this.c.add(new WeakReference(activity));
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onActivityCreated(activity, bundle);
            }
            if (this.g == RunningState.UNDERGROUND) {
                runningState(RunningState.BACKGROUND);
            }
            m managedActivity = managedActivity(activity);
            if (managedActivity != null && managedActivity.getContentController() != null) {
                managedActivity.getContentController().onActivityCreated(activity, bundle);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected void onActivityPaused(Activity activity) {
        if (a || activity != null) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onActivityPaused(activity);
            }
            runningState(RunningState.BACKGROUND, 5000);
            m managedActivity = managedActivity(activity);
            if (managedActivity != null && managedActivity.getContentController() != null) {
                managedActivity.getContentController().onActivityPaused(activity);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected void onActivityResumed(Activity activity) {
        if (a || activity != null) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                Activity activity2 = (Activity) ((WeakReference) it.next()).get();
                if (activity2 == null || activity2 == activity) {
                    it.remove();
                }
            }
            this.c.add(new WeakReference(activity));
            it = this.d.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onActivityResumed(activity);
            }
            runningState(RunningState.FOREGROUND);
            m managedActivity = managedActivity(activity);
            if (managedActivity != null && managedActivity.getContentController() != null) {
                managedActivity.getContentController().onActivityResumed(activity);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected void onActivityDestroyed(Activity activity) {
        if (a || activity != null) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                Activity activity2 = (Activity) ((WeakReference) it.next()).get();
                if (activity2 == null || activity2 == activity) {
                    it.remove();
                }
            }
            it = this.d.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onActivityDestroyed(activity);
            }
            if (this.c.isEmpty()) {
                runningState(RunningState.UNDERGROUND);
            }
            m managedActivity = managedActivity(activity);
            if (managedActivity != null && managedActivity.getContentController() != null) {
                managedActivity.getContentController().onActivityDestroyed(activity);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private m managedActivity(Activity activity) {
        if (activity instanceof m) {
            return (m) activity;
        }
        return null;
    }

    private void runningState(RunningState runningState, int i) {
        this.i = new v(this, runningState);
        t.a(this.i, (long) i);
    }

    private void runningState(RunningState runningState) {
        if (this.g != runningState) {
            RunningState runningState2 = this.g;
            this.g = runningState;
            this.h = System.currentTimeMillis();
            onRunningStateChanged(runningState2, this.g);
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ((w) it.next()).onRunningStateChanged(this, runningState2, this.g);
            }
        }
        this.i = null;
    }
}
