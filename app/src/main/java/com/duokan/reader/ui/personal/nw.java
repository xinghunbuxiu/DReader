package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.duokan.reader.domain.cloud.gq;

class nw implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ nu f9025a;

    nw(nu nuVar) {
        this.f9025a = nuVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        nu nuVar = this.f9025a;
        String str = gq.f4063b;
        if (this.f9025a.f9020b.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        nuVar.m12367a(str, z);
        CheckBox b = this.f9025a.f9020b;
        if (this.f9025a.f9020b.isChecked()) {
            z2 = false;
        }
        b.setChecked(z2);
    }
}
