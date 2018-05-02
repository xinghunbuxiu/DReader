package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.UTools;

class yw implements Runnable {
    final /* synthetic */ Rect[] a;
    final /* synthetic */ yv b;

    yw(yv yvVar, Rect[] rectArr) {
        this.b = yvVar;
        this.a = rectArr;
    }

    public void run() {
        for (int i = 1; i < this.b.a.s.getChildCount(); i++) {
            this.b.a.a(this.b.a.s.getChildAt(i), UTools.getMinimumHeight(this.b.a.getContext(), 40.0f) * i);
        }
        for (int toolCount = this.b.a.z.getToolCount() - 1; toolCount > 0; toolCount--) {
            this.b.a.b((View) this.b.a.z.a(toolCount).getParent(), UTools.getRect(new Rect(), this.b.a.z.a(toolCount), null).left - this.a[toolCount].left);
        }
    }
}
