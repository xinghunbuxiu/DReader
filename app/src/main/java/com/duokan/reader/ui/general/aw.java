package com.duokan.reader.ui.general;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class aw implements OnCheckedChangeListener {
    final /* synthetic */ DkCheckBox a;

    aw(DkCheckBox dkCheckBox) {
        this.a = dkCheckBox;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        super.setSelected(z);
        if (this.a.b != null) {
            this.a.b.a(this.a, z);
        }
    }
}
