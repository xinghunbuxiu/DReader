package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.ui.f;

class gp implements OnClickListener {
    final /* synthetic */ gn a;

    gp(gn gnVar) {
        this.a = gnVar;
    }

    public void onClick(View view) {
        if (this.a.a instanceof f) {
            ((f) this.a.a).cancel();
        } else {
            this.a.a.dismiss();
        }
    }
}
