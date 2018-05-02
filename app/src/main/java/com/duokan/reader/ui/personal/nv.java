package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.duokan.reader.domain.cloud.gq;

class nv implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ nu f9024a;

    nv(nu nuVar) {
        this.f9024a = nuVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        nu nuVar = this.f9024a;
        String str = gq.f4062a;
        if (this.f9024a.f9019a.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        nuVar.m12367a(str, z);
        CheckBox a = this.f9024a.f9019a;
        if (this.f9024a.f9019a.isChecked()) {
            z2 = false;
        }
        a.setChecked(z2);
    }
}
