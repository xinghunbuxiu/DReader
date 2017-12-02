package com.duokan.reader.ui.general;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class al implements OnCheckedChangeListener {
    final /* synthetic */ ak a;

    al(ak akVar) {
        this.a = akVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int access$000 = this.a.getCheckIndex(compoundButton);
        this.a.onCheckStateChanged(access$000);
        if (this.a.h != null) {
            this.a.h.a(access$000);
        }
    }
}
