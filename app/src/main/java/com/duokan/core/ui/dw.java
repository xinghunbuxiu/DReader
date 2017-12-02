package com.duokan.core.ui;

import android.graphics.Camera;

import com.duokan.core.sys.ap;

final class dw extends ap {
    dw() {
    }

    protected /* synthetic */ Object b() {
        return c();
    }

    protected /* synthetic */ void b(Object obj) {
        a((Camera) obj);
    }

    protected Camera c() {
        Camera camera = new Camera();
        camera.save();
        return camera;
    }

    protected void a(Camera camera) {
        camera.restore();
        camera.save();
    }
}
