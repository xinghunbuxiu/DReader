package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.DkPublic;

class df implements OnClickListener {
    final /* synthetic */ de a;

    df(de deVar) {
        this.a = deVar;
    }

    public void onClick(View view) {
        DkPublic.exchangeNewIdThenDo(this.a.y.H(), this.a.F, new dg(this), null);
    }
}
