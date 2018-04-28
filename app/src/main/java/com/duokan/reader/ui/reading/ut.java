package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.C0800c;

class ut implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ uq f11032a;

    ut(uq uqVar) {
        this.f11032a = uqVar;
    }

    public void onClick(View view) {
        C0800c G = this.f11032a.f11020a.mo1992G();
        this.f11032a.f11023d.setSelected(!view.isSelected());
        if (this.f11032a.f11023d.isSelected()) {
            G.mo1009a(new af(Boolean.valueOf(true)));
        } else {
            G.mo1009a(new af(Boolean.valueOf(false)));
        }
        G.aN();
    }
}
