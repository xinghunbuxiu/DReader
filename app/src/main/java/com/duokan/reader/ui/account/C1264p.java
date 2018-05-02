package com.duokan.reader.ui.account;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;

/* renamed from: com.duokan.reader.ui.account.p */
class C1264p implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1261m f5971a;

    C1264p(C1261m c1261m) {
        this.f5971a = c1261m;
    }

    public void onClick(View view) {
        ReaderEnv.get().setIsOnlyWifiSyncEvernote(!ReaderEnv.get().getIsOnlyWifiSyncEvernote());
        this.f5971a.m9003a();
    }
}
