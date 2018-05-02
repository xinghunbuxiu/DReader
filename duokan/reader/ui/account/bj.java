package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ui.general.ReaderUi;

class bj implements OnClickListener {
    final /* synthetic */ bi a;

    bj(bi biVar) {
        this.a = biVar;
    }

    public void onClick(View view) {
        ReaderUi.a(this.a.getContext(), this.a.e.getReasonEditView());
        this.a.c();
    }
}
