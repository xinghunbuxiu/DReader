package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.i;

class gl implements OnClickListener {
    final /* synthetic */ fl a;

    gl(fl flVar) {
        this.a = flVar;
    }

    public void onClick(View view) {
        if (i.f().b()) {
            this.a.g(true);
        } else {
            this.a.f(true);
        }
    }
}
