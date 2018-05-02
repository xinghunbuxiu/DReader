package com.duokan.reader.ui.a;

import android.text.TextUtils;

import com.duokan.core.app.ab;
import com.duokan.core.app.ac;
import com.duokan.reader.ui.general.bz;

class m implements ac {
    final /* synthetic */ bz a;
    final /* synthetic */ l b;

    m(l lVar, bz bzVar) {
        this.b = lVar;
        this.a = bzVar;
    }

    public void a(ab abVar) {
        int indexOf = this.b.d.f.indexOf(this.b.c);
        CharSequence obj = this.a.a().toString();
        this.b.a.setText(obj);
        this.b.a.setGravity(TextUtils.isEmpty(obj) ? 17 : 3);
        this.b.d.g.remove(indexOf);
        this.b.d.g.add(indexOf, obj);
        this.a.dismiss();
        this.b.d.c();
    }

    public void b(ab abVar) {
        this.b.d.c();
    }
}
