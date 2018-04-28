package com.duokan.reader.ui.reading;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class aea implements ServiceConnection {
    /* renamed from: a */
    final /* synthetic */ adz f9561a;

    aea(adz adz) {
        this.f9561a = adz;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f9561a.f9556p = (afl) iBinder;
        if (this.f9561a.f9556p != null && this.f9561a.f9549i != null) {
            this.f9561a.f9556p.m13496a();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f9561a.f9556p != null) {
            this.f9561a.f9556p.m13499d();
        }
        this.f9561a.f9556p = null;
    }
}
