package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.cloud.bb;
import com.duokan.reader.ui.general.ak;

class hb implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bb f8632a;
    /* renamed from: b */
    final /* synthetic */ long f8633b;
    /* renamed from: c */
    final /* synthetic */ fz f8634c;

    hb(fz fzVar, bb bbVar, long j) {
        this.f8634c = fzVar;
        this.f8632a = bbVar;
        this.f8633b = j;
    }

    public void onClick(View view) {
        ak akVar = new ak(this.f8634c.getContext());
        akVar.setPrompt(this.f8634c.m11864c(this.f8632a, this.f8633b));
        akVar.show();
    }
}
