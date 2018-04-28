package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.store.al;
import com.mipay.sdk.Mipay;

class hq implements al {
    /* renamed from: a */
    final /* synthetic */ hp f7945a;

    hq(hp hpVar) {
        this.f7945a = hpVar;
    }

    public void onDownloadCloudBookStarted() {
        C0800c b = ai.m3980a().m3906b(this.f7945a.f7944a.f7941d);
        if (b != null) {
            b.m4235j(this.f7945a.f7944a.f7942e);
        }
        this.f7945a.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7945a.f7944a.f7939b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }

    public void onDownloadCloudBookError(String str) {
        this.f7945a.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7945a.f7944a.f7939b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }

    public void onDownloadCloudBookCanceled() {
        this.f7945a.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7945a.f7944a.f7939b, 2, Mipay.KEY_RESULT, Integer.valueOf(2));
    }
}
