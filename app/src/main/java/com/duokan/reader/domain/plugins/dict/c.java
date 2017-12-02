package com.duokan.reader.domain.plugins.dict;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.b.i;
import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.downloadcenter.b;
import com.duokan.reader.ui.general.be;

class c implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    c(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public void onClick(View view) {
        if (f.b().e()) {
            b.n().b(b.n().b(this.a));
        } else {
            be.a(this.b.a.getContext(), this.b.a.getContext().getString(i.report_no_network_error), 0).show();
        }
    }
}
