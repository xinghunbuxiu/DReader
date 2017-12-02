package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.i;

class hx implements OnClickListener {
    final /* synthetic */ hw a;

    hx(hw hwVar) {
        this.a = hwVar;
    }

    public void onClick(View view) {
        i.f().a(new hy(this));
    }
}
