package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.DkPublic;

class dh implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ dg f10026a;

    dh(dg dgVar) {
        this.f10026a = dgVar;
    }

    public void onClick(View view) {
        DkPublic.exchangeNewIdThenDo(this.f10026a.f10025z.getId(), this.f10026a.f9998G, new di(this), null);
    }
}
