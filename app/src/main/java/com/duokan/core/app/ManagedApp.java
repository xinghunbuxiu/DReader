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

    static final boolean desAsseertionStatus = (!ManagedApp.class.desiredAssertionStatus());

    private static ManagedApp managedApp = null;

    private final ConcurrentLinkedQueue<WeakReference<BaseActivity>> activitys = new ConcurrentLinkedQueue();

    private final CopyOnWriteArrayList<IActivityLifecycleCallbacks> lifecycleCallbacks = new CopyOnWriteArrayList();

    private final CopyOnWriteArrayList<ApplicationsStateCallbacks> runStatusChangeds = new CopyOnWriteArrayList();

    private final FeatureManage featureManage = new FeatureManage();

    private RunningState runningState = RunningState.UNDERGROUND;

    private long currentTimeMillis = System.currentTimeMillis();

    private Runnable runnable = null;

    public enum RunningState {
        UNDERGROUND,
        BACKGROUND,
        FOREGROUND
    }

    @TargetApi(14)
    protected ManagedApp() {
        managedApp = this;
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                managedApp.onActivityCreated(activity, savedInstanceState);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                managedApp.onActivityResumed(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
                managedApp.onActivityPaused(activity);
            }

            @Override
            public void onActivityStopped(Activity activity) {
                managedApp.onActivityPaused(activity);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                managedApp.onActivityDestroyed(activity);
            }
        });
    }

    public final boolean isDebuggable() {
        return (getApplicationInfo().flags & 2) == 2;
    }

    public final RunningState getRunningState() {
        return this.runningState;
    }

    public final long getRunningStateMillis() {
        return Math.max(0, System.currentTimeMillis() - this.currentTimeMillis);
    }

    public final Activity getTopActivity() {
        Iterator<WeakReference<BaseActivity>> it = this.activitys.iterator();
        Activity activity = null;
        while (it.hasNext()) {
            Activity activity2 = it.next().get();
            if (AppManage.isFinishing(activity2)) {
                activity = activity2;
            }
        }
        return activity;
    }

    public final boolean hasAliveActivity() {
        return getTopActivity() != null;
    }

    public final void addActivityLifecycleMonitor(IActivityLifecycleCallbacks mctivityLife) {
        if (desAsseertionStatus || mctivityLife != null) {
            this.lifecycleCallbacks.addIfAbsent(mctivityLife);
            return;
        }
        throw new AssertionError();
    }

    public final void removeActivityLifecycleMonitor(IActivityLifecycleCallbacks mctivityLife) {
        if (desAsseertionStatus || mctivityLife != null) {
            this.lifecycleCallbacks.remove(mctivityLife);
            return;
        }
        throw new AssertionError();
    }

    public final void addOnRunningStateChangedListener(ApplicationsStateCallbacks stateCallbacks) {
        if (desAsseertionStatus || stateCallbacks != null) {
            this.runStatusChangeds.addIfAbsent(stateCallbacks);
            return;
        }
        throw new AssertionError();
    }

    public final void removeOnRunningStateChangedListener(ApplicationsStateCallbacks stateCallbacks) {
        this.runStatusChangeds.remove(stateCallbacks);
    }

    public static ManagedApp get() {
        return managedApp;
    }

    public final void onActivityResult(BaseActivity mActivity, int requestCode, int resultCode, Intent intent) {
        if (!desAsseertionStatus && mActivity == null) {
            throw new AssertionError();
        } else if (mActivity.getContentController() != null) {
            mActivity.getContentController().onActivityResult(mActivity, requestCode, resultCode, intent);
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

    public boolean requestShowMenu(ActivatedController activatedController) {
        return activatedController.onActivityShowMenu();
    }

    public boolean requestHideMenu(ActivatedController activatedController) {
        return activatedController.onActivityHideMenu();
    }

    public boolean requestSoftInputMode(ActivatedController activatedController, int i) {
        activatedController.getActivity().getWindow().setSoftInputMode(i);
        return true;
    }

    public boolean requestDetach(ActivatedController controller) {
        return false;
    }

    public int getSoftInputMode(ActivatedController controller) {
        return controller.getActivity().getWindow().getAttributes().softInputMode;
    }

    public <T extends FeatureListening> T queryFeature(Class<T> cls) {
        return queryLocalFeature(cls);
    }

    public <T extends FeatureListening> T queryLocalFeature(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        return this.featureManage.isContainsListener(cls);
    }

    public boolean registerLocalFeature(FeatureListening featureListening) {
        return this.featureManage.addFeatureListener(featureListening);
    }

    public boolean unregisterLocalFeature(FeatureListening featureListening) {
        return this.featureManage.removeFeatureListener(featureListening);
    }

    public boolean registerGlobalFeature(FeatureListening featureListening) {
        return this.featureManage.addFeatureListener(featureListening);
    }

    public boolean unregisterGlobalFeature(FeatureListening featureListening) {
        return this.featureManage.removeFeatureListener(featureListening);
    }

    public final void onActivityConfigurationChanged(BaseActivity mActivity, Configuration configuration) {
        if (!desAsseertionStatus && mActivity == null) {
            throw new AssertionError();
        } else if (mActivity.getContentController() != null) {
            mActivity.getContentController().onActivityConfigurationChanged(mActivity, configuration);
        }
    }

    @Override
    public final void onActivityWindowFocusChanged(BaseActivity mActivity, boolean z) {
        if (!desAsseertionStatus && mActivity == null) {
            throw new AssertionError();
        } else if (mActivity.getContentController() != null) {
            mActivity.getContentController().onActivityWindowFocusChanged(mActivity, z);
        }
    }

    @Override
    public final boolean onActivityKeyDown(BaseActivity mActivity, int i, KeyEvent keyEvent) {
        if (!desAsseertionStatus && mActivity == null) {
            throw new AssertionError();
        } else if (mActivity.getContentController() != null) {
            return mActivity.getContentController().onActivityKeyDown(mActivity, i, keyEvent);
        } else {
            return false;
        }
    }

    @Override
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

    @Override
    public void onTrimMemory(int i) {
        if (i == 20) {
            runningState(RunningState.BACKGROUND);
        }
        Iterator<WeakReference<BaseActivity>> it = this.activitys.iterator();
        while (it.hasNext()) {
            BaseActivity activity = it.next().get();
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
        if (desAsseertionStatus || activity != null) {
            this.activitys.add(new WeakReference(activity));
            Iterator<IActivityLifecycleCallbacks> it = this.lifecycleCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
            if (this.runningState == RunningState.UNDERGROUND) {
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
        if (desAsseertionStatus || activity != null) {
            Iterator it = this.lifecycleCallbacks.iterator();
            while (it.hasNext()) {
                ((IActivityLifecycleCallbacks) it.next()).onActivityPaused(activity);
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
        if (desAsseertionStatus || activity != null) {
            Iterator<WeakReference<BaseActivity>> it = this.activitys.iterator();
            while (it.hasNext()) {
                BaseActivity activity2 = it.next().get();
                if (activity2 == null || activity2 == activity) {
                    it.remove();
                }
            }
            this.activitys.add(new WeakReference(activity));
            Iterator<IActivityLifecycleCallbacks> callbacksIterator = this.lifecycleCallbacks.iterator();
            while (callbacksIterator.hasNext()) {
                callbacksIterator.next().onActivityResumed(activity);
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
        if (desAsseertionStatus || activity != null) {
            Iterator<WeakReference<BaseActivity>> it = this.activitys.iterator();
            while (it.hasNext()) {
                Activity activity2 = it.next().get();
                if (activity2 == null || activity2 == activity) {
                    it.remove();
                }
            }
            Iterator<IActivityLifecycleCallbacks> callbacksIterator = this.lifecycleCallbacks.iterator();
            while (callbacksIterator.hasNext()) {
                callbacksIterator.next().onActivityDestroyed(activity);
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

    private void runningState(final RunningState runState, int delayMillis) {
        this.runnable = new Runnable() {
            @Override
            public void run() {
//                if (this.managedApp.runnable == this) {
                managedApp.runningState(runState);

            }
        };
        UThread.postDelayed(this.runnable, delayMillis);
    }

    private void runningState(RunningState runningState) {
        if (this.runningState != runningState) {
            RunningState runningState2 = this.runningState;
            this.runningState = runningState;
            this.currentTimeMillis = System.currentTimeMillis();
            onRunningStateChanged(runningState2, this.runningState);
            Iterator<ApplicationsStateCallbacks> it = this.runStatusChangeds.iterator();
            while (it.hasNext()) {
                it.next().onRunningStateChanged(this, runningState2, this.runningState);
            }
        }
        this.runnable = null;
    }
}
