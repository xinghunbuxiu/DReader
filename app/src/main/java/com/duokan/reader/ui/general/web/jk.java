package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.C0299i;
import com.duokan.core.sys.as;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import java.util.Arrays;

class jk implements as {
    /* renamed from: a */
    final /* synthetic */ boolean f8050a;
    /* renamed from: b */
    final /* synthetic */ String f8051b;
    /* renamed from: c */
    final /* synthetic */ String f8052c;
    /* renamed from: d */
    final /* synthetic */ C0299i f8053d;
    /* renamed from: e */
    final /* synthetic */ ji f8054e;

    jk(ji jiVar, boolean z, String str, String str2, C0299i c0299i) {
        this.f8054e = jiVar;
        this.f8050a = z;
        this.f8051b = str;
        this.f8052c = str2;
        this.f8053d = c0299i;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (!this.f8050a) {
            DkUserPurchasedBooksManager.m5029a().m5057a(this.f8052c, new jn(this));
        } else if (TextUtils.isEmpty(this.f8051b)) {
            DkUserPurchasedFictionsManager.m5072a().m5097a(this.f8052c, new jm(this));
        } else {
            DkUserPurchasedFictionsManager.m5072a().m5098a(this.f8052c, Arrays.asList(C0652z.m3050f(this.f8051b)), new jl(this));
        }
    }
}
