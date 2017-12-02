package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;

class kd implements OnClickListener {
    final /* synthetic */ kc a;

    kd(kc kcVar) {
        this.a = kcVar;
    }

    public void onClick(View view) {
        view.setEnabled(false);
        ((kn) x.a(this.a.o()).queryFeature(kn.class)).b();
    }
}
