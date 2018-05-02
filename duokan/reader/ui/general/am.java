package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;

class am implements OnClickListener {
    final /* synthetic */ ak a;

    am(ak akVar) {
        this.a = akVar;
    }

    public void onClick(View view) {
        int access$200 = this.a.getButtonIndex(view);
        this.a.onButtonClicked(access$200);
        if (this.a.i != null) {
            this.a.i.a(access$200);
        }
    }
}
