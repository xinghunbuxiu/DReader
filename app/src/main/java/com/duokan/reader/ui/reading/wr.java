package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class wr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ wd f11122a;

    wr(wd wdVar) {
        this.f11122a = wdVar;
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
        ReadingPrefs ae = this.f11122a.f11102a.ae();
        if (this.f11122a.f11102a.ae().m12446G()) {
            z2 = false;
        }
        ae.m12482b(z2);
        this.f11122a.f11102a.ae().m12463X();
    }
}
