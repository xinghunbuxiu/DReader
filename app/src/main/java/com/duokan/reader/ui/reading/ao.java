package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ao implements OnClickListener {
    final /* synthetic */ al a;

    ao(al alVar) {
        this.a = alVar;
    }

    public void onClick(View view) {
        this.a.a.aG();
        this.a.f = this.a.f - 200;
        this.a.a.ae().k(this.a.f);
        this.a.a.ae().Y();
        this.a.a.f(this.a.f);
        this.a.a();
    }
}
