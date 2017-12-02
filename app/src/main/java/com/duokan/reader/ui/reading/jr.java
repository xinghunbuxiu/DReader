package com.duokan.reader.ui.reading;

import android.content.Context;

import com.duokan.core.ui.bj;
import com.duokan.reader.ui.general.cw;
import com.duokan.reader.ui.general.cy;

class jr extends cw {
    final /* synthetic */ jp a;

    protected /* synthetic */ bj e() {
        return h();
    }

    protected /* synthetic */ cy f() {
        return h();
    }

    public jr(jp jpVar, Context context) {
        this.a = jpVar;
        super(context);
        setOrientation(0);
        setOnFlipListener(new js(this, jpVar));
    }

    protected jt h() {
        return new jt();
    }
}
