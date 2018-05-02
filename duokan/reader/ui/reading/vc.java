package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vc implements OnClickListener {
    final /* synthetic */ uq a;

    vc(uq uqVar) {
        this.a = uqVar;
    }

    public void onClick(View view) {
        this.a.a(new vd(this.a.getContext()), null);
        this.a.a.a(1, 0);
        this.a.a.ae().a(TypesettingStyle.CUSTOM);
        this.a.a.ae().Y();
        this.a.a.aB();
        this.a.b();
    }
}
