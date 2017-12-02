package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.account.i;

class bh implements OnClickListener {
    final /* synthetic */ bg a;

    bh(bg bgVar) {
        this.a = bgVar;
    }

    public void onClick(View view) {
        i.f().a(new bi(this));
    }
}
