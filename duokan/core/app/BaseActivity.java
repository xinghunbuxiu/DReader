package com.duokan.core.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager.LayoutParams;

import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.UTools;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;
import static android.content.res.Configuration.ORIENTATION_UNDEFINED;

public class BaseActivity extends Activity implements IFeature {
    static final boolean assertionStatus = (!BaseActivity.class.desiredAssertionStatus());
    private final FeatureManage featureManage = new FeatureManage();
    private final CopyOnWriteArrayList<SensorBean> sensorBeen = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList<s> screenChanged = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList<onActivityResult> activityResults = new CopyOnWriteArrayList();
    private boolean first = false;
    private OrientationEventListener eventListener = null;
    private int h = 0;
    private int screenRotation = 0;
    private SensorManager sensorManager = null;
    private ActivatedController activatedController = null;
    private BrightnessMode brightnessMode = BrightnessMode.SYSTEM;
    private float screenBright = -1.0f;
    private Runnable runnable = null;
    private BrightnessMode mode = BrightnessMode.SYSTEM;
    private float keyboardBright = -1.0f;
    private Handler handler = null;
    private int screenTimeout = 0;
    private int s = 0;
    private int screen_orientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    static final int[] modes = new int[BrightnessMode.values().length];

    static {
        try {
            modes[BrightnessMode.SYSTEM.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            modes[BrightnessMode.MANUAL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
    public int getScreenTimeout() {
        return this.screenTimeout;
    }

    public void setScreenTimeout(int screenTimeout) {
        this.screenTimeout = screenTimeout;
        lockScreen();
        resetScreenTimeout();
    }

    public BrightnessMode getScreenBrightnessMode() {
        return this.brightnessMode;
    }

    public void setScreenBrightnessMode(BrightnessMode brightnessMode) {
        this.brightnessMode = brightnessMode;
        scheduleScreenBrightnessUpdate();
    }

    public float getScreenBrightness() {
        return this.screenBright;
    }

    public void setScreenBrightness(float screenBright) {
        this.screenBright = screenBright;
        scheduleScreenBrightnessUpdate();
    }

    @TargetApi(9)
    public int getCurrentOrientation() {
        int rotation;
        if (getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
            if (VERSION.SDK_INT < 9) {
                return ORIENTATION_PORTRAIT;
            }
            rotation = getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == Surface.ROTATION_90) {
                return Surface.ROTATION_0;
            }
            if (rotation == Surface.ROTATION_180) {
                return 9;
            }
            if (rotation == Surface.ROTATION_270) {
                return 8;
            }
            return Surface.ROTATION_90;
        } else if (VERSION.SDK_INT < 8) {
            return Surface.ROTATION_0;
        } else {
            rotation = getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 0) {
                return Surface.ROTATION_0;
            }
            if (rotation == 1) {
                return 9;
            }
            if (rotation == 2) {
                return 8;
            }
            return Surface.ROTATION_90;
        }
    }

    public int getScreenRotation() {
        return this.screenRotation;
    }

    public BrightnessMode getKeyboardBrightnessMode() {
        return this.mode;
    }

    public void setKeyboardBrightnessMode(BrightnessMode brightnessMode) {
        this.mode = brightnessMode;
        adjustKeyboardBrightness();
    }

    public float getKeyboardBrightness() {
        return this.keyboardBright;
    }

    public void setKeyboardBrightness(float keyboardBright) {
        this.keyboardBright = keyboardBright;
        adjustKeyboardBrightness();
    }

    public Sensor getAccelerometerSensor() {
        return getSensorManager().getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public Sensor getMagneticFieldSensor() {
        return getSensorManager().getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    public Sensor getLightSensor() {
        return getSensorManager().getDefaultSensor(5);
    }

    public SensorManager getSensorManager() {
        if (this.sensorManager == null) {
            this.sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        }
        return this.sensorManager;
    }

    public ActivatedController getContentController() {
        return this.activatedController;
    }

    public void setContentController(ActivatedController activatedControllerVar) {
        if (this.activatedController != activatedControllerVar) {
            if (this.activatedController != null) {
                this.activatedController.setParent(null);
            }
            this.activatedController = activatedControllerVar;
            if (this.activatedController != null) {
                setContentView(this.activatedController.getContentView());
                this.activatedController.setParent(controllerStub());
                if (this.first) {
                    this.activatedController.onActivityResumed(this);
                    return;
                }
                return;
            }
            setContentView(new View(this));
        }
    }

    public void addSensorListener(Sensor sensor, SensorEventListener sensorEventListener, int i) {
        if (assertionStatus || sensor != null) {
            getSensorManager().registerListener(sensorEventListener, sensor, i);
            this.sensorBeen.addIfAbsent(new SensorBean(sensor, sensorEventListener, i));
            return;
        }
        throw new AssertionError();
    }

    public void removeSensorListener(SensorEventListener sensorEventListener) {
        getSensorManager().unregisterListener(sensorEventListener);
        Iterator<SensorBean> it = this.sensorBeen.iterator();
        while (it.hasNext()) {
            if (it.next() == sensorEventListener) {
                it.remove();
            }
        }
    }

    public void addOnScreenRotationChangedListener(s sVar) {
        this.screenChanged.addIfAbsent(sVar);
    }

    public void removeOnScreenRotationChangedListener(s sVar) {
        this.screenChanged.remove(sVar);
    }

    public void addOnActivityResultListener(onActivityResult rVar) {
        this.activityResults.addIfAbsent(rVar);
    }

    public void removeOnActivityResultListener(onActivityResult rVar) {
        this.activityResults.remove(rVar);
    }

    @TargetApi(18)
    public void lockCurrentOrientation() {
        int i = this.s;
        this.s = i + 1;
        if (i <= 0) {
            this.screen_orientation = getRequestedOrientation();
            if (VERSION.SDK_INT >= 18) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
            } else {
                setRequestedOrientation(getCurrentOrientation());
            }
        }
    }

    public void unlockCurrentOrientation() {
        int i = this.s - 1;
        this.s = i;
        if (i <= 0) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            this.screen_orientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
        }
    }

    public void requestShowMenu() {
        if (this.activatedController != null) {
            this.activatedController.requestShowMenu();
        }
    }

    public void requestHideMenu() {
        if (this.activatedController != null) {
            this.activatedController.requestHideMenu();
        }
    }

    public FeatureListening queryFeature(Class cls) {
        FeatureListening queryLocalFeature = queryLocalFeature(cls);
        if (queryLocalFeature != null) {
            return queryLocalFeature;
        }
        return globalContext().queryFeature(cls);
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
        if (featurelistening == null) {
            return false;
        }
        return globalContext().registerGlobalFeature(featurelistening);
    }

    public boolean unregisterGlobalFeature(FeatureListening featurelistening) {
        return globalContext().unregisterGlobalFeature(featurelistening);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        lockScreen();
        resetScreenTimeout();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        notifyActivityResult(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        notifyActivityConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        updateScreenBrightness();
    }

    protected void onResume() {
        super.onResume();
        this.first = true;
        lockScreen();
        resetScreenTimeout();
        if (this.eventListener == null) {
            this.eventListener = new MyOrientationEventListener(this, this, 3);
        }
        this.eventListener.enable();
        Iterator<SensorBean> it = this.sensorBeen.iterator();
        while (it.hasNext()) {
            SensorBean sensorBean = it.next();
            getSensorManager().registerListener(sensorBean.sensorEventListener, sensorBean.sensor, sensorBean.c);
        }
    }

    protected void onPause() {
        unlockScreen();
        closeScreenTimeout();
        this.eventListener.disable();
        Iterator<SensorBean> it = this.sensorBeen.iterator();
        while (it.hasNext()) {
            getSensorManager().unregisterListener(it.next().sensorEventListener);
        }
        this.first = false;
        super.onPause();
    }

    protected void onDestroy() {
        this.featureManage.clear();
        this.sensorBeen.clear();
        this.screenChanged.clear();
        super.onDestroy();
        setContentController(null);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        notifyActivityWindowFocusChanged(z);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (notifyActivityKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (notifyActivityKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onBackPressed() {
        if (!notifyActivityBackPressed() && this.first) {
            super.onBackPressed();
        }
    }

    private final void resetScreenTimeout() {
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper(), new o(this));
        }
        this.handler.removeCallbacksAndMessages(null);
        if (this.screenTimeout == 0) {
            unlockScreen();
        }
        if (this.screenTimeout != 0 && this.screenTimeout != Integer.MAX_VALUE) {
            this.handler.sendEmptyMessageDelayed(0, (long) this.screenTimeout);
        }
    }

    private final void closeScreenTimeout() {
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    private final void lockScreen() {
        getWindow().setFlags(128, 128);
    }

    private final void unlockScreen() {
        getWindow().clearFlags(128);
    }

    private final void scheduleScreenBrightnessUpdate() {
        if (this.runnable == null) {
            this.runnable = new p(this);
            TaskHandler.PostTask(this.runnable);
        }
    }

    private final void updateScreenBrightness() {
        LayoutParams attributes = getWindow().getAttributes();
        float f = attributes.screenBrightness;
        switch (modes[this.brightnessMode.ordinal()]) {
            case 1:
                f = -1.0f;
                break;
            case 2:
                f = Math.max(0.02f, Math.min(this.screenBright, 1.0f));
                break;
        }
        if (Float.compare(attributes.screenBrightness, f) != 0) {
            attributes.screenBrightness = f;
            getWindow().setAttributes(attributes);
        }
    }

    private final void adjustKeyboardBrightness() {
        LayoutParams attributes = getWindow().getAttributes();
        float f = attributes.buttonBrightness;
        switch (modes[this.mode.ordinal()]) {
            case 1:
                f = -1.0f;
                break;
            case 2:
                f = Math.max(0.0f, Math.min(this.keyboardBright, 1.0f));
                break;
        }
        if (Float.compare(attributes.buttonBrightness, f) != 0) {
            attributes.buttonBrightness = f;
            getWindow().setAttributes(attributes);
        }
    }

    private final void notifyScreenRotationChanged(int i) {
        Iterator it = this.screenChanged.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(i);
        }
    }

    private final void notifyActivityConfigurationChanged(Configuration configuration) {
        if (controllerRoot() != null) {
            controllerRoot().onActivityConfigurationChanged(this, configuration);
        }
    }

    private final void notifyActivityResult(int requestCode, int resultCode,  Intent intent) {
        Iterator<onActivityResult> it = this.activityResults.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(requestCode, resultCode, intent);
        }
        if (getApplication() instanceof ManagedApp) {
            ((ManagedApp) getApplication()).onActivityResult(this, requestCode, resultCode, intent);
        }
    }

    private final void notifyActivityWindowFocusChanged(boolean z) {
        if (controllerRoot() != null) {
            controllerRoot().onActivityWindowFocusChanged(this, z);
        }
    }

    private final boolean notifyActivityKeyDown(int i, KeyEvent keyEvent) {
        if (controllerRoot() == null) {
            return false;
        }
        return controllerRoot().onActivityKeyDown(this, i, keyEvent);
    }

    private final boolean notifyActivityKeyUp(int i, KeyEvent keyEvent) {
        if (controllerRoot() == null) {
            return false;
        }
        return controllerRoot().onActivityKeyUp(this, i, keyEvent);
    }

    private final boolean notifyActivityBackPressed() {
        if (controllerRoot() == null) {
            return false;
        }
        return controllerRoot().onActivityBackPressed(this);
    }

    private final IController controllerStub() {
        return (IController) getApplication();
    }

    private final IFeature globalContext() {
        return (IFeature) getApplication();
    }

    private final Controller controllerRoot() {
        Application application = getApplication();
        if (application instanceof Controller) {
            return (Controller) application;
        }
        return null;
    }

    class SensorBean {
        public final Sensor sensor;
        public final SensorEventListener sensorEventListener;
        public final int c;

        public SensorBean(Sensor sensor, SensorEventListener sensorEventListener, int i) {
            this.sensor = sensor;
            this.sensorEventListener = sensorEventListener;
            this.c = i;
        }
    }

    class MyOrientationEventListener extends OrientationEventListener {
        final BaseActivity a;

        MyOrientationEventListener(BaseActivity baseActivityVar, Context context, int i) {
            super(context, i);
            this.a = baseActivityVar;
        }

        public void onOrientationChanged(int i) {
            if (i >= 0 && i < 360 && Math.abs(this.a.h - i) >= 75) {
                int i2 = i < 45 ? 0 : i < 135 ? 90 : i < 225 ? 180 : i < 315 ? 270 : 0;
                this.a.h = i2;
                i2 = this.a.h - UTools.get_Angle((-this.a.getWindowManager().getDefaultDisplay().getRotation()) * 90, 0, 360);
                if (screenRotation != i2) {
                    screenRotation = i2;
                    notifyScreenRotationChanged(screenRotation);
                }
            }
        }
    }
}
