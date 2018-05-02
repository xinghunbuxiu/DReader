package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.duokan.reader.domain.cloud.hk;

class nh implements OnClickListener {
    final /* synthetic */ ng a;

    nh(ng ngVar) {
        this.a = ngVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        ng ngVar = this.a;
        String str = hk.a;
        if (this.a.a.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        ngVar.a(str, z);
        CheckBox a = this.a.a;
        if (this.a.a.isChecked()) {
            z2 = false;
        }
        a.setChecked(z2);
    }
}
