package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.b.i;
import com.duokan.reader.common.classc;
import com.duokan.reader.domain.b.b;
import com.duokan.reader.ui.general.be;

class el implements OnClickListener {
    final /* synthetic */ ek a;

    el(ek ekVar) {
        this.a = ekVar;
    }

    public void onClick(View view) {
        if (!classc.ConnectivityReceiver.b().e()) {
            be.a(this.a.getContext(), this.a.getContext().getString(i.report_no_network_error), 0).show();
        } else if (b.b().c().e) {
            this.a.d();
        } else {
            this.a.e();
        }
    }
}
