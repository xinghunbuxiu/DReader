package com.duokan.reader.ui.general;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class al implements OnCheckedChangeListener {
    /* renamed from: a */
    final /* synthetic */ ak f6934a;

    al(ak akVar) {
        this.f6934a = akVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int access$000 = this.f6934a.getCheckIndex(compoundButton);
        this.f6934a.onCheckStateChanged(access$000);
        if (this.f6934a.f601h != null) {
            this.f6934a.f601h.m10228a(access$000);
        }
    }
}
