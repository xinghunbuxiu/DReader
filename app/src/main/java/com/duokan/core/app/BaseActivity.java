package com.duokan.core.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
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
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager.LayoutParams;

import com.duokan.core.sys.UThread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback, IFeature {
    static final boolean assertionStatus = (!BaseActivity.class.desiredAssertionStatus());
    private final FeatureManage featureManage = new FeatureManage();
    private final AtomicInteger atomicInteger = new AtomicInteger();
    private final CopyOnWriteArrayList<SensorListener> SensorListeners = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList<IScreenRotationChangedListener> screenRotationChangedListeners = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList<OnActivityResultListener> mActivityResultListeners = new CopyOnWriteArrayList();
    private final ConcurrentHashMap<Integer, OnRequestPermissionsResultCallback> permissions = new ConcurrentHashMap();
    private boolean isFirst = false;
    private OrientationEventListener orientationEventListener = null;
    private int f522j = 0;
    private int screenRotation = 0;
    private SensorManager sensorManager = null;
    private ActivatedController tempController = null;
    private BrightnessMode brightnessMode = BrightnessMode.SYSTEM;
    private float brightness = -1.0f;
    private Runnable updateBrightness = null;
    private BrightnessMode brightnessMode1 = BrightnessMode.SYSTEM;
    private float keyboardBrightness = -1.0f;
    private Handler mHandler = null;
    private int screenTimeout = 0;
    private int isLockCurrentOrientation = 0;
    private int screenOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
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

    public void setScreenTimeout(int i) {
        this.screenTimeout = i;
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
        return this.brightness;
    }

    public void setScreenBrightness(float brightness) {
        this.brightness = brightness;
        scheduleScreenBrightnessUpdate();
    }

    @TargetApi(9)
    public int getCurrentOrientation() {
        int rotation;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (VERSION.SDK_INT < 9) {
                return Configuration.ORIENTATION_PORTRAIT;
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
        return this.brightnessMode1;
    }

    public void setKeyboardBrightnessMode(BrightnessMode brightnessMode) {
        this.brightnessMode1 = brightnessMode;
        adjustKeyboardBrightness();
    }

    public float getKeyboardBrightness() {
        return this.keyboardBrightness;
    }

    public void setKeyboardBrightness(float f) {
        this.keyboardBrightness = f;
        adjustKeyboardBrightness();
    }

    public Sensor getAccelerometerSensor() {
        return getSensorManager().getDefaultSensor(1);
    }

    public Sensor getMagneticFieldSensor() {
        return getSensorManager().getDefaultSensor(2);
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
        return this.tempController;
    }

    public void setContentController(ActivatedController controller) {
        if (this.tempController != controller) {
            if (this.tempController != null) {
                this.tempController.setParent(null);
            }
            this.tempController = controller;
            if (this.tempController != null) {
                setContentView(this.tempController.getContentView());
                this.tempController.setParent(controllerStub());
                if (this.isFirst) {
                    this.tempController.onActivityResumed(this);
                    return;
                }
                return;
            }
            setContentView(new View(this));
        }
    }

    public void addSensorListener(Sensor sensor, SensorEventListener sensorEventListener, int samplingPeriodUs) {
        if (assertionStatus || sensor != null) {
            getSensorManager().registerListener(sensorEventListener, sensor, samplingPeriodUs);
            this.SensorListeners.addIfAbsent(new SensorListener(sensor, sensorEventListener, samplingPeriodUs));
            return;
        }
        throw new AssertionError();
    }

    public void removeSensorListener(SensorEventListener sensorEventListener) {
        getSensorManager().unregisterListener(sensorEventListener);
        Iterator<SensorListener> it = this.SensorListeners.iterator();
        while (it.hasNext()) {
            if (it.next().sensorEventListener == sensorEventListener) {
                it.remove();
            }
        }
    }

    public void addOnScreenRotationChangedListener(IScreenRotationChangedListener screenRotationChangedListener) {
        this.screenRotationChangedListeners.addIfAbsent(screenRotationChangedListener);
    }

    public void removeOnScreenRotationChangedListener(IScreenRotationChangedListener screenRotationChangedListener) {
        this.screenRotationChangedListeners.remove(screenRotationChangedListener);
    }

    public void addOnActivityResultListener(OnActivityResultListener result) {
        this.mActivityResultListeners.addIfAbsent(result);
    }

    public void removeOnActivityResultListener(OnActivityResultListener result) {
        this.mActivityResultListeners.remove(result);
    }

    @TargetApi(18)
    public void lockCurrentOrientation() {
        this.isLockCurrentOrientation = this.isLockCurrentOrientation + 1;
        if (isLockCurrentOrientation <= 0) {
            this.screenOrientation = getRequestedOrientation();
            if (VERSION.SDK_INT >= 18) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
            } else {
                setRequestedOrientation(getCurrentOrientation());
            }
        }
    }

    public void unlockCurrentOrientation() {
        this.isLockCurrentOrientation = this.isLockCurrentOrientation - 1;
        if (isLockCurrentOrientation <= 0) {
            setRequestedOrientation(this.screenOrientation);
            this.screenOrientation = -1;
        }
    }

    public void requestShowMenu() {
        if (this.tempController != null) {
            this.tempController.requestShowMenu();
        }
    }

    public void requestHideMenu() {
        if (this.tempController != null) {
            this.tempController.requestHideMenu();
        }
    }

    public void requestPermissions(String[] strArr, OnRequestPermissionsResultCallback permission) {
        int incrementAndGet = this.atomicInteger.incrementAndGet();
        this.permissions.put(incrementAndGet, permission);
        ActivityCompat.requestPermissions(this, strArr, incrementAndGet);
    }

    public <T extends FeatureListening> T queryFeature(Class<T> cls) {
        T queryLocalFeature = queryLocalFeature(cls);
        if (queryLocalFeature != null) {
            return queryLocalFeature;
        }
        return globalContext().queryFeature(cls);
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
        if (featureListening == null) {
            return false;
        }
        return globalContext().registerGlobalFeature(featureListening);
    }

    public boolean unregisterGlobalFeature(FeatureListening featureListening) {
        return globalContext().unregisterGlobalFeature(featureListening);
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

    @Override
    protected void onResume() {
        super.onResume();
        this.isFirst = true;
        lockScreen();
        resetScreenTimeout();
        if (this.orientationEventListener == null) {
            this.orientationEventListener = new C0310n(this, this, 3);
        }
        this.orientationEventListener.enable();
        Iterator it = this.SensorListeners.iterator();
        while (it.hasNext()) {
            SensorListener sensorListener = (SensorListener) it.next();
            getSensorManager().registerListener(sensorListener.sensorEventListener, sensorListener.sensor, sensorListener.samplingPeriodUs);
        }
    }

    protected void onPause() {
        unlockScreen();
        closeScreenTimeout();
        this.orientationEventListener.disable();
        Iterator<SensorListener> it = this.SensorListeners.iterator();
        while (it.hasNext()) {
            getSensorManager().unregisterListener(it.next().sensorEventListener);
        }
        this.isFirst = false;
        super.onPause();
    }

    protected void onDestroy() {
        this.featureManage.clearFeatureListener();
        this.SensorListeners.clear();
        this.screenRotationChangedListeners.clear();
        super.onDestroy();
        setContentController(null);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        notifyActivityWindowFocusChanged(hasFocus);
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
        if (!notifyActivityBackPressed() && this.isFirst) {
            super.onBackPressed();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (this.permissions.containsKey(requestCode)) {
            this.permissions.remove(requestCode).onRequestPermissionsResult(permissions, grantResults);
        }
    }

    private final void resetScreenTimeout() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper(), new C0311o(this));
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.screenTimeout == 0) {
            unlockScreen();
        }
        if (this.screenTimeout != 0 && this.screenTimeout != Integer.MAX_VALUE) {
            this.mHandler.sendEmptyMessageDelayed(0, this.screenTimeout);
        }
    }

    private final void closeScreenTimeout() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    private final void lockScreen() {
        getWindow().setFlags(128, 128);
    }

    private final void unlockScreen() {
        getWindow().clearFlags(128);
    }

    private final void scheduleScreenBrightnessUpdate() {
        if (this.updateBrightness == null) {
            this.updateBrightness = new Runnable() {
                @Override
                public void run() {
                    updateScreenBrightness();
                }
            };
            UThread.post(this.updateBrightness);
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
                f = Math.max(0.02f, Math.min(this.brightness, 1.0f));
                break;
        }
        if (Float.compare(attributes.screenBrightness, f) != 0) {
            attributes.screenBrightness = f;
            getWindow().setAttributes(attributes);
        }
    }

    private final void adjustKeyboardBrightness() {
        LayoutParams attributes = getWindow().getAttributes();
        float buttonBrightness = attributes.buttonBrightness;
        switch (modes[this.brightnessMode1.ordinal()]) {
            case 1:
                buttonBrightness = -1.0f;
                break;
            case 2:
                buttonBrightness = Math.max(0.0f, Math.min(this.keyboardBrightness, 1.0f));
                break;
        }
        if (Float.compare(attributes.buttonBrightness, buttonBrightness) != 0) {
            attributes.buttonBrightness = buttonBrightness;
            getWindow().setAttributes(attributes);
        }
    }

    private final void notifyScreenRotationChanged(int status) {
        Iterator<IScreenRotationChangedListener> it = this.screenRotationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().ScreenRotationChanged(status);
        }
    }

    private final void notifyActivityConfigurationChanged(Configuration configuration) {
        if (controllerRoot() != null) {
            controllerRoot().onActivityConfigurationChanged(this, configuration);
        }
    }

    private final void notifyActivityResult(int requestCode, int resultCode, Intent intent) {
        Iterator<OnActivityResultListener> it = this.mActivityResultListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(requestCode, resultCode, intent);
        }
        if (getApplication() instanceof ManagedApp) {
            ((ManagedApp) getApplication()).onActivityResult(this, requestCode, resultCode, intent);
        }
    }

    private final void notifyActivityWindowFocusChanged(boolean hasFocus) {
        if (controllerRoot() != null) {
            controllerRoot().onActivityWindowFocusChanged(this, hasFocus);
        }
    }

    private final boolean notifyActivityKeyDown(int keyCode, KeyEvent keyEvent) {
        if (controllerRoot() == null) {
            return false;
        }
        return controllerRoot().onActivityKeyDown(this, keyCode, keyEvent);
    }

    private final boolean notifyActivityKeyUp(int keyCode, KeyEvent keyEvent) {
        if (controllerRoot() == null) {
            return false;
        }
        return controllerRoot().onActivityKeyUp(this, keyCode, keyEvent);
    }

    private final boolean notifyActivityBackPressed() {
        if (controllerRoot() == null) {
            return false;
        }
        return controllerRoot().onActivityBackPressed(this);
    }

    private final ISubControllerParent controllerStub() {
        return (ISubControllerParent) getApplication();
    }

    private final IFeature globalContext() {
        return (IFeature) getApplication();
    }

    private final ISubController controllerRoot() {
        Application application = getApplication();
        if (application instanceof ISubController) {
            return (ISubController) application;
        }
        return null;
    }
}
