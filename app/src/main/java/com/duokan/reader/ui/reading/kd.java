package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import com.duokan.reader.ui.general.cy;

class kd extends cy {
    /* renamed from: b */
    final /* synthetic */ kb f10491b;

    private kd(kb kbVar) {
        this.f10491b = kbVar;
        super(kbVar);
    }

    protected int ab() {
        return this.f10491b.f10488a.f10479b ? super.ab() + 1 : super.ab();
    }

    /* renamed from: a */
    protected void mo491a(int i, int i2) {
        super.mo491a(i, i2);
    }

    /* renamed from: c */
    public boolean mo2420c(MotionEvent motionEvent) {
        if (this.f10491b.f10488a.mo2415k()) {
            return false;
        }
        return super.mo2420c(motionEvent);
    }

    /* renamed from: b */
    public boolean mo2419b(MotionEvent motionEvent) {
        if (this.f10491b.f10488a.mo2415k()) {
            return false;
        }
        return super.mo2419b(motionEvent);
    }
}
