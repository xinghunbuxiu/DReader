package com.duokan.reader.ui.general;

import android.view.View;

import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.bj;
import com.duokan.core.ui.dv;

import org.apache.http.HttpStatus;

public class cy extends bj {
    final /* synthetic */ cw d;

    protected cy(cw cwVar) {
        this.d = cwVar;
        super(cwVar);
    }

    protected void a(ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE) {
            this.d.post(new cz(this, this.d.getFirstViewableChildIndex()));
        }
    }

    protected void a(boolean z) {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            this.d.getChildAt(i).invalidate();
        }
    }

    protected void a(float f, float f2, Runnable runnable, Runnable runnable2) {
        int a = this.d.getFirstViewableChildIndex();
        int b = this.d.getLastViewableChildIndex();
        if (this.d.getChildCount() < 1 || a < 0 || b < 0) {
            super.a(f, f2, runnable, runnable2);
            return;
        }
        int min = Math.min(this.d.b, this.d.getChildCount() - 1);
        if (Float.compare(Math.abs(f), (float) dv.b(this.d.getContext(), 30.0f)) < 0) {
            if (min >= 0) {
                if (e(this.d.b)) {
                    int left = (this.d.getChildAt(min).getLeft() + this.d.getChildAt(min).getRight()) / 2;
                    if (Math.abs(left - getViewportBounds().centerX()) >= dv.b(this.d.getContext(), 30.0f)) {
                        if (left - getViewportBounds().centerX() <= 0) {
                            a = b;
                        }
                    }
                } else {
                    if (Math.abs(((this.d.getChildAt(a).getLeft() + this.d.getChildAt(a).getRight()) / 2) - getViewportBounds().centerX()) < Math.abs(((this.d.getChildAt(b).getLeft() + this.d.getChildAt(b).getRight()) / 2) - getViewportBounds().centerX())) {
                        a = b;
                    }
                }
            }
            a = min;
        } else if (f > 0.0f) {
            a = b;
        }
        View childAt = this.d.getChildAt(a);
        if (childAt != null) {
            super.a((float) (childAt.getLeft() - getViewportBounds().left), 0.0f, (int) HttpStatus.SC_MULTIPLE_CHOICES, false, runnable, runnable2);
        }
    }
}
