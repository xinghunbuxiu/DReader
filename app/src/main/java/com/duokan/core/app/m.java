package com.duokan.core.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
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
import android.view.View;
import android.view.WindowManager.LayoutParams;

import com.duokan.core.sys.t;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class m extends Activity implements y {
    static final /* synthetic */ boolean a = (!m.class.desiredAssertionStatus());
    private final l b = new l();
    private final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();
    private boolean f = false;
    private OrientationEventListener g = null;
    private int h = 0;
    private int i = 0;
    private SensorManager j = null;
    private e k = null;
    private BrightnessMode l = BrightnessMode.SYSTEM;
    private float m = -1.0f;
    private Runnable n = null;
    private BrightnessMode o = BrightnessMode.SYSTEM;
    private float p = -1.0f;
    private Handler q = null;
    private int r = 0;
    private int s = 0;
    private int t = -1;

    public int getScreenTimeout() {
        return this.r;
    }

    public void setScreenTimeout(int i) {
        this.r = i;
        lockScreen();
        resetScreenTimeout();
    }

    public BrightnessMode getScreenBrightnessMode() {
        return this.l;
    }

    public void setScreenBrightnessMode(BrightnessMode brightnessMode) {
        this.l = brightnessMode;
        scheduleScreenBrightnessUpdate();
    }

    public float getScreenBrightness() {
        return this.m;
    }

    public void setScreenBrightness(float f) {
        this.m = f;
        scheduleScreenBrightnessUpdate();
    }

    @TargetApi(9)
    public int getCurrentOrientation() {
        int rotation;
        if (getResources().getConfiguration().orientation == 1) {
            if (VERSION.SDK_INT < 9) {
                return 1;
            }
            rotation = getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 1) {
                return 0;
            }
            if (rotation == 2) {
                return 9;
            }
            if (rotation == 3) {
                return 8;
            }
            return 1;
        } else if (VERSION.SDK_INT < 8) {
            return 0;
        } else {
            rotation = getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 0) {
                return 0;
            }
            if (rotation == 1) {
                return 9;
            }
            if (rotation == 2) {
                return 8;
            }
            return 1;
        }
    }

    public int getScreenRotation() {
        return this.i;
    }

    public BrightnessMode getKeyboardBrightnessMode() {
        return this.o;
    }

    public void setKeyboardBrightnessMode(BrightnessMode brightnessMode) {
        this.o = brightnessMode;
        adjustKeyboardBrightness();
    }

    public float getKeyboardBrightness() {
        return this.p;
    }

    public void setKeyboardBrightness(float f) {
        this.p = f;
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
        if (this.j == null) {
            this.j = (SensorManager) getSystemService("sensor");
        }
        return this.j;
    }

    public e getContentController() {
        return this.k;
    }

    public void setContentController(e eVar) {
        if (this.k != eVar) {
            if (this.k != null) {
                this.k.setParent(null);
            }
            this.k = eVar;
            if (this.k != null) {
                setContentView(this.k.getContentView());
                this.k.setParent(controllerStub());
                if (this.f) {
                    this.k.onActivityResumed(this);
                    return;
                }
                return;
            }
            setContentView(new View(this));
        }
    }

    public void addSensorListener(Sensor sensor, SensorEventListener sensorEventListener, int i) {
        if (a || sensor != null) {
            getSensorManager().registerListener(sensorEventListener, sensor, i);
            this.c.addIfAbsent(new t(sensor, sensorEventListener, i));
            return;
        }
        throw new AssertionError();
    }

    public void removeSensorListener(SensorEventListener sensorEventListener) {
        getSensorManager().unregisterListener(sensorEventListener);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            if (((t) it.next()).b == sensorEventListener) {
                it.remove();
            }
        }
    }

    public void addOnScreenRotationChangedListener(s sVar) {
        this.d.addIfAbsent(sVar);
    }

    public void removeOnScreenRotationChangedListener(s sVar) {
        this.d.remove(sVar);
    }

    public void addOnActivityResultListener(r rVar) {
        this.e.addIfAbsent(rVar);
    }

    public void removeOnActivityResultListener(r rVar) {
        this.e.remove(rVar);
    }

    @TargetApi(18)
    public void lockCurrentOrientation() {
        int i = this.s;
        this.s = i + 1;
        if (i <= 0) {
            this.t = getRequestedOrientation();
            if (VERSION.SDK_INT >= 18) {
                setRequestedOrientation(14);
            } else {
                setRequestedOrientation(getCurrentOrientation());
            }
        }
    }

    public void unlockCurrentOrientation() {
        int i = this.s - 1;
        this.s = i;
        if (i <= 0) {
            setRequestedOrientation(this.t);
            this.t = -1;
        }
    }

    public void requestShowMenu() {
        if (this.k != null) {
            this.k.requestShowMenu();
        }
    }

    public void requestHideMenu() {
        if (this.k != null) {
            this.k.requestHideMenu();
        }
    }

    public k queryFeature(Class cls) {
        k queryLocalFeature = queryLocalFeature(cls);
        if (queryLocalFeature != null) {
            return queryLocalFeature;
        }
        return globalContext().queryFeature(cls);
    }

    public k queryLocalFeature(Class cls) {
        if (cls == null) {
            return null;
        }
        return this.b.a(cls);
    }

    public boolean registerLocalFeature(k kVar) {
        return this.b.a(kVar);
    }

    public boolean unregisterLocalFeature(k kVar) {
        return this.b.b(kVar);
    }

    public boolean registerGlobalFeature(k kVar) {
        if (kVar == null) {
            return false;
        }
        return globalContext().registerGlobalFeature(kVar);
    }

    public boolean unregisterGlobalFeature(k kVar) {
        return globalContext().unregisterGlobalFeature(kVar);
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
        this.f = true;
        lockScreen();
        resetScreenTimeout();
        if (this.g == null) {
            this.g = new n(this, this, 3);
        }
        this.g.enable();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            getSensorManager().registerListener(tVar.b, tVar.a, tVar.c);
        }
    }

    protected void onPause() {
        unlockScreen();
        closeScreenTimeout();
        this.g.disable();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            getSensorManager().unregisterListener(((t) it.next()).b);
        }
        this.f = false;
        super.onPause();
    }

    protected void onDestroy() {
        this.b.a();
        this.c.clear();
        this.d.clear();
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
        if (!notifyActivityBackPressed() && this.f) {
            super.onBackPressed();
        }
    }

    private final void resetScreenTimeout() {
        if (this.q == null) {
            this.q = new Handler(Looper.getMainLooper(), new o(this));
        }
        this.q.removeCallbacksAndMessages(null);
        if (this.r == 0) {
            unlockScreen();
        }
        if (this.r != 0 && this.r != Integer.MAX_VALUE) {
            this.q.sendEmptyMessageDelayed(0, (long) this.r);
        }
    }

    private final void closeScreenTimeout() {
        if (this.q != null) {
            this.q.removeCallbacksAndMessages(null);
        }
    }

    private final void lockScreen() {
        getWindow().setFlags(128, 128);
    }

    private final void unlockScreen() {
        getWindow().clearFlags(128);
    }

    private final void scheduleScreenBrightnessUpdate() {
        if (this.n == null) {
            this.n = new p(this);
            t.b(this.n);
        }
    }

    private final void updateScreenBrightness() {
        LayoutParams attributes = getWindow().getAttributes();
        float f = attributes.screenBrightness;
        switch (q.a[this.l.ordinal()]) {
            case 1:
                f = -1.0f;
                break;
            case 2:
                f = Math.max(0.02f, Math.min(this.m, 1.0f));
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
        switch (q.a[this.o.ordinal()]) {
            case 1:
                f = -1.0f;
                break;
            case 2:
                f = Math.max(0.0f, Math.min(this.p, 1.0f));
                break;
        }
        if (Float.compare(attributes.buttonBrightness, f) != 0) {
            attributes.buttonBrightness = f;
            getWindow().setAttributes(attributes);
        }
    }

    private final void notifyScreenRotationChanged(int i) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(i);
        }
    }

    private final void notifyActivityConfigurationChanged(Configuration configuration) {
        if (controllerRoot() != null) {
            controllerRoot().onActivityConfigurationChanged(this, configuration);
        }
    }

    private final void notifyActivityResult(int i, int i2, Intent intent) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((r) it.next()).onActivityResult(i, i2, intent);
        }
        if (getApplication() instanceof ManagedApp) {
            ((ManagedApp) getApplication()).onActivityResult(this, i, i2, intent);
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

    private final h controllerStub() {
        return (h) getApplication();
    }

    private final y globalContext() {
        return (y) getApplication();
    }

    private final i controllerRoot() {
        Application application = getApplication();
        if (application instanceof i) {
            return (i) application;
        }
        return null;
    }
}
