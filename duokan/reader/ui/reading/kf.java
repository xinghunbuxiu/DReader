package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class kf implements OnClickListener {
    final /* synthetic */ kd a;

    kf(kd kdVar) {
        this.a = kdVar;
    }

    public void onClick(View view) {
        if (this.a.g != null) {
            this.a.a(this.a.g.f.toString());
        }
    }
}
