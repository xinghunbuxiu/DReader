package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.C0366o;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ad;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ah;
import com.duokan.reader.ui.general.be;
import com.mipay.sdk.Mipay;

class ax implements ah {
    /* renamed from: a */
    final /* synthetic */ C0800c f7608a;
    /* renamed from: b */
    final /* synthetic */ aw f7609b;

    ax(aw awVar, C0800c c0800c) {
        this.f7609b = awVar;
        this.f7608a = c0800c;
    }

    /* renamed from: a */
    public void mo1047a(String str, DkCloudBookManifest dkCloudBookManifest) {
        this.f7609b.f7604a.dismiss();
        if (dkCloudBookManifest.getBookCertification() != null && dkCloudBookManifest.getBookCertification().f2184b.length > 0 && dkCloudBookManifest.getBookCertification().f2185c.length > 0) {
            this.f7608a.mo1011a(new ad(ReaderEnv.get().getDeviceIdVersion(), dkCloudBookManifest.getBookCertification().f2183a, C0366o.m1031a(dkCloudBookManifest.getBookCertification().f2184b) + "\n" + C0366o.m1031a(dkCloudBookManifest.getBookCertification().f2185c), 0));
            this.f7608a.m4183a(BookLimitType.NONE);
            this.f7608a.aN();
        }
        this.f7609b.f7607d.downloadChapter((fp) this.f7608a, this.f7609b.f7605b, this.f7609b.f7606c);
    }

    /* renamed from: a */
    public void mo1048a(String str, String str2) {
        this.f7609b.f7604a.dismiss();
        this.f7609b.f7607d.web_notifyWeb(this.f7609b.f7605b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str2);
        if (!TextUtils.isEmpty(str2)) {
            be.m10287a(this.f7609b.f7607d.getContext(), (CharSequence) str2, 1).show();
        }
    }
}
