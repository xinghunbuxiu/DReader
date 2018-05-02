package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class ac implements OnClickListener {
    final /* synthetic */ ab a;

    ac(ab abVar) {
        this.a = abVar;
    }

    public void onClick(View view) {
        this.a.requestHideMenu();
    }
}
