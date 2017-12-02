package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.ad.e;
import com.duokan.reader.domain.ad.g;
import com.duokan.reader.ui.general.jy;

class d implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ e b;
    final /* synthetic */ Context c;
    final /* synthetic */ a d;

    d(a aVar, View view, e eVar, Context context) {
        this.d = aVar;
        this.a = view;
        this.b = eVar;
        this.c = context;
    }

    public void onClick(View view) {
        if (a.d(this.a)) {
            g.a().b(this.b);
            synchronized (this.d) {
                a.a(this.d);
            }
            jy jyVar = new jy(this.c);
            jyVar.a(true);
            jyVar.b();
            jyVar.a(this.b.f);
            jyVar.show();
        }
    }
}
