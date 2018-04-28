package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class wp implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ wd f11120a;

    wp(wd wdVar) {
        this.f11120a = wdVar;
    }

    public void onClick(View view) {
        view.setSelected(!view.isSelected());
        this.f11120a.f11102a.mo2128c(view.isSelected());
    }
}
