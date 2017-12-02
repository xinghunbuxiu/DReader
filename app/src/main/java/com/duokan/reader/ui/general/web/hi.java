package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.store.al;
import com.mipay.sdk.Mipay;

class hi implements al {
    final /* synthetic */ hh a;

    hi(hh hhVar) {
        this.a = hhVar;
    }

    public void onDownloadCloudBookStarted() {
        c b = ai.a().b(this.a.a.d);
        if (b != null) {
            b.j(this.a.a.e);
        }
        this.a.a.f.b.b.web_notifyWeb(this.a.a.b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }

    public void onDownloadCloudBookError(String str) {
        this.a.a.f.b.b.web_notifyWeb(this.a.a.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }

    public void onDownloadCloudBookCanceled() {
        this.a.a.f.b.b.web_notifyWeb(this.a.a.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }
}
