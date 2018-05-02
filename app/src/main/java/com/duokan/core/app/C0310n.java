package com.duokan.core.app;

import android.content.Context;
import android.view.OrientationEventListener;
import com.duokan.core.ui.dv;

/* renamed from: com.duokan.core.app.n */
class C0310n extends OrientationEventListener {
    /* renamed from: a */
    final /* synthetic */ BaseActivity f535a;

    C0310n(BaseActivity mActivity, Context context, int i) {
        this.f535a = mActivity;
        super(context, i);
    }

    public void onOrientationChanged(int i) {
        if (i >= 0 && i < 360 && Math.abs(this.f535a.f522j - i) >= 75) {
            int i2 = i < 45 ? 0 : i < 135 ? 90 : i < 225 ? 180 : i < 315 ? 270 : 0;
            this.f535a.f522j = i2;
            i2 = this.f535a.f522j - dv.m1892a((-this.f535a.getWindowManager().getDefaultDisplay().getRotation()) * 90, 0, 360);
            if (this.f535a.f523k != i2) {
                this.f535a.f523k = i2;
                this.f535a.notifyScreenRotationChanged(this.f535a.f523k);
            }
        }
    }
}
