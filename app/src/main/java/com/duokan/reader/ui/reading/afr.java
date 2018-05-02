package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class afr implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ afq f9648a;

    afr(afq afq) {
        this.f9648a = afq;
    }

    public void onClick(View view) {
        this.f9648a.f9647c.f9641a.runBeforeDetach(new afs(this));
        this.f9648a.f9647c.f9641a.requestDetach();
    }
}
