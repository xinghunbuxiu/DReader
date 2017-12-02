package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ti implements OnClickListener {
    final /* synthetic */ tc a;

    ti(tc tcVar) {
        this.a = tcVar;
    }

    public void onClick(View view) {
        this.a.p.setVisibility(0);
        this.a.s.setVisibility(8);
        this.a.g();
        this.a.d();
    }
}
