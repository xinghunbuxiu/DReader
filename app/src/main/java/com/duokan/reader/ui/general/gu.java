package com.duokan.reader.ui.general;

import android.view.animation.Animation;

import com.duokan.core.ui.dv;

class gu implements Runnable {
    final /* synthetic */ Animation a;
    final /* synthetic */ gt b;
    private long c = -1;

    gu(gt gtVar, Animation animation) {
        this.b = gtVar;
        this.a = animation;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        if (-1 == this.c) {
            this.c = currentTimeMillis;
        }
        float measuredHeight = (((float) this.b.a.d.getMeasuredHeight()) * 1.0f) / ((float) this.b.a.b.getMeasuredHeight());
        float duration = (((float) (currentTimeMillis - this.c)) * 1.0f) / ((float) this.a.getDuration());
        if (this.b.d != 0) {
            duration = 1.0f - duration;
        }
        if (duration < 0.0f) {
            duration = 0.0f;
        } else if (duration > 1.0f) {
            duration = 1.0f;
        }
        duration = this.a.getInterpolator().getInterpolation(duration);
        this.b.a.h.setLevel(Math.round((measuredHeight * duration) * 10000.0f));
        if ((this.b.d == 0 && 1.0f == duration) || (1 == this.b.d && 0.0f == duration)) {
            this.b.e.removeCallbacks(this);
            if (this.b.c != null) {
                this.b.c.run();
            }
            if (1.0f == duration) {
                dv.a(this.b.a.d, new gv(this));
                return;
            }
            return;
        }
        this.b.e.postDelayed(this, 1);
    }
}
