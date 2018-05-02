package com.duokan.reader.ui.account;

import android.app.Activity;
import android.text.TextUtils;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.b;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jq;

class d implements b {
    final /* synthetic */ jq a;
    final /* synthetic */ Activity b;
    final /* synthetic */ MiAccountAssist c;

    d(MiAccountAssist miAccountAssist, jq jqVar, Activity activity) {
        this.c = miAccountAssist;
        this.a = jqVar;
        this.b = activity;
    }

    public void a(a aVar) {
        this.a.dismiss();
        this.c.a(aVar);
    }

    public void a(a aVar, String str) {
        this.a.dismiss();
        if (!TextUtils.isEmpty(str)) {
            be.a(this.b, (CharSequence) str, 1).show();
        }
        this.c.a(aVar, str);
    }
}
