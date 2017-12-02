package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class tf implements OnClickListener {
    final /* synthetic */ tc a;

    tf(tc tcVar) {
        this.a = tcVar;
    }

    public void onClick(View view) {
        if (this.a.j()) {
            if (this.a.f.b(2)) {
                this.a.f.w().m();
            } else {
                this.a.f.au();
            }
            this.a.d();
            this.a.m.setVisibility(8);
            this.a.n.setVisibility(0);
        }
    }
}
