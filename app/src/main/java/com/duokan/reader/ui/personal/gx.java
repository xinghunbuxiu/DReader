package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.ActivatedController;

class gx implements OnClickListener {
    final /* synthetic */ ActivatedController a;
    final /* synthetic */ fl b;

    gx(fl flVar, ActivatedController activatedControllerVar) {
        this.b = flVar;
        this.a = activatedControllerVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
    }
}
