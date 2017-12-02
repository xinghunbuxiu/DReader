package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.e;

class gx implements OnClickListener {
    final /* synthetic */ e a;
    final /* synthetic */ fl b;

    gx(fl flVar, e eVar) {
        this.b = flVar;
        this.a = eVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
