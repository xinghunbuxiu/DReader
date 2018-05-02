package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.c;

class ug implements OnClickListener {
    final /* synthetic */ ud a;

    ug(ud udVar) {
        this.a = udVar;
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
