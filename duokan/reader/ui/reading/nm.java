package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class nm implements OnClickListener {
    final /* synthetic */ nk a;

    nm(nk nkVar) {
        this.a = nkVar;
    }

    public void onClick(View view) {
        ny nyVar = (ny) this.a.j.getAdapter();
        this.a.c.a(nyVar.a, nyVar.c);
    }
}
