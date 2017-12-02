package com.duokan.reader.domain.plugins.dict;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.b.i;
import com.duokan.reader.ui.general.be;

class f implements OnClickListener {
    final /* synthetic */ i a;
    final /* synthetic */ a b;

    f(a aVar, i iVar) {
        this.b = aVar;
        this.a = iVar;
    }

    public void onClick(View view) {
        if (com.duokan.reader.common.c.f.b().e()) {
            this.b.a(this.a);
            view.setClickable(false);
            return;
        }
        be.a(this.b.a.getContext(), this.b.a.getContext().getString(i.report_no_network_error), 0).show();
    }
}
