package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.x;
import com.duokan.core.app.y;
import com.duokan.reader.ui.e;
import com.duokan.reader.ui.general.expandable.ViewMode;

class bz implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ by c;

    bz(by byVar, String str, String str2) {
        this.c = byVar;
        this.a = str;
        this.b = str2;
    }

    public void onClick(View view) {
        if (this.c.c.f() != ViewMode.Edit) {
            y a = x.a(this.c.f);
            e eVar = (e) a.queryFeature(e.class);
            this.c.k = new lk(a, this.c.g, new String[]{this.a, this.b});
            eVar.pushPageSmoothly(this.c.k, null);
        }
    }
}
