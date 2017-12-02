package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.o;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.ad;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ao;
import com.duokan.reader.ui.general.be;
import com.mipay.sdk.Mipay;

class ay implements ao {
    final /* synthetic */ c a;
    final /* synthetic */ ax b;

    ay(ax axVar, c cVar) {
        this.b = axVar;
        this.a = cVar;
    }

    public void a(String str, DkCloudBookManifest dkCloudBookManifest) {
        this.b.a.dismiss();
        if (dkCloudBookManifest.getBookCertification() != null && dkCloudBookManifest.getBookCertification().b.length > 0 && dkCloudBookManifest.getBookCertification().c.length > 0) {
            this.a.a(new ad(ReaderEnv.get().getDeviceIdVersion(), dkCloudBookManifest.getBookCertification().a, o.a(dkCloudBookManifest.getBookCertification().b) + "\n" + o.a(dkCloudBookManifest.getBookCertification().c), 0));
            this.a.a(BookLimitType.NONE);
            this.a.aL();
        }
        this.b.d.downloadChapter((fv) this.a, this.b.b, this.b.c);
    }

    public void a(String str, String str2) {
        this.b.a.dismiss();
        this.b.d.web_notifyWeb(this.b.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str2);
        if (!TextUtils.isEmpty(str2)) {
            be.a(this.b.d.getContext(), (CharSequence) str2, 1).show();
        }
    }
}
