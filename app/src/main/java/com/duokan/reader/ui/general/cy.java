package com.duokan.reader.ui.general;

import android.view.View;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.bj;
import com.duokan.core.ui.dv;
import org.apache.http.HttpStatus;

public class cy extends bj {
    /* renamed from: d */
    final /* synthetic */ cw f6454d;

    protected cy(cw cwVar) {
        this.f6454d = cwVar;
        super(cwVar);
    }

    /* renamed from: a */
    protected void mo494a(ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE) {
            this.f6454d.post(new cz(this, this.f6454d.getFirstViewableChildIndex()));
        }
    }

    /* renamed from: a */
    protected void mo495a(boolean z) {
        for (int i = 0; i < this.f6454d.getChildCount(); i++) {
            this.f6454d.getChildAt(i).invalidate();
        }
    }

    /* renamed from: a */
    protected void mo1694a(float f, float f2, Runnable runnable, Runnable runnable2) {
        int a = this.f6454d.getFirstViewableChildIndex();
        int b = this.f6454d.getLastViewableChildIndex();
        if (this.f6454d.getChildCount() < 1 || a < 0 || b < 0) {
            super.mo1694a(f, f2, runnable, runnable2);
            return;
        }
        int min = Math.min(this.f6454d.f6019b, this.f6454d.getChildCount() - 1);
        if (Float.compare(Math.abs(f), (float) dv.m1932b(this.f6454d.getContext(), 30.0f)) < 0) {
            if (min >= 0) {
                if (m1544e(this.f6454d.f6019b)) {
                    int left = (this.f6454d.getChildAt(min).getLeft() + this.f6454d.getChildAt(min).getRight()) / 2;
                    if (Math.abs(left - getViewportBounds().centerX()) >= dv.m1932b(this.f6454d.getContext(), 30.0f)) {
                        if (left - getViewportBounds().centerX() <= 0) {
                            a = b;
                        }
                    }
                } else {
                    if (Math.abs(((this.f6454d.getChildAt(a).getLeft() + this.f6454d.getChildAt(a).getRight()) / 2) - getViewportBounds().centerX()) < Math.abs(((this.f6454d.getChildAt(b).getLeft() + this.f6454d.getChildAt(b).getRight()) / 2) - getViewportBounds().centerX())) {
                        a = b;
                    }
                }
            }
            a = min;
        } else if (f > 0.0f) {
            a = b;
        }
        View childAt = this.f6454d.getChildAt(a);
        if (childAt != null) {
            super.mo1759a((float) (childAt.getLeft() - getViewportBounds().left), 0.0f, (int) HttpStatus.SC_MULTIPLE_CHOICES, false, runnable, runnable2);
        }
    }
}
