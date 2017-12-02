package com.duokan.reader.domain.downloadcenter;

import android.content.Intent;
import android.text.TextUtils;

class n implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ DownloadNotificationService b;

    n(DownloadNotificationService downloadNotificationService, Intent intent) {
        this.b = downloadNotificationService;
        this.a = intent;
    }

    public void run() {
        if (TextUtils.equals(this.a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_SUCCEEDED")) {
            b.n().p();
            if (b.n().k() != null) {
                this.b.startActivity(b.n().k());
            }
        } else if (TextUtils.equals(this.a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_DELETE_SUCCEEDED")) {
            b.n().p();
        } else if (TextUtils.equals(this.a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_FAILED")) {
            b.n().q();
            if (b.n().l() != null) {
                this.b.startActivity(b.n().l());
            }
        } else if (TextUtils.equals(this.a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_DELETE_FAILED")) {
            b.n().q();
        } else if (TextUtils.equals(this.a.getAction(), "com.duokan.reader.domain.downloadcenter.ACTION_HANDLE_CLICK_RUNNING") && b.n().m() != null) {
            this.b.startActivity(b.n().m());
        }
    }
}
