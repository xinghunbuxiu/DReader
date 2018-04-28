package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;

class jk implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8782a;

    jk(jg jgVar) {
        this.f8782a = jgVar;
    }

    public void onClick(View view) {
        ReaderEnv.get().setReceiveReplyMessage(!ReaderEnv.get().getIsReceiveReplyMessage());
        this.f8782a.m12047a();
    }
}
