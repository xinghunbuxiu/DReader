package com.duokan.reader.ui.surfing;

import android.view.View;
import android.view.animation.Animation;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.reader.ui.store.bq;

class ad implements bq {
    /* renamed from: a */
    boolean f11503a;
    /* renamed from: b */
    int f11504b;
    /* renamed from: c */
    int f11505c = 20;
    /* renamed from: d */
    final /* synthetic */ C1522i f11506d;

    ad(C1522i c1522i) {
        this.f11506d = c1522i;
    }

    /* renamed from: a */
    public void mo2543a(Scrollable scrollable, int i, int i2) {
        View f = this.f11506d.f11549q.m15341f();
        View e = this.f11506d.f11549q.m15340e();
        if (f != null && f.getHeight() != 0) {
            if (i < 0) {
                f.setVisibility(4);
            } else {
                f.setVisibility(0);
                if (i < this.f11506d.f11549q.m15343h() - f.getHeight()) {
                    this.f11504b = 0;
                    this.f11506d.f11549q.m15332a(0);
                } else if ((scrollable.getScrollState() == ScrollState.DRAG || scrollable.getScrollState() == ScrollState.FLING) && scrollable.getViewportBounds().height() == this.f11506d.f11549q.getContentView().getHeight()) {
                    int g = this.f11506d.f11549q.m15342g();
                    int min = Math.min((i - this.f11506d.f11549q.m15343h()) + f.getHeight(), i2);
                    if (min > 0) {
                        if (this.f11503a) {
                            this.f11504b = 0;
                        }
                        this.f11503a = false;
                    } else if (min < 0) {
                        if (!this.f11503a) {
                            this.f11504b = 0;
                        }
                        this.f11503a = true;
                    }
                    this.f11504b += min;
                    this.f11506d.f11549q.m15332a(Math.max(Math.min(Math.max(g - min, (-f.getHeight()) + e.getHeight()), 0), (this.f11506d.f11549q.m15343h() - i) - f.getHeight()));
                } else {
                    f.invalidate();
                }
            }
            e.invalidate();
        }
    }

    /* renamed from: a */
    public void mo2542a(int i, ScrollState scrollState, ScrollState scrollState2) {
        View f = this.f11506d.f11549q.m15341f();
        View e = this.f11506d.f11549q.m15340e();
        int height = e.getHeight() - f.getHeight();
        if (f.getHeight() != 0 && f.getVisibility() == 0) {
            if ((scrollState == ScrollState.DRAG || scrollState == ScrollState.FLING) && scrollState2 == ScrollState.IDLE) {
                int g = this.f11506d.f11549q.m15342g();
                if (i <= this.f11506d.f11549q.m15343h() - e.getHeight()) {
                    if (this.f11504b < (-this.f11505c) || g >= height / 2) {
                        m15459a(f, g, 0);
                    }
                } else if (this.f11504b > this.f11505c) {
                    m15459a(f, g, height);
                } else if (this.f11504b < (-this.f11505c)) {
                    m15459a(f, g, 0);
                } else if (g < height / 2) {
                    m15459a(f, g, height);
                } else {
                    m15459a(f, g, 0);
                }
                this.f11504b = 0;
            }
        }
    }

    /* renamed from: a */
    private void m15459a(View view, int i, int i2) {
        if (i != i2) {
            Animation aeVar = new ae(this, i2, i);
            aeVar.setDuration(200);
            view.startAnimation(aeVar);
        }
    }
}
