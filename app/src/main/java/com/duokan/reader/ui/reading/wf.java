package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class wf implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ wd f11109a;

    wf(wd wdVar) {
        this.f11109a = wdVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        if (view.isSelected()) {
            z = false;
        } else {
            z = true;
        }
        view.setSelected(z);
        ReadingPrefs ae = this.f11109a.f11102a.ae();
        if (this.f11109a.f11102a.ae().m12449J()) {
            z2 = false;
        }
        ae.m12498e(z2);
        this.f11109a.f11102a.ae().m12463X();
    }
}
