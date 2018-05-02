package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.duokan.reader.domain.cloud.gq;

class ny implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ nu f9027a;

    ny(nu nuVar) {
        this.f9027a = nuVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        nu nuVar = this.f9027a;
        String str = gq.f4065d;
        if (this.f9027a.f9022d.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        nuVar.m12367a(str, z);
        CheckBox d = this.f9027a.f9022d;
        if (this.f9027a.f9022d.isChecked()) {
            z2 = false;
        }
        d.setChecked(z2);
    }
}
