package com.duokan.reader.ui.surfing;

import android.view.View;
import android.view.animation.Animation;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.reader.ui.store.bq;

class x implements bq {
    boolean a;
    int b;
    int c = 20;
    final /* synthetic */ f d;

    x(f fVar) {
        this.d = fVar;
    }

    public void a(Scrollable scrollable, int i, int i2) {
        View f = this.d.n.f();
        View e = this.d.n.e();
        if (f != null && f.getHeight() != 0) {
            if (i < 0) {
                f.setVisibility(4);
            } else {
                f.setVisibility(0);
                if (i < this.d.n.h() - f.getHeight()) {
                    this.b = 0;
                    this.d.n.a(0);
                } else if ((scrollable.getScrollState() == ScrollState.DRAG || scrollable.getScrollState() == ScrollState.FLING) && scrollable.getViewportBounds().height() == this.d.n.getContentView().getHeight()) {
                    int g = this.d.n.g();
                    int min = Math.min((i - this.d.n.h()) + f.getHeight(), i2);
                    if (min > 0) {
                        if (this.a) {
                            this.b = 0;
                        }
                        this.a = false;
                    } else if (min < 0) {
                        if (!this.a) {
                            this.b = 0;
                        }
                        this.a = true;
                    }
                    this.b += min;
                    this.d.n.a(Math.max(Math.min(Math.max(g - min, (-f.getHeight()) + e.getHeight()), 0), (this.d.n.h() - i) - f.getHeight()));
                } else {
                    f.invalidate();
                }
            }
            e.invalidate();
        }
    }

    public void a(int i, ScrollState scrollState, ScrollState scrollState2) {
        View f = this.d.n.f();
        View e = this.d.n.e();
        int height = e.getHeight() - f.getHeight();
        if (f.getHeight() != 0 && f.getVisibility() == 0) {
            if ((scrollState == ScrollState.DRAG || scrollState == ScrollState.FLING) && scrollState2 == ScrollState.IDLE) {
                int g = this.d.n.g();
                if (i <= this.d.n.h() - e.getHeight()) {
                    if (this.b < (-this.c) || g >= height / 2) {
                        a(f, g, 0);
                    }
                } else if (this.b > this.c) {
                    a(f, g, height);
                } else if (this.b < (-this.c)) {
                    a(f, g, 0);
                } else if (g < height / 2) {
                    a(f, g, height);
                } else {
                    a(f, g, 0);
                }
                this.b = 0;
            }
        }
    }

    private void a(View view, int i, int i2) {
        if (i != i2) {
            Animation yVar = new y(this, i2, i);
            yVar.setDuration(200);
            view.startAnimation(yVar);
        }
    }
}
