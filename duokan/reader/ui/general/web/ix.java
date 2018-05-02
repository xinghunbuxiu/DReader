package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;
import com.duokan.core.sys.i;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;

import java.util.Arrays;

class ix implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ i d;
    final /* synthetic */ iv e;

    ix(iv ivVar, boolean z, String str, String str2, i iVar) {
        this.e = ivVar;
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = iVar;
    }

    public void a() {
        if (!this.a) {
            DkUserPurchasedBooksManager.a().a(this.c, new ja(this));
        } else if (TextUtils.isEmpty(this.b)) {
            DkUserPurchasedFictionsManager.a().a(this.c, new iz(this));
        } else {
            DkUserPurchasedFictionsManager.a().a(this.c, Arrays.asList(aa.f(this.b)), new iy(this));
        }
    }
}
