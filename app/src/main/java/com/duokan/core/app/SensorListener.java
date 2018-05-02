package com.duokan.core.app;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

/* renamed from: com.duokan.core.app.u */
class SensorListener {
    /* renamed from: a */
    public final Sensor sensor;
    /* renamed from: b */
    public final SensorEventListener sensorEventListener;
    /* renamed from: c */
    public final int samplingPeriodUs;

    public SensorListener(Sensor sensor, SensorEventListener sensorEventListener, int samplingPeriodUs) {
        this.sensor = sensor;
        this.sensorEventListener = sensorEventListener;
        this.samplingPeriodUs = samplingPeriodUs;
    }
}
