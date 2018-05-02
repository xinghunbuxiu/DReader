package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;

public interface es {
    void onTouchCancel(View view, PointF pointF);

    void onTouchDown(View view, PointF pointF);

    void onTouchUp(View view, PointF pointF);
}
