package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnLongClickListener;

class yp implements OnLongClickListener {
    final /* synthetic */ yo a;

    yp(yo yoVar) {
        this.a = yoVar;
    }

    public boolean onLongClick(View view) {
        this.a.D.put("Action1", "NOTE");
        this.a.E.c();
        this.a.E.f();
        return false;
    }
}
