package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ux implements OnClickListener {
    final /* synthetic */ uq a;

    ux(uq uqVar) {
        this.a = uqVar;
    }

    public void onClick(View view) {
        boolean z = true;
        boolean T = this.a.a.T();
        this.a.a.a(1, 0);
        sh a = this.a.a;
        if (T) {
            z = false;
        }
        a.d(z);
        this.a.b();
    }
}
