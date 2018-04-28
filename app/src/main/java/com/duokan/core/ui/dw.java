package com.duokan.core.ui;

import android.graphics.Camera;
import com.duokan.core.sys.BaseAnimation;

final class dw extends BaseAnimation<Camera> {
    dw() {
    }

    /* renamed from: b */
    protected /* synthetic */ Object createAnimation() {
        return m1974c();
    }

    /* renamed from: b */
    protected /* synthetic */ void mo516b(Object obj) {
        m1971a((Camera) obj);
    }

    /* renamed from: c */
    protected Camera m1974c() {
        Camera camera = new Camera();
        camera.save();
        return camera;
    }

    /* renamed from: a */
    protected void m1971a(Camera camera) {
        camera.restore();
        camera.save();
    }
}
