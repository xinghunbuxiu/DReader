package com.duokan.reader.domain.downloadcenter;

import android.content.Intent;
import android.text.TextUtils;

/* renamed from: com.duokan.reader.domain.downloadcenter.n */
class C1026n implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Intent f5085a;
    /* renamed from: b */
    final /* synthetic */ DownloadNotificationService f5086b;

    C1026n(DownloadNotificationService downloadNotificationService, Intent intent) {
        this.f5086b = downloadNotificationService;
        this.f5085a = intent;
    }

    public void run() {
        if (TextUtils.equals(this.f5085a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_SUCCEEDED")) {
            C1016b.m7857p().m7901r();
            if (C1016b.m7857p().m7897m() != null) {
                this.f5086b.startActivity(C1016b.m7857p().m7897m());
            }
        } else if (TextUtils.equals(this.f5085a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_DELETE_SUCCEEDED")) {
            C1016b.m7857p().m7901r();
        } else if (TextUtils.equals(this.f5085a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_FAILED")) {
            C1016b.m7857p().m7902s();
            if (C1016b.m7857p().m7898n() != null) {
                this.f5086b.startActivity(C1016b.m7857p().m7898n());
            }
        } else if (TextUtils.equals(this.f5085a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_DELETE_FAILED")) {
            C1016b.m7857p().m7902s();
        } else if (TextUtils.equals(this.f5085a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_RUNNING") && C1016b.m7857p().m7899o() != null) {
            this.f5086b.startActivity(C1016b.m7857p().m7899o());
        }
    }
}
