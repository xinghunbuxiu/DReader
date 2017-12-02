package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.duokan.reader.domain.cloud.hk;

class ni implements OnClickListener {
    final /* synthetic */ ng a;

    ni(ng ngVar) {
        this.a = ngVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        ng ngVar = this.a;
        String str = hk.b;
        if (this.a.b.isChecked()) {
            z = false;
        } else {
            z = true;
        }
        ngVar.a(str, z);
        CheckBox b = this.a.b;
        if (this.a.b.isChecked()) {
            z2 = false;
        }
        b.setChecked(z2);
    }
}
