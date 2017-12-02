package com.duokan.core.app;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

class t {
    public final Sensor a;
    public final SensorEventListener b;
    public final int c;

    public t(Sensor sensor, SensorEventListener sensorEventListener, int i) {
        this.a = sensor;
        this.b = sensorEventListener;
        this.c = i;
    }
}
