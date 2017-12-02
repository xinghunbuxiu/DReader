package com.duokan.reader.ui.reading;

import android.content.Context;

import com.duokan.core.app.x;
import com.duokan.reader.domain.document.au;

public class kp extends fy {
    private final sh b = ((sh) x.a(getContext()).queryFeature(sh.class));
    private final au c;
    private final kq d;

    public kp(Context context, au auVar) {
        super(context);
        this.c = auVar;
        this.d = new kq(this, context);
        a(this.d, null);
    }

    public float i() {
        return this.d.a();
    }

    public void e() {
        super.e();
        this.d.a(true);
    }

    public void f() {
        super.f();
        this.d.a(false);
    }
}
