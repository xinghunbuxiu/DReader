package com.duokan.core.ui;

import android.graphics.Rect;
import android.view.View;

public interface Scrollable {

    public enum OverScrollMode {
        STRETCH,
        ALWAYS,
        AUTO,
        NEVER
    }

    public enum ScrollState {
        IDLE,
        SEEK,
        DRAG,
        FLING,
        SMOOTH
    }

    /* renamed from: a */
    void mo434a(int i, int i2, int i3, Runnable runnable, Runnable runnable2);

    /* renamed from: a */
    void mo435a(View view, boolean z);

    int getIdleTime();

    int getMaxOverScrollHeight();

    ScrollState getScrollState();

    Rect getViewportBounds();
}
