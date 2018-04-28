package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import com.duokan.reader.ui.general.hp;

class fd implements as {
    /* renamed from: a */
    final /* synthetic */ String f7823a;
    /* renamed from: b */
    final /* synthetic */ String[] f7824b;
    /* renamed from: c */
    final /* synthetic */ String f7825c;
    /* renamed from: d */
    final /* synthetic */ fc f7826d;

    fd(fc fcVar, String str, String[] strArr, String str2) {
        this.f7826d = fcVar;
        this.f7823a = str;
        this.f7824b = strArr;
        this.f7825c = str2;
    }

    /* renamed from: a */
    public void mo1831a() {
        hp hpVar = new hp(this.f7826d.f7822b.f7581b.getContext());
        if (!TextUtils.isEmpty(this.f7823a)) {
            hpVar.m9768a(this.f7823a);
        }
        for (String b : this.f7824b) {
            hpVar.m9770b(b);
        }
        hpVar.m9767a(new fe(this));
        hpVar.open(new ff(this));
    }
}
