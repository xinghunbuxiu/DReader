package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class afh implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ afd f9632a;

    afh(afd afd) {
        this.f9632a = afd;
    }

    public void onClick(View view) {
        this.f9632a.runBeforeDetach(new afi(this));
        this.f9632a.requestDetach();
    }
}
