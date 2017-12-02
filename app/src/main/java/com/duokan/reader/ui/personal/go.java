package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.cloud.bk;
import com.duokan.reader.ui.general.ak;

class go implements OnClickListener {
    final /* synthetic */ bk a;
    final /* synthetic */ long b;
    final /* synthetic */ fl c;

    go(fl flVar, bk bkVar, long j) {
        this.c = flVar;
        this.a = bkVar;
        this.b = j;
    }

    public void onClick(View view) {
        ak akVar = new ak(this.c.getContext());
        akVar.setPrompt(this.c.c(this.a, this.b));
        akVar.show();
    }
}
