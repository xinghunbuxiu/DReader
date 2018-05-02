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

    void a(View view, boolean z);

    int getIdleTime();

    int getMaxOverScrollHeight();

    ScrollState getScrollState();

    Rect getViewportBounds();
}
