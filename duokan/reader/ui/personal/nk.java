package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.duokan.reader.domain.cloud.hk;

class nk implements OnClickListener {
    final /* synthetic */ ng a;

    nk(ng ngVar) {
        this.a = ngVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        ng ngVar = this.a;
        String str = hk.d;
        if (this.a.d.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        ngVar.a(str, z);
        CheckBox d = this.a.d;
        if (this.a.d.isChecked()) {
            z2 = false;
        }
        d.setChecked(z2);
    }
}
