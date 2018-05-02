package com.duokan.reader.ui.store;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.i;

class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void onClick(View view) {
        this.a.requestDetach();
        i.f().a(new d(this));
    }
}
