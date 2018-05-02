package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.sina.weibo.sdk.exception.WeiboAuthException;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

class je implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ Semaphore c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ iv e;

    je(iv ivVar, boolean z, String str, Semaphore semaphore, ArrayList arrayList) {
        this.e = ivVar;
        this.a = z;
        this.b = str;
        this.c = semaphore;
        this.d = arrayList;
    }

    public void a() {
        if (this.a) {
            if (this.d.isEmpty()) {
                DkUserPurchasedFictionsManager.a().a(this.b, new ji(this));
            } else {
                DkUserPurchasedFictionsManager.a().a(this.b, this.d, new jh(this));
            }
        } else if (TextUtils.equals(this.b, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE)) {
            DkUserPurchasedBooksManager.a().b(true, true, new jf(this));
        } else {
            DkUserPurchasedBooksManager.a().a(this.b, new jg(this));
        }
    }
}
