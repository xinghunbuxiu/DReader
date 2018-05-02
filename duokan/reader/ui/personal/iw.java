package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;

class iw implements OnClickListener {
    final /* synthetic */ it a;

    iw(it itVar) {
        this.a = itVar;
    }

    public void onClick(View view) {
        ReaderEnv.get().setReceiveReplyMessage(!ReaderEnv.get().getIsReceiveReplyMessage());
        this.a.a();
    }
}
