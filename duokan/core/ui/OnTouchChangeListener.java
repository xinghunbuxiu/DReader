package com.duokan.core.ui;

import android.graphics.PointF;
import android.view.View;

public interface OnTouchChangeListener {
    void onTouchCancel(View view, PointF pointF);

    void onTouchDown(View view, PointF pointF);

    void onTouchUp(View view, PointF pointF);
}
