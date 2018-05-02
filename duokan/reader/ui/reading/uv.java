package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.b.i;

class uv implements OnClickListener {
    final /* synthetic */ uq a;

    uv(uq uqVar) {
        this.a = uqVar;
    }

    public void onClick(View view) {
        this.a.a.a(1, 0);
        if (!this.a.a.l()) {
            this.a.a.v().prompt(this.a.getString(i.reading__shared__reach_min_size));
        }
        this.a.c();
    }
}
