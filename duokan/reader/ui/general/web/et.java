package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.general.ia;

class et implements as {
    final /* synthetic */ String a;
    final /* synthetic */ String[] b;
    final /* synthetic */ String c;
    final /* synthetic */ es d;

    et(es esVar, String str, String[] strArr, String str2) {
        this.d = esVar;
        this.a = str;
        this.b = strArr;
        this.c = str2;
    }

    public void a() {
        ia iaVar = new ia(this.d.b.pageController.getContext());
        if (!TextUtils.isEmpty(this.a)) {
            iaVar.a(this.a);
        }
        for (String b : this.b) {
            iaVar.b(b);
        }
        iaVar.a(new eu(this));
        iaVar.open(new ev(this));
    }
}
