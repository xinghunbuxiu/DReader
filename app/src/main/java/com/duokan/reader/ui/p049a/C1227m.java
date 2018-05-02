package com.duokan.reader.ui.p049a;

import android.text.TextUtils;
import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.reader.ui.general.bz;

/* renamed from: com.duokan.reader.ui.a.m */
class C1227m implements ad {
    /* renamed from: a */
    final /* synthetic */ bz f5724a;
    /* renamed from: b */
    final /* synthetic */ C1226l f5725b;

    C1227m(C1226l c1226l, bz bzVar) {
        this.f5725b = c1226l;
        this.f5724a = bzVar;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        int indexOf = this.f5725b.f5723d.f5701f.indexOf(this.f5725b.f5722c);
        CharSequence obj = this.f5724a.m10327a().toString();
        this.f5725b.f5720a.setText(obj);
        this.f5725b.f5720a.setGravity(TextUtils.isEmpty(obj) ? 17 : 3);
        this.f5725b.f5723d.f5702g.remove(indexOf);
        this.f5725b.f5723d.f5702g.add(indexOf, obj);
        this.f5724a.dismiss();
        this.f5725b.f5723d.m8756c();
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
        this.f5725b.f5723d.m8756c();
    }
}
