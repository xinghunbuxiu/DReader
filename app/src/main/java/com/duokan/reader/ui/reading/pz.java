package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.c;

class pz implements OnClickListener {
    final /* synthetic */ pw a;

    pz(pw pwVar) {
        this.a = pwVar;
    }

    public void onClick(View view) {
        c G = this.a.a.G();
        this.a.d.setSelected(!view.isSelected());
        if (this.a.d.isSelected()) {
            G.a(new af(Boolean.valueOf(true)));
        } else {
            G.a(new af(Boolean.valueOf(false)));
        }
        G.aL();
    }
}
