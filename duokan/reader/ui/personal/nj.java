package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.duokan.reader.domain.cloud.hk;

class nj implements OnClickListener {
    final /* synthetic */ ng a;

    nj(ng ngVar) {
        this.a = ngVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        ng ngVar = this.a;
        String str = hk.c;
        if (this.a.c.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        ngVar.a(str, z);
        CheckBox c = this.a.c;
        if (this.a.c.isChecked()) {
            z2 = false;
        }
        c.setChecked(z2);
    }
}
