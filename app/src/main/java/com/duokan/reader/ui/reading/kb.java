package com.duokan.reader.ui.reading;

import android.content.Context;
import com.duokan.core.ui.bj;
import com.duokan.reader.ui.general.cw;
import com.duokan.reader.ui.general.cy;

class kb extends cw {
    /* renamed from: a */
    final /* synthetic */ jz f10488a;

    /* renamed from: e */
    protected /* synthetic */ bj mo1597e() {
        return m14536h();
    }

    /* renamed from: f */
    protected /* synthetic */ cy mo1599f() {
        return m14536h();
    }

    public kb(jz jzVar, Context context) {
        this.f10488a = jzVar;
        super(context);
        setOrientation(0);
        setOnFlipListener(new kc(this, jzVar));
    }

    /* renamed from: h */
    protected kd m14536h() {
        return new kd();
    }
}
