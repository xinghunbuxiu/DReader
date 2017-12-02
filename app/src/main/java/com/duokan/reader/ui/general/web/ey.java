package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ui.general.bx;

class ey implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ ex b;

    ey(ex exVar, View view) {
        this.b = exVar;
        this.a = view;
    }

    public void onClick(View view) {
        bx bxVar = new bx(this.b.b.b.b.getContext());
        for (String a : this.b.a) {
            bxVar.a(a);
        }
        bxVar.a(new ez(this));
        bxVar.a(this.a);
    }
}
