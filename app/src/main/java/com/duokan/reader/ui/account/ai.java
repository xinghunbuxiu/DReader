package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;

class ai implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ae f5788a;
    /* renamed from: b */
    final /* synthetic */ ag f5789b;

    ai(ag agVar, ae aeVar) {
        this.f5789b = agVar;
        this.f5788a = aeVar;
    }

    public void onClick(View view) {
        if (this.f5788a != null) {
            this.f5788a.onChoiced(null);
        }
    }
}
