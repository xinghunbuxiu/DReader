package com.duokan.reader.ui.general;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class aw implements OnCheckedChangeListener {
    /* renamed from: a */
    final /* synthetic */ DkCheckBox f6947a;

    aw(DkCheckBox dkCheckBox) {
        this.f6947a = dkCheckBox;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        super.setSelected(z);
        if (this.f6947a.f6780b != null) {
            this.f6947a.f6780b.m10241a(this.f6947a, z);
        }
    }
}
