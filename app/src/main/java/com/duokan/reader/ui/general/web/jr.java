package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class jr implements as {
    /* renamed from: a */
    final /* synthetic */ boolean f8065a;
    /* renamed from: b */
    final /* synthetic */ String f8066b;
    /* renamed from: c */
    final /* synthetic */ Semaphore f8067c;
    /* renamed from: d */
    final /* synthetic */ ArrayList f8068d;
    /* renamed from: e */
    final /* synthetic */ ji f8069e;

    jr(ji jiVar, boolean z, String str, Semaphore semaphore, ArrayList arrayList) {
        this.f8069e = jiVar;
        this.f8065a = z;
        this.f8066b = str;
        this.f8067c = semaphore;
        this.f8068d = arrayList;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f8065a) {
            if (this.f8068d.isEmpty()) {
                DkUserPurchasedFictionsManager.m5072a().m5097a(this.f8066b, new jv(this));
            } else {
                DkUserPurchasedFictionsManager.m5072a().m5098a(this.f8066b, this.f8068d, new ju(this));
            }
        } else if (TextUtils.equals(this.f8066b, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE)) {
            DkUserPurchasedBooksManager.m5029a().m5066b(true, true, new js(this));
        } else {
            DkUserPurchasedBooksManager.m5029a().m5057a(this.f8066b, new jt(this));
        }
    }
}
