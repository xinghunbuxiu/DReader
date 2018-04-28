package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class uc implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ub f11004a;

    uc(ub ubVar) {
        this.f11004a = ubVar;
    }

    public void onClick(View view) {
        this.f11004a.requestDetach();
    }
}
