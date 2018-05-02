package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import org.apache.http.HttpStatus;

class an implements OnClickListener {
    final /* synthetic */ al a;

    an(al alVar) {
        this.a = alVar;
    }

    public void onClick(View view) {
        this.a.a.aG();
        this.a.f = this.a.f + HttpStatus.SC_OK;
        this.a.a.ae().k(this.a.f);
        this.a.a.ae().Y();
        this.a.a.f(this.a.f);
        this.a.a();
    }
}
