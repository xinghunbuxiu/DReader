package com.duokan.reader.domain.downloadcenter;

import android.content.Intent;
import android.net.Uri;
import com.duokan.reader.DkApp;

/* renamed from: com.duokan.reader.domain.downloadcenter.d */
class C1018d implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1016b f5068a;

    C1018d(C1016b c1016b) {
        this.f5068a = c1016b;
    }

    public void run() {
        Intent intent = new Intent(this.f5068a.f5055c, DkApp.get().getMainActivityClass());
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("duokan-reader://bookshelf"));
        intent.addFlags(268435456);
        C1016b.m7857p().m7867a(intent);
        intent = new Intent(this.f5068a.f5055c, DkApp.get().getMainActivityClass());
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("duokan-reader://bookshelf"));
        intent.addFlags(268435456);
        C1016b.m7857p().m7878b(intent);
        intent = new Intent(this.f5068a.f5055c, DkApp.get().getMainActivityClass());
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("duokan-reader://bookshelf"));
        intent.addFlags(268435456);
        C1016b.m7857p().m7884c(intent);
        this.f5068a.m7864z();
    }
}
