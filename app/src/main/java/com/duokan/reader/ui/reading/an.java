package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import org.apache.http.HttpStatus;

class an implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ al f9779a;

    an(al alVar) {
        this.f9779a = alVar;
    }

    public void onClick(View view) {
        this.f9779a.f9772a.aG();
        this.f9779a.f9777f = this.f9779a.f9777f + HttpStatus.SC_OK;
        this.f9779a.f9772a.ae().m12517k(this.f9779a.f9777f);
        this.f9779a.f9772a.ae().m12463X();
        this.f9779a.f9772a.mo2140f(this.f9779a.f9777f);
        this.f9779a.m13727a();
    }
}
