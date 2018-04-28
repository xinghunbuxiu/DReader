package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class wq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ wd f11121a;

    wq(wd wdVar) {
        this.f11121a = wdVar;
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
        ReadingPrefs ae = this.f11121a.f11102a.ae();
        if (this.f11121a.f11102a.ae().m12447H()) {
            z2 = false;
        }
        ae.m12488c(z2);
        this.f11121a.f11102a.ae().m12463X();
    }
}
