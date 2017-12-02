package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.i;

class bq implements OnClickListener {
    final /* synthetic */ bn a;

    bq(bn bnVar) {
        this.a = bnVar;
    }

    public void onClick(View view) {
        i.f().a(new br(this));
    }
}
