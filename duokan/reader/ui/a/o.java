package com.duokan.reader.ui.a;

import android.view.View;
import android.view.View.OnClickListener;

class o implements OnClickListener {
    final /* synthetic */ u a;
    final /* synthetic */ n b;

    o(n nVar, u uVar) {
        this.b = nVar;
        this.a = uVar;
    }

    public void onClick(View view) {
        this.b.requestDetach();
        this.a.a();
    }
}
