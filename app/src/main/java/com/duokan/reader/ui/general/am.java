package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class am implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ak f6935a;

    am(ak akVar) {
        this.f6935a = akVar;
    }

    public void onClick(View view) {
        int access$200 = this.f6935a.getButtonIndex(view);
        this.f6935a.onButtonClicked(access$200);
        if (this.f6935a.f602i != null) {
            this.f6935a.f602i.mo1689a(access$200);
        }
    }
}
