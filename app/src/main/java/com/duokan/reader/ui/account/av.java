package com.duokan.reader.ui.account;

import android.view.View;

import com.duokan.core.ui.ay;
import com.duokan.core.ui.bf;

class av implements bf {
    final /* synthetic */ as a;
    final /* synthetic */ au b;

    av(au auVar, as asVar) {
        this.b = auVar;
        this.a = asVar;
    }

    public void a(ay ayVar, View view, int i) {
        if (this.a != null) {
            this.a.onChoiced(this.b.b.a(i).b);
        }
    }
}
