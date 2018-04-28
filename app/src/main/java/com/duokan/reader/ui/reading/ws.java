package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ws implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ wd f11123a;

    ws(wd wdVar) {
        this.f11123a = wdVar;
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
        ReadingPrefs ae = this.f11123a.f11102a.ae();
        if (this.f11123a.f11102a.ae().m12448I()) {
            z2 = false;
        }
        ae.m12494d(z2);
        this.f11123a.f11102a.ae().m12463X();
    }
}
