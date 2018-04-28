package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.sys.af;
import com.duokan.reader.domain.bookshelf.C0800c;

class qj implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ qg f10864a;

    qj(qg qgVar) {
        this.f10864a = qgVar;
    }

    public void onClick(View view) {
        C0800c G = this.f10864a.f10853a.mo1992G();
        this.f10864a.f10856d.setSelected(!view.isSelected());
        if (this.f10864a.f10856d.isSelected()) {
            G.mo1009a(new af(Boolean.valueOf(true)));
        } else {
            G.mo1009a(new af(Boolean.valueOf(false)));
        }
        G.aN();
    }
}
