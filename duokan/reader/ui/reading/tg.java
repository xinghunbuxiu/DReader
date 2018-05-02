package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class tg implements OnClickListener {
    final /* synthetic */ tc a;

    tg(tc tcVar) {
        this.a = tcVar;
    }

    public void onClick(View view) {
        if (this.a.k()) {
            if (this.a.f.b(2)) {
                this.a.f.w().l();
            } else {
                this.a.f.at();
            }
            this.a.d();
            this.a.n.setVisibility(8);
            this.a.m.setVisibility(0);
        }
    }
}
