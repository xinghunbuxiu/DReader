package com.duokan.core.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;
import android.view.KeyEvent;

import com.duokan.core.sys.TaskHandler;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManagedApp extends MultiDexApplication implements i, IFeature {
    static final boolean a = (!ManagedApp.class.desiredAssertionStatus());
    private static ManagedApp manage = null;
    private final ConcurrentLinkedQueue<WeakReference<Activity>> activitys = new ConcurrentLinkedQueue();
    private final CopyOnWriteArrayList<IActivityLife> activityLifes = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList<IActivityRunStatusChanged> runStatusChangeds = new CopyOnWriteArrayList();
    private final FeatureManage featureManage = new FeatureManage();
    private RunningState oldRunningState = RunningState.UNDERGROUND;
    private long currentTime = System.currentTimeMillis();
    private Runnable runnable = null;

    public enum RunningState {
        UNDERGROUND,
        BACKGROUND,
        FOREGROUND
    }

    @TargetApi(14)
    protected ManagedApp() {
        manage = this;
        registerActivityLifecycleCallbacks(new MyActivityLife(this));
    }

    public final boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) == 2;
    }

    public final RunningState getOldRunningState() {
        return this.oldRunningState;
    }

    public final long getRunningStateMillis() {
        return Math.max(0, System.currentTimeMillis() - this.currentTime);
    }

    public final Activity getTopActivity() {
        Iterator<WeakReference<Activity>> iterator = this.activitys.iterator();
        Activity activity = null;
        while (iterator.hasNext()) {
            Activity activity2 = iterator.next().get();
            if (!(activity2 == null || activity2.isFinishing())) {
                activity = activity2;
            }
        }
        return activity;
    }

    public final boolean hasAliveActivity() {
        return getTopActivity() != null;
    }

    public final void addActivityLifecycleMonitor(IActivityLife activityLife) {
        if (a || activityLife != null) {
            this.activityLifes.addIfAbsent(activityLife);
            return;
        }
        throw new AssertionError();
    }

    public final void removeActivityLifecycleMonitor(IActivityLife IActivityLifeVar) {
        if (a || IActivityLifeVar != null) {
            this.activityLifes.remove(IActivityLifeVar);
            return;
        }
        throw new AssertionError();
    }

    public final void addOnRunningStateChangedListener(IActivityRunStatusChanged runStatusChanged) {
        if (a || runStatusChanged != null) {
            this.runStatusChangeds.addIfAbsent(runStatusChanged);
            return;
        }
        throw new AssertionError();
    }

    public final void removeOnRunningStateChangedListener(IActivityRunStatusChanged IActivityRunStatusChangedVar) {
        this.runStatusChangeds.remove(IActivityRunStatusChangedVar);
    }

    public static ManagedApp get() {
        return manage;
    }

    public final void onActivityResult(BaseActivity baseActivity, int requestCode, int resultCode, Intent intent) {
        if (!a && baseActivity == null) {
            throw new AssertionError();
        } else if (baseActivity.getContentController() != null) {
            baseActivity.getContentController().onActivityResult(baseActivity, requestCode, resultCode, intent);
        }
    }

    public final boolean isStub() {
        return true;
    }

    public final IFeature getContext() {
        return this;
    }

    public final IController getParent() {
        return null;
    }

    public boolean requestShowMenu(ActivatedController activatedControllerVar) {
        return activatedControllerVar.onActivityShowMenu();
    }

    public boolean requestHideMenu(ActivatedController activatedControllerVar) {
        return activatedControllerVar.onActivityHideMenu();
    }

    public boolean requestSoftInputMode(ActivatedController activatedControllerVar, int i) {
        activatedControllerVar.getActivity().getWindow().setSoftInputMode(i);
        return true;
    }

    public boolean requestDetach(ActivatedController activatedControllerVar) {
        return false;
    }

    public int getSoftInputMode(ActivatedController activatedControllerVar) {
        return activatedControllerVar.getActivity().getWindow().getAttributes().softInputMode;
    }

    public FeatureListening queryFeature(Class cls) {
        return queryLocalFeature(cls);
    }

    public FeatureListening queryLocalFeature(Class cls) {
        if (cls == null) {
            return null;
        }
        return this.featureManage.addFirst(cls);
    }

    public boolean registerLocalFeature(FeatureListening featurelistening) {
        return this.featureManage.addFirst(featurelistening);
    }

    public boolean unregisterLocalFeature(FeatureListening featurelistening) {
        return this.featureManage.remove(featurelistening);
    }

    public boolean registerGlobalFeature(FeatureListening featurelistening) {
        return this.featureManage.addFirst(featurelistening);
    }

    public boolean unregisterGlobalFeature(FeatureListening featurelistening) {
        return this.featureManage.remove(featurelistening);
    }

    public final void onActivityConfigurationChanged(BaseActivity baseActivityVar, Configuration configuration) {
        if (!a && baseActivityVar == null) {
            throw new AssertionError();
        } else if (baseActivityVar.getContentController() != null) {
            baseActivityVar.getContentController().onActivityConfigurationChanged(baseActivityVar, configuration);
        }
    }

    public final void onActivityWindowFocusChanged(BaseActivity baseActivityVar, boolean z) {
        if (!a && baseActivityVar == null) {
            throw new AssertionError();
        } else if (baseActivityVar.getContentController() != null) {
            baseActivityVar.getContentController().onActivityWindowFocusChanged(baseActivityVar, z);
        }
    }

    public final boolean onActivityKeyDown(BaseActivity baseActivityVar, int i, KeyEvent keyEvent) {
        if (!a && baseActivityVar == null) {
            throw new AssertionError();
        } else if (baseActivityVar.getContentController() != null) {
            return baseActivityVar.getContentController().onActivityKeyDown(baseActivityVar, i, keyEvent);
        } else {
            return false;
        }
    }

    public final boolean onActivityKeyUp(BaseActivity baseActivityVar, int i, KeyEvent keyEvent) {
        if (baseActivityVar.getContentController() != null) {
            return baseActivityVar.getContentController().onActivityKeyUp(baseActivityVar, i, keyEvent);
        }
        return false;
    }

    public final boolean onActivityBackPressed(BaseActivity baseActivityVar) {
        if (baseActivityVar.getContentController() != null) {
            return baseActivityVar.getContentController().onActivityBackPressed(baseActivityVar);
        }
        return false;
    }

    public void onTrimMemory(int i) {
        if (i == 20) {
            runningState(RunningState.BACKGROUND);
        }
        Iterator it = this.activitys.iterator();
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
        if (a || activity != null) {
            this.activitys.add(new WeakReference(activity));
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((IActivityLife) it.next()).onActivityCreated(activity, bundle);
            }
            if (this.oldRunningState == RunningState.UNDERGROUND) {
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
        if (a || activity != null) {
            Iterator<IActivityLife> it = this.activityLifes.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
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
        if (a || activity != null) {
            Iterator<WeakReference<Activity>> it = this.activitys.iterator();
            while (it.hasNext()) {
                Activity activity2 = it.next().get();
                if (activity2 == null || activity2 == activity) {
                    it.remove();
                }
            }
            this.activitys.add(new WeakReference(activity));
            Iterator<IActivityLife> lifeIterator = this.activityLifes.iterator();
            while (lifeIterator.hasNext()) {
                lifeIterator.next().onActivityResumed(activity);
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
        if (a || activity != null) {
            Iterator<WeakReference<Activity>> it = this.activitys.iterator();
            while (it.hasNext()) {
                Activity activity2 = it.next().get();
                if (activity2 == null || activity2 == activity) {
                    it.remove();
                }
            }
            Iterator<IActivityLife> lifeIterator = this.activityLifes.iterator();
            while (lifeIterator.hasNext()) {
                ((IActivityLife) it.next()).onActivityDestroyed(activity);
            }
            if (this.activitys.isEmpty()) {
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

    private void runningState(final RunningState runningState, final int i) {
        this.runnable = new RunTask(this, runningState);
        TaskHandler.postDelayed(this.runnable, (long) i);
    }

    class RunTask implements Runnable {
        final RunningState runningState;
        final ManagedApp managedApp;

        RunTask(ManagedApp managedApp, RunningState runningState) {
            this.managedApp = managedApp;
            this.runningState = runningState;
        }

        public void run() {
            if (this.managedApp.runnable == this) {
                this.managedApp.runningState(this.runningState);
            }
        }
    }

    private void runningState(RunningState runningState) {
        if (this.oldRunningState != runningState) {
            RunningState tempRunningState = this.oldRunningState;
            this.oldRunningState = runningState;
            this.currentTime = System.currentTimeMillis();
            onRunningStateChanged(tempRunningState, this.oldRunningState);
            Iterator it = this.runStatusChangeds.iterator();
            while (it.hasNext()) {
                ((IActivityRunStatusChanged) it.next()).onRunningStateChanged(this, tempRunningState, this.oldRunningState);
            }
        }
        this.runnable = null;
    }
}
