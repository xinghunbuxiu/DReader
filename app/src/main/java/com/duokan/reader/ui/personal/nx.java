package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.duokan.reader.domain.cloud.gq;

class nx implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ nu f9026a;

    nx(nu nuVar) {
        this.f9026a = nuVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        nu nuVar = this.f9026a;
        String str = gq.f4064c;
        if (this.f9026a.f9021c.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        nuVar.m12367a(str, z);
        CheckBox c = this.f9026a.f9021c;
        if (this.f9026a.f9021c.isChecked()) {
            z2 = false;
        }
        c.setChecked(z2);
    }
}
