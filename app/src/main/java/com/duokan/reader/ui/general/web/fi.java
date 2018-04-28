package com.duokan.reader.ui.general.web;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ui.general.bx;

class fi implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ View f7833a;
    /* renamed from: b */
    final /* synthetic */ fh f7834b;

    fi(fh fhVar, View view) {
        this.f7834b = fhVar;
        this.f7833a = view;
    }

    public void onClick(View view) {
        bx bxVar = new bx(this.f7834b.f7832b.f7830b.f7581b.getContext());
        for (String a : this.f7834b.f7831a) {
            bxVar.m10320a(a);
        }
        bxVar.m10323a(new fj(this));
        bxVar.m10322a(this.f7833a);
    }
}
