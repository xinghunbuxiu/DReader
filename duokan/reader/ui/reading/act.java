package com.duokan.reader.ui.reading;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.au;

class act implements au {
    final /* synthetic */ acr a;

    act(acr com_duokan_reader_ui_reading_acr) {
        this.a = com_duokan_reader_ui_reading_acr;
    }

    public void onTouchUp(View view, PointF pointF) {
    }

    public void onTouchDown(View view, PointF pointF) {
    }

    public void onTouchCancel(View view, PointF pointF) {
    }

    public void a(View view, PointF pointF, int i) {
        this.a.a.a(new Point((int) pointF.x, (int) pointF.y), new Rect(0, 0, view.getWidth(), view.getHeight()), view);
    }
}
