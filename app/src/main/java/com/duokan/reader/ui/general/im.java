package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class im implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ik f7387a;

    im(ik ikVar) {
        this.f7387a = ikVar;
    }

    public void onClick(View view) {
        this.f7387a.requestDetach();
    }
}
