package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ui.general.ReaderUi;

class bt implements OnClickListener {
    final /* synthetic */ bs a;

    bt(bs bsVar) {
        this.a = bsVar;
    }

    public void onClick(View view) {
        ReaderUi.a(this.a.getContext(), this.a.e.getReasonEditView());
        this.a.c();
    }
}
